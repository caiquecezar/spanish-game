package negocios;
import java.awt.Color;

public class Frase implements Retornavel{
	private Nivel level;
	private Color cor;
	private Dicionario dicionario;
	public Frase (Nivel l){
		level = l;
		cor = Color.green;
		dicionario = level.geraFrase();
	}
	//calcula a pontuacao pra quem acertar a frase
	public int calcularPontuacao(){
		return (3*dicionario.getEspanhol().length());
	}
	@Override
	public String getNome() {
		return dicionario.getEspanhol();
	}

	@Override
	public String getTraducao() {
		return dicionario.getPortugues();
	}
	//retorna a cor da frase
	public Color getCorLabel(){
        return cor;
	}
	//retorna 1 para a velocidade da frase
	public int getCor() {
		return 1;
	}

}
