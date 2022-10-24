package com.educandoweb.course.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Embeddable //classe auxiliar composta.
public class OderItemPK implements Serializable {
// classe auxiliar de chave primária composta.
	private static final long serialVersionUID = 1L;
//vai ter uma referência para o produto e para o pedido.
	
	@ManyToOne
	@JoinColumn(name = "order_id") // nome da chave estrangeira, na tabela de banco de dados relacional.
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OderItemPK other = (OderItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}
	
	
}
