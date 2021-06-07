import java.time.LocalDate;
import java.util.*;
import java.lang.Math;
import java.util.stream.Collectors;
import java.util.AbstractMap.SimpleEntry;
import java.util.concurrent.TimeUnit;
import java.io.Serializable;

public class Jogo implements Serializable{
    
    private SimpleEntry<String, Equipa> equipaCasa;
    
    private SimpleEntry<String, Equipa> equipaFora;

    private int golosCasa;

    private int golosFora;

    private LocalDate date;

    private Map<Integer, Jogador> jogadoresCasa;

    private Map<Integer, Jogador> jogadoresFora;

    Map<Integer, Integer> substituicoesCasa;

    Map<Integer, Integer> substituicoesFora;

    public Jogo() {

    }

    public Jogo(String ec, String ef, Equipa casa, Equipa fora, List<Integer> jc, List<Integer> jf) {
        this.equipaCasa = new SimpleEntry<>(ec, casa);
        this.equipaFora = new SimpleEntry<>(ef, fora);
        this.golosCasa = 0;
        this.golosFora = 0;
        this.date = LocalDate.now();
        this.jogadoresCasa = jc.stream().collect(Collectors.toMap(j -> j, j -> casa.existeJogador(j)));
        this.jogadoresFora = jf.stream().collect(Collectors.toMap(j -> j, j -> fora.existeJogador(j)));
        this.substituicoesCasa = new HashMap<>();
        this.substituicoesFora = new HashMap<>();
        
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

    public SimpleEntry<String, Equipa> getEquipaCasa() {
        return new SimpleEntry<>(this.equipaCasa.getKey(), this.equipaCasa.getValue().clone());
    }

    public SimpleEntry<String, Equipa> getEquipaFora() {
        return new SimpleEntry<>(this.equipaFora.getKey(), this.equipaFora.getValue().clone());
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

    public void setEquipaCasa(String clube, Equipa e) {
        this.equipaCasa = new SimpleEntry<>(clube, e);
    }

    public void setEquipaFora(String clube, Equipa e) {
        this.equipaCasa = new SimpleEntry<>(clube, e);
    }

    public void setJogadoresFora(Equipa equipa) {
        this.jogadoresFora = this.jogadoresFora.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> equipa.existeJogador(e.getKey())));
    }

