package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration // para identificar que é uma classe de configuração
@Profile("test") //pra falar q ela é específica para o perfil d teste. nome igual ao que foi colocado no "spring.profiles.active=test", presente no application.propesties. 
// identificando que ela vai rodar essa configuração apenas quando se estiver no perfil de teste.
// essa classe de configuração vai ser usada pra criar o database seeding, ou seja, popular o banco de dados com alguns objetos., pra popular é preciso acessar o banco de dados,pra salvar que faz isso 
//é o repository sendo necessário o primeiro caso de injenção de dependência. pois vai ter q ter uma dependência do UserRepository. sendo necessária ser fraca dessacoplada.

public class TestConfig implements CommandLineRunner {
    @Autowired
	private UserRepository userRepository; // fazer um objeto depender de outro.// para o spring consiga resolver essa dependência e associar uma instância do userepository no testeconfig=@Autowired
    @Autowired
    private OrderRepository orderRepository;
	@Override
	public void run(String... args) throws Exception { // tudo que colocar dentro desse método, vai ser executado quando a aplicação for inicializada.
	
		User u1 = new User(null, "Elson Barcelos", "elson@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Stalin", "stalin@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1); // padrão Iso8601
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		userRepository.saveAll(Arrays.asList(u1,u2));  // saveAll salva uma lista de objetos no banco de dados,
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
    
    
	
	
	
}
