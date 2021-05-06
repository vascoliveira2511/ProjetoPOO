
public class Lateral extends Jogador{

    private int cruzamento;

    public Lateral(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, int cruz) {
        super(nomeJ, numeroJ, vel, res, des, imp, cab, rem, p);
        cruzamento = cruz;
    }
    
    public Lateral(Lateral l) {
        super(l);
        this.cruzamento = l.getCruzamento();
    }
    

    public static Lateral parse(String input){
        String[] campos = input.split(",");
        return new Lateral(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]));
    }
    
    public int getCruzamento(){
        return this.cruzamento;
    }
    
    public void setCruzamento(int cruzamento){
        this.cruzamento = cruzamento;
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
}