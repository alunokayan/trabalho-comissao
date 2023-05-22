package br.edu.ifsp.xyz.teste;

import java.io.IOException;

import br.edu.ifsp.xyz.comissao.*;

public class ProdutoTeste {
	public static void main(String[] args) throws IOException {
		Produto produto1 = new Produto("./src/dados/Produto.txt", "celular");
		System.out.println(produto1);
	}
}
