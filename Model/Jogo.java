import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.lang.Math;

public class Jogo {
    //private String equipaCasa;
    private Map <String, Equipa> equipaCasa;
    //private String equipaFora;
     private Map <String, Equipa> equipaFora;
    private int golosCasa;
    private int golosFora;
    private LocalDate date;
    //private List<Integer> jogadoresCasa;
    private Map <Integer, Jogador> jogadoresCasa;
    //private List<Integer> jogadoresFora;
    private Map <Integer, Jogador> jogadoresFora;
    Map<Integer, Integer> substituicoesCasa;
    Map<Integer, Integer> substituicoesFora;

    public Jogo(String ec, String ef, int gc, int gf) {
        this.equipaCasa = new AbstractMap.SimpleEntry(ec, casa);
        this.equipaFora =  new AbstractMap.SimpleEntry(ec, fora);
        this.golosCasa = gc;
        this.golosFora = gf;
    }

    public Jogo(String ec, String ef, int gc, int gf, LocalDate d, List<Integer> jc, Map<Integer, Integer> sc,
            List<Integer> jf, Map<Integer, Integer> sf, Equipa casa, Equipa fora) {
        this.equipaCasa = new AbstractMap.SimpleEntry(ec, casa);
        this.equipaFora =  new AbstractMap.SimpleEntry(ec, fora);
        this.golosCasa = gc;
        this.golosFora = gf;
        this.date = d;
        this.jogadoresCasa = jf.stream().collect(Collectors.toMap(j-> j, j -> casa.existeJogador(j)));
        this.jogadoresFora = jf.stream().collect(Collectors.toMap(j-> j, j -> fora.existeJogador(j)));;
        this.substituicoesCasa = new HashMap<>(sc);
        this.substituicoesFora = new HashMap<>(sf);
    }

    /*public Jogo(String ec, String ef, int gc, int gf, LocalDate d, List<Integer> jc, Map<Integer, Integer> sc,
                List<Integer> jf, Map<Integer, Integer> sf) {
        this.equipaCasa = ec;
        this.equipaFora = ef;
        this.golosCasa = gc;
        this.golosFora = gf;
        this.date = d;
        this.jogadoresCasa = new ArrayList<>(jc);
        this.jogadoresFora = new ArrayList<>(jf);
        this.substituicoesCasa = new HashMap<>(sc);
        this.substituicoesFora = new HashMap<>(sf);
    }*/


    public Jogo(Jogo jogo) {
        this.equipaCasa = jogo.getEquipaCasa();
        this.equipaFora = jogo.getEquipaFora();
        this.golosCasa = jogo.getGolosCasa();
        this.golosFora = jogo.getGolosFora();
        this.date = jogo.getData();
        this.jogadoresCasa = jogo.getJogadoresCasa();
        this.jogadoresFora = jogo.getJogadoresFora();
        this.substituicoesCasa = jogo.getSubstituicoesCasa();
        this.substituicoesFora = jogo.getSubstituicoesFora();

    }

