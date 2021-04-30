
/**
 * Write a description of class Avancados here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Avancado extends Jogador {

    /**
     * Constructor for objects of class Avancados
     */
    public Avancado() {
        super();
    }

    public Avancado(Avancado a) {
        super(a);
    }

    public double overall() {
        return ((super.getVelocidade() * 0.15 + super.getResistencia() * 0.15 + super.getDestreza() * 0.1
                + super.getImpulsao() * 0.1 + super.getJogoDeCabeca() * 0.20 + super.getRemate() * 0.25
                + super.getCapacidadeDePasse() * 0.05));
    }

    public Avancado clone() {
        return new Avancado(this);
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Avancado a = (Avancado) o;
        return super.equals(a);
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Avancado: \n" + super.toString());
        return str.toString();
    }
}
