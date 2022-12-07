package org.springframework.monopoly.tile;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.monopoly.player.Player;
import org.springframework.monopoly.turn.Action;
import org.springframework.monopoly.turn.Turn;
import org.springframework.monopoly.turn.TurnService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GenericService {
	
	private GenericRepository genericRepository;
	private TurnService turnService;

	@Autowired
	public GenericService(GenericRepository genericRepository, TurnService turnService) {
		this.genericRepository = genericRepository;
		this.turnService = turnService;
	}
	
	@Transactional
	public void genericTile(Turn turn) {
		Optional<Generic> generic = genericRepository.findGenericByGameId(turn.getGame().getId(), turn.getFinalTile());
		if(generic.isPresent()) {
			Boolean goJail = generic.get().getGenericType().equals(GenericType.GOTOJAIL);
			if(goJail) {
				turn.setAction(Action.GOTOJAIL);
			} else {
				turn.setAction(Action.NOTHING_HAPPENS);
			}
		}
	}
	
	@Transactional(readOnly = true)
	public Set<Generic> getBlankGenerics() {
		return genericRepository.findBlankGenerics();
	}

	@Transactional
	public Generic save(Generic newGeneric) {
		return genericRepository.save(newGeneric);
	}
	
	@Transactional
	public void free(Turn turn, Integer decision) {
		
		Player player = turn.getPlayer();
		
		switch (decision) {
			case 1: player.setMoney(player.getMoney() - 50); 
					player.setIsJailed(false);
					break;
			case 2: player.setHasExitGate(false); 
					player.setIsJailed(false);
					break;
			case 3: Pair<Integer, Boolean> roll =  turnService.getRoll(); {
				if (roll.getSecond()) {
					player.setIsJailed(false);
					turn.setRoll(roll.getFirst());
				}
			};
			break;
					
			default:}
	}
	
}