import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        List<Jogador> jc = equipas.get("Mahler Athletic").getJogadores();
        List<Jogador> jf = equipas.get("Mozart F. C.").getJogadores();
        Equipa ec = equipas.get("Mahler Athletic");
        Equipa ef = equipas.get("Mozart F. C.");
        Jogo j = new Jogo(ec.getClube(), ef.getClube(),
                jc.stream().map(e -> e.getNumeroJogador()).collect(Collectors.toList()),
                jf.stream().map(e -> e.getNumeroJogador()).collect(Collectors.toList()));
        j.quemGanha(ec, ef);
        System.out.println(j);
    }
}