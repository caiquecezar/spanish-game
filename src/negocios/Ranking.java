package negocios;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import persistencia.Arquivo;



public class Ranking {
    private Jogo[] melhoresJogos;
    private Arquivo arquivo;
    public Ranking (){
        melhoresJogos = new Jogo[10];
        adquireValues();
    }
    //Inicia os melhoresJogos
    private void adquireValues() {
		arquivo = new Arquivo();
        ArrayList<String> l = new ArrayList<String>();

        try {
            l = arquivo.carregarArquivo("recordes.txt");
        } catch (FileNotFoundException e) {
			System.out.println("O arquivo, por algum motivo, nao pode ser lido!");
			e.printStackTrace();
        } catch (IOException e) {
			System.out.println("O arquivo, por algum motivo, nao pode ser lido!");
			e.printStackTrace();
        }
        
        int i=0;
        for(String s: l){
        	String[] v = s.split(";");
			melhoresJogos[i] = new Jogo(Integer.parseInt(v[0]),Integer.parseInt(v[1]),Integer.parseInt(v[2]),v[3],v[4]);
        	i++;
        }
    }
    public int getMenorPontuacao(){
    	return melhoresJogos[9].getPontuacaoJogador();
    }
    //Atualiza o ranking caso o usuario faça a pontuacao necessaria
	public void atualizarRanking(Jogo jogo) {
		melhoresJogos[9] = jogo;
		int i=9;
		while(melhoresJogos[i].getPontuacaoJogador()>melhoresJogos[i-1].getPontuacaoJogador()){
			Jogo j = melhoresJogos[i-1];
			melhoresJogos[i-1] = melhoresJogos[i];
			melhoresJogos[i] = j;
			if(i==1){
				break;
			}
			i--;
		}
		
		try {
			arquivo.limpaRecordes();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		for(i=0;i<10;i++){
			String linha = ""+melhoresJogos[i].getLevel()+";"+melhoresJogos[i].getVidasJogador()+";"+melhoresJogos[i].getPontuacaoJogador()+";"+melhoresJogos[i].getNomeJogador()+";"+melhoresJogos[i].getData();
			try {
				arquivo.salvarArquivo(linha);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//Retorna o nome do jogador que bateu o recorde da posicao i
	public Object getNomeJogador(int i) {
		return melhoresJogos[i].getNomeJogador();
	}
	//Retorna a pontuacao do jogador que bateu o recorde da posicao i
	public Object getPontuacaoJogador(int i) {
		return melhoresJogos[i].getPontuacaoJogador();
	}
	//Retorna a data que o jogador que bateu o recorde da posicao i
	public Object getDataJogador(int i) {
		return melhoresJogos[i].getData();
	}
}
