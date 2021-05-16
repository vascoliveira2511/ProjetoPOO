import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.lang.Math;
import java.util.stream.Collectors;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Jogo {
    // private String equipaCasa;
    private SimpleEntry<String, Equipa> equipaCasa;
    // private String equipaFora;
    private SimpleEntry<String, Equipa> equipaFora;
    private int golosCasa;
    private int golosFora;
    private LocalDate date;
    // private List<Integer> jogadoresCasa;
    private Map<Integer, Jogador> jogadoresCasa;
    // private List<Integer> jogadoresFora;
    private Map<Integer, Jogador> jogadoresFora;
    Map<Integer, Integer> substituicoesCasa;
    Map<Integer, Integer> substituicoesFora;

    public Jogo(String ec, String ef, Equipa casa, Equipa fora, List<Integer> jc, List<Integer> jf) {
        this.equipaCasa = new SimpleEntry<>(ec, casa);
        this.equipaFora = new SimpleEntry<>(ef, fora);
        this.golosCasa = 0;
        this.golosFora = 0;
        this.jogadoresCasa = jc.stream().collect(Collectors.toMap(j -> j, j -> casa.existeJogador(j)));
        this.jogadoresFora = jf.stream().collect(Collectors.toMap(j -> j, j -> fora.existeJogador(j)));
        this.date = LocalDate.now();
    }

    public Jogo(String ec, String ef, int gc, int gf, LocalDate d, List<Integer> jc, Map<Integer, Integer> sc,
            List<Integer> jf, Map<Integer, Integer> sf, Equipa casa, Equipa fora) {
        this.equipaCasa = new SimpleEntry<>(ec, casa);
        this.equipaFora = new SimpleEntry<>(ef, fora);
        this.golosCasa = gc;
        this.golosFora = gf;
        this.date = d;
        this.jogadoresCasa = jc.stream().collect(Collectors.toMap(j -> j, j -> casa.existeJogador(j)));
        this.jogadoresFora = jf.stream().collect(Collectors.toMap(j -> j, j -> fora.existeJogador(j)));
        this.substituicoesCasa = new HashMap<>(sc);
        this.substituicoesFora = new HashMap<>(sf);
    }
    
    public Jogo(String ec, String ef, int gc, int gf, LocalDate d, List<Integer> jc, Map<Integer, Integer> sc,
            List<Integer> jf, Map<Integer, Integer> sf) {
        this.equipaCasa = new SimpleEntry<>(ec, null);
        this.equipaFora = new SimpleEntry<>(ef, null);
        this.golosCasa = gc;
        this.golosFora = gf;
        this.date = d;
        this.jogadoresCasa = jc.stream().collect(Collectors.toMap(j -> j, null));
        this.jogadoresFora = jf.stream().collect(Collectors.toMap(j -> j, null));
        this.substituicoesCasa = new HashMap<>(sc);
        this.substituicoesFora = new HashMap<>(sf);
    }


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

    public static Jogo parse(String input){
        String[] campos = input.split(",");
        String[] data = campos[4].split("-");
        List<Integer> jc = new ArrayList<>();
        List<Integer> jf = new ArrayList<>();
        Map<Integer, Integer> subsC = new HashMap<>();
        Map<Integer, Integer> subsF = new HashMap<>();
        for (int i = 5; i < 16; i++){
            jc.add(Integer.parseInt(campos[i]));
        }
        for (int i = 16; i < 19; i++){
            String[] sub = campos[i].split("->");
            subsC.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        for (int i = 19; i < 30; i++){
            jf.add(Integer.parseInt(campos[i]));
        }
        for (int i = 30; i < 33; i++){
            String[] sub = campos[i].split("->");
            subsF.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        return new Jogo(campos[0], campos[1], Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),
                        LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])),
                        jc, subsC, jf, subsF);
    }

    public SimpleEntry<String, Equipa> getEquipaCasa() {
        return new SimpleEntry<String, Equipa>(this.equipaCasa.getKey(), this.equipaCasa.getValue().clone());
    }

    public SimpleEntry<String, Equipa> getEquipaFora() {
        return new SimpleEntry<String, Equipa>(this.equipaFora.getKey(), this.equipaFora.getValue().clone());
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
        return this.jogadoresCasa.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
    }

    public Map<Integer, Jogador> getJogadoresFora() {
        return this.jogadoresCasa.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
    }
    
    public void setEquipaCasa(String clube, Equipa e){
        this.equipaCasa = new SimpleEntry<>(clube, e);
    }
    
    public void setEquipaFora(String clube, Equipa e){
        this.equipaCasa = new SimpleEntry<>(clube, e);
    }


    
    public void setJogadoresFora(Equipa equipa) {
        this.jogadoresFora = this.jogadoresFora.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> equipa.existeJogador(e.getKey()))); 
    }
      
     public void setJogadoresCasa(Equipa equipa) {
        this.jogadoresCasa = this.jogadoresCasa.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> equipa.existeJogador(e.getKey()))); 
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
            if (aleatorio2 < marcar){
                this.golosCasa++;
                System.out.println("golo equipa 1!");
            }
        } else {
            // ataque equipa 2
            marcar = probs(overallPosicao(e1, "Avancado"), overallPosicao(e2, "Defesa"));
            if (aleatorio2 < marcar){
                this.golosFora++;
                System.out.println("golo equipa 2!");
            }
        }
    }

    public void simulacaoJogo() throws java.lang.InterruptedException {
        Equipa ec = this.equipaCasa.getValue();
        Equipa ef = this.equipaFora.getValue();
        double dif = probs(ec.overallEquipa(), ef.overallEquipa());
        for (int i = 0; i < 9; i++) {
            TimeUnit.SECONDS.sleep(1);
            double aleatorio = Math.random();
            this.situacoesGolos(ec, ef, dif, aleatorio);
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
        StringBuilder sb = new StringBuilder();
        sb.append("Data: " + this.date.toString() + "\n" + this.equipaCasa.getKey() + " - "
                + this.equipaFora .getKey()+ "\n" + this.golosCasa + "  -  " + this.golosFora + "\n")
                /*+ "\n" + "Jogadores casa: \n")*/;
        /*for (Jogador j : this.jogadoresCasa.values()){
            sb.append(j.toString());
        }
        sb.append("Jogadores fora: \n");
        for (Jogador j : this.jogadoresFora.values()){
            sb.append(j.toString());
        }*/
        return sb.toString();
        /*return "Data: " + this.date.toString() + "\n" + "Equipa casa: " + this.equipaCasa.getKey() + "\n" + "Equipa fora: "
                + this.equipaFora .getKey()+ "\n" + "Golos casa: " + this.golosCasa + "\n" + "Golos fora: " + this.golosFora
                + "\n" + "Jogadores casa" + this.jogadoresCasa.values().stream().map(Jogador :: toString) + "\n" + "Jogadores fora"
                + this.jogadoresFora.values().stream().map(Jogador :: toString) + "\n"/* + "Substituições casa" + this.substituicoesCasa.toString() + "\n"
                + "Substituições fora" + this.substituicoesFora.toString() + "\n";*/
    }
}
