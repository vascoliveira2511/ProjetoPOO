import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        Equipa e1 = new Equipa(equipas.get("Bartok F. C."));
        Equipa e2 = new Equipa(equipas.get("Mozart F. C."));
        Jogo jj = new Jogo(e1.getClube(), e2.getClube(), 0, 0, LocalDate.now(),
                e1.getJogadores().stream().map(Jogador::getNumeroJogador).collect(Collectors.toList()), new HashMap<>(),
                e2.getJogadores().stream().map(Jogador::getNumeroJogador).collect(Collectors.toList()), new HashMap<>(),
                e1, e2);
        jj.simulacaoJogo();
        LigaPOO lp = new LigaPOO(equipas, jogos);
        System.out.println("\nOverall equipa casa: " + e1.overallEquipa());
        System.out.println("\nOverall equipa fora: " + e2.overallEquipa());
        System.out.println(jj.toString());*/
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        Jogador j1 = new Avancado("Miguel", 1, 100, 100, 100, 100, 100, 100, 100);
        Jogador j2 = new Defesa("Vasco", 2, 100, 100, 100, 100, 100, 100, 100);
        Jogador j3 = new Defesa("Diogo", 3, 100, 100, 100, 100, 100, 100, 100);
        Jogador j4 = new Avancado("Ronaldo", 4, 100, 100, 100, 100, 100, 100, 100);
        Equipa e1 = new Equipa("E1");
        e1.addJogador(j1);
        e1.addJogador(j2);
        e1.addJogador(j3);
        e1.addJogador(j4);
        Equipa e2 = new Equipa("E2");
        Jogador j5 = new Avancado("Miguel", 1, 10, 10, 10, 10, 10, 10, 10);
        Jogador j6 = new Defesa("Vasco", 2, 10, 10, 10, 10, 10, 10, 10);
        Jogador j7 = new Defesa("Diogo", 3, 10, 10, 10, 10, 10, 10, 10);
        Jogador j8 = new Avancado("Ronaldo", 4, 10, 10, 10, 10, 10, 10, 10);
        e2.addJogador(j5);
        e2.addJogador(j6);
        e2.addJogador(j7);
        e2.addJogador(j8);
        Jogo jj = new Jogo("Equipa1", "Equipa2", e1, e2, numeros, numeros);
        System.out.println(jj.toString());
    }
}