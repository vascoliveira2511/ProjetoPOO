import java.io.IOException;
import java.util.Scanner;

public class FMMenu {
    public static void main(String[] args) throws IOException {
        Controller c = new Controller();
        String[] s = { "Ler ficheiro", "Transferir jogador", "Simular jogo" };
        Menu m = new Menu(s);
        m.executa();
        int op = m.getOpcao();
        System.out.println("Opção lida: " + op);
        switch (op) {
            case 1:
                Scanner sc1 = new Scanner(System.in);
                System.out.println("\tQual ficheiro: ");
                String file = sc1.next();
                c.leFicheiro(file);
                break;
            case 2:
                Scanner sc2 = new Scanner(System.in);
                System.out.println("\tQuais joagdores: ");
                // sinceramente nao sei como podemos fazer isto;
                break;
            case 3:
                System.out.println("");
                break;
        }

    }
}
