
/**
 * Write a description of class Laterais here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lateral extends Jogador
{

    /**
     * Constructor for objects of class Laterais
     */
    public Lateral()
    {
        super();
    }

    public Lateral(Lateral l){
        super(l);
    }

    public double overall() {
        return ((super.getVelocidade() * 0.30  + 
                 super.getResistencia() * 0.15   + 
                 super.getDestreza() *0.1    + 
                 super.getImpulsao() * 0.0025    + 
                 super.getJogoDeCabeca() * 0.025 + 
                 super.getRemate() * 0.1      +
                 super.getCapacidadeDePasse() * 0.30));
    }
    
    public Lateral  clone(){
        return new Lateral(this);
    }
    
    public boolean equals(Object o){
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Lateral l = (Lateral) o;
        return super.equals(l);
    }
    
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Lateral: \n" + super.toString());
        return str.toString();
    }
}