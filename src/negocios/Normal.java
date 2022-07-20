package negocios;

public class Normal extends Palavra {
	private Dicionario palavraNormal;

	public Normal(Nivel l) {
		super(l);
		palavraNormal = l.geraPalavra();
	}
	@Override
	public String getNome() {
		return palavraNormal.getEspanhol();
	}
	@Override
	public String getTraducao() {
		return palavraNormal.getPortugues();
	}
	@Override
	public int calcularPontuacao() {
		return (10*super.getCor());
	}
	@Override
	public boolean isNormal(){
		return true;
	}
}
