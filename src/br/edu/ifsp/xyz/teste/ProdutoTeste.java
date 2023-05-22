package br.edu.ifsp.xyz.teste;

import java.io.IOException;

import br.edu.ifsp.xyz.comissao.*;

public class ProdutoTeste {
	public static void main(String[] args) throws IOException {
		long inicio = System.currentTimeMillis();
		Produto produto1 = new Produto("./src/dados/Produto.txt", "celular");
		System.out.println(produto1);
		System.out.println("---------------------------------");
		System.out.println("Tempo decorrido: " + (System.currentTimeMillis() - inicio) + "ms");
	}
}
