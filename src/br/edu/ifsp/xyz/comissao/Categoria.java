package br.edu.ifsp.xyz.comissao;

import java.io.IOException;
import java.util.HashMap;
import br.edu.ifsp.xyz.leitor.*;

public class Categoria {
	private int idCategoria;
	private String nome;
	private double percentualComissao;
	
	public Categoria(int idCategoria, String nome, float percentualComissao) {
		this.idCategoria = idCategoria;
		this.nome = nome;
		this.percentualComissao = percentualComissao;
	}
	
	public Categoria(String caminhoArquivo, String nome) throws IOException {
		Leitor leitor = new Leitor(caminhoArquivo);
		
		 HashMap<String, String> categoria = leitor.arrayChavesValores().stream().filter(id -> id.get("nome").equals(nome.toLowerCase())).findFirst().orElse(null);
		 this.idCategoria = Integer.parseInt(categoria.get("idCategoria"));
		 this.nome = categoria.get("nome");
		 switch(this.nome)	{
		 	case "moda":
			 	this.percentualComissao = 0.15;
			 	break;
		 	case "brinquedos":
		 		this.percentualComissao = 0.25;
		 		break;
		 	case "perfumaria":
		 		this.percentualComissao = 0.5;
		 		break;
		 	case "eletrônicos":
		 		this.percentualComissao = 1.5;
		 		break;
		 	default:
		 		this.percentualComissao = 0.05;
		 		break;
		 }
		 
		 
	}
	
	public String getNome() {
		return nome.toUpperCase();
	}
	
	public double getPercentualComissao() {
		return percentualComissao;
	}
	
	@Override
	public String toString() {
		return "ID da Categoria: " + idCategoria + "\nNome: " + nome.toUpperCase() + "\nPercentual de Comissão: " + percentualComissao * 100 + "%";
	}
}
