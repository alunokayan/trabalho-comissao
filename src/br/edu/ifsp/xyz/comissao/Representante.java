package br.edu.ifsp.xyz.comissao;

import java.io.IOException;
import java.util.*;

import br.edu.ifsp.xyz.leitor.*;

public class Representante {
	private int idRepresentante;
	private RegiaoVenda regiaoVenda;
	private String nome;
	
	public Representante(int idRepresentante, RegiaoVenda regiaoVenda, String nome) {
		this.idRepresentante = idRepresentante;
		this.regiaoVenda = regiaoVenda;
		this.nome = nome;
	}
	
	public Representante(String caminhoArquivo, String regiaoVenda) throws IOException {
		Leitor leitor = new Leitor(caminhoArquivo);
		
		HashMap<String, String> representante = leitor.arrayChavesValores().stream().filter(id -> id.get("regiaoVenda").equals(regiaoVenda)).findFirst().orElse(null);		 
		
		this.idRepresentante = Integer.parseInt(representante.get("idRepresentante"));
		this.regiaoVenda = new RegiaoVenda("./src/dados/RegiaoVenda.txt", representante.get("regiaoVenda"));
		this.nome = representante.get("nome");
	}
	
	public String calcularComissao() {
		
	}
	
	@Override
	public String toString() {
		return "ID do Representante: " + idRepresentante + "\nNome: " + nome + "\nRegião de Venda: " + regiaoVenda;
	}
}
