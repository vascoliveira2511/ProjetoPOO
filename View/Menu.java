import java.util.*;

public class Menu {
    private List<String> opcoes;
    private int op;

    public Menu(String[] opcoes) {
        this.opcoes = Arrays.asList(opcoes);
        this.op = 0;
    }

    public void executa() {
        do {
            showMenu();
            this.op = lerOpcao();
        } while (this.op == -1);
    }

    private void showMenu() {
        System.out.println("\n *** Menu *** ");
        for (int i = 0; i < this.opcoes.size(); i++) {
            System.out.print(i + 1);
            System.out.print(" - ");
            System.out.println(this.opcoes.get(i));
        }
        System.out.println("0 - Sair");
    }

    private int lerOpcao() {
        int op;
        Scanner is = new Scanner(System.in);

        System.out.print("Opção: ");
        try {
            op = is.nextInt();
        } catch (InputMismatchException e) {
            op = -1;
        }
        if (op < 0 || op > this.opcoes.size()) {
            System.out.println("Opção Invâlida!!!");
            op = -1;
        }
        is.close();
        return op;
    }

    public int getOpcao() {
        return this.op;
    }

    public String menuLerFicheiro(){
        Scanner in = new Scanner(System.in);
        System.out.println("Nome do ficheiro a ler:");
        return in.nextLine();
    }

    public String menuGuardarFicheiro(){
        Scanner in = new Scanner(System.in);
        System.out.println("Nome do ficheiro a guardar:");
        return in.nextLine();
    }

    public AbstractMap.SimpleEntry<String, String> menuEscolherEquipas(){
        System.out.println("1:");
        String e1 = this.menuEscolherEquipa();
        System.out.println("2");
        String e2 = this.menuEscolherEquipa();
        return new AbstractMap.SimpleEntry<>(e1, e2);

    }

    public String menuEscolherEquipa(){
        Scanner in = new Scanner(System.in);
        System.out.println("Nome da equipa:");
        return in.nextLine();

    }

    public AbstractMap.SimpleEntry<Integer, String> menuEscolherJogador(){
        Scanner in = new Scanner(System.in);
        System.out.println("Nome da Equipa do Jogador:");
        String e1 = in.nextLine();
        System.out.println("Numero do Jogador");
        int e2 = in.nextInt();
        return new AbstractMap.SimpleEntry<>(e2, e1);
    }

    public AbstractMap.SimpleEntry<Integer, AbstractMap.SimpleEntry<String, String>> menuTransferencia(){
        Scanner in = new Scanner(System.in);
        System.out.println("Equipa atual:");
        String e1 = in.nextLine();
        System.out.println("Numero do Jogador");
        int e2 = in.nextInt();
        System.out.println("Equipa futura:");
        String e3 = in.nextLine();
        return new AbstractMap.SimpleEntry<>(e2, new AbstractMap.SimpleEntry<>(e1, e3));
    }

    public void imprimeJogador(Jogador j){
        System.out.println(j.toString());
    }

    public void imprimeEquipa(Equipa e){
        System.out.println(e.toString());
    }
}