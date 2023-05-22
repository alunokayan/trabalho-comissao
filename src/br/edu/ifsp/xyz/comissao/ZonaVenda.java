package br.edu.ifsp.xyz.comissao;

import java.io.IOException;
import java.util.HashMap;

import br.edu.ifsp.xyz.leitor.*;

public class ZonaVenda {
	private int idZonaVenda;
	private String uf;
	private String nomeCompleto;
	
	public ZonaVenda(int idZonaVenda, String uf, String nomeCompleto) {
		this.idZonaVenda = idZonaVenda;
		this.uf = uf;
		this.nomeCompleto = nomeCompleto;
	}
	
	public ZonaVenda(String caminhoArquivo, String uf) throws IOException {
		Leitor leitor = new Leitor(caminhoArquivo);
		
		HashMap<String, String> zonaVenda = leitor.arrayChavesValores().stream().filter(id -> id.get("uf").equals(uf.toUpperCase())).findFirst().orElse(null);
		
		this.idZonaVenda = Integer.parseInt(zonaVenda.get("idZonaVenda"));
		this.uf = zonaVenda.get("uf");
		this.nomeCompleto = zonaVenda.get("nomeCompleto");
	}
	
	public String getUf() {
		return uf;
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	@Override
	public String toString() {
		return "\n===================" + "\nID da Zona de Venda: " + idZonaVenda + "\nUF (Unidade Federativa): " + uf +  " (" + nomeCompleto + ")" + "\n===================";
	}
}
