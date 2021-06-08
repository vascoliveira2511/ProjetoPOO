import java.util.*;
import java.util.stream.Collectors;

public class Menu {
    private List<String> opcoes;
    private int op;
    private Scanner stdin;

    public Menu(String[] opcoes) {
        this.opcoes = Arrays.asList(opcoes);
        this.op = 0;
        stdin = new Scanner(System.in);
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
        // Scanner is = new Scanner(System.in);

        System.out.print("Opção: ");
        try {
            op = Integer.parseInt(stdin.nextLine());
        } catch (InputMismatchException e) {
            op = -1;
        }
        if (op < 0 || op > this.opcoes.size()) {
            System.out.println("Opção Invâlida!!!");
            op = -1;
        }
        // is.close();
        return op;
    }

    public int getOpcao() {
        return this.op;
    }

    public String menuLerFicheiro() {
        // Scanner in = new Scanner(System.in);
        System.out.println("Nome do ficheiro a ler:");
        String c = stdin.nextLine();
        // in.close();
        return c;
    }

    public String menuGuardarFicheiro() {
        // Scanner in = new Scanner(System.in);
        System.out.println("Nome do ficheiro a guardar:");
        String c = stdin.nextLine();
        // in.close();
        return c;
    }

    public AbstractMap.SimpleEntry<String, String> menuEscolherEquipas() {
        System.out.println("1:");
        String e1 = this.menuEscolherEquipa();
        System.out.println("2");
        String e2 = this.menuEscolherEquipa();
        return new AbstractMap.SimpleEntry<>(e1, e2);

    }

    public String menuEscolherEquipa() {
        System.out.println("Nome da equipa:");
        return stdin.nextLine();

    }

    public AbstractMap.SimpleEntry<Integer, String> menuEscolherJogador() {
        System.out.println("Nome da Equipa do Jogador:");
        String e1 = stdin.nextLine();
        System.out.println("Numero do Jogador");
        int e2 = Integer.parseInt(stdin.nextLine());
        return new AbstractMap.SimpleEntry<>(e2, e1);
    }

    public AbstractMap.SimpleEntry<Integer, AbstractMap.SimpleEntry<String, String>> menuTransferencia() {
        System.out.println("Equipa atual:");
        String e1 = stdin.nextLine();
        System.out.println("Numero do Jogador");
        int e2 = Integer.parseInt(stdin.nextLine());
        System.out.println("Equipa futura:");
        String e3 = stdin.nextLine();
        return new AbstractMap.SimpleEntry<>(e2, new AbstractMap.SimpleEntry<>(e1, e3));
    }

    public AbstractMap.SimpleEntry<List<Integer>, List<Integer>> menuEscolheTitulares(Equipa e1, Equipa e2) {
        imprimeEquipa(e1);
        List<Integer> numE1 = new ArrayList<>();
        Set<Integer> utilE1 = new HashSet<>(e1.getJogadores().keySet());
        System.out.println("Jogador 1 - Escolha o seu onze inicial(Por numero separado por -enter-)");
        int i = 0, num;
        while (i < 11) {
            num = Integer.parseInt(stdin.nextLine());
            if (utilE1.contains(num) && (!numE1.contains(num))) {
                numE1.add(num);
                i++;
            } else {
                System.out.println("Numero invalido");
            }
        }
        imprimeEquipa(e2);
        List<Integer> numE2 = new ArrayList<>();
        Set<Integer> utilE2 = new HashSet<>(e2.getJogadores().keySet());
        i = 0;
        System.out.println("Jogador 2 - Escolha o seu onze inicial(Por numero separado por -enter-)");
        while (i < 11) {
            num = Integer.parseInt(stdin.nextLine());
            if (utilE2.contains(num) && (!numE2.contains(num))) {
                numE2.add(num);
                i++;
            } else {
                System.out.println("Numero invalido");
            }
        }
        return new AbstractMap.SimpleEntry<>(numE1, numE2);
    }

    public AbstractMap.SimpleEntry<Map<Integer, Integer>, Map<Integer, Integer>> menuEscolheSubstituicoes(Equipa eq1,
            List<Integer> e1, Equipa eq2, List<Integer> e2) {
        List<Integer> ent1 = new ArrayList<>();
        System.out.println("Jogador 1 - Escolha 3 jogadores para sair(Por numero separado por -enter-)");
        System.out.println(e1);
        int i = 0, num;
        while (i < 3) {
            num = Integer.parseInt(stdin.nextLine());
            if (e1.contains(num)) {
                ent1.add(num);
                i++;
            } else {
                System.out.println("Numero invalido");
            }
        }
        List<Integer> sai1 = new ArrayList<>();
        List<Integer> sub1 = eq1.getJogadores().keySet().stream().filter(n -> !e1.contains(n))
                .collect(Collectors.toList());
        System.out.println("Jogador 1 - Escolha 3 jogadores para entrar(Por numero separado por -enter-)");
        System.out.println(sub1);
        i = 0;
        while (i < 3) {
            num = Integer.parseInt(stdin.nextLine());
            if (sub1.contains(num)) {
                sai1.add(num);
                i++;
            } else {
                System.out.println("Numero invalido");
            }
        }
        Map<Integer, Integer> s1 = new HashMap<>();
        for (i = 0; i < 3; i++)
            s1.put(ent1.get(i), sai1.get(i));

        List<Integer> ent2 = new ArrayList<>();
        System.out.println("Jogador 2 - Escolha 3 jogadores para sair(Por numero separado por -enter-)");
        System.out.println(e2);
        i = 0;
        while (i < 3) {
            num = Integer.parseInt(stdin.nextLine());
            if (e2.contains(num)) {
                ent2.add(num);
                i++;
            } else {
                System.out.println("Numero invalido");
            }
        }
        List<Integer> sai2 = new ArrayList<>();
        List<Integer> sub2 = eq2.getJogadores().keySet().stream().filter(n -> !e2.contains(n))
                .collect(Collectors.toList());
        System.out.println("Jogador 2 - Escolha 3 jogadores para entrar(Por numero separado por -enter-)");
        System.out.println(sub2);
        i = 0;
        while (i < 3) {
            num = Integer.parseInt(stdin.nextLine());
            if (sub2.contains(num)) {
                sai2.add(num);
                i++;
            } else {
                System.out.println("Numero invalido");
            }
        }
        Map<Integer, Integer> s2 = new HashMap<>();
        for (i = 0; i < 3; i++)
            s2.put(ent2.get(i), sai2.get(i));
        // in.close();
        return new AbstractMap.SimpleEntry<>(s1, s2);
    }

    public int escolheJogo(List<Jogo> jogos) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jogos.size(); i++)
            sb.append(i + " - " + jogos.get(i).toString2());
        System.out.println(sb.toString());
        System.out.println("Numero do jogo para um reencontro:");
        return Integer.parseInt(stdin.nextLine());
    }

    public void imprimeJogador(Jogador j) {
        System.out.println(j.toString());
    }

    public void imprimeEquipa(Equipa e) {
        System.out.println(e.toString());
    }

    public void imprimeJogo(Jogo j) {
        System.out.println(j.toString());
    }

    public void closeScanner() {
        this.stdin.close();
    }
}