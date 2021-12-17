package com.produtos.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtos.apirest.dto.ProdutoDTO;
import com.produtos.apirest.model.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	public List<ProdutoDTO> findAll() {
		List<Produto> produtos = produtoRepository.findAll();
		return ProdutoDTO.converter(produtos);
	}

	public Produto insertProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	public Produto findById(long id) {
		return produtoRepository.findById(id);
	}

	public void deleteProdutoById(long id) {
		produtoRepository.deleteById(id);
	}
}
