package com.inti.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table
@Data @NoArgsConstructor @AllArgsConstructor
public class Voiture {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String marque;
	private String model;
	private double prix;
	
	public Voiture(String marque, String model, double prix) {
		super();
		this.marque = marque;
		this.model = model;
		this.prix = prix;
	}
	
	

}
