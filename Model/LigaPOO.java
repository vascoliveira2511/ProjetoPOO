import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.time.LocalDate;
import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

/**
 * Classe ligaPOO
 */
public class LigaPOO implements Serializable {

    /**
     * Mapa de equipas.
     */
    private Map<String, Equipa> equipas;

    /**
     * Lista de jogos.
     */
    private List<Jogo> jogos;

    public LigaPOO() {
        this.equipas = new HashMap<>();
        this.jogos = new ArrayList<>();
    }

    public LigaPOO(Map<String, Equipa> equipas, List<Jogo> jogos) {
        this.equipas = equipas.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().clone(), (a, b) -> b, HashMap::new));
        this.jogos = jogos.stream().map(Jogo::clone).collect(Collectors.toList());
    }
    
    public LigaPOO(LigaPOO l){
        this.equipas = l.getEquipas();
        this.jogos = l.getJogos();
    }
    
    public Map<String, Equipa> getEquipas(){
        return this.equipas.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().clone()));
    }
    
    public void setEquipas (Map<String, Equipa> e){
        this.equipas = e.entrySet().stream().collect(Collectors.toMap(eq -> eq.getKey(), eq -> eq.getValue().clone()));
    }
    
    public List<Jogo> getJogos(){
        return this.jogos.stream().map(Jogo :: clone).collect(Collectors.toList());
    }
    
    public void getJogos(List<Jogo> j){
        this.jogos = j.stream().map(Jogo :: clone).collect(Collectors.toList());
    }
    
    

    /**
     * Método que efetua a transferência de jogadores.
     * 
     * @param equipaPresente
     * @param equipaFuturo
     * @param num
     */
    public void transferencia(String equipaPresente, String equipaFuturo, int num) throws JogadorException {
        Equipa eP = equipas.get(equipaPresente);
        Equipa eF = equipas.get(equipaFuturo);
        Jogador j = eP.existeJogador(num);
        eP.removeJogador(j);
        eF.addJogador(j);
    }

    public List<Jogo> jogosDoDia(LocalDate date) {
        return this.jogos.stream().map(Jogo::clone).filter(j -> j.getData().isEqual(date)).collect(Collectors.toList());
    }
    
    public void saveToBinary(String fn)throws IOException{
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fn));
        os.writeObject(this);
        os.close();
    }
    
    public static LigaPOO readFromBinary(String fn)throws IOException, FileNotFoundException, ClassNotFoundException{
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(fn));
        LigaPOO liga = (LigaPOO) is.readObject();
        is.close();
        return liga;
    }
    
    public LigaPOO clone(){
        return new LigaPOO(this);
    }

}
