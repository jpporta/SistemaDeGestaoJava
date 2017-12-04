package teste;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Teste {

    private File file = null;
    InterpretadorGUIDatabase guiDB = InterpretadorGUIDatabase.getInstance();
    private static final long serialVersionUID = 6529685098267757690L;
    
    public static void main(String[] args) {
        
        Teste serialization = new Teste();
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
        linhas.add("p1, p2, p3, p4");
        linhas.add("ntr, ptr, npr, ppr");
        linhas.add("meu pai, 8, 7, 6, 7");
        linhas.add("Me lambeu, 5, 5, 9, 7");
        try{
            guiDB.criarTabelaGD(linhas);
        }
        catch (NullPointerException e){
            guiDB = InterpretadorGUIDatabase.getInstance();
        }
    }

    private void read() {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
//            InterpretadorGUIDatabase GUIdB =  (InterpretadorGUIDatabase)ois.readObject();
            guiDB = InterpretadorGUIDatabase.getInstance();
            guiDB.adicionarTabelas((InterpretadorGUIDatabase)ois.readObject());
        } catch (FileNotFoundException ex) {
            guiDB = InterpretadorGUIDatabase.getInstance();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
            guiDB = InterpretadorGUIDatabase.getInstance();
        }    
    }

    private void write() {
        System.out.println(guiDB);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            if(guiDB != null) oos.writeObject(guiDB);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
