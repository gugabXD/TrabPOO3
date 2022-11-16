package TrabPOO;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Registros {
    private ArrayList<Matricula> matriculas, ultimaConsulta;
    private Comparador comparador;
    public Registros(){
        matriculas = new ArrayList<>();
        ultimaConsulta = new ArrayList<>();
        comparador = new Comparador();
    }
    public void add(Matricula mat){
        matriculas.add(mat);
    }
    public void ordemCrescente(){
        matriculas.sort(comparador);
        print();
    }
    public void ordemDecrescente(){
        matriculas.sort(comparador.reversed());
        print();
    }
    public void print() {
        for (Matricula m : matriculas) {
            System.out.println(m);
        }
        setUltimaConsulta(getMatriculas());
    }

    public ArrayList<Matricula> getMatriculas(){
        ArrayList<Matricula> aux = new ArrayList<>();
        for(Matricula m: matriculas){
            aux.add(m);
        }
        return aux;
    }
    public void pesquisaNome(String nome){
        ArrayList<Matricula> aux = new ArrayList<>();
        nome = nome.toLowerCase();
        String finalNome = nome;
            matriculas.stream()
                .filter(n-> n.getNome().toLowerCase().contains(finalNome))
                .forEach(p-> aux.add(p));
        for (Matricula matricula : aux) {
            System.out.println(matricula);
        }
        setUltimaConsulta(aux);
    }

    public void setUltimaConsulta(ArrayList<Matricula> aux){
        ultimaConsulta.clear();
        for(Matricula m: aux){
            ultimaConsulta.add(m);
        }
    }
    public boolean salvaArquivo(String arq) {
        try{
            BufferedWriter escritor = new BufferedWriter(new FileWriter(arq+".CSV"));
            ultimaConsulta.stream().map(Matricula::versaoArquivo).forEach(l-> {
                try {
                    escritor.write(l);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            return true;
            }catch (IOException e) {
            throw new RuntimeException(e);
        }catch(Exception e){
            System.out.println("Erro.");
        }
        return false;
    }
   /* public boolean salvaArquivo(String arq) {
        try{
            BufferedWriter escritor = new BufferedWriter(new FileWriter(arq+".CSV"));
            for(Matricula m: ultimaConsulta){
                escritor.write(m.versaoArquivo());
            }
            return true;
        }catch (IOException e) {
            throw new RuntimeException(e);
        }catch(Exception e){
            System.out.println("Erro.");
        }
        return false;
    }*/

    public void printUltimaConsulta(){
        for(Matricula m: ultimaConsulta){
            System.out.println(m);
        }
    }

}
