import java.util.Map;
import java.util.List;

/**
 * Write a description of class LigaPOO here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LigaPOO
{
    
    private Map<String, Equipa> equipas;
    List<Jogo> jogos;
    
    public void transferencia (String equipaPresente, String equipaFuturo, int num){
        Equipa eP = equipas.get(equipaPresente);
        Equipa eF = equipas.get(equipaFuturo);
        Jogador j = eP.existeJogador(num);
        eP.removeJogador(j);
        eF.addJogador(j);
    }
        

}
