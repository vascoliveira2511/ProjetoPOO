import java.lang.StringBuilder;

public class FMJogador {

    //Tipo de jogador
    private int tipoJogador; // 1 - guarda-redes , 2 - defesas, 3 - medios, 4 - avancados, 5 - laterais.

    //Caracteristicas base
    private int velocidade;
    private int resistencia;
    private int destreza;
    private int impulsao;
    private int jogoDeCabeca;
    private int remate;
    private int capacidadeDePasse;

    //Caracteristica especifica guarda-redes.
    private int elasticidade; // será -1 se não é um guarda-redes

    //Equipas
    private int equipa; // 1 - visitantes, 2 - visitados.

    public FMJogador() {
        this((int) Math.random() * (6 - 1 + 1) + 1, (int) Math.random() * (100 - 1 + 1) + 1, (int) Math.random() * (100 - 1 + 1) + 1, (int) Math.random() * (100 - 1 + 1) + 1, (int) Math.random() * (100 - 1 + 1) + 1, (int) Math.random() * (100 - 1 + 1) + 1, (int) Math.random() * (100 - 1 + 1) + 1, (int) Math.random() * (100 - 1 + 1) + 1, (int) Math.random() * (100 - 1 + 1) + 1, (int) Math.random() * (3 - 1 + 1) + 1);
    }

    public FMJogador (int tipoJogador, int velocidade, int resistencia, int destreza, int impulsao, int jogoDeCabeca, int remate, int capacidadeDePasse, int elasticidade, int equipa) {
        this.tipoJogador = tipoJogador;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.jogoDeCabeca = jogoDeCabeca;
        this.remate = remate;
        this.capacidadeDePasse = capacidadeDePasse;
        if (tipoJogador == 1) this.elasticidade = elasticidade;
        else this.elasticidade = -1;
        this.equipa = equipa;
    }

    public FMJogador (FMJogador jogador) {
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
     * @param int tipoJogador
     * @return void
     */
    public void setTipoJogador(int tipoJogador) {
        this.tipoJogador = tipoJogador;
    }

    /**
    * Metodo que modifica a velocidade do jogador.
    * @param int velocidade
    * @return void
    */
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    /**
     * Metodo que modifica a resistencia do jogador.
     * @param void
     * @return this.resistencia
     */
    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    /**
     * Metodo que modifica a destreza do jogador.
     * @param int destreza
     * @return void
     */
    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    /**
     * Metodo que modifica o impulso do jogador.
     * @param int impulso
     * @return void
     */
    public void setImpulsao(int impulso) {
        this.impulsao = impulso;
    }

    /**
     * Metodo que retorna o jogo de cabeca do jogador.
     * @param int jogoDeCabeca
     * @return void
     */
    public void setJogoDeCabeca(int jogoDeCabeca) {
        this.jogoDeCabeca = jogoDeCabeca;
    }

    /**
     * Metodo que modifica o remate do jogador.
     * @param int remate
     * @return void
     */
    public void setRemate(int remate) {
        this.remate = remate;
    }

    /**
     * Metodo que modifica a capacidade de passe do jogador
     * @param int capacidadeDePasse
     * @return void
     */
    public void setCapacidadeDePasse(int capacidadeDePasse) {
        this.capacidadeDePasse = capacidadeDePasse;
    }

    /**
     * Metodo que modifica a elasticidade do jogador, sse o jogador e um guarda-redes(tipoJogador == 1).
     * @param int this.elasticidade
     * @return void
     */
    public void setElasticidade(int elasticidade) {
        if (getTipoJogador() == 1) this.elasticidade = elasticidade;
        else this.elasticidade = -1;
    }

    /**
     * Metodo que modifica a que equipa pertence o jogador.
     * @param int equipa
     * @return void
     */
    public void setEquipa(int equipa) {
        this.equipa = equipa;
    }
    

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
     * Metodo que retorna a elasticidade do jogador.
     * @param void
     * @return this.resistencia
     */
    public int getElasticidade() {
        return this.elasticidade;
    }

    /**
     * Metodo que retorna a que equipa pertence o jogador.
     * @param void
     * @return this.equipa
     */
    public int getEquipa() {
        return this.equipa;
    }
    
    /**
     * Metodo que retorna o overall do jogador.
     * @param double
     * @return o
     */
    public double overall(){
        double o = 0;
        if (this.posicao == 1){
            o = ((this.velocidade + this.resistencia+ this.destreza + this.impulsao+ this.jogoCabeca+ this.remate + this.capacidadePasse + this.elastecidade) / 8);
        }
        else {
            o = ((this.velocidade + this.resistencia+ this.destreza + this.impulsao+ this.jogoCabeca+ this.remate + this.capacidadePasse) / 7);
        }
        return o;

    }
    
    /**
     * Metodo que retorna a String com informação do jogador
     * @param String
     * @return str.toString()
     */
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append ("Posicao: " + this.posicao + "\n");
        str.append ("Velocidade: " + this.velocidade + "\n");
        str.append ("Resistencia: " + this.resistencia + "\n");
        str.append ("Destreza: " + this.destreza + "\n");
        str.append ("Impulsao: " + this.impulsao + "\n");
        str.append ("Jogo de Cabeça: " + this.jogoCabeca + "\n");
        str.append ("Remate: " + this.remate + "\n");
        str.append ("Capacidade de Passe: " + this.capacidadePasse + "\n");
        if (this.posicao == 1) str.append ("Elastecidade: " + this.elastecidade + "\n");
        return str.toString();
    }
    
    /**
     * Metodo que retorna o clone
     * @param Jogador
     * @return new Jogador(this);
     */
    public Jogador clone(){
        return new Jogador(this);
    }
    
    /**
     * Metodo equals
     * @param boolean
     * @return 
     */
    public boolean equals(Object o) {
        if (this == o) 
            return true;
        if ((o == null) || (this.getClass() != o.getClass() )) 
            return false;
        Jogador j = (Jogador) o;
        return (this.velocidade == j.getVelocidade() && this.resistencia == j.getResistencia() && 
                this.impulsao == j.getImpulsao() && this.jogoCabeca == j.getJogoCabeca() &&
                this.remate == j.getRemate() && this.capacidadePasse == j.getCapacidadePasse());
    }


}
