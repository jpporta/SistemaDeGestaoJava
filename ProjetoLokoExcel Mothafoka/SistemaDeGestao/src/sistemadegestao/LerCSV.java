package sistemadegestao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Paulo
 */
public class LerCSV {

    String csvFile = "AlunosExemploProjetoFinal.csv";
    BufferedReader br = null;
    String line = "";

    public void abrir(File arquivo){
        csvFile = arquivo.getAbsolutePath();
    }
    
    public void ler() {
        
        List<String> mandaDatabase = new ArrayList();
        try {
            
            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {
                
                mandaDatabase.add(line);
                
            }
            
        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            if (br != null) {

                try {

                    br.close();

                } catch (IOException e) {

                    e.printStackTrace();

                }
            }
        }
    }
}
