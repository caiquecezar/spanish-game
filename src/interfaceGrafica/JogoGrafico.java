package interfaceGrafica;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import negocios.Frase;
import negocios.Jogo;
import negocios.Palavra;



public class JogoGrafico {
	private JTable palavrasErradas;
	private Timer timer;
	private Timer timer2;
	private int tempo;
	private ArrayList<JLabel> palavrasTela;
	private JLabel marcadorTempo = new JLabel();
	private JLabel marcadorVidas = new JLabel();
	private JLabel marcadorPontuacao= new JLabel();
	private JFrame fundoTela;
	private JButton botaoEnter;
	private JTextField barraSubmicao;
	private JButton botaoContinuar;
	private JOptionPane mensagemPerdeuVida;
	private Jogo game;
	public JogoGrafico(Jogo game) {
		this.game = game;
		tempo = game.getTempo();
	}
	public void iniciarJogo(){
		palavrasTela = new ArrayList<JLabel>();
		tempo = game.getTempo();
		if(this.game.getLevel() == 0) {
			this.game.setLevel();
			relogio();
			movimentacaoLabels();
		}
        iniciarTelaDeFundo();
	}
	private void iniciarTelaDeFundo() {
		this.fundoTela = new JFrame();
        fundoTela.setDefaultCloseOperation(fundoTela.DO_NOTHING_ON_CLOSE);
        fundoTela.setSize(800,600);
        fundoTela.setResizable(false);
		fundoTela.setVisible(true);
        fundoTela.setLayout(null);

        barraSubmicao = new JTextField();
        barraSubmicao.setText("");
		barraSubmicao.setSize(730, 30);
		barraSubmicao.setLocation(0,540);
		barraSubmicao.setVisible(true);
		barraSubmicao.setEditable(true);
		barraSubmicao.setEnabled(true);
		fundoTela.add(barraSubmicao);

        botaoEnter = new JButton();
		botaoEnter.setText("Enter");
		botaoEnter.setSize(70,30);
		botaoEnter.setLocation(730,540);
		botaoEnter.setEnabled(true);
		botaoEnter.setVisible(true);
		fundoTela.add(botaoEnter);
		
		botaoContinuar = new JButton();
		botaoContinuar.setText("Continuar");
		botaoContinuar.setSize(100,30);
		botaoContinuar.setLocation(700,540);
		botaoContinuar.setEnabled(true);
		botaoContinuar.setVisible(false);
		fundoTela.add(botaoContinuar);
	
		marcadorTempo.setText(""+tempo);
		marcadorTempo.setEnabled(true);
		marcadorTempo.setBounds(385,0,30,30);
		marcadorTempo.setVisible(true);
		fundoTela.add(marcadorTempo);

		marcadorVidas.setText(""+game.getVidasJogador());
		marcadorVidas.setBounds(0,0,30,30);
		ImageIcon icone1 = new ImageIcon("heart.png");   
		marcadorVidas.setIcon(icone1);
		marcadorVidas.setEnabled(true);
		marcadorVidas.setVisible(true);
		marcadorVidas.setHorizontalTextPosition((int) Component.CENTER_ALIGNMENT); 
		fundoTela.add(marcadorVidas);

		marcadorPontuacao.setText(""+game.getPontuacaoJogador());
		ImageIcon icone2 = new ImageIcon("star.png");
		marcadorPontuacao.setIcon(icone2);
		marcadorPontuacao.setVisible(true);
		marcadorPontuacao.setEnabled(true);
		marcadorPontuacao.setBounds(760,0,60,30);
        marcadorPontuacao.setHorizontalTextPosition((int) Component.CENTER_ALIGNMENT);
		fundoTela.add(marcadorPontuacao);
		
		fundoTela.repaint();


        fundoTela.addWindowListener(new WindowAdapter()  {
            public void windowClosing (WindowEvent e)  {
                    System.exit(0);
            } 
        });

        botaoEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEnterActionPerformed(evt);
            }
        });

        botaoContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoContinuarActionPerformed(evt);
            }
        });
        
        barraSubmicao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                barraSubmicaoKeyPressed1(evt);
            }
        });
	}
	public void movimentacaoLabels() {
		ActionListener action2 = new ActionListener() {  
                synchronized public void actionPerformed(ActionEvent e) {
                    for(JLabel j: palavrasTela){
                    	int c=0;
                    	ArrayList<Palavra> listaPalavras = game.getListaPalavras();
                    	for(Palavra p: listaPalavras) {
                    		if (p.getNome().equals(j.getText())&&j.isVisible()){
                    			c = p.getCor();
                    			break;
                    		}
                    	}
                    	if(j.getY()+c<510){
                    		j.setLocation(j.getX(),j.getY()+c);
                    	} else {
                    		j.setVisible(false);
                    		break;
                    	}
                    }
                    for(JLabel j: palavrasTela){
                    	ArrayList<Frase> listaFrases = game.getListaFrases();
            			int c=0;
            			for(Frase f: listaFrases) {
            				if (f.getNome().equals(j.getText())&&j.isVisible()){
            					c = f.getCor();
            					break;
            				}    
            			}
            			if(j.getY()+c<510){
        					j.setLocation(j.getX(),j.getY()+c);
            			} else {
        					j.setVisible(false);
        					break;
        				}
                    }
                    if(!(fundoTela.isVisible())) {
                    	System.exit(0);
                    }
            }  
		};
		timer2 = new Timer(50, action2);
		timer2.setInitialDelay(0);
		this.timer2.start(); 
	}
	private void relogio(){
        ActionListener action = new ActionListener() {
            synchronized public void actionPerformed(ActionEvent e) {
                if(tempo==0){
                	if(game.getPalavrasAcertadas()>=game.getQuantidadeMinima()){
                                mensagemPerdeuVida.showMessageDialog(null,"Felicidades... Nivel avanzado!");
                		mostrarPalavrasErradas();
                	} else {
                		if(game.getVidasJogador()>0){
                			mensagemPerdeuVida.showMessageDialog(null,"Su tiempo se ha terminado, no se ha alcanzado el l�mite m�nimo de palabras, haga clic en Aceptar para volver a intentarlo.");
                			game.diminuiVidaJogador();
                			mostrarPalavrasErradas();
                		} else {
                			mensagemPerdeuVida.showMessageDialog(null,"Juego ha terminado. Usted ya no tiene vida.");
                			game.diminuiVidaJogador();
                			mostrarPalavrasErradas();
                		}
                	}
                }
            	tempo--;
                String segundoString = "" + tempo;
                marcadorTempo.setText(segundoString);
                if(tempo>0) {
                	criadorPalavras();
                }
        }
	};
	timer = new Timer(1000, action);
	timer.setInitialDelay(0);
	this.timer.start();
	}
	
	private void mostrarPalavrasErradas(){
		timer.stop();
		timer2.stop();
		
		this.palavrasErradas = new JTable();
		String[] colunas = new String []{"Espanhol","Portugues"};
		DefaultTableModel modelo = new DefaultTableModel(new Object[][]{},colunas){
			Class[] types = new Class[] {java.lang.String.class,java.lang.String.class };
			boolean[] canEdit = new boolean[] { false, false};
			public Class getColumnClass (int columnIndex){
				return types[columnIndex];
			}
			public boolean isCellEditable (int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		};
		ArrayList<Palavra> listaPalavras = game.getListaPalavras();
                ArrayList<Frase> listaFrases = game.getListaFrases();
		palavrasErradas.setModel(modelo);
		palavrasErradas.setPreferredSize(new Dimension(400,30*(listaPalavras.size()+listaFrases.size())));
		palavrasErradas.setRowHeight(30);
		modelo.setNumRows(listaPalavras.size()+listaFrases.size());
		int i=0;
		for (Palavra p : listaPalavras){
			palavrasErradas.setValueAt( p.getNome(), i,0);
			palavrasErradas.setValueAt( p.getTraducao(), i,1);
			i++;
		}
                for (Frase f : listaFrases){
			palavrasErradas.setValueAt( f.getNome(), i,0);
			palavrasErradas.setValueAt( f.getTraducao(), i,1);
			i++;
		}
		palavrasErradas.setVisible(true);
		
		JScrollPane barraRolagem = new JScrollPane();
		barraRolagem.setBounds(200, 70, 400, 450);
		barraRolagem.setViewportView(palavrasErradas);
		fundoTela.add(barraRolagem);
		
		allComponentsInvisible();
		fundoTela.repaint();
	}
	
	private void allComponentsInvisible() {
		for (JLabel j : palavrasTela) {
			j.setVisible(false);
		}
		marcadorTempo.setVisible(false);
		marcadorVidas.setVisible(false);
		marcadorPontuacao.setVisible(false);
		botaoEnter.setVisible(false);
		barraSubmicao.setVisible(false);
		botaoContinuar.setVisible(true);
	}
	public void instanciaLabelFrase(Frase f) {
        JLabel j = new JLabel();
        j.setBackground(f.getCorLabel());
        j.setOpaque(true);
        j.setText(f.getNome());
        j.setHorizontalAlignment((int) Component.CENTER_ALIGNMENT);
        j.setBorder(BorderFactory.createRaisedBevelBorder());
        j.setBounds(0, 0, 300, 25);
        Random gerador = new Random();
        j.setLocation(gerador.nextInt(500),35);
        j.setVisible(true);
        palavrasTela.add(j);	
        fundoTela.add(j);
	}
	private void instanciaLabelPalavra(Palavra p) {
            JLabel j = new JLabel();
            j.setBackground(p.getCorLabel());
            j.setOpaque(true);
            j.setText(p.getNome());
            j.setHorizontalAlignment((int) Component.CENTER_ALIGNMENT);
            j.setBorder(BorderFactory.createRaisedBevelBorder());
            j.setBounds(0, 0, 100, 25);
            Random gerador = new Random();
            j.setLocation(gerador.nextInt(8)*100,35);
            j.setVisible(true);
            palavrasTela.add(j);	
            fundoTela.add(j);
	}
    private void barraSubmicaoKeyPressed(java.awt.event.KeyEvent evt) {
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try{
            	Palavra p;
            	p = game.comparaPalavras(this.barraSubmicao.getText());
            } catch(Exception e){ }
        }
    }
    private void botaoContinuarActionPerformed(java.awt.event.ActionEvent evt) {
        fundoTela.setVisible(false);
    	if(game.getPalavrasAcertadas()>=game.getQuantidadeMinima()){
    			game.atualizaLevel();
    			if(game.getLevel()<8){
    				
    				iniciarJogo();
                	game.iniciarJogo();
                	timer.start();
                	timer2.start();
    			}
    	} else {
    		if(game.getPalavrasAcertadas()<game.getQuantidadeMinima()&&game.getVidasJogador()>=0) {
                    game.restartPalavras();
                    iniciarJogo();
                    game.iniciarJogo();
                    timer.start();
                    timer2.start();
    		} else {
                    if (game.getPontuacaoJogador()>game.getPontuacaoMinima()) {
                    		game.gameOver();
                    }
                    MenuGrafico m = new MenuGrafico();
                    m.mostrarRecordes();
    		}
    	}
   }
    private void barraSubmicaoKeyPressed1(java.awt.event.KeyEvent evt) {
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        	Palavra p;
        	p = game.comparaPalavras(this.barraSubmicao.getText());
        	if(p!=null){
        		for(JLabel j: palavrasTela){
        			if (j.getText().equals(p.getNome())&&j.isVisible()){
        				if(p.isNormal()) {
        					game.atualizaPalavrasAcertadas();
        					game.atualizaPontuacao(p.calcularPontuacao());
        					destroiPalavra(j,p);
        					break;
        				} else {
        					if(p.getTroca()<(4-p.getCor())){
        						p.atualizaTroca();
        						j.setText(p.getNome());
        						break;
        					} else {
        						game.atualizaPalavrasAcertadas();
        						game.atualizaPontuacao(p.calcularPontuacao());
        						destroiPalavra(j, p);
        						break;
        					}
        				}

        			}
        		}
        	}
        	Frase f;
        	f = game.comparaFrases(this.barraSubmicao.getText());
        	if(f!=null){
        		for(JLabel j: palavrasTela){
        			if (j.getText().equals(f.getNome())&&j.isVisible()){
    					game.atualizaPalavrasAcertadas();
    					game.atualizaPontuacao(f.calcularPontuacao());
    					destroiFrase(j,f);
    					break;
        			}
        		}
        	}
        barraSubmicao.setText("");
		marcadorPontuacao.setText(""+game.getPontuacaoJogador());
		fundoTela.repaint();
        }
    }
    private void botaoEnterActionPerformed(java.awt.event.ActionEvent evt) {
    	game.comparaPalavras(this.barraSubmicao.getText());
         barraSubmicao.setText("");
    }
	private void criadorPalavras(){
		if(((61 - tempo)%(60/(game.getLevel()+2))==0)) {
			Palavra p = game.criadorPalavraArmadilha();
			instanciaLabelPalavra(p);
		} else {
			if(((61 - tempo)%(60/(game.getLevel()+1))==0)){
				Frase f = game.criadorFrase();
				instanciaLabelFrase(f);
			} else {
				if(((tempo+1)%(6-(game.getLevel()/2)))==0){
					Palavra p = game.criadorPalavraNormal();
					instanciaLabelPalavra(p);
				}
			}
		}
	}
	private void destroiPalavra(JLabel j, Palavra p2) {
		j.setVisible(false);
		game.removePalavra(p2);
		fundoTela.remove(j);
		fundoTela.repaint();
	}
    private void destroiFrase(JLabel j, Frase f) {
		j.setVisible(false);
		game.removeFrase(f);
		fundoTela.remove(j);
		fundoTela.repaint();
		
	}

	
}
