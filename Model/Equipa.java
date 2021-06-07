
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.io.Serializable;

/**
 * Classe Equipa
 */
public class Equipa implements Serializable {

    private String clube;
    /**
     * Numero de titulares na equipa.
     */
    private int nTitulares;

    /**
     * Numero de suplentes na equipa.
     */
    private int nSuplentes;

    /**
     * List de jogadores
     */
    private List<Jogador> jogadores;

    /**
     * Metodo que cria uma instancia de equipa com os valores recebidos.
     *
     * @param nTitulares
     * @param nSuplentes
     * @param titulares
     * @param suplentes
     */
    public Equipa(String clube, int nTitulares, int nSuplentes, ArrayList<Jogador> jogadores) {
        this.clube = clube;
        this.nTitulares = nTitulares;
        this.nSuplentes = nSuplentes;
        this.jogadores = jogadores.stream().map(Jogador::clone).collect(Collectors.toList());
    }

    public Equipa(String nomeE) {
        this.clube = nomeE;
        this.jogadores = new ArrayList<>();
    }

    public Equipa(String clube, ArrayList<Jogador> jogadores) {
        this.clube = clube;
        this.nTitulares = 11;
        this.nSuplentes = 3;
        this.jogadores = jogadores.stream().map(Jogador::clone).collect(Collectors.toList());
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
        this.nTitulares = e.getnTitulares();
        this.nSuplentes = e.getnSuplentes();
        this.jogadores = e.getJogadores();
    }

    public String getClube() {
        return this.clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }

    /**
     * Metodo que debolve o numero de titulares na equipa.
     *
     * @return nTitulares
     */
    public int getnTitulares() {
        return this.nTitulares;
    }

    /**
     * Metodo que altera o numero de suplentes na equipa
     *
     * @param nTitulares
     */
    public void setnTitulares(int nTitulares) {
        this.nTitulares = nTitulares;
    }

    /**
     * Metodo que debolve o numero de suplentes na equipa.
     *
     * @return nSuplentes
     */
    public int getnSuplentes() {
        return this.nSuplentes;
    }

    /**
     * Metodo que altera o numero de suplentes na equipa
     *
     * @param nSuplentes
     */
    public void setnSuplentes(int nSuplentes) {
        this.nSuplentes = nSuplentes;
    }

    /**
     * Metodo que devolve a lista de titulares da equipa.
     *
     * @return titulares
     */
    public List<Jogador> getJogadores() {
        return this.jogadores.stream().map(Jogador::clone).collect(Collectors.toList());
    }

    /**
     * Metodo que altera os valores do ArrayList de joagdores titulares.
     *
     * @param titulares
     * @param nTitulares
     */
    public void setJogadores(ArrayList<Jogador> titulares) {
        this.jogadores = jogadores.stream().map(Jogador::clone).collect(Collectors.toList());
    }

    public void addJogador(Jogador j) {
        j.addEquipa(this.clube);
        this.jogadores.add(j.clone());
    }

    public void removeJogador(Jogador j) throws JogadorException {
        if (!this.jogadores.contains(j))
            throw new JogadorException("Jogador" + j.getNumeroJogador() + "nao existe na equipa " + this.clube + "!\n");
        this.jogadores.remove(j);
    }

    public Jogador existeJogador(int num) {
        return this.jogadores.stream().map(Jogador::clone).filter(j -> j.getNumeroJogador() == num)
                .collect(Collectors.toList()).get(0);
    }

    /**
     * Metodo que calcula o overall da equipa.
     *
     * @return overall da equipa
     */
    public double overallEquipa() {
        double overall = 0;
        for (Jogador t : this.jogadores)
            overall += t.overall();
        return (overall / (this.jogadores.size()));
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
        return this.clube.equals(e.clube) && this.jogadores.equals(e.getJogadores())
                && this.nSuplentes == e.getnSuplentes() && this.nTitulares == e.getnTitulares();
    }

    public String toString() {
        return "Clube: " + this.clube + "\n" + "Numero suplentes: " + this.nSuplentes + "\n" + "Numero Titulares: "
                + this.nTitulares + "\n" + "Jogadores: " + this.jogadores.toString() + "\n";
    }
}