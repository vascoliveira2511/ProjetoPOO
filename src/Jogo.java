import java.time.LocalDateTime;

/**
 * Write a description of class Jogo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jogo
{
    private LocalDateTime data;
    private Equipa visitados;
    private int golosVisitados;
    private Equipa visitantes;
    private int golosVisitantes;
    private int nSubstituicoes;
    
    public Jogo(Equipa visitados, Equipa visitantes){
        this.visitados = visitados.clone();
        this.visitantes = visitantes.clone();
    }
}
