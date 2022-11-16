package TrabPOO;

import static java.lang.System.*;

public class Matricula {
    private String nome;
    private String matricula;
    private String curso;
    private int anoIngresso;
    public Matricula(String nome, String matricula, String curso, int anoIngresso){
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.anoIngresso = anoIngresso;
    }

    public String getNome(){
        return nome;
    }

    public String toString(){
        return "Nome: " + nome + " / Matrícula: " + matricula + " / Curso: " + curso + " / Ano de Ingresso: " + anoIngresso;
    }

    public String versaoArquivo(){
        return nome+";"+matricula+";"+curso+";"+anoIngresso+"\n";
    }
}
