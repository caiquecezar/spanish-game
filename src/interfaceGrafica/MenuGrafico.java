package interfaceGrafica;


import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import negocios.Menu;

public class MenuGrafico {
    private JFrame telaMenu;
    private JButton botaoJogar;
    private JButton botaoRanking;
    private JButton botaoAjuda;
    private JButton botaoSobre;
    private JButton botaoFechar;
    private JButton botaoOk;
    private JTextField nomeJogador;
    private JLabel nomeFixo;
    private JTextArea textoAjuda;
    private JTextArea textoSobre;
    private JButton botaoVoltar;
    private Menu menu;
    private JogoGrafico jg;
    private RankingGrafico rg;
    public MenuGrafico () {
    	this.menu = new Menu();
    	iniciarComponentes();
    }
    private void iniciarComponentes() {
        this.telaMenu = new JFrame();
        telaMenu.setSize(800,600);
        telaMenu.setResizable(false);
        telaMenu.setVisible(true);
        telaMenu.setLayout(null);
        telaMenu.setDefaultCloseOperation(telaMenu.DO_NOTHING_ON_CLOSE);
        
        this.botaoJogar = new JButton();
        botaoJogar.setText("Jugar");
        botaoJogar.setSize(130,30);
        botaoJogar.setLocation(50,50);
        botaoJogar.setEnabled(true);
        botaoJogar.setVisible(true);
        telaMenu.add(botaoJogar);

        this.nomeFixo = new JLabel();
        nomeFixo.setText("Nombre:");
        nomeFixo.setSize(100,25);
        nomeFixo.setEnabled(true);
        nomeFixo.setVisible(false);
        nomeFixo.setLocation(190, 24);
        telaMenu.add(nomeFixo);
        
        this.botaoRanking = new JButton();
        botaoRanking.setText("Mejores Tempos");
        botaoRanking.setSize(130,30);
        botaoRanking.setLocation(50,150);
        botaoRanking.setEnabled(true);
        botaoRanking.setVisible(true);
        telaMenu.add(botaoRanking);
        
        this.botaoAjuda = new JButton();
        botaoAjuda.setText("Ayuda");
        botaoAjuda.setSize(130,30);
        botaoAjuda.setLocation(50,250);
        botaoAjuda.setEnabled(true);
        botaoAjuda.setVisible(true);
        telaMenu.add(botaoAjuda);
        
        this.botaoSobre = new JButton();
        botaoSobre.setText("Acerca de ...");
		botaoSobre.setSize(130,30);
		botaoSobre.setLocation(50,350);
		botaoSobre.setEnabled(true);
        botaoSobre.setVisible(true);
        telaMenu.add(botaoSobre);
        
        this.botaoFechar = new JButton();
        botaoFechar.setText("Salir");
        botaoFechar.setSize(130,30);
        botaoFechar.setLocation(650,520);
        botaoFechar.setEnabled(true);
        botaoFechar.setVisible(true);
        telaMenu.add(botaoFechar);

        this.nomeJogador = new JTextField();
        nomeJogador.setText("");
        nomeJogador.setSize(250, 30);
        nomeJogador.setLocation(190,50);
        nomeJogador.setVisible(false);
        telaMenu.add(nomeJogador);

        this.botaoOk = new JButton();
        botaoOk.setText("Ok");
        botaoOk.setSize(50,30);
        botaoOk.setLocation(390,85);
        botaoOk.setVisible(false);
        telaMenu.add(botaoOk);

        this.botaoVoltar = new JButton();
        botaoVoltar.setText("Voltar");
        botaoVoltar.setSize(130,30);
        botaoVoltar.setLocation(650,520);
        botaoVoltar.setEnabled(true);
        botaoVoltar.setVisible(false);
        telaMenu.add(botaoVoltar);
        
        this.textoAjuda = new JTextArea();
        textoAjuda.setText(menu.getAjuda());
        textoAjuda.setBackground(telaMenu.getBackground());
        textoAjuda.setSize(500,500);
        textoAjuda.setVisible(false);
        textoAjuda.setEditable(false);
        textoAjuda.setLocation(150, 50);
        telaMenu.add(textoAjuda);
        
        this.textoSobre = new JTextArea();
        textoSobre.setText(menu.getSobre());
        textoSobre.setBackground(telaMenu.getBackground());
        textoSobre.setSize(500,500);
        textoSobre.setVisible(false);
        textoSobre.setEditable(false);
        textoSobre.setLocation(150, 50);
        telaMenu.add(textoSobre);
        
        telaMenu.addWindowListener(new WindowAdapter()  {
            public void windowClosing (WindowEvent e)  {
                    System.exit(0);
            }
        });

        botaoJogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jogarActionPerformed(evt);
            }
        });
        botaoRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rankingActionPerformed(evt);
            }
        });
        botaoAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajudaActionPerformed(evt);
            }
        });
        botaoSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sobreActionPerformed(evt);
            }
        });
        botaoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        botaoFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharActionPerformed(evt);
            }
        });
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });
        nomeJogador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeJogadorKeyPressed(evt);
            }
        });      
    }
	private void nomeJogadorKeyPressed(java.awt.event.KeyEvent evt) {
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try{
                if(nomeJogador.getText().equals("")){
                	JOptionPane msg = new JOptionPane();
                	msg.showMessageDialog(null,"Tu nombre no puede ser vazio, mi compadre!!");
                  	
                } else {
                    GregorianCalendar d = new GregorianCalendar();
                    String data;
                    data = ""+d.getTime();
                    menu.setGame(0,3,0,nomeJogador.getText(),data);
                    jg = new JogoGrafico(menu.getGame());
            		this.jg.iniciarJogo();
                    this.telaMenu.setVisible(false);            	
                }
            } catch(Exception e){ }
        }
    }
    
    private void fecharActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    public void mostrarRecordes (){
    	menu.setRanking();
    	rg = new RankingGrafico (menu.getRanking());
        this.telaMenu.setVisible(false);        
    }

    private void rankingActionPerformed(java.awt.event.ActionEvent evt) {
    	menu.setRanking();
    	rg = new RankingGrafico (menu.getRanking());
        this.telaMenu.setVisible(false);
    }

    private void ajudaActionPerformed(java.awt.event.ActionEvent evt) {
    	botaoJogar.setVisible(false);
       	botaoRanking.setVisible(false);
       	botaoAjuda.setVisible(false);
       	botaoSobre.setVisible(false);
       	botaoFechar.setVisible(false);
       	botaoOk.setVisible(false);
       	nomeJogador.setVisible(false);
        this.nomeFixo.setVisible(false);
       	
       	botaoVoltar.setVisible(true);
    	textoAjuda.setVisible(true);
    }

    private void sobreActionPerformed(java.awt.event.ActionEvent evt) {
    	botaoJogar.setVisible(false);
       	botaoRanking.setVisible(false);
       	botaoAjuda.setVisible(false);
       	botaoSobre.setVisible(false);
       	botaoFechar.setVisible(false);
       	botaoOk.setVisible(false);
       	nomeJogador.setVisible(false);
        this.nomeFixo.setVisible(false);
       	
		botaoVoltar.setVisible(true);
		textoSobre.setVisible(true);
    }
    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {
    	MenuGrafico m = new MenuGrafico();
    	this.telaMenu.setVisible(false);
    }
    private void okActionPerformed(java.awt.event.ActionEvent evt) {
    	 if(nomeJogador.getText().equals("")){
         	JOptionPane msg = new JOptionPane();
         	msg.showMessageDialog(null,"Tu nombre no puede ser vazio, mi compadre!!");         	
         } else {
             Date d = new Date();
             String data;
             data = ""+d.getDay()+"/"+d.getDate()+"/"+d.getYear();
             menu.setGame(0,3,0,nomeJogador.getText(),data);
             jg = new JogoGrafico(menu.getGame());
     		this.jg.iniciarJogo();
             this.telaMenu.setVisible(false);            	
         }
    }

    private void jogarActionPerformed(java.awt.event.ActionEvent evt) {
        this.nomeJogador.setEnabled(true);
        this.nomeJogador.setVisible(true);
        this.nomeJogador.setEditable(true);
        this.botaoOk.setVisible(true);
        this.nomeFixo.setVisible(true);
        
    }
}