    public static Jogo parse(String input) {
        String[] campos = input.split(",");
        String[] data = campos[4].split("-");
        List<Integer> jc = new ArrayList<>();
        List<Integer> jf = new ArrayList<>();
        Map<Integer, Integer> subsC = new HashMap<>();
        Map<Integer, Integer> subsF = new HashMap<>();
        for (int i = 5; i < 16; i++) {
            jc.add(Integer.parseInt(campos[i]));
        }
        for (int i = 16; i < 19; i++) {
            String[] sub = campos[i].split("->");
            subsC.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        for (int i = 19; i < 30; i++) {
            jf.add(Integer.parseInt(campos[i]));
        }
        for (int i = 30; i < 33; i++) {
            String[] sub = campos[i].split("->");
            subsF.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        return new Jogo(campos[0], campos[1], Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),
                LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])), jc,
                subsC, jf, subsF);
    }

    public Map<String, Equipa> getEquipaCasa() {
        return this.equipaCasa.entrySet().stream().collect(Collectors.toMap(e-> e.getKey(), e -> e.getValue()));
    }

    public Map<String, Equipa> getEquipaFora() {
        return this.equipaFora.entrySet().stream().collect(Collectors.toMap(e-> e.getKey(), e -> e.getValue()));
    }

    public int getGolosCasa() {
        return this.golosCasa;
    }

    public int getGolosFora() {
        return this.golosFora;
    }

    public LocalDate getData() {
        return this.date;
    }

    public Map<Integer, Jogador> getJogadoresCasa() {
        return this.jogadoresCasa.entrySet().stream().collect(Collectors.toMap(e-> e.getKey(), e -> e.getValue()));;;
    }

    public Map<Integer, Jogador> getJogadoresFora() {
        return this.jogadoresCasa.entrySet().stream().collect(Collectors.toMap(e-> e.getKey(), e -> e.getValue()));;;
    }

    public void setJogadoresFora(List<Integer> jogadoresFora) {
        this.jogadoresFora = new ArrayList<>(jogadoresFora);
    }

    public void setJogadoresCasa(List<Integer> jogadoresCasa) {
        this.jogadoresCasa = new ArrayList<>(jogadoresCasa);
    }

    public Map<Integer, Integer> getSubstituicoesCasa() {
        return this.substituicoesCasa;
    }

    public Map<Integer, Integer> getSubstituicoesFora() {
        return this.substituicoesFora;
    }

    private double probs(double overall1, double overall2) {
        double dif = (overall1 / 100) - (overall2 / 100);
        return Math.exp(dif) / (1 + Math.exp(dif));
    }

    public double overallPosicao(Equipa e, String posicao) {
        List<Jogador> pos = e.melhoresPosicao(posicao);
        return ((pos.stream().mapToDouble(Jogador::overall).sum()) / (e.melhoresPosicao(posicao)).size());
    }

    private void situacoesGolos(Equipa e1, Equipa e2, double dif, double aleatorio) {
        double aleatorio2 = Math.random();
        double marcar;
        if (aleatorio <= dif) {
            // ataque equipa 1
            marcar = probs(overallPosicao(e1, "Avancado"), overallPosicao(e2, "Defesa"));
            if (aleatorio2 < marcar)
                this.golosCasa++;
        } else {
            // ataque equipa 2
            marcar = probs(overallPosicao(e1, "Avancado"), overallPosicao(e2, "Defesa"));
            if (aleatorio2 < marcar)
                this.golosFora++;
        }
    }

    public void simulacaoJogo(Equipa e1, Equipa e2) {
        double dif = probs(e1.overallEquipa(), e2.overallEquipa());
        for (int i = 0; i < 9; i++) {
            double aleatorio = Math.random();
            this.situacoesGolos(e1, e2, dif, aleatorio);
        }

    }

    public Jogo clone() {
        return new Jogo(this);
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null || o.getClass() != this.getClass())
            return false;
        Jogo j = (Jogo) o;
        return this.date.equals(j.getData()) && this.equipaCasa.equals(j.getEquipaCasa())
                && this.equipaFora.equals(j.getEquipaFora()) && this.golosCasa == j.getGolosFora()
                && this.golosFora == j.getGolosFora() && this.jogadoresCasa.equals(j.getJogadoresCasa())
                && this.jogadoresFora.equals(j.getJogadoresFora())
                && this.substituicoesCasa.equals(j.getSubstituicoesCasa())
                && this.substituicoesFora.equals(j.getSubstituicoesFora());
    }

    public String toString() {
        return "Data: " + this.date.toString() + "\n" +
                "Equipa casa: " + this.equipaCasa + "\n" +
                "Equipa fora: " + this.equipaFora + "\n" +
                "Golos casa: " + this.golosCasa + "\n" +
                "Golos fora: " + this.golosFora + "\n" +
                "Jogadores casa" + this.jogadoresCasa.toString() + "\n" +
                "Jogadores fora" + this.jogadoresFora.toString() + "\n" +
                "Substituições casa" + this.substituicoesCasa.toString() + "\n" +
                "Substituições fora" + this.substituicoesFora.toString() + "\n";
    }
}
