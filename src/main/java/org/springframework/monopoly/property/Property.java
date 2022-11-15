package org.springframework.monopoly.property;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

import org.springframework.monopoly.game.Game;
import org.springframework.monopoly.player.Player;
import org.springframework.monopoly.tile.Tile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Property extends Tile {
	
	@Column(name = "name")
	@NotBlank
	private String name;
	
	@Column(name = "price")
	@NotBlank
	private Integer price;

	@Column(name = "rental_price")
	@NotBlank
	private Integer rentalPrice;

	@Column(name = "mortage_price")
	@NotBlank
	private Integer mortagePrice;

	@Column(name = "is_mortage")
	@NotBlank
	private Boolean isMortage;
	
	@Column(name = "badge_Image")
	@NotBlank
	private String badgeImage;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "game", referencedColumnName = "id")
	private Game game;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner", referencedColumnName = "id")
	private Player owner;

	
}
