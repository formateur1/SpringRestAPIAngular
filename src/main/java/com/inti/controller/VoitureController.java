package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Voiture;
import com.inti.repository.IVoitureRepository;

@RestController
public class VoitureController {
	
	@Autowired
	IVoitureRepository ivr;
	
	@PostMapping("saveVoiture")
	public Voiture saveVoiture(@RequestBody Voiture v)
	{
		Voiture vSaved = ivr.save(v);
		
		return vSaved;
	}
	
	@PutMapping("updateVoiture")
	public boolean updateVoiture(@RequestBody Voiture v, @RequestParam("id") int id)
	{
		boolean update = false;
		
		Voiture v1 = ivr.getReferenceById(id);
		
		if(v1 != null)
		{
			if(v.getMarque() != null)
			{
				if(!v.getMarque().equals(""))
					v1.setMarque(v.getMarque());
			}
//			v.setId(id);
			ivr.save(v1);
			update = true;
		}
		
		return update;		
	}
	
	@DeleteMapping("deleteVoiture/{id}")
	public boolean deleteVoiture(@PathVariable("id") int id)
	{
		boolean delete = false;
		
		System.out.println("id : " + id);
		
		try
		{
			if(ivr.existsById(id))
			{
				ivr.deleteById(id);
				delete = true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return delete;
	}

}
