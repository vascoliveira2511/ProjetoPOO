public class Defesas extends Jogador {

    /**
     * Método que cria uma instancia de um defesa através da função super().
     */
    public Defesas() {
        super();
    }

    /**
     * Método que cria uma instancia de um defesa através da função
     * super(tipoJogador, velocidade, resistencia, destreza, impulsao, jogoDeCabeca,
     * remate, capacidadeDePasse, equipa).
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
    public Defesas(int tipoJogador, int velocidade, int resistencia, int destreza, int impulsao, int jogoDeCabeca,
            int remate, int capacidadeDePasse, int equipa) {
        super(tipoJogador, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse,
                equipa);
    }

    /**
     * Método que cria uma instancia de um defesa através da função super(Jogador
     * jogador).
     * 
     * @param defesas
     */
    public Defesas(Defesas defesas) {
        super(defesas);
    }

    /**
     * Metodo que clona um defesa.
     */
    public Defesas clone() {
        return new Defesas(this);
    }
}
