public class Avancados extends Jogador {

    /**
     * Método que cria uma instancia de um avançado através da função super().
     */
    public Avancados() {
        super();
    }

    /**
     * Método que cria uma instancia de um avançado através da função
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
    public Avancados(int tipoJogador, int velocidade, int resistencia, int destreza, int impulsao, int jogoDeCabeca,
            int remate, int capacidadeDePasse, int equipa) {
        super(tipoJogador, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse,
                equipa);
    }

    /**
     * Método que cria uma instancia de um avançado através da função super(Jogador
     * jogador).
     * 
     * @param avancados
     */
    public Avancados(Avancados avancados) {
        super(avancados);
    }
}
