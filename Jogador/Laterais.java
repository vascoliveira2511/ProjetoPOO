public class Laterais extends Jogador {

    /**
     * Método que cria uma instancia de um lateral através da função super().
     * 
     * @param laterais
     */
    public Laterais() {
        super();
    }

    /**
     * Método que cria uma instancia de um lateral através da função super(int
     * tipoJogador, int velocidade, int resistencia, int destreza, int impulsao, int
     * jogoDeCabeca, int remate, int capacidadeDePasse, int equipa).
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
     */
    public Laterais(int tipoJogador, int velocidade, int resistencia, int destreza, int impulsao, int jogoDeCabeca,
            int remate, int capacidadeDePasse, int equipa) {
        super(tipoJogador, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse,
                equipa);
    }

    /**
     * Método que cria uma instancia de um lateral através da função super(Jogador
     * jogador).
     * 
     * @param laterais
     */
    public Laterais(Laterais laterais) {
        super(laterais);
    }

    /**
     * Metodo que clona um lateral.
     */
    public Laterais clone() {
        return new Laterais(this);
    }
}
