package negocios;

public class Dicionario {
	private String portugues;
	private String espanhol;
	public Dicionario(String portugues, String espanhol) {
		this.portugues = portugues;
		this.espanhol = espanhol;
	}
	//Metodos get-sets normais
	public String getPortugues() {
		return portugues;
	}
	public void setPortugues(String portugues) {
		this.portugues = portugues;
	}
	public String getEspanhol() {
		return espanhol;
	}
	public void setEspanhol(String espanhol) {
		this.espanhol = espanhol;
	}
	
}
