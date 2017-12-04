package teste;
import java.io.Serializable;
import java.util.*;

public final class Tabela implements Serializable{
    private List<Aluno> alunos = new ArrayList();
    private List<Float> pesoProvas = new ArrayList();
    private float pesoTrabalhos, pesoProjetos;
    private static final long serialVersionUID = 6529685098267757690L;
    
    // Setters
    public void setPesoProvas(List<Float> pesoProvas) {
        this.pesoProvas = pesoProvas;
    }

    public void setPesoTrabalhos(float pesoTrabalhos) {
        this.pesoTrabalhos = pesoTrabalhos;
    }

    public void setPesoProjetos(float pesoProjetos) {
        this.pesoProjetos = pesoProjetos;
    }
    // Contructor
       public Tabela(List<String> nomesAlunos){
           nomesAlunos.forEach((a) -> {
               alunos.add(new Aluno(a));
        });
       }
    // -------------------------------------------------------------------------
    // Atualizar notas quando forem editadas, recebe um array de notas
       private void atualizarNotasAluno(int index, List<Float> notasProvas,
              List<Float> notasTrabalhos,  List<Float> notasProjetos){
           Aluno aux;
        aux = alunos.get(index);
        aux.setNotasProvas(notasProvas);
        aux.setNotasTrabalhos(notasTrabalhos);
        aux.setNotasProjetos(notasProjetos);
        alunos.set(index, aux);
       }
       public void atualizarNotas(List<List<Float>> matriz){
           for(int i = 0; i < alunos.size(); i++){
               List<Float> aux;
               aux = matriz.get(i);
           }
       }
       
    // -------------------------------------------------------------------------
    // Calculo da Media Final do Aluno
      private float calcularNotaFinal(int index){
          float notaFinal = 0;
          Aluno aux = alunos.get(index);
          float sumNotaProjetos, sumNotasTrabalhos;
          sumNotaProjetos = 0;
          sumNotasTrabalhos = 0;
          // Soma dos Projetos
          if(!aux.getNotasProjetos().isEmpty()){
            for(Float a : aux.getNotasProjetos()){
                sumNotaProjetos += a;
            }
          }
          // Soma dos Trabalhos
          if(!aux.getNotasTrabalhos().isEmpty()){
            for(Float a : aux.getNotasTrabalhos()){
                sumNotasTrabalhos += a;
            }
          }
          notaFinal += sumNotaProjetos*pesoProjetos + sumNotasTrabalhos*pesoTrabalhos; // Projetos + Trabalho com pesos
          
          // Soma das notas das provas com seus respectivos pesos
          int i = 0;
          if(!aux.getNotasProvas().isEmpty()){
            for(Float a : aux.getNotasProvas()){
                notaFinal += a*pesoProvas.get(i);
                i++;
            }
          }
          return notaFinal;
      }
       // -----------------------------------------------------------------------
      // Atualiza todas notas Finais
     public void atualizaNotasFinais(){
         for(int i = 0; i < alunos.size(); i++){
             float nota = calcularNotaFinal(i);
             Aluno aux = alunos.get(i);
             aux.setmediaFinal(nota);
             alunos.set(i, aux);
         }
     }
     public ArrayList<ArrayList<Float>> retornoMediasFinais(){
         ArrayList<ArrayList<Float>> retorno = null;
         atualizaNotasFinais();
         for(Aluno a : alunos){
             ArrayList<Float> aluno = null;
             aluno.addAll(a.getNotasProvas());
             aluno.addAll(a.getNotasTrabalhos());
             aluno.addAll(a.getNotasProjetos());
             aluno.add(a.getMediaFinal());
             retorno.add(aluno);
         }
         return retorno;
     }

    @Override
    public String toString() {
        return "Tabela{" + "alunos=" + alunos + ", pesoProvas=" + pesoProvas + ", pesoTrabalhos=" + pesoTrabalhos + ", pesoProjetos=" + pesoProjetos + '}';
    }
     
}
