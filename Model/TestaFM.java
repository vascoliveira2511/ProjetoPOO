
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

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
        /*Jogo j1 = jogos.get(0);
        System.out.println(j1.toString());
        j1.simulacaoJogo();
        System.out.println(j1.toString());*/
        Equipa e1 = equipas.get("Bartok F. C.");
        Equipa e2 = equipas.get("Sporting Club Dvorak");
        Jogo j2 = new Jogo(e1, e2);
        System.out.println(j2.equipaTitular(new ArrayList<>(j2.getEquipaFora().getValue().getJogadores().values())));
    }
}