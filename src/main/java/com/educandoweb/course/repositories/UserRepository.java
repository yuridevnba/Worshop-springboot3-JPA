package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
// com isso somos capaz de instanciar pra gente um objeto
	//repositor que vai ter várias operações para se trabalhar com o usuário.
	
	// não será necessário criar a implementação dessa interface, pois o spring data jpa, já tem uma implementação padrão pra essa interface.
}
