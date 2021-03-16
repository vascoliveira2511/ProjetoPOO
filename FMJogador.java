public class FMJogador {

    //Tipo de jogador
    private int tipoJogador; // 1 - guarda-redes , 2 - defesas, 3 - medios, 4 - avancados, 6 - laterais.

    //Caracteristicas base
    private int velocidade;
    private int resistencia;
    private int destreza;
    private int impulsao;
    private int jogoDeCabeca;
    private int remate;
    private int capacidadeDePasse;

    //Caracteristica especifica guarda-redes.
    private int elasticidade;

    //Equipas
    private int equipa; // 1 - visitantes, 2 - visitados.


    /**
     * Metodo que retorna o tipo de jogador .
     * @param void
     * @return this.tipoJogador
     */
    public int getTipoJogador() {
        return this.tipoJogador;
    }

    /**
    * Metodo que retorna a velocidade do jogador.
    * @param void
    * @return this.velocidade
    */
    public int getVelocidade() {
        return this.velocidade;
    }

    /**
     * Metodo que retorna a resistencia do jogador.
     * @param void
     * @return this.resistencia
     */
    public int getResistencia() {
        return this.resistencia;
    }

    /**
     * Metodo que retorna a destreza do jogador.
     * @param void
     * @return this.destreza
     */
    public int getDestreza() {
        return this.destreza;
    }

    /**
     * Metodo que retorna o impulso do jogador.
     * @param void
     * @return this.impulso
     */
    public int getImpulsao() {
        return this.impulsao;
    }

    /**
     * Metodo que retorna o jogo de cabeca do jogador.
     * @param void
     * @return this.jogoDeCabeca
     */
    public int getJogoDeCabeca() {
        return this.jogoDeCabeca;
    }

    /**
     * Metodo que retorna o remate do jogador.
     * @param void
     * @return this.remate
     */
    public int getRemate() {
        return this.remate;
    }

    /**
     * Metodo que retorna a capacidade de passe do jogador
     * @param void
     * @return this.capacidadeDePasse
     */
    public int getCapacidadeDePasse() {
        return this.capacidadeDePasse;
    }

    /**
     * Metodo que retorna a elasticidade do jogador, sse o jogador e um guarda-redes(tipoJogador == 1), senao retorna -1.
     * @param void
     * @return this.resistencia
     */
    public int getElasticidade() {
        if (getTipoJogador() == 1) return this.elasticidade;
        else return -1;
    }

    /**
     * Metodo que retorna a que equipa pertence o jogador.
     * @param void
     * @return this.equipa
     */
    public int getEquipa() {
        return this.equipa;
    }

    


}
