package TrabPOO;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class Sistema {

    private Registros registro;
    private Scanner in;
    public Sistema(){
        registro = new Registros();
        in = new Scanner(System.in);
    }

    public void carregaDados(){
        BufferedReader leitor;
        try{
            System.out.println("Insira o local de arquivo");
            String caminho = in.nextLine();
            leitor = new BufferedReader(new FileReader(caminho));
            String linha;
            leitor.readLine();
            while(true){
                linha = leitor.readLine();
                if(linha==null) break;
                ler(linha);
            }
            registro.print();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch(Exception e){
            System.err.print(e);
        }
    }
    public void ler(String linha){
        String[] res = linha.split(";", 0);
        Matricula mat = new Matricula(res[0], res[1], res[2], Integer.parseInt(res[3]));
        registro.add(mat);
    }

    public void executar(){
        while (true) {
        try {
                int opcao;
                System.out.println("=======================");
                System.out.println("Menu: Escolha uma das opções");
                System.out.println("1- Carregar dados");
                System.out.println("2- Classificar dados por nome");
                System.out.println("3- Consultar todos os dados");
                System.out.println("4- Pesquisar por um nome");
                System.out.println("5- Salvar dados em um arquivo");
                System.out.println("0- Sair");
                System.out.println("=======================");
                opcao = Integer.parseInt(in.nextLine());
                menu(opcao);
            } catch(Exception e) {
            System.err.print(e);
        }
        }
    }
    public void menu(int comando){
        switch(comando){
            case 1-> carregaDados();
            case 2 -> classificaDados();
            case 3-> registro.print();
            case 4-> pesquisaNome();
            case 5-> salvaArquivo();
            case 0-> System.exit(0);
            case 99-> registro.printUltimaConsulta(); //teste
            default-> System.out.println("Escreva uma opção válida");
        }
    }
    public void classificaDados(){
        try {
            System.out.println("Digite 1 para ordem crescente e 2 para decrescente");
            int opcao = Integer.parseInt(in.nextLine());
            switch(opcao){
                case 1-> registro.ordemCrescente();
                case 2-> registro.ordemDecrescente();
            }
        } catch(Exception e){
            System.out.println("Erro.");
        }
    }
    public void pesquisaNome(){
        System.out.println("Insira o nome a pesquisar (completo ou não)");
        String nome = in.nextLine();
        registro.pesquisaNome(nome);
    }

    public void salvaArquivo(){
        System.out.println("Insira o local de arquivo para salvar os dados");
        String arq = in.nextLine();
        if(registro.salvaArquivo(arq)) System.out.println("Arquivo salvo com sucesso");
        else System.out.println("Falha ao salvar o arquivo");
    }
}
