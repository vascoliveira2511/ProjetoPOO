import java.io.Serializable;
import java.time.LocalDate;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Jogo implements Serializable {

    private SimpleEntry<String, Equipa> equipaCasa;

    private SimpleEntry<String, Equipa> equipaFora;

    private int golosCasa;

    private int golosFora;

    private LocalDate date;

    private Map<Integer, Jogador> jogadoresCasa;

    private Map<Integer, Jogador> jogadoresFora;

    private Map<Integer, Integer> substituicoesCasa;

    private Map<Integer, Integer> substituicoesFora;

    public Jogo() {

    }

    public Jogo(Equipa e1, Equipa e2, List<Integer> jc, List<Integer> jf, Map<Integer, Integer> sc,
            Map<Integer, Integer> sf) {
        this.equipaCasa = new SimpleEntry<>(e1.getClube(), e1.clone());
        this.equipaFora = new SimpleEntry<>(e2.getClube(), e2.clone());
        this.jogadoresCasa = jc.stream().collect(Collectors.toMap(j -> j, e1::existeJogador));
        this.jogadoresFora = jf.stream().collect(Collectors.toMap(j -> j, e2::existeJogador));
        this.golosCasa = 0;
        this.golosFora = 0;
        this.substituicoesCasa = new HashMap<>(sc);
        this.substituicoesFora = new HashMap<>(sf);
        this.date = LocalDate.now();
    }

    public Jogo(String ec, String ef, int gc, int gf, LocalDate d, List<Integer> jc, Map<Integer, Integer> sc,
            List<Integer> jf, Map<Integer, Integer> sf, Equipa casa, Equipa fora) {
        this.equipaCasa = new SimpleEntry<>(ec, casa);
        this.equipaFora = new SimpleEntry<>(ef, fora);
        this.golosCasa = gc;
        this.golosFora = gf;
        this.date = d;
        this.jogadoresCasa = jc.stream().collect(Collectors.toMap(j -> j, casa::existeJogador));
        this.jogadoresFora = jf.stream().collect(Collectors.toMap(j -> j, fora::existeJogador));
        this.substituicoesCasa = new HashMap<>(sc);
        this.substituicoesFora = new HashMap<>(sf);
    }

    public Jogo(String ec, String ef, int gc, int gf, LocalDate d, List<Integer> jc, Map<Integer, Integer> sc,
            List<Integer> jf, Map<Integer, Integer> sf) {
        this.equipaCasa = new SimpleEntry<>(ec, new Equipa());
        this.equipaFora = new SimpleEntry<>(ef, new Equipa());
        this.golosCasa = gc;
        this.golosFora = gf;
        this.date = d;
        this.jogadoresCasa = jc.stream().collect(Collectors.toMap(j -> j, j -> new Avancado())); // temporario
        this.jogadoresFora = jf.stream().collect(Collectors.toMap(j -> j, j -> new Avancado())); // temporario
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
        return this.jogadoresCasa.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, j -> j.getValue().clone()));
    }

    public Map<Integer, Jogador> getJogadoresFora() {
        return this.jogadoresFora.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, j -> j.getValue().clone()));
    }

    public void setEquipaCasa(String clube, Equipa e) {
        this.equipaCasa = new SimpleEntry<>(clube, e);
    }

    public void setEquipaFora(String clube, Equipa e) {
        this.equipaFora = new SimpleEntry<>(clube, e);
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
        return this.substituicoesCasa.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<Integer, Integer> getSubstituicoesFora() {
        return this.substituicoesFora.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public void setGolosCasa(int x) {
        this.golosCasa = x;
    }

    public void setGolosFora(int x) {
        this.golosFora = x;
    }

    public void setDate(LocalDate x) {
        this.date = x;
    }

    private double probs(double overall1, double overall2) {
        double dif = (overall1 / 100) - (overall2 / 100);
        return Math.exp(dif) / (1 + Math.exp(dif));
    }

    public double overallPosicao(String posicao, int x) {
        if (x == 0)
            return this.jogadoresCasa.values().stream().filter(j -> j.getClass().getSimpleName().equals(posicao))
                    .mapToDouble(Jogador::overall).sum();
        else
            return this.jogadoresFora.values().stream().filter(j -> j.getClass().getSimpleName().equals(posicao))
                    .mapToDouble(Jogador::overall).sum();
    }

    private void situacoesGolos(double dif, double aleatorio) {
        double aleatorio2 = Math.random();
        double marcar;
        if (aleatorio <= dif) {
            // ataque equipa 1
            marcar = probs(overallPosicao("Avancado", 0),
                    (0.6 * overallPosicao("Defesa", 1) + (0.4 * overallPosicao("GuardaRedes", 1))));
            if (aleatorio2 < marcar) {
                this.golosCasa++;
            }
        } else {
            // ataque equipa 2
            marcar = probs(overallPosicao("Avancado", 1),
                    (0.6 * overallPosicao("Defesa", 0) + (0.4 * overallPosicao("GuardaRedes", 0))));
            if (aleatorio2 < marcar) {
                this.golosFora++;
            }
        }
    }

    public void substituicoes() {
        // equipa casa
        Jogador s1 = this.jogadoresCasa.values().stream().min(Comparator.comparingInt(Jogador::getResistencia)).get();
        Jogador e1 = this.jogadoresCasa.values().stream().filter(j -> j.getClass().equals(s1.getClass()))
                .max((j1, j2) -> (int) (j1.overall() - j2.overall())).get();
        this.jogadoresCasa.remove(s1.getNumeroJogador());
        this.jogadoresCasa.put(e1.getNumeroJogador(), e1);
        this.substituicoesCasa.put(s1.getNumeroJogador(), e1.getNumeroJogador());
        // equipa fora
        Jogador s2 = this.jogadoresFora.values().stream().min(Comparator.comparingInt(Jogador::getResistencia)).get();
        Jogador e2 = this.jogadoresFora.values().stream().filter(j -> j.getClass().equals(s2.getClass()))
                .max(Comparator.comparingDouble(Jogador::overall)).get();
        this.jogadoresFora.remove(s2.getNumeroJogador());
        this.jogadoresFora.put(e2.getNumeroJogador(), e2);
        this.substituicoesFora.put(s2.getNumeroJogador(), e2.getNumeroJogador());

    }

    public void substituiçoes2() {
        for (Map.Entry<Integer, Integer> m : this.substituicoesCasa.entrySet()) {
            this.jogadoresCasa.remove(m.getKey());
            this.jogadoresCasa.put(m.getValue(), this.equipaCasa.getValue().existeJogador(m.getValue()));
        }
        for (Map.Entry<Integer, Integer> m : this.substituicoesFora.entrySet()) {
            this.jogadoresFora.remove(m.getKey());
            this.jogadoresFora.put(m.getValue(), this.equipaFora.getValue().existeJogador(m.getValue()));
        }
    }

    public List<Jogador> melhoresPosicao(List<Jogador> listaJ, String posicao) {
        return listaJ.stream().filter(j -> j.getClass().getSimpleName().equals(posicao)).map(Jogador::clone)
                .sorted(new JogadorComparator()).collect(Collectors.toList());
    }

    public Map<String, List<Jogador>> melhoresTodasPosicoes(List<Jogador> listaJ) {
        Map<String, List<Jogador>> m = new HashMap<>();
        m.put("Guarda-Redes", this.melhoresPosicao(listaJ, "Guarda-Redes"));
        m.put("Defesa", this.melhoresPosicao(listaJ, "Defesa"));
        m.put("Lateral", this.melhoresPosicao(listaJ, "Lateral"));
        m.put("Avancado", this.melhoresPosicao(listaJ, "Avancado"));
        return m;
    }

    public Jogador escolheGuardaRedes(Map<String, List<Jogador>> melhores) {
        List<Jogador> g = melhores.get("Guarda-Redes");
        return g.get(0);
    }

    public List<Jogador> escolhePosicao(Map<String, List<Jogador>> melhores, String posicao, int quantos, String opcao2,
            String opcao3) {
        List<Jogador> r = new ArrayList<>(quantos);
        int i;

        // 1 OPCAO
        List<Jogador> m1 = melhores.get(posicao);
        for (i = 0; i < quantos && i < m1.size(); i++) {
            r.add(m1.get(i));
        }
        // 2 OPCAO
        if (i < quantos) {
            List<Jogador> m2 = melhores.get(opcao2);
            int j = 0;
            for (; i < quantos && i < m2.size(); i++) {
                r.add(m2.get(j++));
            }
        }
        // 3 OPCAO
        if (i < quantos) {
            List<Jogador> m3 = melhores.get(opcao3);
            int j = 0;
            for (; i < quantos && i < m3.size(); i++) {
                r.add(m3.get(j++));
            }
        }
        return r;
    }

    public Map<Integer, Jogador> equipaTitular(List<Jogador> jogadores) {
        List<Jogador> utilizados = new ArrayList<>(jogadores);
        Map<Integer, Jogador> r = new HashMap<>();
        Map<String, List<Jogador>> melhores = this.melhoresTodasPosicoes(jogadores);
        r.put(escolheGuardaRedes(melhores).getNumeroJogador(), escolheGuardaRedes(melhores));
        for (Jogador j : escolhePosicao(melhores, "Defesa", 2, "Medio", "Lateral")) {
            r.put(j.getNumeroJogador(), j);
            utilizados.remove(j);
        }
        for (Jogador j : escolhePosicao(melhores, "Medio", 2, "Defesa", "Avancado")) {
            r.put(j.getNumeroJogador(), j);
            utilizados.remove(j);
        }
        for (Jogador j : escolhePosicao(melhores, "Avancado", 2, "Medio", "Lateral")) {
            r.put(j.getNumeroJogador(), j);
            utilizados.remove(j);
        }
        for (Jogador j : escolhePosicao(melhores, "Lateral", 2, "Avancado", "Medio")) {
            r.put(j.getNumeroJogador(), j);
            utilizados.remove(j);
        }
        return r;
    }

    public double overallTitulares(List<Jogador> titulares) {
        double r = titulares.stream().mapToDouble(Jogador::overall).sum();
        return r / 11;
    }

    public double difsEquipas() {
        double overallEC = this.overallTitulares(new ArrayList<>(this.jogadoresCasa.values()));
        double overallEF = this.overallTitulares(new ArrayList<>(this.jogadoresFora.values()));
        return probs(overallEC / 11, overallEF / 11);
    }

    public void simulacaoJogo() {
        double dif = this.difsEquipas();
        for (int i = 0; i < 9; i++) {
            if (i == 5) {
                this.substituiçoes2();
                dif = this.difsEquipas();
            }
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
                && this.equipaFora.equals(j.getEquipaFora()) && this.golosCasa == j.getGolosCasa()
                && this.golosFora == j.getGolosFora() && this.jogadoresCasa.equals(j.getJogadoresCasa())
                && this.jogadoresFora.equals(j.getJogadoresFora())
                && this.substituicoesCasa.equals(j.getSubstituicoesCasa())
                && this.substituicoesFora.equals(j.getSubstituicoesFora());
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Data: " + this.date.toString() + "\n" + this.equipaCasa.getKey() + "  "
                + this.golosCasa + "  -  " + this.golosFora + "  " + this.equipaFora.getKey() + "\n");
        sb.append("Equipa Casa: " + this.jogadoresCasa.keySet() + "\n");
        sb.append("Equipa Fora: " + this.jogadoresFora.keySet() + "\n");
        sb.append("Substituições casa: {");
        for (Map.Entry<Integer, Integer> m : this.substituicoesCasa.entrySet()) {
            sb.append(m.getKey() + " -> " + m.getValue() + "; ");
        }
        sb.append("}\nSubstituições Fora: {");
        for (Map.Entry<Integer, Integer> m : this.substituicoesFora.entrySet()) {
            sb.append(m.getKey() + " -> " + m.getValue() + "; ");
        }
        sb.append("}\n");
        return sb.toString();
    }

    public String toString2() {

        return this.equipaCasa.getKey() + "  " + this.golosCasa + " - " + this.golosFora + " "
                + this.equipaFora.getKey() + "     -->Data: " + this.date.toString() + "\n";
    }
}
