package negocios;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import persistencia.Arquivo;


public class Nivel {
	private String caminho;
	private int quantidadeMinima;
	private int level;
	private ArrayList<Dicionario> dicionario;
	private ArrayList<Dicionario> dicFrases;
	private Arquivo arquivo;
	public Nivel(int level) {
		this.level = level;
	}
	//Avanca para o proximo level
	public void atualizaLevel(){
		level++;
		this.atualizaCaminho();
		this.atualizaQuantidadeMinima();
		this.geraDicionario();		
		
	}
	//Atualiza a quantidade minima de palavra que o  jogador tem que acertar
	private void atualizaQuantidadeMinima() {
		if (level == 1) {
			quantidadeMinima = 3;	
		} else {
			quantidadeMinima+=3+((level+1)/3);
		}
	}
	//Atualiza o caminho do arquivo
	private void atualizaCaminho() {
		switch(level){
			case 1:
				caminho = "cores.txt";
				break;
			case 2:
				caminho = "tempo.txt";
				break;
			case 3:
                caminho = "frutas.txt";
                break;
			case 4:
				caminho = "corpohumano.txt";
                break;
			case 5:
                caminho = "profissoes.txt";
                break;
			case 6:
                caminho = "animais.txt";
                break;
			case 7:
				caminho = "verbos.txt";
				break;
			case 8:
                caminho = "verbos.txt";
                break;
		}
	}
	//Inicializa o dicionario
	public void geraDicionario(){
		dicionario = new ArrayList<Dicionario>();
		arquivo = new Arquivo();
		ArrayList<String> linhas = new ArrayList<String>();
			
		try {
			linhas = arquivo.carregarArquivo(caminho);
		} catch (FileNotFoundException e) {
			System.out.println("O arquivo, por algum motivo, nao pode ser lido!");
			System.exit(0);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("O arquivo, por algum motivo, nao pode ser lido!");
			System.exit(0);
			e.printStackTrace();
		}		
	
		for(String s: linhas){
			Dicionario d;
			String[] values = s.split(";");
			d = new Dicionario(values[0],values[1]);
			dicionario.add(d);
		}	
		
		dicFrases = new ArrayList<Dicionario>();
		ArrayList<String> linha = new ArrayList<String>();
			
		try {
			linha = arquivo.carregarArquivo("frases.txt");
		} catch (FileNotFoundException e) {
			System.out.println("O arquivo, por algum motivo, nao pode ser lido!");
			System.exit(0);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("O arquivo, por algum motivo, nao pode ser lido!");
			System.exit(0);
			e.printStackTrace();
		}		
	
		for(String s: linha){
			Dicionario d2;
			String[] value = s.split(";");
			d2 = new Dicionario(value[0],value[1]);
			dicFrases.add(d2);
		}	
	}
	//retorna a quantidade minima
	public int getQuantidadeMinima(){
		return quantidadeMinima;
	}
	//retorna o level
	public int getLevel() {
		return level;
	}
	//Retorna uma palavra do dicionario
	public Dicionario geraPalavra() {
            Random gerador = new Random();
            int x = gerador.nextInt(dicionario.size());
            Dicionario p = dicionario.get(x);
            dicionario.remove(x);
            return p;
	}
	//Retorna uma Frase do dicionario
	public Dicionario geraFrase() {
        Random gerador = new Random();
        int x = gerador.nextInt(dicFrases.size());
        Dicionario p = dicFrases.get(x);
        dicFrases.remove(x);
        return p;
	}
}