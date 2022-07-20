package negocios;
import interfaceGrafica.MenuGrafico;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Jogo {
	private int palavrasAcertadas;
	private Nivel level;
	private int tempo;
	private int vidaJogador;
	private int pontuacaoJogador;
	private String nomeJogador;
	private ArrayList<Palavra> listaPalavras;
    private ArrayList<Frase> listaFrases;
    private Frase f;
	private Palavra p;
	private String data;
	private Ranking ranking;
	public Jogo(int level, int vidaJogador, int pontuacaoJogador,
			String nomeJogador, String data) {
		this.palavrasAcertadas = 0; 
		this.vidaJogador = vidaJogador;
		this.pontuacaoJogador = pontuacaoJogador;
		this.nomeJogador = nomeJogador;
		this.level = new Nivel(level);
        this.data = data;
	}
	
	//comeca um novo jogo
	public void iniciarJogo(){
		this.listaPalavras = new ArrayList<Palavra>();
		this.listaFrases = new ArrayList<Frase>();
		this.palavrasAcertadas = 0;
		tempo = 60;
	}
	//retorna o level da fase
	public int getLevel() {
		return level.getLevel();
	}
	//muda para o proximo level
	public void setLevel() {
		this.level.atualizaLevel();
	}
	//retorna a quantidade de vidas do jogadaor
	public int getVidasJogador() {
		return this.vidaJogador;
	}
	//retorna a data
	public String getData() {
        return data;
    }
	//retorna o nome do jogador
    public String getNomeJogador() {
        return nomeJogador;
    }
//retorna a pontucao do jogador
    public int getPontuacaoJogador() {
        return pontuacaoJogador;
    }
    //retorna todo o array das palavras
	public ArrayList<Palavra> getListaPalavras() {
		return this.listaPalavras;
	}
	//retorna todo o array das frases
	public ArrayList<Frase> getListaFrases() {
		return this.listaFrases;
	}
	//retorna a quantidade minima de palavras que tem que acertar para passar de fase
	public int getQuantidadeMinima() {
		return level.getQuantidadeMinima();
	}
	// retorna a quantidade de palavras que o usuario acertou ate o momento
	public int getPalavrasAcertadas() {
		return this.palavrasAcertadas;
	}
	//diminui a vida quando o jogador nao atinge a quantidade minima de palavras
	public void diminuiVidaJogador() {
		this.vidaJogador--;
	}
	//atualiza o level da fase quando o usuario passa de fase
	public void atualizaLevel() {
		this.level.atualizaLevel();
		if(level.getLevel()==8) {
			if (this.getPontuacaoJogador()>this.getPontuacaoMinima()) {
				this.gameOver();
			}
			MenuGrafico m = new MenuGrafico();
			m.mostrarRecordes();
		}
	}
	//cria uma palavra 'normal'
	public Palavra criadorPalavraNormal() {
		p = new Normal(level);
		listaPalavras.add(p);
		return p;
	}
	//cria uma palavra 'armadilha'
	public Palavra criadorPalavraArmadilha() {
		p = new Armadilha(level);
		listaPalavras.add(p);
		return p;
		
	}
	//cria uma frase
	public Frase criadorFrase() {
		f = new Frase(level);
		listaFrases.add(f);
		return f;
	}
	//compara a palavra que o jogador digitou com a palavra correta e retorna a palavra certa caso o jogador acerte
	public Palavra comparaPalavras(String submicao) {
		for(Palavra p: listaPalavras) {
			if(submicao.toLowerCase().equals(p.getTraducao().toLowerCase())){
				return p;
			}
		}
		return null;
	}
	//atualiza a pontuacao do jogado quando ele acerta uma palavra
	public void atualizaPontuacao(int calcularPontuacao) {
		this.pontuacaoJogador+=calcularPontuacao;
		
	}
	//atualiza a quantidade de pálavra que o jogador acertou
	public void atualizaPalavrasAcertadas() {
		this.palavrasAcertadas++;
		
	}
	//remove uma palavra da lista de palavras
	public void removePalavra(Palavra p2) {
		this.listaPalavras.remove(p2);	
	}
	//remove uma frase da lista
	public void removeFrase(Frase f) {
		this.listaFrases.remove(f);	
	}
	//compara a frase que o jogador digitou com a palavra correta e retorna a palavra certa caso o jogador acerte
	public Frase comparaFrases(String submicao) {
		for(Frase f: listaFrases) {
			if(submicao.toLowerCase().equals(f.getTraducao().toLowerCase())){
				return f;
			}
		}
		return null;
	}
	//retorna o tempo
	public int getTempo() {
		return tempo;
	}
	//reseta o dicionario se o jogador nao passar de fase
	public void restartPalavras() {
		level.geraDicionario();
	}
	//atualiza o ranking se o jogador tiver conseguido bater o recorde
	public void gameOver() {
                ranking.atualizarRanking(this);
	}
	//retorna a pontuacao minima para passar de fase
    public int getPontuacaoMinima() {
        this.ranking = new Ranking();
        return ranking.getMenorPontuacao();

    }
	
}
