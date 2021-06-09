import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de um jogador.
 */
public abstract class Jogador implements Serializable {

    /**
     * 
     */
    private String nome;

    /**
     * 
     */
    private int numero;

    /**
     * Velocidade de um Jogador
     */
    private int velocidade;
    /**
     * Resistencia de um Jogador
     */
    private int resistencia;
    /**
     * Destreza de um Jogador
     */
    private int destreza;
    /**
     * Impulso de um Jogador
     */
    private int impulsao;
    /**
     * Jogo de cabeca de um Jogador
     */
    private int jogoDeCabeca;
    /**
     * Cpacidade de remate de um Jogador
     */
    private int remate;
    /**
     * Cpacidade de passe de um Jogador
     */
    private int capacidadeDePasse;

    /**
     * 
     */
    private List<String> histEquipas = new ArrayList<>();

    /**
     * Metodo de classe que cria uma instancia de jogador com valores fornecidos.
     *
     * @param velocidade
     * @param resistencia
     * @param destreza
     * @param impulsao
     * @param jogoDeCabeca
     * @param remate
     * @param capacidadeDePasse
     * @return void
     */

    public Jogador() {
        this.nome = " ";
        this.numero = 0;
        this.velocidade = 0;
        this.resistencia = 0;
        this.destreza = 0;
        this.impulsao = 0;
        this.jogoDeCabeca = 0;
        this.remate = 0;
        this.capacidadeDePasse = 0;
    }

    public Jogador(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao,
            int jogoDeCabeca, int remate, int capacidadeDePasse) {
        this.nome = nome;
        this.numero = numero;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.jogoDeCabeca = jogoDeCabeca;
        this.remate = remate;
        this.capacidadeDePasse = capacidadeDePasse;
    }

    /**
     * Metodo de classe que cria uma instancia de jogador a partir de um jogador
     * recebido.
     *
     * @param jogador
     * @return void
     */
    public Jogador(Jogador jogador) {
        this.nome = jogador.getNomeJogador();
        this.numero = jogador.getNumeroJogador();
        this.velocidade = jogador.getVelocidade();
        this.resistencia = jogador.getResistencia();
        this.destreza = jogador.getDestreza();
        this.impulsao = jogador.getImpulsao();
        this.jogoDeCabeca = jogador.getJogoDeCabeca();
        this.remate = jogador.getRemate();
        this.capacidadeDePasse = jogador.getCapacidadeDePasse();
        this.histEquipas = jogador.getHistEquipas();
    }

    public String getNomeJogador() {
        return this.nome;
    }

    public void setNomeJogador(String nome) {
        this.nome = nome;
    }

    public int getNumeroJogador() {
        return this.numero;
    }

    public void setNumeroJogador(int numero) {
        this.numero = numero;
    }

    /**
     * Metodo que modifica a velocidade do jogador.
     *
     * @param velocidade
     * @return void
     */
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    /**
     * Metodo que modifica a resistencia do jogador.
     *
     * @param void
     * @return this.resistencia
     */
    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    /**
     * Metodo que modifica a destreza do jogador.
     *
     * @param destreza
     * @return void
     */
    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    /**
     * Metodo que modifica o impulso do jogador.
     *
     * @param impulso
     * @return void
     */
    public void setImpulsao(int impulso) {
        this.impulsao = impulso;
    }

    /**
     * Metodo que retorna o jogo de cabeca do jogador.
     *
     * @param jogoDeCabeca
     * @return void
     */
    public void setJogoDeCabeca(int jogoDeCabeca) {
        this.jogoDeCabeca = jogoDeCabeca;
    }

    /**
     * Metodo que modifica o remate do jogador.
     *
     * @param remate
     * @return void
     */
    public void setRemate(int remate) {
        this.remate = remate;
    }

    /**
     * Metodo que modifica a capacidade de passe do jogador
     *
     * @param capacidadeDePasse
     * @return void
     */
    public void setCapacidadeDePasse(int capacidadeDePasse) {
        this.capacidadeDePasse = capacidadeDePasse;
    }

    /**
     * Metodo que retorna a velocidade do jogador.
     *
     * @param void
     * @return velocidade
     */
    public int getVelocidade() {
        return this.velocidade;
    }

    /**
     * Metodo que retorna a resistencia do jogador.
     *
     * @param void
     * @return this.resistencia
     */
    public int getResistencia() {
        return this.resistencia;
    }

    /**
     * Metodo que retorna a destreza do jogador.
     *
     * @param void
     * @return destreza
     */
    public int getDestreza() {
        return this.destreza;
    }

    /**
     * Metodo que retorna o impulso do jogador.
     *
     * @param void
     * @return impulso
     */
    public int getImpulsao() {
        return this.impulsao;
    }

    /**
     * Metodo que retorna o jogo de cabeca do jogador.
     *
     * @param void
     * @return jogoDeCabeca
     */
    public int getJogoDeCabeca() {
        return this.jogoDeCabeca;
    }

    /**
     * Metodo que retorna o remate do jogador.
     *
     * @param void
     * @return remate
     */
    public int getRemate() {
        return this.remate;
    }

    /**
     * Metodo que retorna a capacidade de passe do jogador
     *
     * @param void
     * @return capacidadeDePasse
     */
    public int getCapacidadeDePasse() {
        return this.capacidadeDePasse;
    }

    public List<String> getHistEquipas() {
        if (this.histEquipas == null) return new ArrayList<>();
        else return new ArrayList<>(this.histEquipas);
    }

    public void setHistEquipas(List<String> h) {
        this.histEquipas = new ArrayList<>(h);
    }

    public void addEquipa(String nome) {
        this.histEquipas.add(nome);
    }

    /**
     * Metodo que retorna o overall do jogador.
     *
     * @param void
     * @return double
     */
    public abstract double overall();

    /**
     * Metodo que retorna a String com informação do jogador.
     *
     * @param void
     * @return String
     */
    public String toString() {
        return  this.numero + " -> " + this.nome + "; " + this.velocidade + "; " + this.resistencia + "; " + this.destreza
                + "; " + this.impulsao + "; " + this.jogoDeCabeca + "; " + this.remate + "; " + this.capacidadeDePasse
                + "; (Overall:" + String.format("%.2f", this.overall()) + ");  Antigos clubes:" + this.histEquipas + "\n";
    }

    /**
     * Metodo que retorna o clone.
     *
     * @param void
     * @return Jogador
     */
    public abstract Jogador clone();

    /**
     * Metodo equals.
     *
     * @param o
     * @return true se iguais, false se nao
     */
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Jogador j = (Jogador) o;
        return (this.velocidade == j.getVelocidade() && this.resistencia == j.getResistencia()
                && this.impulsao == j.getImpulsao() && this.jogoDeCabeca == j.getJogoDeCabeca()
                && this.remate == j.getRemate() && this.capacidadeDePasse == j.getCapacidadeDePasse());
    }
}
