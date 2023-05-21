package br.edu.ifsp.xyz.comissao;

import java.io.IOException;
import java.util.HashMap;
import br.edu.ifsp.xyz.leitor.*;

public class Categoria {
	private int idCategoria;
	private String nome;
	private float percentualComissao;
	
	public Categoria(int idCategoria, String nome, float comissao) {
		this.idCategoria = idCategoria;
		this.nome = nome;
		this.percentualComissao = comissao;
	}
	
	public Categoria(String caminhoArquivo, String nome) throws IOException {
		Leitor leitor = new Leitor(caminhoArquivo);
		
		 HashMap<String, String> categoria = leitor.arrayChavesValores().stream().filter(id -> id.get("nome").equals(nome.toLowerCase())).findFirst().orElse(null);
		 this.idCategoria = Integer.parseInt(categoria.get("idCategoria"));
		 this.nome = categoria.get("nome");
		 this.percentualComissao = Float.parseFloat(categoria.get("percentualComissao")) / 100;
	}
	
	public String getNome() {
		return nome.toUpperCase();
	}
	
	public float getPercentualComissao() {
		return percentualComissao;
	}
	
	@Override
	public String toString() {
		if (nome == null) {
			throw new IllegalStateException("PEDIDO NÃO PRESENTE NO SISTEMA!");
		} else {
			return "Id da Categoria: " + idCategoria + "\nNome: " + nome.toUpperCase() + "\nPercentual de Comissão: " + percentualComissao * 100 + "%";
		}
	}
}
