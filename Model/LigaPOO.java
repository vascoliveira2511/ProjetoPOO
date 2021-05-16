import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.List;
import java.time.LocalDate;

/**
 * Classe ligaPOO
 */
public class LigaPOO {

    /**
     * Mapa de equipas.
     */
    private Map<String, Equipa> equipas;

    /**
     * Lista de jogos.
     */
    List<Jogo> jogos;

    public LigaPOO(Map<String, Equipa> equipas, List<Jogo> jogos) {
        this.equipas = equipas.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().clone(), (a, b) -> b, HashMap::new));
        this.jogos = jogos.stream().map(Jogo::clone).collect(Collectors.toList());
    }

    /**
     * Método que efetua a transferência de jogadores.
     * 
     * @param equipaPresente
     * @param equipaFuturo
     * @param num
     */
    public void transferencia(String equipaPresente, String equipaFuturo, int num) {
        Equipa eP = equipas.get(equipaPresente);
        Equipa eF = equipas.get(equipaFuturo);
        Jogador j = eP.existeJogador(num);
        eP.removeJogador(j);
        eF.addJogador(j);
    }
    
    public List<Jogo> jogosDoDia (LocalDate date){
        return this.jogos.stream().map(Jogo :: clone).filter(j -> j.getData().isEqual(date)).collect(Collectors.toList());
    }

}
