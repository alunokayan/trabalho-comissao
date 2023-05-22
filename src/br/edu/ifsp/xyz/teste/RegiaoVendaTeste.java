package br.edu.ifsp.xyz.teste;

import java.io.IOException;

import br.edu.ifsp.xyz.comissao.*;

public class RegiaoVendaTeste {
	public static void main(String[] args) throws IOException {
		RegiaoVenda regiao = new RegiaoVenda("./src/dados/RegiaoVenda.txt", "sul");
		System.out.println(regiao);
	}
}
