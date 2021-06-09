import java.io.Serializable;

/**
 * Classe de um médio.
 */
public class Medio extends Jogador implements Serializable {

    /**
     * Capacidade de recuperar bolas de um médio.
     */
    private int recuperarBolas;

    public Medio(){
        super();
        this.recuperarBolas=0;
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
    public Medio(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoDeCabeca,
            int remate, int capacidadeDePasse, int recuperarBolas) {
        super(nome, numero, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse);
        this.recuperarBolas = recuperarBolas;
    }

    public Medio(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogoDeCabeca,
            int remate, int capacidadeDePasse) {
        super(nome, numero, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse);
        this.recuperarBolas = (int) (Math.random() * 100);
    }

    public static Medio parse(String input) {
        String[] campos = input.split(",");
        return new Medio(campos[0], Integer.parseInt(campos[1]), Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]), Integer.parseInt(campos[4]), Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]), Integer.parseInt(campos[7]), Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]));
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
        return "Medio: " + super.toString();
    }

    public double overallCentral() {
        return this.overall();
    }
}