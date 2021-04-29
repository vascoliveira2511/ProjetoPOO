public class Medios extends Jogador {

    /**
     * Método que cria uma instancia de um médio através da função super().
     */
    public Medios() {
        super();
    }

    /**
     * * Método que cria uma instancia de um médio através da função super(int
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
    public Medios(int tipoJogador, int velocidade, int resistencia, int destreza, int impulsao, int jogoDeCabeca,
            int remate, int capacidadeDePasse, int equipa) {
        super(tipoJogador, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse,
                equipa);
    }

    /**
     * Método que cria uma instancia de um médio através da função super(Jogador
     * jogador).
     * 
     * @param medios
     */
    public Medios(Medios medios) {
        super(medios);
    }

    /**
     * Metodo que clona um medio.
     */
    public Medios clone() {
        return new Medios(this);
    }
}
