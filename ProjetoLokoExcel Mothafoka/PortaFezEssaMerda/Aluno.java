package notas;
import java.io.Serializable;
import java.util.*;

class Aluno implements Serializable{
    private final String nome;
    private Collection<Float> notasProvas = new ArrayList();
    private Collection<Float> notasTrabalhos = new ArrayList();
    private Collection<Float> notasProjetos = new ArrayList();
    private float mediaFinal = 0;
     private static final long serialVersionUID = 6529685098267757690L;
   
    // Contructor
   public Aluno(String nome){
       this.nome = nome;
   }
   //---------------------------------------------------------------------------
   // Getters & Setters
   public void setNotasProvas(List<Float> notas){
       notasProvas = notas;
   }
   public void setNotasTrabalhos(List<Float> notas){
       notasTrabalhos = notas;
   }
   public void setNotasProjetos(List<Float> notas){
       notasProjetos = notas;
   }
   public void setmediaFinal(float nota){
       mediaFinal = nota;
   }
   public float getMediaFinal(){
       return mediaFinal;
   }
   public Collection<Float> getNotasTrabalhos(){
       return notasTrabalhos;
   }
   public Collection<Float> getNotasProjetos(){
       return notasProjetos;
   }
   public Collection<Float> getNotasProvas(){
       return notasProvas;
   }
   // --------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Aluno{" + "nome=" + nome + ", notasProvas=" + notasProvas + ", notasTrabalhos=" + notasTrabalhos + ", notasProjetos=" + notasProjetos + ", mediaFinal=" + mediaFinal + '}';
    }
   
}

