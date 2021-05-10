import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestaFM {
    public static void main(String args[]) {
        /*Map<String, Equipa> equipas = new HashMap<>(); // nome, equipa
        Map<Integer, Jogador> jogadores = new HashMap<>(); // numero, jogador
        List<Jogo> jogos = new ArrayList<>();
        try {
            Parser.parse(equipas, jogadores, jogos);
        } catch (LinhaIncorretaException e) {
            e.printStackTrace();
        }
        Equipa e1 = new Equipa(equipas.get("Mahler Athletic"));
        Equipa e2 = new Equipa(equipas.get("Sporting Club Chopin"));*/
        Jogador j1 = new Avancado("Miguel", 1, 50, 50, 50, 50, 50, 50, 50);
        Jogador j2 = new Defesa("Vasco", 2, 50, 50, 50, 50, 50, 50, 50);
        Jogador j3 = new Defesa("Diogo", 3, 50, 50, 50, 50, 50, 50, 50);
        Jogador j4 = new Avancado("Ronaldo", 4, 50, 50, 50, 50, 50, 50, 50);
        Equipa e1 = new Equipa("E1");
        e1.addJogador(j1);
        e1.addJogador(j2);
        e1.addJogador(j3);
        e1.addJogador(j4);
        Equipa e2 = e1.clone();
        Jogo jj = new Jogo("e1", "e2", 0, 0);
        jj.quemGanha(e1, e2);
        System.out.println(jj.toString());
        
    }
}