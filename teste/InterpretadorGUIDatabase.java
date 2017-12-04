package teste;

import java.io.*;
import java.util.*;

public class InterpretadorGUIDatabase implements Serializable{
    private DataBase dB = DataBase.getInstance();
    private static final InterpretadorGUIDatabase INSTANCE = new InterpretadorGUIDatabase();
    private static final long serialVersionUID = 6529685098267757690L;

    private InterpretadorGUIDatabase(){};
    
    public static InterpretadorGUIDatabase getInstance(){
        return INSTANCE;
    }
    public void criarTabelaGD(List<String> linhas){
        List<List<String>> dados = new ArrayList();
        for(int i = 0; i < linhas.size(); i++){
            List<String> dadosLinha = new ArrayList();
            String linha = linhas.get(i);
            
            while(!linha.isEmpty()){
                int fimDado;
                try{
                    fimDado = linha.indexOf(",");
                    dadosLinha.add(linha.substring(0, fimDado));
                    linha = linha.substring(fimDado + 1);
                }
                catch (StringIndexOutOfBoundsException e){
                    dadosLinha.add(linha.substring(0));
                    break;
                }
            }
            dados.add(dadosLinha);
        }
        dB.criarTabela(dados); 
    }

    public void adicionarTabelas(InterpretadorGUIDatabase aux){
        for(int i = 0; i < aux.dB.tabelas.size(); i++){
            dB.tabelas.add(aux.dB.tabelas.get(i));
        }
    }
    @Override
    public String toString() {
        return "InterpretadorGUIDatabase{" + "dB=" + dB + '}';
    }
    
}