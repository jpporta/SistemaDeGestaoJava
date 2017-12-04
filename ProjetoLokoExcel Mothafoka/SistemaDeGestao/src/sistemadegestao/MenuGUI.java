package sistemadegestao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuGUI extends JFrame {

    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem importar;
    private JMenuItem exportar;
    private JMenuItem sair;
    private JMenu inserir;
    private JMenuItem inserirCriterio;
    private JCheckBoxMenuItem inserirNotas;

    public JMenuBar MenuGUI() {
        barraMenu = new JMenuBar();
        menu = new JMenu("Menu");

        HandlerMenu handler = new HandlerMenu();

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

        return barraMenu;
    }

    private class HandlerMenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            AbstractButton checkbox = (AbstractButton) ae.getSource();
            if (ae.getSource() == importar) {
                //Insere nova tabela com presets
                JFileChooser escolhedorDeArquivo = new JFileChooser();
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivo csv", "csv");
                escolhedorDeArquivo.setFileFilter(filtro);

                if (escolhedorDeArquivo.showOpenDialog(MenuGUI.this) == JFileChooser.APPROVE_OPTION) {
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
                //Salva tudo e dispose()
                //Salva estado e arquivos
                System.out.println("Saindo");
            } else if (ae.getSource() == inserirCriterio) {
                //Insere critérios (colunas)
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
