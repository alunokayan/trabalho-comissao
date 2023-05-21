package br.edu.ifsp.xyz.comissao;

import java.io.IOException;
import java.util.HashMap;

import br.edu.ifsp.xyz.leitor.Leitor;

public class Produto {
	private int idProduto;
	private String nome;
	private float precoBase;
	private Categoria categoria;
	
	public Produto(int idProduto, String nome, float precoBase, Categoria categoria) {
		this.idProduto = idProduto;
		this.nome = nome;
		this.precoBase = precoBase;
		this.categoria = categoria;
	}
	
	public Produto(String caminhoArquivo, String nome) throws IOException {
		Leitor leitor = new Leitor(caminhoArquivo);
		
		 HashMap<String, String> produto = leitor.arrayChavesValores().stream().filter(id -> id.get("nome").equals(nome.toLowerCase())).findFirst().orElse(null);
		 this.idProduto = Integer.parseInt(produto.get("idProduto"));
		 this.nome = produto.get("nome");
		 this.precoBase = Float.parseFloat(produto.get("precoBase"));
		 this.categoria = new Categoria("./src/dados/Categoria.txt", produto.get("categoria"));
	}
	
	public String toString() {
		if (nome == null) {
			throw new IllegalStateException("PEDIDO NÃO PRESENTE NO SISTEMA!");
		} else {
			return "Id do Produto: " + idProduto + "\nNome: " + nome.toUpperCase() + "\nPreço Base: " + precoBase + "\nCategoria: " + categoria.getNome();
		}
	}
}
