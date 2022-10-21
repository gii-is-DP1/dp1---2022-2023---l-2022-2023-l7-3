package org.springframework.samples.petclinic.property;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "companies")
public class Company extends Property{

}
