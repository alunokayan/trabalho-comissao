package br.edu.ifsp.xyz.leitor;

import java.util.*;
import java.io.*;

public class Leitor {
	private String caminhoArquivo;
	
	public Leitor(String caminhoArquivo) throws IOException {
		this.caminhoArquivo = caminhoArquivo;
	}
	
	private ArrayList<ArrayList <String>> lerLinhas() throws IOException {
		BufferedReader leitor = new BufferedReader(new FileReader(this.caminhoArquivo));
		ArrayList<String> linhas = new ArrayList<String>();
		
		String linhaAtual = leitor.readLine();
		while (linhaAtual != null) {
			linhas.add(linhaAtual);
			linhaAtual = leitor.readLine();
		}
		
		ArrayList<ArrayList<String>> matriz = new ArrayList<ArrayList<String>>();
		for (String linha : linhas) {
			String[] partes = linha.split(";");
			ArrayList<String> novaLinha = new ArrayList<String>(Arrays.asList(partes));
	        matriz.add(novaLinha);
	    }
		
		leitor.close();
		 
		return matriz;
	}
	
	public ArrayList<HashMap<String, String>> arrayChavesValores() throws IOException {
		ArrayList<HashMap<String, String>> chavesValores = new ArrayList<HashMap<String, String>>();
		ArrayList<ArrayList <String>> linhas = lerLinhas(); //Guardando o método lerLinhas() numa variável
		
		for(int i = 1; i < linhas.size(); i++) {
			HashMap<String, String> novoHash = new HashMap<String, String>();
			
			for(int j = 0; j < linhas.get(i).size(); j++) {
				novoHash.put(linhas.get(0).get(j), linhas.get(i).get(j));
			}
			
			chavesValores.add(novoHash);
		}
		
		return chavesValores;
	}
}
