package br.edu.ifsp.xyz.comissao;

import java.io.IOException;
import java.util.*;
import java.util.stream.*;

import br.edu.ifsp.xyz.leitor.*;

public class Vendedor {
	private int idVendedor;
	private String nome;
	private ZonaVenda zonaVenda;
	private Cliente[] clientesCadastrados;
	
	public Vendedor(int idVendedor, String nome, ZonaVenda zonaVenda, Cliente[] clientesCadastrados) {
		this.idVendedor = idVendedor;
		this.nome = nome;
		this.zonaVenda = zonaVenda;
		this.clientesCadastrados = clientesCadastrados;
	}
	
	public Vendedor(String caminhoArquivo, int idVendedor) throws IOException{
		Leitor leitor = new Leitor(caminhoArquivo);
		Leitor leitorCliente = new Leitor("./src/dados/Cliente.txt");
		
		HashMap<String, String> vendedor = leitor.arrayChavesValores().stream().filter(id -> Integer.parseInt(id.get("idVendedor")) == idVendedor).findFirst().orElse(null);		 
		
		this.idVendedor = Integer.parseInt(vendedor.get("idVendedor"));
		this.nome = vendedor.get("nome");
		this.zonaVenda = new ZonaVenda("./src/dados/ZonaVenda.txt", vendedor.get("zonaVenda"));
		
		List<HashMap<String, String>> clientesUf = leitorCliente.arrayChavesValores().stream().filter(id -> id.get("uf").equals(zonaVenda.getUf())).collect(Collectors.toList());
		this.clientesCadastrados = new Cliente[clientesUf.size()];
		
		for (int i = 0; i < clientesUf.size(); i++) {
			HashMap<String, String> clienteUf = clientesUf.get(i);
			Cliente cliente = new Cliente (
					clienteUf.get("cpf"),
					clienteUf.get("nome"),
					new ZonaVenda ("./src/dados/ZonaVenda.txt", clienteUf.get("uf")));
			this.clientesCadastrados[i] = cliente;
		}
	}
	
	public String calcularComissao() {
		double comissao = 125;
		return "Por cada cliente cadastrado em " + zonaVenda.getNomeCompleto() + ", você recebeu: R$" + comissao + 
				"\nClientes cadastrados: " + clientesCadastrados.length +
				"\nTotal: R$" + comissao * clientesCadastrados.length;
	}
	
	@Override
	public String toString() {
		if (idVendedor == 0) {
			throw new IllegalStateException("PEDIDO NÃO PRESENTE NO SISTEMA!");
		} else {
			return "ID do Vendedor: " + idVendedor + "\nNome: " + nome + "\nZona de Venda: " + zonaVenda.getUf() + "\nClientes Cadastrados" + Arrays.toString(clientesCadastrados);
		}
	}
}
