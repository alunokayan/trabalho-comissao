package br.edu.ifsp.xyz.comissao;

import java.io.IOException;
import java.util.HashMap;

import br.edu.ifsp.xyz.leitor.Leitor;

public class Produto {
	private int idProduto;
	private String nome;
	private String descricao;
	private double precoBase;
	private Categoria categoria;
	
	public Produto(int idProduto, String nome, String descricao, float precoBase, Categoria categoria) {
		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.precoBase = precoBase;
		this.categoria = categoria;
	}
	
	public Produto(String caminhoArquivo, String nome) throws IOException {
		Leitor leitor = new Leitor(caminhoArquivo);
		
		 HashMap<String, String> produto = leitor.arrayChavesValores().stream().filter(id -> id.get("nome").equals(nome.toLowerCase())).findFirst().orElse(null);
		 this.idProduto = Integer.parseInt(produto.get("idProduto"));
		 this.nome = produto.get("nome");
		 this.descricao = produto.get("descricao");
		 this.precoBase = Float.parseFloat(produto.get("precoBase"));
		 this.categoria = new Categoria("./src/dados/Categoria.txt", produto.get("categoria"));
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public double getPrecoBase() {
		return precoBase;
	}
	
	public String toString() {
		return "\n===================" + "ID do Produto: " + idProduto +
				"\nNome: " + nome.toUpperCase() + "\nDescrição: " + descricao +
				"\nPreço Base: R$" + String.format("%.2f", precoBase) +
				"\nCategoria: " + categoria.getNome() +
				"\n(Comissão: " + categoria.getPercentualComissao() * 100 + "%)" + "\n===================";
	}
}
