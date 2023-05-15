package br.edu.ifsp.xyz.comissao;

import java.io.IOException;
import java.util.*;
import java.util.stream.*;

import br.edu.ifsp.xyz.leitor.*;

public class Cliente {
	private String cpf;
	private String nome;
	private Pedido pedidos[];
	
	public Cliente(String cpf, String nome, Pedido pedidos[]) {
		this.cpf = cpf;
		this.nome = nome;
		this.pedidos = pedidos;
	}
	
	public Cliente(String caminhoArquivo, String cpf) throws IOException {
		Leitor leitor = new Leitor(caminhoArquivo);
		Leitor leitorPedidos = new Leitor("./src/dados/Pedido.txt");
		
		List<HashMap<String, String>> pedidosCPF = leitorPedidos.getArrayChavesValores().stream().filter(pedido -> pedido.get("cpf").equals(cpf)).collect(Collectors.toList());
		HashMap<String, String> cliente = leitor.getArrayChavesValores().stream().filter(id -> id.get("cpf").equals(cpf)).findFirst().orElse(null);
		
		this.cpf = cliente.get("cpf");
		this.nome = cliente.get("nome");
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
	

	@Override
	public String toString() {
		if (cpf == null) {
			throw new IllegalStateException("CLIENTE NÃO ENCONTRADO NO SISTEMA!");
		} else {
			return "Nome: " + nome + "\nCPF do Comprador: " + cpf + "\nPedidos: " + Arrays.toString(pedidos);
		}
	}
}