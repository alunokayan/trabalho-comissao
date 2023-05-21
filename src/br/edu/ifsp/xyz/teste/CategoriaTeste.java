package br.edu.ifsp.xyz.teste;

import java.io.IOException;

import br.edu.ifsp.xyz.comissao.*;

public class CategoriaTeste {
	public static void main(String[] args) throws IOException {
		Categoria categoria = new Categoria("./src/dados/Categoria.txt", "moda");
		System.out.println(categoria);
	}
}