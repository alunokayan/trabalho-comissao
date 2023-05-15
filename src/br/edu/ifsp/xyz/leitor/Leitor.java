package br.edu.ifsp.xyz.leitor;

import java.util.*;
import java.io.*;

public class Leitor {
	private String caminhoArquivo;
	private List<String[]> linhasSeparadas = new ArrayList<>();
	private List<HashMap<String, String>> chavesValores = new ArrayList<>();
	
	public Leitor(String caminhoArquivo) throws IOException {
		this.caminhoArquivo = caminhoArquivo;
		lerLinhas();
		definirChavesValores();
	}
	
	private void lerLinhas() throws IOException {
		BufferedReader leitorArquivo = new BufferedReader(new FileReader(this.caminhoArquivo));
		List<String> linhas = new ArrayList<>();
		
		String linhaAtual = leitorArquivo.readLine();
		while (linhaAtual != null) {
			linhas.add(linhaAtual);
			linhaAtual = leitorArquivo.readLine();
		}
		
		for (String linha : linhas) {
			String[] partes = linha.split(";");
	        linhasSeparadas.add(partes);
	    }
		
		leitorArquivo.close();
	}
	
	private void definirChavesValores() throws IOException {
		for(int i = 1; i < linhasSeparadas.size(); i++) {
			HashMap<String, String> novoHash = new HashMap<String, String>();
		
			for(int j = 0; j < linhasSeparadas.get(i).length; j++) {
				novoHash.put(linhasSeparadas.get(0)[j], linhasSeparadas.get(i)[j]);
			}
			
			chavesValores.add(novoHash);
		}
	
		System.out.println(chavesValores);
	}
}
