package negocios;
import java.awt.Color;
import java.util.Random;


public abstract class Palavra implements Retornavel{
	protected Color cor;
	protected Nivel level;
	protected int troca = 0;
	public Palavra(Nivel l){
		level = l;
		setCor();
	}
	//Retorna a cor tipo Color
	public Color getCorLabel(){
            return cor;
	}
	//Retorna um int para a velocidade dos labels
	public int getCor() {
		if(cor == Color.red){
			return 3;
		} else {
			if(cor == Color.yellow){
				return 2;
			} else {
				if(cor == Color.green){
					return 1;
				}
			}
		}
		return 0;
	}
	//Escolhe uma cor aleatoriamente
	private void setCor() {
        Random gerador = new Random();
        int i=gerador.nextInt(10);
        if(i<7) {
            cor = Color.green;
        } else {
                if(i<9) {
                    cor = Color.YELLOW;
                } else {
                    cor = Color.red;
                }
        }
	}
	//Calcular a pontuacao (existe formas diferentes para palavra Normar e Armadilha
	public abstract int calcularPontuacao();
	//Retorna um boleano que diz se a palavra e normal ou nao
	public abstract boolean isNormal();
	//muda o valor da troca (necessario para palavra Armadilha)
	public void atualizaTroca() {
		troca++;
	}
	//Retorna o valor da troca
	public int getTroca(){
		return troca;
	}
	
}
