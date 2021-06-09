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

    public LigaPOO() throws LinhaIncorretaException {
        this.equipas = new HashMap<>();
        this.jogos = new ArrayList<>();
        Map<Integer, Jogador> jogadores = new HashMap<>();
        Parser.parse(this.equipas, jogadores, this.jogos);
    }

    public LigaPOO(Map<String, Equipa> equipas, List<Jogo> jogos) {
        this.equipas = equipas.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone()));
        this.jogos = jogos.stream().map(Jogo::clone).collect(Collectors.toList());
    }

    public LigaPOO(LigaPOO l) {
        this.equipas = l.getEquipas();
        this.jogos = l.getJogos();
    }

    public Map<String, Equipa> getEquipas() {
        return this.equipas.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone()));
    }

    public void setEquipas(Map<String, Equipa> e) {
        this.equipas = e.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, eq -> eq.getValue().clone()));
    }

    public List<Jogo> getJogos() {
        return this.jogos.stream().map(Jogo::clone).collect(Collectors.toList());
    }

    public void getJogos(List<Jogo> j) {
        this.jogos = j.stream().map(Jogo::clone).collect(Collectors.toList());
    }

    public Equipa existeEquipa(String clube) throws EquipaException {
        Equipa e = this.equipas.get(clube);
        if (e == null)
            throw new EquipaException("Equipa" + clube + "nao existe!\n");
        return e;
    }

    public Jogador procuraJogador(String clube, int num) throws EquipaException {
        Equipa e = this.existeEquipa(clube);
        return e.existeJogador(num);
    }

    public Jogo simulaJogo(String e1, String e2, List<Integer> jc, List<Integer> jf, Map<Integer, Integer> sc,
            Map<Integer, Integer> sf) throws EquipaException {
        Equipa eq1 = this.existeEquipa(e1);
        Equipa eq2 = this.existeEquipa(e2);
        Jogo j = new Jogo(eq1, eq2, jc, jf, sc, sf);
        j.simulacaoJogo();
        this.jogos.add(j);
        return j;
    }

    public Jogo simulaJogo(Jogo j) {
        Jogo novo = j.clone();
        novo.setGolosCasa(0);
        novo.setGolosFora(0);
        novo.setDate(LocalDate.now());
        novo.simulacaoJogo();
        this.jogos.add(novo);
        return novo;
    }

    /**
     * Método que efetua a transferência de jogadores.
     * 
     * @param equipaPresente
     * @param equipaFuturo
     * @param num
     */
    public void transferencia(String equipaPresente, String equipaFuturo, int num)
            throws JogadorException, EquipaException {
        Equipa eP = this.existeEquipa(equipaPresente);
        Equipa eF = this.existeEquipa(equipaFuturo);
        Jogador j = eP.existeJogador(num);
        eP.removeJogador(j);
        int numero = j.getNumeroJogador();
        while (eF.getJogadores().containsKey(numero)) {
            if (numero == 99)
                numero = 0;
            else
                numero++;
        }
        j.setNumeroJogador(numero);
        eF.addJogador(j);
    }

    public List<Jogo> jogosDoDia(LocalDate date) {
        return this.jogos.stream().map(Jogo::clone).filter(j -> j.getData().isEqual(date)).collect(Collectors.toList());
    }

    public void saveToBinary(String fn) throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fn));
        os.writeObject(this);
        os.close();
    }

    public static LigaPOO readFromBinary(String fn) throws IOException, FileNotFoundException, ClassNotFoundException {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(fn));
        LigaPOO liga = (LigaPOO) is.readObject();
        is.close();
        return liga;
    }

    public LigaPOO clone() {
        return new LigaPOO(this);
    }

}
