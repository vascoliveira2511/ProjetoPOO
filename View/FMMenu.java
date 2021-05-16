import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FMMenu {
    public static void main(String[] args) throws IOException, InterruptedException {
        Controller c = new Controller(); // Solucao temporaria.
        String[] s = { "Ler ficheiro", "Transferir jogador", "Simular jogo" };
        Menu m = new Menu(s);
        m.executa();
        int op = m.getOpcao();
        System.out.println("Opção lida: " + op);
        switch (op) {
            case 1:
                Scanner sc1 = new Scanner(System.in);
                System.out.println("\nQual ficheiro: ");
                String file = sc1.next();
                System.out.println("Lendo ficheiro...");
                c.leFicheiro(file);
                System.out.println("\nConcluído!!");
                break;
            case 2:
                LigaPOO l1 = new LigaPOO(); // Solucao temporaria.
                Scanner sc2 = new Scanner(System.in);
                System.out.println("\nQuais equipas: ");
                String e1 = sc2.next();
                String e2 = sc2.next();
                System.out.println("\nQual número: ");
                int num = sc2.nextInt();
                System.out.println("\nTransferindo: ");
                l1.transferencia(e1, e2, num);
                System.out.println("\nConcluído!!");
                break;
            case 3:
                Jogo j = new Jogo(); // Solucao temporaria.
                Scanner sc3 = new Scanner(System.in);
                System.out.println("\nQuais equipas: ");
                String e3 = sc3.next();
                String e4 = sc3.next();
                Equipa casa = new Equipa(e3, new ArrayList<>()); // Solucao temporaria.
                Equipa fora = new Equipa(e3, new ArrayList<>()); // Solucao temporaria.
                j.setEquipaCasa(e3, casa);
                j.setEquipaFora(e4, fora);
                System.out.println("\nSimulando...");
                j.simulacaoJogo();
                System.out.println("\nConcluído!!Imprimindo...");
                System.out.println(j.toString());
                break;
        }

    }
}