    public void setJogadoresCasa(Equipa equipa) {
        this.jogadoresCasa = this.jogadoresCasa.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> equipa.existeJogador(e.getKey())));
    }

    public Map<Integer, Integer> getSubstituicoesCasa() {
        return this.substituicoesCasa.entrySet().stream().collect(Collectors.toMap(Map.Entry :: getKey, Map.Entry :: getValue));
    }

    public Map<Integer, Integer> getSubstituicoesFora() {
        return this.substituicoesFora.entrySet().stream().collect(Collectors.toMap(Map.Entry :: getKey, Map.Entry :: getValue));
    }

    private double probs(double overall1, double overall2) {
        double dif = (overall1 / 100) - (overall2 / 100);
        return Math.exp(dif) / (1 + Math.exp(dif));
    }

    public double overallPosicao(String posicao) {
        return this.jogadoresCasa.values().stream()
                                          .filter(j -> j.getClass().getSimpleName().equals(posicao))
                                          .mapToDouble(Jogador :: overall)
                                          .sum();
    }

    private void situacoesGolos(double dif, double aleatorio) {
        double aleatorio2 = Math.random();
        double marcar;
        if (aleatorio <= dif) {
            // ataque equipa 1
            marcar = probs(overallPosicao("Avancado"), overallPosicao("Defesa"));
            if (aleatorio2 < marcar) {
                this.golosCasa++;
            }
        } else {
            // ataque equipa 2
            marcar = probs(overallPosicao("Avancado"), overallPosicao("Defesa"));
            if (aleatorio2 < marcar) {
                this.golosFora++;
            }
        }
    }
    
    public void substituicoes(){
        //equipa casa
        Jogador s1 = this.jogadoresCasa.values().stream()
                                               .min(Comparator.comparingInt(Jogador::getResistencia))
                                               .get();
        Jogador e1 = this.jogadoresCasa.values().stream()
                                               .filter(j -> j.getClass().equals(s1.getClass()))
                                               .max((j1,j2)-> (int)(j1.overall() - j2.overall()))
                                               .get();
        this.jogadoresCasa.remove(s1.getNumeroJogador());
        this.jogadoresCasa.put(e1.getNumeroJogador(), e1);
        this.substituicoesCasa.put(s1.getNumeroJogador(), e1.getNumeroJogador());
        //equipa fora
        Jogador s2 = this.jogadoresFora.values().stream()
                                               .min(Comparator.comparingInt(Jogador::getResistencia))
                                               .get();
        Jogador e2 = this.jogadoresFora.values().stream()
                                               .filter(j -> j.getClass().equals(s2.getClass()))
                                               .max(Comparator.comparingDouble(Jogador::overall))
                                               .get();
        this.jogadoresFora.remove(s2.getNumeroJogador());
        this.jogadoresFora.put(e2.getNumeroJogador(), e2);
        this.substituicoesFora.put(s2.getNumeroJogador(), e2.getNumeroJogador());
        
    }
    
    public List<Jogador> melhoresPosicao(List<Jogador> listaJ, String posicao) {
        return listaJ.stream().filter(j-> j.getClass().getSimpleName().equals(posicao))
                              .map(Jogador::clone)
                              .sorted(new JogadorComparator())
                              .collect(Collectors.toList());
    }
    
    public Map <String, List<Jogador>> melhoresTodasPosicoes(List<Jogador> listaJ) {
        Map<String, List<Jogador>> m = new HashMap<>();
        m.put("GuardaRedes", this.melhoresPosicao( listaJ,"GuardaRedes"));
        m.put("Defesa", this.melhoresPosicao( listaJ,"Defesa"));
        m.put("Lateral", this.melhoresPosicao(listaJ,"Lateral"));
        m.put("Avancado", this.melhoresPosicao(listaJ,"Avancado"));
        return m;
    }
    
    public Jogador escolheGuardaRedes(Map<String, List<Jogador>> melhores){
        List<Jogador> g = melhores.get("GuardaRedes");
        return g.get(0);
    }
    
    public List<Jogador> escolhePosicao(Map<String, List<Jogador>> melhores, String posicao, int quantos, String opcao2, String opcao3){
        List<Jogador> r = new ArrayList<>(quantos);
        int i;
        
        //1 OPCAO
        List<Jogador> m1 = melhores.get(posicao);
        for (i = 0; i < quantos && i < m1.size(); i++){
            r.add(m1.get(i));
        }
        //2 OPCAO 
        if ( i < quantos){
            List<Jogador> m2 = melhores.get(opcao2);
            int j = 0;
            for (; i < quantos && i < m2.size(); i++){
                r.add(m2.get(j++));
            }
        }
        //3 OPCAO
        if ( i < quantos){
            List<Jogador> m3 = melhores.get(opcao3);
            int j = 0;
            for (; i < quantos && i < m3.size(); i++){
                r.add(m3.get(j++));
            }
        }
        return r;
    }
    
    public Map<Integer, Jogador> equipaTitular(List<Jogador> jogadores){
        List<Jogador> utilizados = new ArrayList<>(jogadores);
        Map<Integer, Jogador> r = new HashMap<>();
        Map <String, List<Jogador>> melhores = this.melhoresTodasPosicoes(jogadores);
        r.put(escolheGuardaRedes(melhores).getNumeroJogador(), escolheGuardaRedes(melhores));
        for (Jogador j : escolhePosicao(melhores, "Defesa", 2, "Medio", "Lateral")){
            r.put(j.getNumeroJogador(), j);
            utilizados.remove(j);
        }
        for (Jogador j : escolhePosicao(melhores, "Medio", 2, "Defesa", "Avancado")){
            r.put(j.getNumeroJogador(), j);
            utilizados.remove(j);
        }
        for (Jogador j : escolhePosicao(melhores, "Avancado", 2, "Medio", "Lateral")){
            r.put(j.getNumeroJogador(), j);
            utilizados.remove(j);
        }
        for (Jogador j : escolhePosicao(melhores, "Lateral", 2, "Avancado", "Medio")){
            r.put(j.getNumeroJogador(), j);
            utilizados.remove(j);
        }
        return r;
    }

    public void simulacaoJogo() throws java.lang.InterruptedException {
        double overallEC = this.jogadoresCasa.values().stream()
                                                      .mapToDouble(Jogador :: overall)
                                                      .sum();
        double overallEF = this.jogadoresFora.values().stream()
                                                      .mapToDouble(Jogador :: overall)
                                                      .sum();
        double dif = probs(overallEC/11,overallEF/11);
        for (int i = 0; i < 9; i++) {
            //TimeUnit.SECONDS.sleep(1);
            if (i == 6 || i == 7 || i == 8) this.substituicoes();
            double aleatorio = Math.random();
            this.situacoesGolos(dif, aleatorio);
            
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
        sb.append("Data: " + this.date.toString() + "\n" + this.equipaCasa.getKey() + " - " + this.equipaFora.getKey()
                + "\n" + this.golosCasa + "  -  " + this.golosFora + "\n")
        /* + "\n" + "Jogadores casa: \n") */;
        /*
         * for (Jogador j : this.jogadoresCasa.values()){ sb.append(j.toString()); }
         * sb.append("Jogadores fora: \n"); for (Jogador j :
         * this.jogadoresFora.values()){ sb.append(j.toString()); }
         */
        return sb.toString();
        /*
         * return "Data: " + this.date.toString() + "\n" + "Equipa casa: " +
         * this.equipaCasa.getKey() + "\n" + "Equipa fora: " + this.equipaFora
         * .getKey()+ "\n" + "Golos casa: " + this.golosCasa + "\n" + "Golos fora: " +
         * this.golosFora + "\n" + "Jogadores casa" +
         * this.jogadoresCasa.values().stream().map(Jogador :: toString) + "\n" +
         * "Jogadores fora" + this.jogadoresFora.values().stream().map(Jogador ::
         * toString) + "\n"/* + "Substituições casa" + this.substituicoesCasa.toString()
         * + "\n" + "Substituições fora" + this.substituicoesFora.toString() + "\n";
         */
    }
}
