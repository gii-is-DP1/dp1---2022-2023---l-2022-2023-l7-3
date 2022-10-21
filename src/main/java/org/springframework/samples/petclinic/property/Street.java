package org.springframework.samples.petclinic.property;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "streets")
public class Street extends Property{
	@Column(name = "color")
	@NotBlank
	@Enumerated(EnumType.STRING)
	private Color color;
	
	public enum Color {
		 BROWN, LIGHTBLUE, PINK, ORANGE, RED, YELLOW, GREEN, BLUE
		}

	
	@Column(name = "price")
	@NotBlank
	private Integer price;
	
	@Column(name = "building_price")
	@NotBlank
	private Integer buildingPrice;
	
	@Column(name = "house_num")
	@NotBlank
	private Integer houseNum;
	
	@Column(name = "have_hotel")
	@NotBlank
	private Boolean haveHotel;
	
	

}



