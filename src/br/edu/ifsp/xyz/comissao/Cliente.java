package br.edu.ifsp.xyz.comissao;

import java.io.IOException;
import java.util.HashMap;

import br.edu.ifsp.xyz.leitor.*;

public class Cliente {
	private String cpf;
	private String nome;
	private ZonaVenda uf;
	private Pedido[] pedidos;
	
	public Cliente(String cpf, String nome, ZonaVenda uf) {
		this.cpf = cpf;
		this.nome = nome;
		this.uf = uf;
	}
	
	public Cliente(String caminhoArquivo, String cpf) throws IOException {
		Leitor leitor = new Leitor(caminhoArquivo);
		HashMap<String, String> cliente = leitor.arrayChavesValores().stream().filter(id -> id.get("cpf").equals(cpf)).findFirst().orElse(null);
		this.cpf = cliente.get("cpf");
		this.nome = cliente.get("nome");
		this.uf = new ZonaVenda("./src/dados/ZonaVenda.txt", cliente.get("uf"));
	}
	
	public String toString() {
		if (uf == null) {
			throw new IllegalStateException("PEDIDO NÃO PRESENTE NO SISTEMA!");
		} else {
			return "CPF: " + cpf + "\nNome: " + nome + "\nUF (Unidade Federativa): " + uf.getUf() + " (" + uf.getNomeCompleto() + ")" + "\nPedidos: ....";
		}
	}
}