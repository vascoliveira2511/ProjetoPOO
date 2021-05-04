public class Avancado extends Jogador implements Central, Lateral {

    private int cruzamentos;
    private int finalizacao;

    /**
     * 
     */
    public Avancado() {
        super();
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
     */
    public Avancado(int velocidade, int resistencia, int destreza, int impulsao, int jogoDeCabeca, int remate,
            int capacidadeDePasse) {
        super(velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse);
    }

    /**
     * 
     * @param a
     */
    public Avancado(Avancado a) {
        super(a);
    }

    /**
     * 
     */
    public double overall() {
        return ((super.getVelocidade() * 0.15 + super.getResistencia() * 0.15 + super.getDestreza() * 0.1
                + super.getImpulsao() * 0.1 + super.getJogoDeCabeca() * 0.20 + super.getRemate() * 0.25
                + super.getCapacidadeDePasse() * 0.05));
    }

    /**
     * 
     */
    public Avancado clone() {
        return new Avancado(this);
    }

    /**
     * 
     */
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Avancado a = (Avancado) o;
        return super.equals(a);
    }

    /**
     * 
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Avancado: \n" + super.toString());
        return str.toString();
    }

    public double overallLateral() {
        return (this.overall() * 0.8 + this.cruzamentos * 0.2);
    }

    public double overallCentral() {
        return (this.overall() * 0.8 + this.finalizacao * 0.2);
    }
}
