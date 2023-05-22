package br.edu.ifsp.xyz.comissao;

import java.io.IOException;
import java.util.*;
import java.util.stream.*;

import br.edu.ifsp.xyz.leitor.*;

public class Pedido {
	private String idPedido;
	private String cpf;
	private String dataPedido;
	private float valorPedido;
	
	public Pedido(String idPedido, String cpf, String dataPedido, float valorPedido) {
		this.idPedido = idPedido;
		this.cpf = cpf;
		this.dataPedido = dataPedido;
		this.valorPedido = valorPedido;
	}
	
	public Pedido(String caminhoArquivo, String idPedido) throws IOException {
		Leitor leitor = new Leitor(caminhoArquivo);
		
	    HashMap<String, String> pedido = leitor.getArrayChavesValores().stream().filter(id -> id.get("idPedido").equals(idPedido)).findFirst().orElse(null);

	    this.idPedido = pedido.get("idPedido");
	    this.cpf = pedido.get("cpf");
	    this.dataPedido = pedido.get("dataPedido");
	    this.valorPedido = Float.parseFloat(pedido.get("valorPedido")); 
	}
	
	@Override
	public String toString() {
		if (idPedido == null) {
			throw new IllegalStateException("PEDIDO NÃO PRESENTE NO SISTEMA!");
		} else {
			return "\n=======================" + "\nID do Pedido: " + idPedido + "\nCPF do Comprador: " + cpf + "\nData do Pedido: " + dataPedido + "\nValor do Pedido: " + valorPedido + "\n=======================";
		}
	}
}
