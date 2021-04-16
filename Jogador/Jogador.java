import java.lang.StringBuilder;

/**
 * Classe Jogador
 *
 * @author @Skynet-Model101
 * @author @DiogoPereiraMatos
 * @author @MiguelFernandes13
 */
public class Jogador {
    /**
     * Tipo de jogador
     *
     * @apiNote 1 - guarda-redes , 2 - defesas, 3 - medios, 4 - avancados, 5 -
     *          laterais.
     */
    private int tipoJogador;

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
     * Elasticidade de um jogador
     *
     * @apiNote Esta carectaristica e exculsiva ao guarda-redes e tera o valor de -1
     *          em qualquer outro jogador
     */
    private int elasticidade; // será -1 se não é um guarda-redes

    /**
     * Equipa de um jogador
     *
     * @apiNote 1 - visitantes, 2 - visitados.
     */
    private int equipa; // 1 - visitantes, 2 - visitados.

    /**
     * Metodo de classe que cria uma instancia de jogador com valores aleatorios.
     *
     * @param void
     * @return void
     */
    public Jogador() {
        this((int) Math.random() * (6 - 1 + 1) + 1, (int) Math.random() * (100 - 1 + 1) + 1,
                (int) Math.random() * (100 - 1 + 1) + 1, (int) Math.random() * (100 - 1 + 1) + 1,
                (int) Math.random() * (100 - 1 + 1) + 1, (int) Math.random() * (100 - 1 + 1) + 1,
                (int) Math.random() * (100 - 1 + 1) + 1, (int) Math.random() * (100 - 1 + 1) + 1,
                (int) Math.random() * (100 - 1 + 1) + 1, (int) Math.random() * (3 - 1 + 1) + 1);
    }

    /**
     * Metodo de classe que cria uma instancia de jogador com valores fornecidos.
     *
     * @param tipoJogador
     * @param velocidade
     * @param resistencia
     * @param destreza
     * @param impulsao
     * @param jogoDeCabeca
     * @param remate
     * @param capacidadeDePasse
     * @param elasticidade
     * @param equipa
     * @return void
     */
    public Jogador(int tipoJogador, int velocidade, int resistencia, int destreza, int impulsao, int jogoDeCabeca,
            int remate, int capacidadeDePasse, int elasticidade, int equipa) {
        this.tipoJogador = tipoJogador;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.jogoDeCabeca = jogoDeCabeca;
        this.remate = remate;
        this.capacidadeDePasse = capacidadeDePasse;
        if (tipoJogador == 1)
            this.elasticidade = elasticidade;
        else
            this.elasticidade = -1;
        this.equipa = equipa;
    }

    /**
     * Metodo de classe que cria uma instancia de jogador a partir de um jogador
     * recebido.
     *
     * @param jogador
     * @return void
     */
    public Jogador(Jogador jogador) {
        this.tipoJogador = jogador.getTipoJogador();
        this.velocidade = jogador.getVelocidade();
        this.resistencia = jogador.getResistencia();
        this.destreza = jogador.getDestreza();
        this.impulsao = jogador.getImpulsao();
        this.jogoDeCabeca = jogador.getJogoDeCabeca();
        this.remate = jogador.getRemate();
        this.capacidadeDePasse = jogador.getCapacidadeDePasse();
        this.elasticidade = jogador.getElasticidade();
        this.equipa = jogador.getEquipa();
    }

    /**
     * Metodo que modifica o tipo de jogador .
     *
     * @param tipoJogador
     * @return void
     */
    public void setTipoJogador(int tipoJogador) {
        this.tipoJogador = tipoJogador;
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
     * Metodo que modifica a elasticidade do jogador, sse o jogador e um
     * guarda-redes(tipoJogador == 1).
     *
     * @param elasticidade
     * @return void
     */
    public void setElasticidade(int elasticidade) {
        if (getTipoJogador() == 1)
            this.elasticidade = elasticidade;
        else
            this.elasticidade = -1;
    }

    /**
     * Metodo que modifica a que equipa pertence o jogador.
     *
     * @param equipa
     * @return void
     */
    public void setEquipa(int equipa) {
        this.equipa = equipa;
    }

    /**
     * Metodo que retorna o tipo de jogador .
     *
     * @param void
     * @return tipoJogador
     */
    public int getTipoJogador() {
        return this.tipoJogador;
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

    /**
     * Metodo que retorna a elasticidade do jogador.
     *
     * @param void
     * @return resistencia
     */
    public int getElasticidade() {
        return this.elasticidade;
    }

    /**
     * Metodo que retorna a que equipa pertence o jogador.
     *
     * @param void
     * @return equipa
     */
    public int getEquipa() {
        return this.equipa;
    }

    /**
     * Metodo que retorna o overall do jogador.
     *
     * @param void
     * @return double
     */
    public double overall() {
        double o = 0;
        if (this.tipoJogador == 1) {
            o = ((this.velocidade + this.resistencia + this.destreza + this.impulsao + this.jogoDeCabeca + this.remate
                    + this.capacidadeDePasse + this.elasticidade) / 8);
        } else {
            o = ((this.velocidade + this.resistencia + this.destreza + this.impulsao + this.jogoDeCabeca + this.remate
                    + this.capacidadeDePasse) / 7);
        }
        return o;

    }

    /**
     * Metodo que retorna a String com informação do jogador.
     *
     * @param void
     * @return String
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Posicao: " + this.tipoJogador + "\n");
        str.append("Velocidade: " + this.velocidade + "\n");
        str.append("Resistencia: " + this.resistencia + "\n");
        str.append("Destreza: " + this.destreza + "\n");
        str.append("Impulsao: " + this.impulsao + "\n");
        str.append("Jogo de Cabeça: " + this.jogoDeCabeca + "\n");
        str.append("Remate: " + this.remate + "\n");
        str.append("Capacidade de Passe: " + this.capacidadeDePasse + "\n");
        if (this.tipoJogador == 1)
            str.append("Elastecidade: " + this.elasticidade + "\n");
        return str.toString();
    }

    /**
     * Metodo que retorna o clone.
     *
     * @param void
     * @return Jogador
     */
    public Jogador clone() {
        return new Jogador(this);
    }

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
                && this.remate == j.getRemate() && this.capacidadeDePasse == j.getCapacidadeDePasse())
                && this.elasticidade == j.getElasticidade();
    }
}
