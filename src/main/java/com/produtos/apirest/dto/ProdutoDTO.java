package com.produtos.apirest.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.produtos.apirest.model.Produto;

import lombok.Getter;

@Getter
public class ProdutoDTO {
	
	private String nome;
	private BigDecimal quantidade;
	private BigDecimal valor;
	
	public ProdutoDTO(Produto produto) {
		this.nome = produto.getNome();
		this.quantidade = produto.getQuantidade();
		this.valor = produto.getValor();
	}
	
	
	public static List<ProdutoDTO> converter(List<Produto> produtos){
		return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
	}
	
}
