
/**
 * Write a description of class Defesas here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Defesa extends Jogador
{
    /**
     * Constructor for objects of class Defesas
     */
    public Defesa()
    {
        super();
    }
    
    public Defesa(Defesa d){
        super(d);
    }

    public double overall() {
        return ((super.getVelocidade() * 0.1  + 
                 super.getResistencia() * 0.1   + 
                 super.getDestreza() *0.30    + 
                 super.getImpulsao() * 0.15    + 
                 super.getJogoDeCabeca() * 0.15 + 
                 super.getRemate() * 0.05     +
                 super.getCapacidadeDePasse() * 0.15));
    }
    
    public Defesa  clone(){
        return new Defesa(this);
    }
    
    public boolean equals(Object o){
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Defesa d = (Defesa) o;
        return super.equals(d);
    }
    
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Defesa: \n" + super.toString());
        return str.toString();
    }
}
