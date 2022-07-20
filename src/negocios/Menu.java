package negocios;

public class Menu {
	private Jogo game;
	private Ranking score;
	private String ajuda;
	private String sobre;
	public Menu() {
		this.ajuda  =  "......................................................................" +
				"AJUDA" +
				"...................................................................\n\n\n" +
		        "	Jogar esse jogo é relativamente simples, a ideia fundamental é\n" +
		        "digitar a tradução das palavras que aparecem na tela, ou seja, qual o significado\n" +
		        "da palavra em portugues.\n" +
		        "	Note que, no canto superior direito existe um coracao com um valor\n" +
		        "dentro dele esse valor representa a quantidade de vidas do jogador. No canto \n" +
		        "superior esquerdo existe uma estrela cujo valor dentro dela representa a\n" +
		        "pontuacao do jogador. E  importante dizer que na parte superior, bem no \n" +
		        "centro, entre o coracao e a estrela existe um numero que representa o \n" +
		        "tempo da fase que decresce do 60 ate o 0.\n" +
		        "	O jogo é composto por varios niveis, e cada nivel é a respeito de\n" +
		        "um assunto em particular como, por exemplo, cores.\n" +
		        "	Em cada nivel o jogador deverá acertar um quantidade minima de \n" +
		        "palavras que varia de nivel para nivel, só assim ele poderá passar para o próximo\n" +
		        "nivel.\n" +
		        "	Cuidado com algumas armadilhas que aparecem no processo... :D\n\n\n\n" +
		        "Bom jogo!";
		this.sobre = "......................................................................" +
				"SOBRE" +
				"......................................................................\n\n\n "+
		        "	Este Software é parte do projeto da disciplina Programação Orientada a\n" +
		        "Objetos ministrada pelo professor Rosalvo, docente da Universidade Federal do Vale do\n" +
		        "São Francisco.\n";
	}
	//Retorna a ajuda
	public String getAjuda() {
		return ajuda;
	}
	//Retorna o SObre
	public String getSobre() {
		return sobre;
	}
	//Comeca um novo jogo
	public void setGame(int i, int j, int k, String text, String data) {
		this.game = new Jogo (i,j,k,text,data);
		this.game.iniciarJogo();		
	}
	//Inicia o score
	public void setRanking() {
        score = new Ranking();
	}
	//Retorna o game
	public Jogo getGame() {
		return game;
	}
	//Retorna o score
	public Ranking getRanking() {
		return score;
	}

	
}
