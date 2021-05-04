public class Defesa extends Jogador implements Central, Lateral {

    public Defesa() {
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
    public Defesa(int velocidade, int resistencia, int destreza, int impulsao, int jogoDeCabeca, int remate,
            int capacidadeDePasse) {
        super(velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse);
    }

    /**
     * 
     * @param d
     */
    public Defesa(Defesa d) {
        super(d);
    }

    /**
     * 
     */
    public double overall() {
        return ((super.getVelocidade() * 0.1 + super.getResistencia() * 0.1 + super.getDestreza() * 0.30
                + super.getImpulsao() * 0.15 + super.getJogoDeCabeca() * 0.15 + super.getRemate() * 0.05
                + super.getCapacidadeDePasse() * 0.15));
    }

    /**
     * 
     */
    public Defesa clone() {
        return new Defesa(this);
    }

    /**
     * 
     */
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Defesa d = (Defesa) o;
        return super.equals(d);
    }

    /**
     * 
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Defesa: \n" + super.toString());
        return str.toString();
    }

    @Override
    public double overallLateral() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double overallCentral() {
        // TODO Auto-generated method stub
        return 0;
    }
}
