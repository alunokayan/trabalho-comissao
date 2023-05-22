package br.edu.ifsp.xyz.teste;

import java.io.IOException;

import br.edu.ifsp.xyz.comissao.*;

public class RegiaoVendaTeste {
	public static void main(String[] args) throws IOException {
		long inicio = System.currentTimeMillis();
		RegiaoVenda regiao = new RegiaoVenda("./src/dados/RegiaoVenda.txt", "sul");
		System.out.println(regiao);
		System.out.println("---------------------------------");
		System.out.println("Tempo decorrido: " + (System.currentTimeMillis() - inicio) + "ms");
	}
}
