
/**
 * Write a description of class GuardaRedes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GuardaRedes extends Jogador {
    private int elastecidade;

    /**
     * Constructor for objects of class GuardaRedes
     */
    public GuardaRedes() {
        super();
        this.elastecidade = (int) Math.random() * 100;
    }

    public GuardaRedes(GuardaRedes gr) {
        super(gr);
        this.elastecidade = gr.getElastecidade();
    }

    public int getElastecidade() {
        return this.elastecidade;
    }

    public void setElastecidade(int elastecidade) {
        this.elastecidade = elastecidade;
    }

    public double overall() {
        return (super.getVelocidade() * 0.02 + super.getResistencia() * 0.02 + super.getDestreza() * 0.02
                + super.getImpulsao() * 0.10 + super.getJogoDeCabeca() * 0.02 + super.getRemate() * 0.02
                + super.getCapacidadeDePasse() * 0.15 + this.elastecidade * 0.65);
    }

    public GuardaRedes clone() {
        return new GuardaRedes(this);
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        GuardaRedes gr = (GuardaRedes) o;
        return super.equals(gr) && this.elastecidade == gr.getElastecidade();
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Guada redes: \n" + super.toString());
        str.append("Elastecidade: " + this.elastecidade + "\n");
        return str.toString();
    }
}
