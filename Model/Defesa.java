import java.io.Serializable;

public class Defesa extends Jogador implements Serializable {

    /**
     * Método que cria uma instância de um defesa com os seguintes parâmetros:
     * 
     * @param velocidade
     * @param resistencia
     * @param destreza
     * @param impulsao
     * @param jogoDeCabeca
     * @param remate
     * @param capacidadeDePasse
     */

    public  Defesa(){
        super();
    }

    public Defesa(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao,
            int jogoDeCabeca, int remate, int capacidadeDePasse) {
        super(nome, numero, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse);
    }

    /**
     * Método que cri auma instância de um defesa através do método super.
     * 
     * @param d
     */
    public Defesa(Defesa d) {
        super(d);
    }

    /**
     * Método que efetua parse de um defesa.
     * 
     * @param input
     * @return
     */
    public static Defesa parse(String input) {
        String[] campos = input.split(",");
        return new Defesa(campos[0], Integer.parseInt(campos[1]), Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]), Integer.parseInt(campos[4]), Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]), Integer.parseInt(campos[7]), Integer.parseInt(campos[8]));
    }

    /**
     * Método que calcula o overall de um defesa.
     */
    public double overall() {
        return ((super.getVelocidade() * 0.1 + super.getResistencia() * 0.1 + super.getDestreza() * 0.30
                + super.getImpulsao() * 0.15 + super.getJogoDeCabeca() * 0.15 + super.getRemate() * 0.05
                + super.getCapacidadeDePasse() * 0.15));
    }

    /**
     * Método que clona um defesa.
     */
    public Defesa clone() {
        return new Defesa(this);
    }

    /**
     * Método equals de um defesa.
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
     * Método toString de um defesa.
     */
    public String toString() {
        return "Defesa: " + super.toString();
    }

    /**
     * Método que calcula o overall de um central.
     * 
     * @return
     */
    public double overallCentral() {
        return this.overall();
    }
}
