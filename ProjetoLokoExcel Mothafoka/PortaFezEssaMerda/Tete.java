package notas;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Tete {

    private File file = null;
    InterpretadorGUIDatabase guiDB = null;
    private static final long serialVersionUID = 6529685098267757690L;
    public static void main(String[] args) {
        
        Tete serialization = new Tete();
        serialization.init();
        serialization.read();
        serialization.work();
        serialization.write();
    }

    private void init() {
        file = new File("Database.bin");
        
    }
    private void work(){
        List<String> linhas = new ArrayList();
        linhas.add("Nome1 Sobrenome1, 8, 7, 6, 7");
        linhas.add("Nome2 Sobrenome2, 5, 5, 9, 7");
        try{
            guiDB.criarTabelaGD(linhas);
        }
        catch (NullPointerException e){
            guiDB = new InterpretadorGUIDatabase();
        }
    }

    private void read() {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            InterpretadorGUIDatabase GUIdB =  (InterpretadorGUIDatabase)ois.readObject();
            System.out.println(GUIdB);
        } catch (FileNotFoundException ex) {
            guiDB = new InterpretadorGUIDatabase();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Tete.class.getName()).log(Level.SEVERE, null, ex);
            guiDB = new InterpretadorGUIDatabase();
        }    
    }

    private void write() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            if(guiDB != null) oos.writeObject(guiDB);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tete.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
