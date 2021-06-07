import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe parser.
 */
public class Parser {
    /**
     * Método que efetua parse de um ficheiro.
     * 
     * @param equipas
     * @param jogadores
     * @param jogos
     * @throws LinhaIncorretaException
     */
    public static void parse(Map<String, Equipa> equipas, Map<Integer, Jogador> jogadores, List<Jogo> jogos)
            throws LinhaIncorretaException {
        List<String> linhas = lerFicheiro("Files/logs.txt");
        // Map<String, Equipa> equipas = new HashMap<>(); // nome, equipa
        // Map<Integer, Jogador> jogadores = new HashMap<>(); // numero, jogador
        // List<Jogo> jogos = new ArrayList<>();
        Equipa ultima = null;
        Jogador j = null;
        String[] linhaPartida;
        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);
            switch (linhaPartida[0]) {
                case "Equipa":
                    Equipa e = Equipa.parse(linhaPartida[1]);
                    equipas.put(e.getClube(), e);
                    ultima = e;
                    break;
                case "Guarda-Redes":
                    j = GuardaRedes.parse(linhaPartida[1]);
                    jogadores.put(j.getNumeroJogador(), j);
                    if (ultima == null)
                        throw new LinhaIncorretaException(); // we need to insert the player into the team
                    ultima.addJogador(j.clone()); // if no team was parsed previously, file is not well-formed
                    break;
                case "Defesa":
                    j = Defesa.parse(linhaPartida[1]);
                    jogadores.put(j.getNumeroJogador(), j);
                    if (ultima == null)
                        throw new LinhaIncorretaException(); // we need to insert the player into the team
                    ultima.addJogador(j.clone()); // if no team was parsed previously, file is not well-formed
                    break;
                case "Medio":
                    j = Medio.parse(linhaPartida[1]);
                    jogadores.put(j.getNumeroJogador(), j);
                    if (ultima == null)
                        throw new LinhaIncorretaException(); // we need to insert the player into the team
                    ultima.addJogador(j.clone()); // if no team was parsed previously, file is not well-formed
                    break;
                case "Lateral":
                    j = Lateral.parse(linhaPartida[1]);
                    jogadores.put(j.getNumeroJogador(), j);
                    if (ultima == null)
                        throw new LinhaIncorretaException(); // we need to insert the player into the team
                    ultima.addJogador(j.clone()); // if no team was parsed previously, file is not well-formed
                    break;
                case "Avancado":
                    j = Avancado.parse(linhaPartida[1]);
                    jogadores.put(j.getNumeroJogador(), j);
                    if (ultima == null)
                        throw new LinhaIncorretaException(); // we need to insert the player into the team
                    ultima.addJogador(j.clone()); // if no team was parsed previously, file is not well-formed
                    break;
                case "Jogo":
                    Jogo jo = Jogo.parse(linhaPartida[1]);
                    Equipa casa = equipas.get(jo.getEquipaCasa().getKey());
                    Equipa fora = equipas.get(jo.getEquipaFora().getKey());
                    jo.setEquipaCasa(jo.getEquipaCasa().getKey(), casa);
                    jo.setEquipaFora(jo.getEquipaFora().getKey(), fora);
                    jo.setJogadoresCasa(casa);
                    jo.setJogadoresFora(fora);
                    jogos.add(jo);
                    break;
                default:
                    throw new LinhaIncorretaException();

            }
        }
    }

    /**
     * Método que efetua a leitura de um ficheiro.
     * 
     * @param nomeFich
     * @return
     */
    public static List<String> lerFicheiro(String nomeFich) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8);
        } catch (IOException exc) {
            lines = new ArrayList<>();
        }
        return lines;
    }

}