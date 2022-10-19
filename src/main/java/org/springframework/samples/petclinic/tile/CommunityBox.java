package org.springframework.samples.petclinic.tile;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.monopoly.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "community_box")
public class CommunityBox extends Tile{

}
