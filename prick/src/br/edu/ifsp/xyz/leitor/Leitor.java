package br.edu.ifsp.xyz.leitor;

import java.util.*;
import java.io.*;

public class Leitor {
	private String caminhoArquivo;
	private List<String[]> linhasSeparadasPontoVirgula = new ArrayList<>();
	private List<HashMap<String, String>> arrayChavesValores = new ArrayList<>();
	
	public Leitor(String caminhoArquivo) throws IOException {
		this.caminhoArquivo = caminhoArquivo;
		lerLinhas();
		definirArrayChavesValores();
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
	        linhasSeparadasPontoVirgula.add(partes);
	    }
		
		leitorArquivo.close();
	}
	
	private void definirArrayChavesValores() throws IOException {
		for(int i = 1; i < linhasSeparadasPontoVirgula.size(); i++) {
			HashMap<String, String> novoHash = new HashMap<String, String>();
		
			for(int j = 0; j < linhasSeparadasPontoVirgula.get(i).length; j++) {
				novoHash.put(linhasSeparadasPontoVirgula.get(0)[j], linhasSeparadasPontoVirgula.get(i)[j]);
			}
			
			arrayChavesValores.add(novoHash);
		}
	}
	
	public List<HashMap<String, String>> getArrayChavesValores() {
		return arrayChavesValores;
	}
}