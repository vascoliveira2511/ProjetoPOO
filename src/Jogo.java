import java.time.LocalDateTime;

public class Jogo {
    private LocalDateTime data;
    private Equipa visitados;
    private int golosVisitados;
    private Equipa visitantes;
    private int golosVisitantes;
    private int nSubstituicoes;

    public Jogo(Equipa visitados, Equipa visitantes) {
        this.visitados = visitados.clone();
        this.visitantes = visitantes.clone();
    }
}
