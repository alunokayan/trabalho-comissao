package br.edu.ifsp.xyz.comissao;

import java.io.IOException;
import java.util.*;

import br.edu.ifsp.xyz.leitor.*;

public class Pedido {
	private String idPedido;
	private String cpf;
	private String dataPedido;
	private double valorPedido;
	private Produto[] produtos;
	
	public Pedido(String idPedido, String cpf, String dataPedido, float valorPedido, Produto[] produtos) {
		this.idPedido = idPedido;
		this.cpf = cpf;
		this.dataPedido = dataPedido;
		this.valorPedido = valorPedido;
		this.produtos = produtos;
	}
	
	public Pedido(String caminhoArquivo, String idPedido) throws IOException {
		Leitor leitor = new Leitor(caminhoArquivo);
		
	    HashMap<String, String> pedido = leitor.arrayChavesValores().stream().filter(id -> id.get("idPedido").equals(idPedido.toUpperCase())).findFirst().orElse(null);
		List<String> produtosSeparadosVirgula = Arrays.asList(pedido.get("produtos").split(","));
		
	    this.idPedido = pedido.get("idPedido");
	    this.cpf = pedido.get("cpf");
	    this.dataPedido = pedido.get("dataPedido");
	    this.valorPedido = Float.parseFloat(pedido.get("valorPedido")); 
	    this.produtos = new Produto[produtosSeparadosVirgula.size()];
	    
	    for (int i = 0; i < produtosSeparadosVirgula.size(); i++) {
			Produto produto = new Produto("./src/dados/Produto.txt", produtosSeparadosVirgula.get(i));
			this.produtos[i] = produto;
		}
	    
	    System.out.println();
	}
	
	public Produto[] getProdutos() {
		return produtos;
	}
	
	@Override
	public String toString() {
		return "\n===================" + "\nID do Pedido: " + idPedido +
				"\nCPF do Comprador: " + cpf +
				"\nData do Pedido: " + dataPedido +
				"\nValor do Pedido: " + valorPedido +
				"\nProdutos: " + Arrays.toString(produtos) + "\n===================";
	}
}
