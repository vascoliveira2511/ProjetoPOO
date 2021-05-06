public class Defesa extends Jogador implements Central {

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
    public Defesa(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoDeCabeca, int remate,
            int capacidadeDePasse) {
        super(nome, numero, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse);
    }

    /**
     * 
     * @param d
     */
    public Defesa(Defesa d) {
        super(d);
    }
    
    public static Defesa parse(String input){
        String[] campos = input.split(",");
        return new Defesa(campos[0], Integer.parseInt(campos[1]),
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

    public double overallCentral() {
        return this.overall();
    }
}
