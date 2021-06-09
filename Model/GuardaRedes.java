import java.io.Serializable;

public class GuardaRedes extends Jogador implements Serializable {

    /**
     * 
     */
    private int elastecidade;

    public GuardaRedes(){
        super();
        this.elastecidade = 0;
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
     * @param elastecidade
     */

    public GuardaRedes(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao,
            int jogoDeCabeca, int remate, int capacidadeDePasse, int elastecidade) {
        super(nome, numero, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse);
        this.elastecidade = elastecidade;
    }

    public GuardaRedes(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao,
            int jogoDeCabeca, int remate, int capacidadeDePasse) {
        super(nome, numero, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse);
        this.elastecidade = (int) Math.random() * 100;
    }

    /**
     * 
     * @param gr
     */
    public GuardaRedes(GuardaRedes gr) {
        super(gr);
        this.elastecidade = gr.getElastecidade();
    }

    public static GuardaRedes parse(String input) {
        String[] campos = input.split(",");
        return new GuardaRedes(campos[0], Integer.parseInt(campos[1]), Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]), Integer.parseInt(campos[4]), Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]), Integer.parseInt(campos[7]), Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]));
    }

    /**
     * 
     * @return
     */
    public int getElastecidade() {
        return this.elastecidade;
    }

    /**
     * 
     * @param elastecidade
     */
    public void setElastecidade(int elastecidade) {
        this.elastecidade = elastecidade;
    }

    /**
     * 
     */
    public double overall() {
        return (super.getVelocidade() * 0.02 + super.getResistencia() * 0.02 + super.getDestreza() * 0.02
                + super.getImpulsao() * 0.10 + super.getJogoDeCabeca() * 0.02 + super.getRemate() * 0.02
                + super.getCapacidadeDePasse() * 0.15 + this.elastecidade * 0.65);
    }

    /**
     * 
     */
    public GuardaRedes clone() {
        return new GuardaRedes(this);
    }

    /**
     * 
     */
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        GuardaRedes gr = (GuardaRedes) o;
        return super.equals(gr) && this.elastecidade == gr.getElastecidade();
    }

    /**
     * 
     */
    public String toString() {
        return "Guarda redes: " + super.toString();
    }
}
