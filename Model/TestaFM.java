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
        System.out.println(equipas.toString());
        System.out.println(jogadores.toString());
        System.out.println(jogos.toString());
    }
}