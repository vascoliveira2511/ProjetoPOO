import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestaFM {
    public static void main(String args[]) {
        Map<String, Equipa> equipas = new HashMap<>(); // nome, equipa
        Map<Integer, Jogador> jogadores = new HashMap<>(); // numero, jogador
        List<Jogo> jogos = new ArrayList<>();
        try {
            Parser.parse(equipas, jogadores, jogos);
        } catch (LinhaIncorretaException e) {
            e.printStackTrace();
        }
        Equipa e1 = new Equipa(equipas.get("Mahler Athletic"));
        Equipa e2 = new Equipa(equipas.get("Sporting Club Chopin"));
        System.out.println("Equipa 1: \n" + e1.toString() + "\n" + "Equipa 2: \n" + e2.toString() + "\n" + "Resultado "
                + Jogo.quemGanha(e1, e2));
    }
}