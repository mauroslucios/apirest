package com.produtos.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.dto.ProdutoDTO;
import com.produtos.apirest.model.Produto;
import com.produtos.apirest.service.ProdutoService;

@RestController
@RequestMapping(value="/api")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/produtos")
	public List<ProdutoDTO> listaProdutos(){
		return produtoService.findAll();
	}
	
	@GetMapping("/produto/{id}")
	public Produto findById(@PathVariable(value="id") long id){
		return produtoService.findById(id);
	}
	
	@PostMapping("/produtos")
	public Produto insertProduto(@RequestBody Produto produto) {
		return produtoService.insertProduto(produto);
		
	}
	
	
	
	
	
	
}
