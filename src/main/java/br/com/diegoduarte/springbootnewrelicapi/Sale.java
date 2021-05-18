package br.com.diegoduarte.springbootnewrelicapi;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
	private BigDecimal valor;
	
	private String status;
	
	public Sale() {
	}

	public Sale(String descricao, BigDecimal valor, String status) {
		this.descricao = descricao;
		this.valor = valor;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public String getStatus() {
		return status;
	}	
	
}
