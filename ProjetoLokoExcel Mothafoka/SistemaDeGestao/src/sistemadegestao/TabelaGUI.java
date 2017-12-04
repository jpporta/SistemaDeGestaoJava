package sistemadegestao;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TabelaGUI extends JFrame{
    private JPanel x = new JPanel();
    
    public JPanel criaTabela(int linha, int coluna){
        JTable ohaio = new JTable(linha,coluna);
        JScrollPane js = new JScrollPane(ohaio);
        js.setVisible(true);
        x.setLayout(new BorderLayout());
        x.add(js, BorderLayout.CENTER);
        
        return x;
    }
}
