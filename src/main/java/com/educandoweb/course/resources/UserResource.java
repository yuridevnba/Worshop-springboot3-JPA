package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;
// controlador rest
//para indentificar que a classe é um recurso web que é implementado por um controlador rest
// é preciso colocar uma anotation. @RestController.

// requestMapping é o nome do recurso
//"/users" é o caminho do recurso. ou o nome, como o recurso está relacionado á entidade users, int ele deu o nome do recurso com "/users"
// criou um método que vai ser um endpoints para acessar os usuários.
 
@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	// método get é pra recuperar dados do banco de dados.
	
	@GetMapping // para indicar que esse método vai ser um tipo método que responde a requisição do get  http, annotation.
// tipo de retorno específico do spring para retornar resposta de requisição web. o responseEntity é um generics, findAll retorna os usuários.
	public ResponseEntity<List<User>> findAll(){
		//User u = new User(22L, "Jair Messias Bolsonaro","bozofacista@gmail.com", "98748512","12345");
		List<User> list = service.findAll(); // método estático
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value="/{id}") // indica que a requisição vai aceitar um id dentro da url.
	public ResponseEntity<User> findById(@PathVariable Long id){ //endpoints do controlador rest, para o spring aceitar o id e considerar como parâmetro q vai chegar na url, precisa colocar um anotation q é o @PathVarible
	User obj= service.findById(id);//
	return ResponseEntity.ok().body( obj);
}
	 //quando é pra inserir é post
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		//return ResponseEntity.ok().body( obj);// retorna 200 q n é o ideal
		
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);// o createdd espera um objeto do tipo uri, no padrão http quando se retorna uma resposta do tipo 201 é esperado um cabeçalho do tipo location, contendo o endereço do novo recurso.
	}
	@DeleteMapping(value="/{id}")
	
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping(value="/{id}")
	
	public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User obj){
	 obj=service.update(id, obj);
	return ResponseEntity.ok().body(obj);
}
	
	
	
	
	
	
	
	
	
	
}