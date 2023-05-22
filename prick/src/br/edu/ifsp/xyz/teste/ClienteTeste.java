package br.edu.ifsp.xyz.teste;

import java.io.IOException;

import br.edu.ifsp.xyz.comissao.*;

public class ClienteTeste {

	public static void main(String[] args) throws IOException{
		long inicio = System.currentTimeMillis();
		Cliente cliente = new Cliente("./src/dados/Cliente.txt", "678.789.012-34");
		System.out.println(cliente);
		System.out.println("---------------------------------");
		System.out.println("Tempo decorrido: " + (System.currentTimeMillis() - inicio) + "ms");
	}
}
