package br.edu.ifsp.xyz.teste;

import java.io.IOException;

import br.edu.ifsp.xyz.comissao.*;

public class RepresentanteTeste {
	public static void main(String[] args) throws IOException {
		Representante representante = new Representante("./src/dados/Representante.txt", "sudeste");
		System.out.println(representante);
	}
}
