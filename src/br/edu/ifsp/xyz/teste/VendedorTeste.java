package br.edu.ifsp.xyz.teste;

import java.io.IOException;

import br.edu.ifsp.xyz.comissao.*;

public class VendedorTeste {
	public static void main(String[] args) throws IOException {
		long inicio = System.currentTimeMillis();
		Vendedor vendedor = new Vendedor("./src/dados/Vendedor.txt", 111);
		System.out.println("---------------------------------");
		System.out.println(vendedor.calcularComissao());
		System.out.println("Tempo decorrido: " + (System.currentTimeMillis() - inicio) + "ms");
	}
}
