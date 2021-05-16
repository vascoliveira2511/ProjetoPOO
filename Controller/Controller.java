import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {

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
