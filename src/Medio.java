
public class Medio extends Jogador implements Central {

    private int recuperarBolas;

    /**
     * 
     */
    public Medio() {
        super();
        this.recuperarBolas = (int) Math.random() * 100;
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
     * @param recuperarBolas
     */
    public Medio(int velocidade, int resistencia, int destreza, int impulsao, int jogoDeCabeca, int remate,
            int capacidadeDePasse, int recuperarBolas) {
        super(velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse);
        this.recuperarBolas = recuperarBolas;
    }

    /**
     * 
     * @param m
     */
    public Medio(Medio m) {
        super(m);
        this.recuperarBolas = m.getRecuperarBolas();
    }

    /**
     * 
     * @return
     */
    public int getRecuperarBolas() {
        return this.recuperarBolas;
    }

    /**
     * 
     * @param recuperarBolas
     */
    public void setRecuperarBolas(int recuperarBolas) {
        this.recuperarBolas = recuperarBolas;
    }

    /**
     * 
     */
    public double overall() {
        return (super.getVelocidade() * 0.15 + super.getResistencia() * 0.1 + super.getDestreza() * 0.15
                + super.getImpulsao() * 0.05 + super.getJogoDeCabeca() * 0.05 + super.getRemate() * 0.15
                + super.getCapacidadeDePasse() * 0.20 + this.recuperarBolas * 0.15);
    }

    /**
     * 
     */
    public Medio clone() {
        return new Medio(this);
    }

    /**
     * 
     */
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Medio a = (Medio) o;
        return super.equals(a) && this.recuperarBolas == a.getRecuperarBolas();
    }

    /**
     * 
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Medio: \n" + super.toString());
        return str.toString();
    }
}