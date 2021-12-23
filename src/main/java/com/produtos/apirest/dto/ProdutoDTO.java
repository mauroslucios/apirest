package com.produtos.apirest.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.RepresentationModel;

import com.produtos.apirest.model.Produto;

public class ProdutoDTO extends RepresentationModel<ProdutoDTO> implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String nome;
	private BigDecimal quantidade;
	private BigDecimal valor;
	
	public ProdutoDTO(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.quantidade = produto.getQuantidade();
		this.valor = produto.getValor();
	}
	
	
	public static List<ProdutoDTO> converter(List<Produto> produtos){
		return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
	}


	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	
}
