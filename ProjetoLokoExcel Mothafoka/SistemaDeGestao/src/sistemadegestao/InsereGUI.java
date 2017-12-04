package sistemadegestao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsereGUI extends JFrame {

    private JPanel principal = new JPanel();
    
    //-------------------------------------- Painel para botões -------------------------------------
    private JPanel botoes = new JPanel();
    //Botão de OK
    private JButton ok = new JButton("Ok");
    //Botão de Voltar
    private JButton voltar = new JButton("Voltar");

    //-------------------------------------- Painel para Provas -------------------------------------
    private JPanel provas = new JPanel();
    //Escrita "Numero de Provas: "
    private JLabel numProvas;
    //Entrada dos numero das provas
    private JTextField entradaProvas = new JTextField(5);

    //-------------------------------------- Painel para Trabalhos ----------------------------------
    private JPanel trabalhos = new JPanel();
    //Escrita "Numero de Trabalhos: "
    private JLabel numTrabalhos;
    //Entrada dos numero dos trabalhos
    private JTextField entradaTrabalhos = new JTextField(5);

    //-------------------------------------- Painel para Projetos -----------------------------------
    private JPanel projetos = new JPanel();
    //Escrita "Numero de Projetos: "
    private JLabel numProjetos;
    //Entrada dos numero dos projetos
    private JTextField entradaProjetos = new JTextField(5);

    public InsereGUI() {
        
        super("Inserir Critérios");
        
        
        handlerInserir handler = new handlerInserir();
        
        //Painel principal
        principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));
        
        //Painel para tamanho razoavel da entrada de dados das Provas
        provas.setLayout(new FlowLayout());
        //Painel para tamanho razoavel da entrada de dados dos Trabalhos
        trabalhos.setLayout(new FlowLayout());
        //Painel para tamanho razoavel da entrada de dados dos Projetos
        projetos.setLayout(new FlowLayout());
        //Painel dos botões
        botoes.setLayout(new FlowLayout());
        
        
        //Titulo da página
        JLabel tituloDaPagina = new JLabel("Inserir Critérios");
        //Dá espaçamento do topo ao título
        principal.add(Box.createRigidArea(new Dimension(0,20)));
        
        
        //Coloca o título no painel principal
        principal.add(tituloDaPagina);
        //Título no meio
        tituloDaPagina.setAlignmentX(CENTER_ALIGNMENT);
        
        
        //Inicializando os labels
        numProvas = new JLabel("Número de Provas:");
        numTrabalhos = new JLabel("Número de Trabalhos:");
        numProjetos = new JLabel("Número de Projetos:");
        
        //Mais espaço entre o título e as infos
        principal.add(Box.createRigidArea(new Dimension(0,20)));
        
        //Adiciona Título
        provas.add(numProvas);
        provas.add(Box.createRigidArea(new Dimension(10,0)));
        //Adiciona entrada de dados
        provas.add(entradaProvas);
        //Manda para o principal
        principal.add(provas);
        
        //Adiciona Título
        trabalhos.add(numTrabalhos);
        //Adiciona entrada de dados
        trabalhos.add(entradaTrabalhos);
        //Manda para o principal
        principal.add(trabalhos);
        
        //Adiciona Título
        projetos.add(numProjetos);
        projetos.add(Box.createRigidArea(new Dimension(4,0)));
        //Adiciona entrada de dados
        projetos.add(entradaProjetos);
        //Manda para o principal
        principal.add(projetos);
        
        botoes.add(ok);
        botoes.add(voltar);
        
        principal.add(Box.createRigidArea(new Dimension(0,10)));
        principal.add(botoes);
        
        entradaProvas.addActionListener(handler);
        entradaTrabalhos.addActionListener(handler);
        entradaProjetos.addActionListener(handler);
        ok.addActionListener(handler);
        voltar.addActionListener(handler);
        
        add(principal);
    }
    
    private class handlerInserir implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            int numeroDeProvas, numeroDeTrabalhos, numeroDeProjetos;
            if (ae.getSource() == ok){
                
                //Salva informações
                
                numeroDeProvas = Integer.parseInt(entradaProvas.getText());
                numeroDeTrabalhos = Integer.parseInt(entradaTrabalhos.getText());
                numeroDeProjetos = Integer.parseInt(entradaProjetos.getText());
                
                PesoProvasGUI telaPesoProvas = new PesoProvasGUI(numeroDeProvas);
                telaPesoProvas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                telaPesoProvas.setSize(350,250+(50*numeroDeProvas));
                telaPesoProvas.setVisible(true);
                dispose();
                
            } else if (ae.getSource() == voltar){
                dispose();
            }
        }
        
    }
}
