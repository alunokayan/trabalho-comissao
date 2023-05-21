package br.edu.ifsp.xyz.comissao;

import java.io.IOException;
import java.util.*;

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
		
	    HashMap<String, String> pedido = leitor.arrayChavesValores().stream().filter(id -> id.get("idPedido").equals(idPedido.toUpperCase())).findFirst().orElse(null);

	    this.idPedido = pedido.get("idPedido");
	    this.cpf = pedido.get("cpf");
	    this.dataPedido = pedido.get("dataPedido");
	    this.valorPedido = Float.parseFloat(pedido.get("valorPedido")); 
		/*for (int i = 0; i < leitor.definirChavesValores().size(); i++) {
			if (leitor.definirChavesValores().get(i).get("idPedido").equals(idPedido)) {
				this.idPedido = leitor.definirChavesValores().get(i).get("idPedido");
	            this.cpf = leitor.definirChavesValores().get(i).get("cpf");
	            this.dataPedido = leitor.definirChavesValores().get(i).get("dataPedido");
	            this.valorPedido = Float.parseFloat(leitor.definirChavesValores().get(i).get("valorPedido"));
	            break;
			}
		}*/
	}
	
	@Override
	public String toString() {
		if (idPedido == null) {
			throw new IllegalStateException("PEDIDO NÃO PRESENTE NO SISTEMA!");
		} else {
			return "ID do Pedido: " + idPedido + "\nCPF do Comprador: " + cpf + "\nData do Pedido: " + dataPedido + "\nValor do Pedido: " + valorPedido;
		}
	}
}
