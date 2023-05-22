package br.edu.ifsp.xyz.comissao;

import java.io.IOException;
import java.util.*;

import br.edu.ifsp.xyz.leitor.Leitor;

public class RegiaoVenda {
	private int idRegiaoVenda;
	private String nome;
	private ZonaVenda[] zonasVenda;
	
	public RegiaoVenda(int idRegiaoVenda, String nome, ZonaVenda[] zonasVenda) {
		this.idRegiaoVenda = idRegiaoVenda;
		this.nome = nome;
		this.zonasVenda = zonasVenda;
	}
	
	public RegiaoVenda(String caminhoArquivo, String nome) throws IOException {
		Leitor leitor = new Leitor(caminhoArquivo);
		
		HashMap<String, String> RegiaoVenda = leitor.arrayChavesValores().stream().filter(id -> id.get("nome").equals(nome)).findFirst().orElse(null);
		List<String> zonasVendaSeparadasVirgula = Arrays.asList(RegiaoVenda.get("zonasVenda").split(","));
		
		this.idRegiaoVenda = Integer.parseInt(RegiaoVenda.get("idRegiaoVenda")) ;
		this.nome = RegiaoVenda.get("nome");
		this.zonasVenda = new ZonaVenda[zonasVendaSeparadasVirgula.size()];
		
		for (int i = 0; i < zonasVendaSeparadasVirgula.size(); i++) {
			ZonaVenda zonaVenda = new ZonaVenda("./src/dados/ZonaVenda.txt", zonasVendaSeparadasVirgula.get(i));
			this.zonasVenda[i] = zonaVenda;
		}
		
	}
	
	@Override
	public String toString() {
		return "\n===================" + "\nID da Região de Venda: " + idRegiaoVenda + "\nNome: " + nome.toUpperCase() + "\nZonas de Venda: " + Arrays.toString(zonasVenda);
	}
}
