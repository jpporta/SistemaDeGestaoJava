package sistemadegestao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PesoProvasGUI extends JFrame {

    private JPanel principal = new JPanel();

    //-------------------------------------- Painel para botões -------------------------------------
    private JPanel botoes = new JPanel();
    //Botão de OK
    private JButton ok = new JButton("Ok");
    //Botão de Voltar
    private JButton voltar = new JButton("Voltar");

    public PesoProvasGUI(int numeroDeProvas) {
        super("Peso");
        int contadorParaLoop;
        
        handlerInserir handler = new handlerInserir();
        
        //-------------------------------------- Painel para Provas -------------------------------------
        JPanel[] provas = new JPanel[numeroDeProvas];
        //Escrita "Numero de Provas: "
        JLabel[] numProvas = new JLabel[numeroDeProvas];
        //Entrada dos numero das provas
        JTextField[] entradaProvas = new JTextField[numeroDeProvas];

        //Painel principal
        principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));

        //Painel para tamanho razoavel da entrada de dados das Provas
        for (contadorParaLoop = 0; contadorParaLoop < numeroDeProvas; contadorParaLoop++) {
            provas[contadorParaLoop] = new JPanel();
            provas[contadorParaLoop].setLayout(new FlowLayout());
        }
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

        for (contadorParaLoop = 0; contadorParaLoop < numeroDeProvas; contadorParaLoop++) {
            //Inicializando os labels
            numProvas[contadorParaLoop] = new JLabel("Peso da Prova " + (contadorParaLoop + 1) + ":");

            //Mais espaço entre o título e as infos
            principal.add(Box.createRigidArea(new Dimension(0, 20)));

            //Adiciona Título
            provas[contadorParaLoop].add(numProvas[contadorParaLoop]);
            //Adiciona entrada de dados
            entradaProvas[contadorParaLoop] = new JTextField(5);
            provas[contadorParaLoop].add(entradaProvas[contadorParaLoop]);
            //Manda para o principal
            principal.add(provas[contadorParaLoop]);

            entradaProvas[contadorParaLoop].addActionListener(handler);
        }
        botoes.add(ok);
        botoes.add(voltar);

        principal.add(Box.createRigidArea(new Dimension(0, 10)));
        principal.add(botoes);

        ok.addActionListener(handler);
        voltar.addActionListener(handler);
        
        add(principal);
    }
    
    private class handlerInserir implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == ok){
                
                //Salva informações
                
                PesoTrabProjGUI telaPesoTrabEProj = new PesoTrabProjGUI();
                telaPesoTrabEProj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                telaPesoTrabEProj.setSize(350,250);
                telaPesoTrabEProj.setVisible(true);
                dispose();
                
            } else if (ae.getSource() == voltar){
                dispose();
            }
        }
        
    }
}
