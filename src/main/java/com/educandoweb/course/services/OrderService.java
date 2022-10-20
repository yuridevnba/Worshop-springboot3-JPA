package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

@Service
public class OrderService {
// operações básicas para buscar todos os usuários e buscar usuários por id. sendo necessário uma dependência para o Order repository.
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){ // operação na camada de serviço que repassa  a chamada para o repository.
		return repository.findAll();
	}
	public Order findById(Long id) {
		Optional<Order> obj= repository.findById(id);
		return obj.get(); // o get vai retornar um Order que estiver dentro optional
	}
}
