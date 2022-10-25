package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service
public class UserService {
// operações básicas para buscar todos os usuários e buscar usuários por id. sendo necessário uma dependência para o user repository.
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){ // operação na camada de serviço que repassa  a chamada para o repository.
		return repository.findAll();
	}
	public User findById(Long id) {
		Optional<User> obj= repository.findById(id);
		return obj.get(); // o get vai retornar um user que estiver dentro optional
	}
	public User insert(User obj) {
		return repository.save(obj); // operação pra inserir no banco de dados um novo objeto do tipo.
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
