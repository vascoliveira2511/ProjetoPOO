
/**
 * Write a description of class Medios here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Medio extends Jogador {
    // instance variables - replace the example below with your own
    private int recuperarBolas;

    /**
     * Constructor for objects of class Medios
     */
    public Medio() {
        super();
        this.recuperarBolas = this.recuperarBolas = (int) Math.random() * 100;
    }

    public Medio(Medio m) {
        super(m);
        this.recuperarBolas = this.recuperarBolas = (int) Math.random() * 100;
    }

    public int getRecuperarBolas() {
        return this.recuperarBolas;
    }

    public void setRecuperarBolas(int recuperarBola) {
        this.recuperarBolas = recuperarBolas;
    }

    public double overall() {
        return (super.getVelocidade() * 0.15 + super.getResistencia() * 0.1 + super.getDestreza() * 0.15
                + super.getImpulsao() * 0.05 + super.getJogoDeCabeca() * 0.05 + super.getRemate() * 0.15
                + super.getCapacidadeDePasse() * 0.20 + this.recuperarBolas * 0.15);
    }

    public Medio clone() {
        return new Medio(this);
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Medio a = (Medio) o;
        return super.equals(a) && this.recuperarBolas == a.getRecuperarBolas();
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Medio: \n" + super.toString());
        return str.toString();
    }
}