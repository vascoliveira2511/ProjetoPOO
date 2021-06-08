import java.io.IOException;
import java.util.*;

public class Controller {
    public static void run() throws LinhaIncorretaException, IOException, ClassNotFoundException {
        String[] s = { "Ler ficheiro", "Guarda Ficheiro", "Jogar FM-POO EDITION" };
        Menu m = new Menu(s);
        m.executa();
        LigaPOO l = null;
        int op = m.getOpcao();
        switch (op) {
            case 1:
                String r = m.menuLerFicheiro();
                l = LigaPOO.readFromBinary(r);
                System.out.println("\nLeitura executada com sucesso!!");
                break;
            case 2:
                if (l != null){
                    String sa = m.menuGuardarFicheiro();
                    l.saveToBinary(sa);
                }

            case 3:


        }

    }

    public Controller() {

    }

    public void leFicheiro(String filename) throws IOException {
        if (filename.equals("Files/logs.txt")) {
            Map<String, Equipa> equipas = new HashMap<>(); // nome, equipa
            Map<Integer, Jogador> jogadores = new HashMap<>(); // numero, jogador
            List<Jogo> jogos = new ArrayList<>();
            try {
                Parser.parse(equipas, jogadores, jogos);
            } catch (LinhaIncorretaException e) {
                e.printStackTrace();
            }
        } else {
            // Por enquanto vamos ignorar esta parte porque os unicos ficehiros lidos sao os
            // logs
        }
    }
}
