package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.educandoweb.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order") // o nome da tabela "Order" estava entrando em conflito.
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd 'T' HH:mm:ss 'Z'", timezone = "GMT")
	private Instant moment;
	private Integer orderstatus; // integer só para trabalhar com o bd.
	
	
// o relacionamento entre pedidos e clientes vai ser necessário uma chave estrangeira,
// o jpa vai transformar isso em chave estrangeira quando tiver o @ManyToOne. associação pedidos (muito) usuário(um), muito para um.
//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cliente_id")// na tabela de pedidos do banco de dados,vai ter uma chave estrangeira que é o client_id que vai conter o id do usuário associado a esse pedido.
	private User cliente;
     
	@OneToMany(mappedBy="id.order")
	
	private Set<OrderItem>items = new HashSet<>();
	
	public Order() {

	}

	public Order(Long id, Instant moment,OrderStatus orderstatus, User cliente) {
		super();
		this.id = id;
		this.moment = moment;
		setOrderstatus(orderstatus);
		//this.orderstatus=orderstatus;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	
	

	public OrderStatus getOrderstatus() { // pegando um número inteiro e convertendo para orderstatus.
		return OrderStatus.valueOf(orderstatus);
	}

	public void setOrderstatus(OrderStatus orderstatus) { // recebe um orderstatus e guarda um inteiro.
		if(orderstatus != null) {
		this.orderstatus = orderstatus.getCode(); // pegar um número inteiro correspondente a orderstatus.
	}
	}

	public User getCliente() {
		return cliente;
	}

	public void setCliente(User cliente) {
		this.cliente = cliente;
	}
    public Set<OrderItem>getItems(){
    	return items;
    }
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

}
