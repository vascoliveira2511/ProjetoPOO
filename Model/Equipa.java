
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.Serializable;

/**
 * Classe Equipa
 */
public class Equipa implements Serializable {

    private String clube;
    /**
     * List de jogadores
     */
    private Map<Integer, Jogador> jogadores;

    public Equipa() {
        this.clube = " ";
        this.jogadores = new HashMap<>();
    }

    public Equipa(String clube, int nTitulares, int nSuplentes, ArrayList<Jogador> jogadores) {
        this.clube = clube;
        this.jogadores = jogadores.stream().map(Jogador::clone)
                .collect(Collectors.toMap(Jogador::getNumeroJogador, j -> j));
    }

    public Equipa(String nomeE) {
        this.clube = nomeE;
        this.jogadores = new HashMap<>();
    }

    public Equipa(String clube, ArrayList<Jogador> jogadores) {
        this.clube = clube;
        this.jogadores = jogadores.stream().map(Jogador::clone)
                .collect(Collectors.toMap(Jogador::getNumeroJogador, j -> j));
    }

    public static Equipa parse(String input) {
        String[] campos = input.split(",");
        return new Equipa(campos[0]);
    }

    /**
     * Metodo que cria uma instancia de equipa a partir de outra equipa recebida.
     *
     * @param e
     */
    public Equipa(Equipa e) {
        this.clube = e.getClube();
        this.jogadores = e.getJogadores();
    }

    public String getClube() {
        return this.clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }


    /**
     * Metodo que devolve a lista de titulares da equipa.
     *
     * @return titulares
     */
    public Map<Integer, Jogador> getJogadores() {
        return this.jogadores.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, j -> j.getValue().clone()));
    }

    /**
     * Metodo que altera os valores do ArrayList de joagdores titulares.
     *
     * @param titulares
     * @param nTitulares
     */
    public void setJogadores(ArrayList<Jogador> titulares) {
        this.jogadores = titulares.stream().map(Jogador::clone)
                .collect(Collectors.toMap(Jogador::getNumeroJogador, j -> j));
    }

    public void addJogador(Jogador j) {
        this.jogadores.put(j.getNumeroJogador(), j.clone());
    }

    public void removeJogador(Jogador j) throws JogadorException {
        j.addEquipa(this.clube);
        if (this.jogadores.get(j.getNumeroJogador()) == null)
            throw new JogadorException("Jogador" + j.getNumeroJogador() + "nao existe na equipa " + this.clube + "!\n");
        this.jogadores.remove(j.getNumeroJogador());
    }

    public Jogador existeJogador(int num) {
        for (Jogador j : this.jogadores.values()) {
            if (j.getNumeroJogador() == num)
                return j;
        }
        return null;
    }

    /**
     * Metodo que calcula o overall da equipa.
     *
     * @return overall da equipa
     */
    public double overallEquipa() {
        double overall = 0;
        for (Jogador t : this.jogadores.values())
            overall += t.overall();
        return (overall / ((this.jogadores.size() == 0) ? 1 : this.jogadores.size()));
    }

    public Equipa clone() {
        return new Equipa(this);
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || o.getClass() != this.getClass())
            return false;
        Equipa e = (Equipa) o;
        return this.clube.equals(e.clube) && this.jogadores.equals(e.getJogadores());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Clube: " + this.clube + " (Overall: " + String.format("%.2f", this.overallEquipa())
                 + ")\n");
        for (Jogador j : this.jogadores.values().stream()
                                                .sorted(Comparator.comparing(j -> j.getClass().getSimpleName()))
                                                .collect(Collectors.toList())){
            sb.append(j);
        }
        return sb.toString();
    }
}