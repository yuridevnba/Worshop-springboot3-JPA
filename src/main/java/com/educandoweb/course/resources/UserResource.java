package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

//para indentificar que a classe é um recurso web que é implementado por um controlador rest
// é preciso colocar uma anotation. @RestController.

// requestMapping é o nome do recurso
//"/users" é o caminho do recurso. ou o nome, como o recurso está relacionado á entidade users, int ele deu o nome do recurso com "/users"
// criou um método que vai ser um endpoints para acessar os usuários.
// pra indica que esse método responde a requisição do tipo get do HTTP.
@RestController
@RequestMapping(value="/users")
public class UserResource {
	@GetMapping // para indicar que esse método vai ser um tipo método que responde a requisição do get  wttp, annotation.
// tipo de retorno específico do spring para retornar resposta de requisição web. o responseEntity é um generics, findAll retorna os usuários.
	public ResponseEntity<User> findAll(){
		User u = new User(22L, "Jair Messias Bolsonaro","bozofacista@gmail.com", "98748512","12345");
		return ResponseEntity.ok().body(u);
	}
}