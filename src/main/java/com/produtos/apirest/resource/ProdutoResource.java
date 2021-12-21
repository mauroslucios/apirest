package com.produtos.apirest.resource;

import java.util.ArrayList;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.dto.ProdutoDTO;
import com.produtos.apirest.model.Produto;
import com.produtos.apirest.service.ProdutoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/produtos")
	@ApiOperation(value="Retorna uma lista de produtos")
	public @ResponseBody ArrayList<ProdutoDTO> listaProdutos(){
		Iterable<ProdutoDTO> listaProdutos = produtoService.findAll();
		ArrayList<ProdutoDTO> produtos = new ArrayList<ProdutoDTO>();
		for(ProdutoDTO produto : listaProdutos) {
			long id = produto.getId();
			produto.add(linkTo(methodOn(ProdutoResource.class).produto(id)).withSelfRel());
			produtos.add(produto);
		}
		return produtos;
	}
	
	@GetMapping(value="/produto/{id}", produces="application/json")
	@ApiOperation(value="Busca um produto pelo id")
	public @ResponseBody Produto produto(@PathVariable(value="id") long id){
		Produto produto = produtoService.findById(id);
		produto.add(linkTo(methodOn(ProdutoResource.class).listaProdutos()).withRel("Lista de Produtos"));
		return produto;
	}
	
	@PostMapping("/produto")
	@ApiOperation(value="Salva um produto no banco")
	public Produto insertProduto(@RequestBody Produto produto) {
		return produtoService.insertProduto(produto);
		
	}
	
	@DeleteMapping("/produto/{id}")
	@ApiOperation(value="Deleta um produto pelo id")
	public void deleteProduto(@PathVariable long id) {
		produtoService.deleteProdutoById(id);
	}
	
	@PutMapping("/produto")
	@ApiOperation(value="Atualiza um produto completo")
	public Produto updateProduto(@RequestBody Produto produto) {
		return produtoService.updateProdutoById(produto);
	}
	
	
}
