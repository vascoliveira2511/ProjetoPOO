public class GuardaRedes extends Jogador {

    /**
     * Elasticidade de um jogador
     *
     * @apiNote Esta carectaristica e exculsiva ao guarda-redes.
     */
    private int elasticidade;

    /**
     * Método que cria uma instancia de um médio através da função super() e um
     * numero random entre 0 e 1 e 100 para a elasticidade.
     */
    public GuardaRedes() {
        super();
        this.elasticidade = (int) Math.random() * (100 - 1 + 1) + 1;
    }

    /**
     * Método que cria uma instancia de um médio através da função
     * super(tipoJogador, velocidade, resistencia, destreza, impulsao, jogoDeCabeca,
     * remate, capacidadeDePasse, equipa) e um numero dado para a elasticidade.
     * 
     * @param tipoJogador
     * @param velocidade
     * @param resistencia
     * @param destreza
     * @param impulsao
     * @param jogoDeCabeca
     * @param remate
     * @param capacidadeDePasse
     * @param equipa
     * @param elasticidade
     */
    public GuardaRedes(int tipoJogador, int velocidade, int resistencia, int destreza, int impulsao, int jogoDeCabeca,
            int remate, int capacidadeDePasse, int equipa, int elasticidade) {
        super(tipoJogador, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse,
                equipa);
        this.elasticidade = elasticidade;
    }

    /**
     * Método que cria uma instancia de um médio através da função super(Jogador
     * jogador) e um numero obtido pela funcao getElasticidade para a elasticidade.
     * 
     * @param g
     */
    public GuardaRedes(GuardaRedes g) {
        super(g);
        this.elasticidade = g.getElasticidade();
    }

    /**
     * Metodo que modifica a elasticidade do jogador
     *
     * @param elasticidade
     * @return void
     */
    public void setElasticidade(int elasticidade) {
        this.elasticidade = elasticidade;
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
     * Metodo que clona um guarda-redes.
     */
    public GuardaRedes clone() {
        return new GuardaRedes(this);
    }

}
