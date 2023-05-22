package br.edu.ifsp.xyz.teste;

import java.io.IOException;

import br.edu.ifsp.xyz.leitor.Leitor;

public class LeitorTeste {

	public static void main(String[] args) throws IOException {
		long inicio = System.currentTimeMillis();
		Leitor leitor = new Leitor("./src/dados/Pedido.txt");
		System.out.println(leitor.getArrayChavesValores());
		System.out.println("---------------------------------");
		System.out.println("Tempo decorrido: " + (System.currentTimeMillis() - inicio) + "ms");
	}
}
