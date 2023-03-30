package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Produit;
import com.inti.repository.IProduitRepository;

@RestController
@RequestMapping("produit")
@CrossOrigin(origins = "http://localhost:4200")
public class ProduitController {
	
	@Autowired
	IProduitRepository ipr;
	
	@GetMapping("listeProduits")
	public List<Produit> listeProduits()
	{
		return ipr.findAll();
	}

}
