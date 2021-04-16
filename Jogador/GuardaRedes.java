public class GuardaRedes extends Jogador {

    /**
     * Elasticidade de um jogador
     *
     * @apiNote Esta carectaristica e exculsiva ao guarda-redes.
     */
    private int elasticidade;

    public GuardaRedes() {
        super();
        this.elasticidade = (int) Math.random() * (100 - 1 + 1) + 1;
    }

    public GuardaRedes(int tipoJogador, int velocidade, int resistencia, int destreza, int impulsao, int jogoDeCabeca,
            int remate, int capacidadeDePasse, int equipa, int elasticidade) {
        super(tipoJogador, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse,
                equipa);
        this.elasticidade = elasticidade;
    }

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

}
