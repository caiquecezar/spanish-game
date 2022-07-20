package negocios;

public class Armadilha extends Palavra {
	private Dicionario[] palavraArmadilha = new Dicionario[4] ;
	public Armadilha(Nivel l) {
		super(l);
		troca=0;
        for(int i=0;i<(5-getCor());i++){
            palavraArmadilha[i] = l.geraPalavra();
        }
	}
	
	@Override
	public String getNome() {
		return palavraArmadilha[troca].getEspanhol();
	}
	@Override
	public String getTraducao() {
		return palavraArmadilha[troca].getPortugues();
	}
	@Override
	public int calcularPontuacao() {
		return (10*super.getCor()*(5-super.getCor()));
	}
	@Override
	public boolean isNormal(){
		return false;
	}
	
	
}

