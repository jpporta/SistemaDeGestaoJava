package teste;
import java.io.Serializable;
import java.util.*;

public class DataBase implements Serializable{
    private static final DataBase INSTANCE = new DataBase(); // SILGLETON
    public final List<Tabela> tabelas = new ArrayList();

    public Tabela getTabela(int index) {
        return tabelas.get(index);
    }
    private static final long serialVersionUID = 6529685098267757690L;

    // SILGLETON ---------------------------------------------------------------
    private DataBase(){};
    public static DataBase getInstance(){
        return INSTANCE;
    }
    //--------------------------------------------------------------------------
    // Criar e remover tabela do arrayList
    public void criarTabela(List<List<String>> dados){
        List<String> nomes = new ArrayList();
        List<List<Float>> notas = new ArrayList();
        dados.forEach((a) -> {
            nomes.add(a.get(0));
            List<Float> notasLinha = new ArrayList();
            List<String> b = a.subList(1, a.size() - 1);
            b.forEach((nota) -> {
                try {
                    if(nota.isEmpty()) notasLinha.add(Float.valueOf(0));
                    else notasLinha.add(Float.parseFloat(nota));
                }
                catch (NumberFormatException e){
                    System.out.println("O valor " + nota + " nâo está no formato adequado");
                }
            });
            notas.add(notasLinha);
        });
        tabelas.add(new Tabela(nomes));
        atualizarNotasTabela(tabelas.size() - 1, notas);
    }
    
    public void removerTabela(int index){
            tabelas.remove(tabelas.get(index));
    }
    //--------------------------------------------------------------------------
    // Editar pesos após criação
    public void alterarPesos(int index, ArrayList<Float> pesoProvas, float pesoProjetos,
            float pesoTrabalhos){
        Tabela aux;
        aux = tabelas.get(index);
        aux.setPesoProvas(pesoProvas);
        aux.setPesoProjetos(pesoProjetos);
        aux.setPesoTrabalhos(pesoTrabalhos);
        aux.atualizaNotasFinais();
        tabelas.set(index, aux);
    }
    //--------------------------------------------------------------------------
    // Metodos de tabela
    public void atualizarNotasTabela(int index, List<List<Float>> matriz){
        Tabela aux;
        aux = tabelas.get(index);
        aux.atualizarNotas(matriz);
        aux.atualizaNotasFinais();
        tabelas.set(index, aux);
    }
    public ArrayList<ArrayList<Float>> getArrayMF(int index){
        Tabela aux;
        aux = tabelas.get(index);
        return aux.retornoMediasFinais();
    }

    @Override
    public String toString() {
        return "DataBase{" + "tabelas=" + tabelas + '}';
    }

    
    
}
