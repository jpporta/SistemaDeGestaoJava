package sistemadegestao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class GUIPrincipal extends JFrame{
    private JTabbedPane tabelas;
    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem importar;
    private JMenuItem exportar;
    private JMenuItem sair;
    private JMenu inserir;
    private JMenuItem inserirCriterio;
    private JCheckBoxMenuItem inserirNotas;
    
    public GUIPrincipal(){
        super("JPexel");
        
        //======================================================================
        //                          CRIANDO MENU
        //======================================================================
        barraMenu = new JMenuBar();
        menu = new JMenu("Menu");

        HandlerPrincipal handler = new HandlerPrincipal();

        barraMenu.add(menu);

        importar = new JMenuItem("Importar arquivo");
        importar.addActionListener(handler);
        menu.add(importar);

        exportar = new JMenuItem("Exportar arquivo");
        exportar.addActionListener(handler);
        menu.add(exportar);

        sair = new JMenuItem("Sair");
        sair.addActionListener(handler);
        menu.add(sair);

        inserir = new JMenu("Inserir");

        barraMenu.add(inserir);

        inserirCriterio = new JMenuItem("Critérios");
        inserirCriterio.addActionListener(handler);
        inserir.add(inserirCriterio);

        inserirNotas = new JCheckBoxMenuItem("Notas");
        inserirNotas.addActionListener(handler);
        inserir.add(inserirNotas);
        
        //======================================================================
        //                          CRIANDO TABELAS
        //======================================================================
        TabelaGUI teste = new TabelaGUI();
        TabelaGUI teste1 = new TabelaGUI();
        TabelaGUI teste2 = new TabelaGUI();
        
        setJMenuBar(barraMenu);
        
        tabelas = new JTabbedPane();
        
        
        tabelas.addTab("Tabela 1", teste.criaTabela(5,6));
        tabelas.addTab("Porta", teste1.criaTabela(4,5));
        tabelas.addTab("Joao", teste2.criaTabela(8,8));
        add(tabelas);
    }
    
    private class HandlerPrincipal implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            AbstractButton checkbox = (AbstractButton) ae.getSource();
            if (ae.getSource() == importar) {
                //Insere nova tabela com presets
                JFileChooser escolhedorDeArquivo = new JFileChooser();
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivo csv", "csv");
                escolhedorDeArquivo.setFileFilter(filtro);

                if (escolhedorDeArquivo.showOpenDialog(GUIPrincipal.this) == JFileChooser.APPROVE_OPTION) {
                    LerCSV teste = new LerCSV();
                    try {
                        teste.abrir(escolhedorDeArquivo.getSelectedFile());
                        teste.ler();
                    } catch (SecurityException securityException) {
                        System.out.println("Não tem acesso");
                    }
                }
            } else if (ae.getSource() == exportar) {
                //Salva tabela atual
            } else if (ae.getSource() == sair) {
                //Salva estado e arquivos
                dispose();
            } else if (ae.getSource() == inserirCriterio) {
                //Insere critérios (colunas)
                InsereGUI telaInserirCriterios = new InsereGUI();
                telaInserirCriterios.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                telaInserirCriterios.setSize(350,250);
                telaInserirCriterios.setVisible(true);
                
            } else if (checkbox.getModel().isSelected()) {
                //Enable editar notas
                System.out.println("SELECIONADO");
            } else {
                //Disable editar notas
                System.out.println("DESCELECIONADO");
            }
        }
        
    }
    
}
