package com.inti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@GetMapping("hello")
	public String hello()
	{
		
		return "Hello World !";
	}
	
	@GetMapping("listeNom")
	public List<String> listeNom()
	{
		List<String> listeN = new ArrayList<>();
		listeN.add("Dupont");
		listeN.add("Durand");
		listeN.add("Toto");
		listeN.add("Titi");
		
		return listeN;
	}

}
