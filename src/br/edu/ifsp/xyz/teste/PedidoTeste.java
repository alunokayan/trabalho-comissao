package br.edu.ifsp.xyz.teste;
import java.io.IOException;
import java.util.*;

import br.edu.ifsp.xyz.comissao.*;


public class PedidoTeste {

	public static void main(String[] args) throws IOException {
		long inicio = System.currentTimeMillis();
		Pedido pedido = new Pedido("./src/dados/Pedido.txt", "1");
		System.out.println(Arrays.toString(pedido.getProdutos()));
		System.out.println("---------------------------------");
		System.out.println("Tempo decorrido: " + (System.currentTimeMillis() - inicio) + "ms");
	}

}
