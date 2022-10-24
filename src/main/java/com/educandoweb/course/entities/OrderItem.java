package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.Objects;

import com.educandoweb.course.entities.pk.OderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId // id composto.
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
private OderItemPK id = new OderItemPK (); //o id identificador, no orderitem não tem associação com order diretamente, ele tem o id , e o id que tem associação com o order.
//sempre q criar um atributo que vai exemplificar uma associação composta, precisa instânciar.
private Integer quantity;

private Double price;

public OrderItem() {
	
}
// colocou o order e o product, manualmente, chamando pelo id e modificando no OderItemPK, uma vez que id é do tipo OrderItemPK.
public OrderItem(Order order,Product product,Integer quantity, Double price) {
	super();
	id.setOrder(order);
	id.setProduct(product);
	this.quantity = quantity;
	this.price = price;
}
// o getOrder que chama o pedido, o pedido chamava o orders e ficava aí dava o lup infinito.
@JsonIgnore
public Order getOrder() {
	return id.getOrder();
}
public void setOrder(Order order) {
	id.setOrder(order); // joga o id informado dentro do ordemItemPK
}
public Product getProduct() {
	return id.getProduct();
}
public void setProduct(Product product) {
	id.setProduct(product); // joga o id informado dentro do ordemItemPK
}
public Integer getQuantity() {
	return quantity;
}

public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
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
	OrderItem other = (OrderItem) obj;
	return Objects.equals(id, other.id);
}

	
}

