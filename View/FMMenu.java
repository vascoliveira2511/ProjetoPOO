import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FMMenu {
    public static void main(String[] args) {
        String[] s = {};
        Menu m = new Menu(s);
        m.executa();
        Map<String, Equipa> equipas = new HashMap<>(); // nome, equipa
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
                e2.getJogadores().stream().map(Jogador::getNumeroJogador).collect(Collectors.toList()),
                new HashMap<>());
        jj.simulacaoJogo(e1, e2);
        int op = m.getOpcao();
        System.out.println("Opção lida: " + op);
        switch (op) {

        }

    }
}
