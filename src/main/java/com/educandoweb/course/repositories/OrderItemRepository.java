package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.course.entities.OrderItem;
import com.educandoweb.course.entities.pk.OderItemPK;
@Repository // é algo opcional, pois ela está herdando do JpaRepository que é um componente do spring.
public interface OrderItemRepository extends JpaRepository<OrderItem, OderItemPK> {
// com isso somos capaz de instanciar pra gente um objeto
	//repositor que vai ter várias operações para se trabalhar com o usuário.
	
	// não será necessário criar a implementação dessa interface, pois o spring data jpa, Já tem uma implementação padrão pra essa interface.
}
