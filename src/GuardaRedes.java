
public class GuardaRedes extends Jogador {

    /**
     * 
     */
    private int elastecidade;

    /**
     * 
     */
    public GuardaRedes() {
        super();
        this.elastecidade = (int) Math.random() * 100;
    }

    /**
     * 
     * @param velocidade
     * @param resistencia
     * @param destreza
     * @param impulsao
     * @param jogoDeCabeca
     * @param remate
     * @param capacidadeDePasse
     * @param elastecidade
     */
    public GuardaRedes(int velocidade, int resistencia, int destreza, int impulsao, int jogoDeCabeca, int remate,
            int capacidadeDePasse, int elastecidade) {
        super(velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse);
        this.elastecidade = elastecidade;
    }

    /**
     * 
     * @param gr
     */
    public GuardaRedes(GuardaRedes gr) {
        super(gr);
        this.elastecidade = gr.getElastecidade();
    }

    /**
     * 
     * @return
     */
    public int getElastecidade() {
        return this.elastecidade;
    }

    /**
     * 
     * @param elastecidade
     */
    public void setElastecidade(int elastecidade) {
        this.elastecidade = elastecidade;
    }

    /**
     * 
     */
    public double overall() {
        return (super.getVelocidade() * 0.02 + super.getResistencia() * 0.02 + super.getDestreza() * 0.02
                + super.getImpulsao() * 0.10 + super.getJogoDeCabeca() * 0.02 + super.getRemate() * 0.02
                + super.getCapacidadeDePasse() * 0.15 + this.elastecidade * 0.65);
    }

    /**
     * 
     */
    public GuardaRedes clone() {
        return new GuardaRedes(this);
    }

    /**
     * 
     */
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        GuardaRedes gr = (GuardaRedes) o;
        return super.equals(gr) && this.elastecidade == gr.getElastecidade();
    }

    /**
     * 
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Guada redes: \n" + super.toString());
        str.append("Elastecidade: " + this.elastecidade + "\n");
        return str.toString();
    }
}
