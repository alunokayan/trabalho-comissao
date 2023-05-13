package br.edu.ifsp.xyz.teste;

import java.io.IOException;

import br.edu.ifsp.xyz.leitor.Leitor;

public class LeitorTeste {

	public static void main(String[] args) throws IOException {
		Leitor leitor = new Leitor("./src/dados/Pedido.txt");
		System.out.println(leitor.arrayChavesValores());
	}
}
