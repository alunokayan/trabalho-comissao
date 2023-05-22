package br.edu.ifsp.xyz.teste;

import java.io.IOException;

import br.edu.ifsp.xyz.comissao.*;

public class ZonaVendaTeste {
	public static void main(String[] args) throws IOException {
		ZonaVenda zona = new ZonaVenda("./src/dados/ZonaVenda.txt", "");
		System.out.println(zona);
	}
}
