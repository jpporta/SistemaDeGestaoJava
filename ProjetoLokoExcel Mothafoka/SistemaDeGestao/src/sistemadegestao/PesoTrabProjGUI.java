package sistemadegestao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PesoTrabProjGUI extends JFrame {

    private JPanel principal = new JPanel();

    //-------------------------------------- Painel para botões -------------------------------------
    private JPanel botoes = new JPanel();
    //Botão de OK
    private JButton ok = new JButton("Ok");
    //Botão de Voltar
    private JButton voltar = new JButton("Voltar");

    //-------------------------------------- Painel para Trabalhos ----------------------------------
    private JPanel trabalhos = new JPanel();
    //Escrita "Numero de Trabalhos: "
    private JLabel pesoTrabalhos;
    //Entrada dos numero dos trabalhos
    private JTextField entradaPesoTrabalhos = new JTextField(5);

    //-------------------------------------- Painel para Projetos -----------------------------------
    private JPanel projetos = new JPanel();
    //Escrita "Numero de Projetos: "
    private JLabel pesoProjetos;
    //Entrada dos numero dos projetos
    private JTextField entradaPesoProjetos = new JTextField(5);

    public PesoTrabProjGUI() {
        
        super("Peso");

        handlerInserir handler = new handlerInserir();
        
        //Painel principal
        principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));

        //Painel para tamanho razoavel da entrada de dados dos Trabalhos
        trabalhos.setLayout(new FlowLayout());
        //Painel para tamanho razoavel da entrada de dados dos Projetos
        projetos.setLayout(new FlowLayout());
        //Painel dos botões
        botoes.setLayout(new FlowLayout());

        //Titulo da página
        JLabel tituloDaPagina = new JLabel("Inserir Pesos");
        //Dá espaçamento do topo ao título
        principal.add(Box.createRigidArea(new Dimension(0, 20)));

        //Coloca o título no painel principal
        principal.add(tituloDaPagina);
        //Título no meio
        tituloDaPagina.setAlignmentX(CENTER_ALIGNMENT);

        //Inicializando os labels
        pesoTrabalhos = new JLabel("Peso dos Trabalhos:");
        pesoProjetos = new JLabel("Peso dos Projetos:");

        //Mais espaço entre o título e as infos
        principal.add(Box.createRigidArea(new Dimension(0, 20)));

        //Adiciona Título
        trabalhos.add(pesoTrabalhos);
        //Adiciona entrada de dados
        trabalhos.add(entradaPesoTrabalhos);
        //Manda para o principal
        principal.add(trabalhos);

        //Adiciona Título
        projetos.add(pesoProjetos);
        projetos.add(Box.createRigidArea(new Dimension(4, 0)));
        //Adiciona entrada de dados
        projetos.add(entradaPesoProjetos);
        //Manda para o principal
        principal.add(projetos);

        botoes.add(ok);
        botoes.add(voltar);

        principal.add(Box.createRigidArea(new Dimension(0, 10)));
        principal.add(botoes);

        
        entradaPesoTrabalhos.addActionListener(handler);
        entradaPesoProjetos.addActionListener(handler);
        ok.addActionListener(handler);
        voltar.addActionListener(handler);
        
        
        add(principal);
    }
    
    private class handlerInserir implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == ok){

                //Salva informações
                dispose();
                
            } else if (ae.getSource() == voltar){
                dispose();
            }
        }
        
    }
}
