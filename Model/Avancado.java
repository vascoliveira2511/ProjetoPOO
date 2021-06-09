import java.io.Serializable;

public class Avancado extends Jogador implements Serializable {

    /**
     * Método que cria um avançado recebvendo os seguintes parâmetros:
     * 
     * @param velocidade
     * @param resistencia
     * @param destreza
     * @param impulsao
     * @param jogoDeCabeca
     * @param remate
     * @param capacidadeDePasse
     */

    public Avancado() {
        super();
    }

    /**
     * 
     * @param nome
     * @param numero
     * @param velocidade
     * @param resistencia
     * @param destreza
     * @param impulsao
     * @param jogoDeCabeca
     * @param remate
     * @param capacidadeDePasse
     */
    public Avancado(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao,
            int jogoDeCabeca, int remate, int capacidadeDePasse) {
        super(nome, numero, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse);
    }

    /**
     * Método que cria um avançado chamando o método super.
     * 
     * @param a
     */
    public Avancado(Avancado a) {
        super(a);
    }

    /**
     * Método que efetua parse de um avançado.
     * 
     * @param input
     * @return
     */
    public static Avancado parse(String input) {
        String[] campos = input.split(",");
        return new Avancado(campos[0], Integer.parseInt(campos[1]), Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]), Integer.parseInt(campos[4]), Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]), Integer.parseInt(campos[7]), Integer.parseInt(campos[8]));
    }

    /**
     * Método que efetua o cálculo do overall de um avançado.
     */
    public double overall() {
        return ((super.getVelocidade() * 0.15 + super.getResistencia() * 0.15 + super.getDestreza() * 0.1
                + super.getImpulsao() * 0.1 + super.getJogoDeCabeca() * 0.20 + super.getRemate() * 0.25
                + super.getCapacidadeDePasse() * 0.05));
    }

    /**
     * Método que efetua clone de um avançado.
     */
    public Avancado clone() {
        return new Avancado(this);
    }

    /**
     * Método equals de um avançado.
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
     * Método toString de um avançado.
     */
    public String toString() {
        return "Avancado: " + super.toString();
    }

    /**
     * Método que calcula o verall de um central.
     * 
     * @return
     */
    public double overallCentral() {
        return this.overall();
    }
}
