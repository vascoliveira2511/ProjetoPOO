import java.util.Comparator;

/**
 * Write a description of class ComparatorJogador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JogadorComparator implements Comparator<Jogador> {
    public int compare(Jogador j1, Jogador j2) {
        return (int) (j1.overall() - j2.overall());
    }
}
