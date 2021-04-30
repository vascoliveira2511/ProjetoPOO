public class Lateral extends Jogador {
    private int cruzamentos;

    /**
     * Constructor for objects of class Laterais
     */
    public Lateral() {
        super();
        this.cruzamentos = (int) Math.random() * 100;
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
     * @param cruzamentos
     */
    public Lateral(int velocidade, int resistencia, int destreza, int impulsao, int jogoDeCabeca, int remate,
            int capacidadeDePasse, int cruzamentos) {
        super(velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse);
        this.cruzamentos = cruzamentos;
    }

    /**
     * 
     * @param l
     */
    public Lateral(Lateral l) {
        super(l);
        this.cruzamentos = l.getCruzamentos();
    }

    /**
     * 
     * @return
     */
    public int getCruzamentos() {
        return this.cruzamentos;
    }

    /**
     * 
     * @param cruzamentos
     */
    public void setCruzamentos(int cruzamentos) {
        this.cruzamentos = cruzamentos;
    }

    /**
     * 
     */
    public double overall() {
        return (super.getVelocidade() * 0.20 + super.getResistencia() * 0.15 + super.getDestreza() * 0.1
                + super.getImpulsao() * 0.0025 + super.getJogoDeCabeca() * 0.025 + super.getRemate() * 0.1
                + super.getCapacidadeDePasse() * 0.20 + this.cruzamentos * 0.20);
    }

    /**
     * 
     */
    public Lateral clone() {
        return new Lateral(this);
    }

    /**
     * 
     */
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Lateral l = (Lateral) o;
        return super.equals(l) && this.cruzamentos == l.getCruzamentos();
    }

    /**
     * 
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Lateral: \n" + super.toString());
        return str.toString();
    }
}