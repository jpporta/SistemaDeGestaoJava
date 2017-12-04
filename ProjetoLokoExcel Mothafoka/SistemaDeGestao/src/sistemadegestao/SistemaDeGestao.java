package sistemadegestao;

import javax.swing.JFrame;

/**
 *
 * @author Paulo
 */
public class SistemaDeGestao {
    public static void main(String[] args) {
        
        GUIPrincipal novo = new GUIPrincipal();
        novo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        novo.setSize(450,260);
        novo.setVisible(true);
        
    }
    
}
