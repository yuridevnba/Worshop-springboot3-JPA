package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

@Service
public class CategoryService {
// operações básicas para buscar todos os usuários e buscar usuários por id. sendo necessário uma dependência para o user repository.
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){ // operação na camada de serviço que repassa  a chamada para o repository.
		return repository.findAll();
	}
	public Category findById(Long id) {
		Optional<Category> obj= repository.findById(id);
		return obj.get(); // o get vai retornar um user que estiver dentro optional
	}
}
