package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Article;
import com.inti.repository.IArticleRepository;

@RestController
@RequestMapping("article")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201"})
public class ArticleController {
	
	@Autowired
	IArticleRepository iar;

	@GetMapping("listeArticle")
	public List<Article> listeArticle()
	{
		return iar.findAll();
	}
	
	@PostMapping("saveArticle")
	public Article saveArticle(@RequestBody Article a)
	{
		return iar.save(a);
	}
	
	@DeleteMapping("deleteArticle/{id}")
	public void deleteArticle(@PathVariable("id") int id)
	{
		iar.deleteById(id);
	}
	
	@GetMapping("articleId/{id}")
	public Article articleId(@PathVariable("id") int id)
	{
		System.out.println("id : " + id);
		return iar.getReferenceById(id);
	}
	
	@PutMapping("modifierArticle")
	public Article modifierArticle(@RequestBody Article a)
	{
		return iar.save(a);
	}
}
