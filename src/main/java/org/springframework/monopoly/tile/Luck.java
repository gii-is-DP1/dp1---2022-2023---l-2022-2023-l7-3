package org.springframework.monopoly.tile;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "luck")
public class Luck extends Tile{

}
