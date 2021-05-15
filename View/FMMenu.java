import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Jogo jj = new Jogo(null, null, 0, 0, e2, e2);
        jj.simulacaoJogo();
        int op = m.getOpcao();
        System.out.println("Opção lida: " + op);
        switch (op) {

        }

    }
}
