package com.produtos.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public List<ProdutoDTO> listaProdutos(){
		return produtoService.findAll();
	}
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value="Busca um produto pelo id")
	public Produto findById(@PathVariable(value="id") long id){
		return produtoService.findById(id);
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
