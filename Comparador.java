package TrabPOO;
import java.util.Comparator;

public class Comparador implements Comparator {
    @Override
    public int compare(Object o1, Object o2){
        Matricula m1 = (Matricula) o1;
        Matricula m2 = (Matricula) o2;
        String nome1 = m1.getNome().toLowerCase();
        String nome2 = m2.getNome().toLowerCase();
        return nome1.compareTo(nome2);
    }
}
