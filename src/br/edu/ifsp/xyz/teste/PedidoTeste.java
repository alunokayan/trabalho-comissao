package br.edu.ifsp.xyz.teste;
import java.io.IOException;

import br.edu.ifsp.xyz.comissao.*;

public class PedidoTeste {

	public static void main(String[] args) throws IOException {
		long inicio = System.currentTimeMillis();
		Pedido pedido = new Pedido("./src/dados/Pedido.txt", "10");
		System.out.println(pedido);
		System.out.println("---------------------------------");
		System.out.println("Tempo decorrido: " + (System.currentTimeMillis() - inicio) + "ms");
	}

}
