package br.edu.ifsp.xyz.comissao;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifsp.xyz.leitor.*;

public class Cliente {
	private String cpf;
	private String nome;
	private ZonaVenda uf;
	private Pedido[] pedidos;
	
	public Cliente(String cpf, String nome, ZonaVenda uf, Pedido[] pedidos) {
		this.cpf = cpf;
		this.nome = nome;
		this.uf = uf;
		this.pedidos = pedidos;
	}
	
	public Cliente(String caminhoArquivo, String cpf) throws IOException {
		Leitor leitor = new Leitor(caminhoArquivo);
		Leitor leitorPedidos = new Leitor("./src/dados/Pedido.txt");
		
		HashMap<String, String> cliente = leitor.arrayChavesValores().stream().filter(id -> id.get("cpf").equals(cpf)).findFirst().orElse(null);
		List<HashMap<String, String>> pedidosCPF = leitorPedidos.arrayChavesValores().stream().filter(pedido -> pedido.get("cpf").equals(cpf)).collect(Collectors.toList());
		
		this.cpf = cliente.get("cpf");
		this.nome = cliente.get("nome");
		this.uf = new ZonaVenda("./src/dados/ZonaVenda.txt", cliente.get("uf"));
		this.pedidos = new Pedido[pedidosCPF.size()];
	    for (int i = 0; i < pedidosCPF.size(); i++) {
	        HashMap<String, String> pedidoMapa = pedidosCPF.get(i);
	        Pedido pedido = new Pedido(
                pedidoMapa.get("idPedido"),
                pedidoMapa.get("cpf"),
                pedidoMapa.get("dataPedido"),
                Float.parseFloat(pedidoMapa.get("valorPedido")));
	        this.pedidos[i] = pedido;
	    }
	}
	
	public String getNome() {
		return nome;
	}
	
	public Pedido[] getPedidos() {
		return pedidos;
	}
	
	@Override
	public String toString() {
		return "\n===================" + "CPF: " + cpf + "\nNome: " + nome + "\nUF (Unidade Federativa): " + uf.getUf() + " (" + uf.getNomeCompleto() + ")" + "\nPedidos: " + Arrays.toString(pedidos) + "\n===================";
	}
}