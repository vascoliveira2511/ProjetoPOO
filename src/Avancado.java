public class Avancado extends Jogador implements Central {

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
    public Avancado(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoDeCabeca, int remate,
            int capacidadeDePasse) {
        super(nome, numero, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse);
    }

    /**
     * 
     * @param a
     */
    public Avancado(Avancado a) {
        super(a);
    }
    
    public static Avancado parse(String input){
        String[] campos = input.split(",");
        return new Avancado(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]));
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

    public double overallCentral() {
        return this.overall();
    }
}
