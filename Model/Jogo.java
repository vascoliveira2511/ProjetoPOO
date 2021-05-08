import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.lang.Math;

public class Jogo {
    private String equipaCasa;
    private String equipaFora;
    private int golosCasa;
    private int golosFora;
    private LocalDate date;
    private List<Integer> jogadoresCasa;
    private List<Integer> jogadoresFora;
    Map<Integer, Integer> substituicoesCasa;
    Map<Integer, Integer> substituicoesFora;

    public Jogo(String ec, String ef, int gc, int gf, LocalDate d, List<Integer> jc, Map<Integer, Integer> sc,
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

    public String getEquipaCasa() {
        return this.equipaCasa;
    }

    public String getEquipaFora() {
        return this.equipaFora;
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

    public List<Integer> getJogadoresCasa() {
        return this.jogadoresCasa;
    }

    public List<Integer> getJogadoresFora() {
        return this.jogadoresCasa;
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
    /*
     * private void probs(double overall1, double overall2) { double dif = (overall1
     * / 100) - (overall2 / 100); double ganhar = Math.exp(dif) / (1 +
     * Math.exp(dif)); double perder = 1 - ganhar; double empatar = ganhar * perder;
     * ganhar -= empatar; perder -= empatar; }
     */

    public static String quemGanha(Equipa e1, Equipa e2) {
        String r;
        double dif = (e1.overallEquipa() / 100) - (e2.overallEquipa() / 100);
        double ganhar = Math.exp(dif) / (1 + Math.exp(dif));
        double empatar = ganhar * (1 - ganhar);
        ganhar -= empatar;
        double aleatorio = Math.random();
        if (aleatorio <= ganhar)
            r = e1.getClube();
        else if (aleatorio <= ganhar + empatar)
            r = "Empate";
        else
            r = e2.getClube();
        return r;
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
        return this.date.equals(j.getData()) && this.equipaCasa == j.getEquipaCasa()
                && this.equipaFora == j.getEquipaFora() && this.golosCasa == j.getGolosFora()
                && this.golosFora == j.getGolosFora() && this.jogadoresCasa.equals(j.getJogadoresCasa())
                && this.jogadoresFora.equals(j.getJogadoresFora())
                && this.substituicoesCasa.equals(j.getSubstituicoesCasa())
                && this.substituicoesFora.equals(j.getSubstituicoesFora());
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Data: " + this.date.toString() + "\n");
        str.append("Equipa casa: " + this.equipaCasa.toString() + "\n");
        str.append("Equipa fora: " + this.equipaFora.toString() + "\n");
        str.append("Golos casa: " + this.golosCasa + "\n");
        str.append("Golos fora: " + this.golosFora + "\n");
        str.append("Jogadores casa" + this.jogadoresCasa.toString() + "\n");
        str.append("Jogadores fora" + this.jogadoresFora.toString() + "\n");
        str.append("Substituições casa" + this.substituicoesCasa.toString() + "\n");
        str.append("Substituições fora" + this.substituicoesFora.toString() + "\n");
        return str.toString();
    }
}
