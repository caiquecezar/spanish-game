package interfaceGrafica;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import negocios.Menu;
import negocios.Palavra;
import negocios.Ranking;

public class RankingGrafico {
    private JButton botaoVoltar;
    private JFrame telaRanking;
    private JTable tabelaRanking;
    private Ranking score;
    public RankingGrafico (Ranking score){
    	this.score = score;
        iniciaComponentes();
    }
    private void iniciaComponentes() {
        this.telaRanking = new JFrame();
        telaRanking.setSize(800,600);
        telaRanking.setResizable(false);
        telaRanking.setVisible(true);
        telaRanking.setLayout(null);
        telaRanking.setDefaultCloseOperation(telaRanking.DO_NOTHING_ON_CLOSE);
        
        this.tabelaRanking = new JTable();
        telaRanking.add(tabelaRanking);
        
        this.botaoVoltar = new JButton();
        botaoVoltar.setText("Voltar");
        botaoVoltar.setSize(130,30);
        botaoVoltar.setLocation(650,520);
        botaoVoltar.setEnabled(true);
        botaoVoltar.setVisible(true);
        telaRanking.add(botaoVoltar);
        
		this.tabelaRanking = new JTable();
                String[] colunas = new String []{"Nome","Pontuacao","Data"};
                DefaultTableModel modelo = new DefaultTableModel(new Object[][]{},colunas){
		Class[] types = new Class[] {java.lang.String.class,java.lang.String.class,java.lang.String.class };
		boolean[] canEdit = new boolean[] { false, false,false};
		public Class getColumnClass (int columnIndex){
			return types[columnIndex];
		}
		public boolean isCellEditable (int rowIndex, int columnIndex) {
			return canEdit[columnIndex];
		}
	};
	tabelaRanking.setModel(modelo);
	tabelaRanking.setPreferredSize(new Dimension(450,300));
	tabelaRanking.setRowHeight(30);
	modelo.setNumRows(10);
	int i=0;
	for (i=0;i<10;i++){
		tabelaRanking.setValueAt( score.getNomeJogador(i), i,0);
		tabelaRanking.setValueAt( score.getPontuacaoJogador(i), i,1);
		tabelaRanking.setValueAt( score.getDataJogador(i), i,2);
	}
	tabelaRanking.setVisible(true);
	JScrollPane barraRolagem = new JScrollPane();
	barraRolagem.setBounds(175, 70, 450, 323);
	barraRolagem.setViewportView(tabelaRanking);
	telaRanking.add(barraRolagem);
		
        
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });
        telaRanking.addWindowListener(new WindowAdapter()  {
        public void windowClosing (WindowEvent e)  {
                    System.exit(0);
            }
        });
    }
    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {
    	MenuGrafico m = new MenuGrafico();
    	this.telaRanking.setVisible(false);
	}
}
