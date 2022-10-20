package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;
// controlador rest
//para indentificar que a classe é um recurso web que é implementado por um controlador rest
// é preciso colocar uma anotation. @RestController.

// requestMapping é o nome do recurso
//"/users" é o caminho do recurso. ou o nome, como o recurso está relacionado á entidade users, int ele deu o nome do recurso com "/users"
// criou um método que vai ser um endpoints para acessar os usuários.
 
@RestController
@RequestMapping(value="/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	@GetMapping // para indicar que esse método vai ser um tipo método que responde a requisição do get  http, annotation.
// tipo de retorno específico do spring para retornar resposta de requisição web. o responseEntity é um generics, findAll retorna os usuários.
	public ResponseEntity<List<Order>> findAll(){
		//Order u = new Order(22L, "Jair Messias Bolsonaro","bozofacista@gmail.com", "98748512","12345");
		List<Order> list = service.findAll(); // método estático
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value="/{id}") // indica que a requisição vai aceitar um id dentro da url.
	public ResponseEntity<Order> findById(@PathVariable Long id){ //endpoints do controlador rest, para o spring aceitar o id e considerar como parâmetro q vai chegar na url, precisa colocar um anotation q é o @PathVarible
	Order obj= service.findById(id);//
	return ResponseEntity.ok().body( obj);
}
}