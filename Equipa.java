package trabalho;
import java.util.ArrayList;

/**
 * Write a description of class Equipa here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Equipa{
    private int nTitulares;
    private int nSuplentes;
    private ArrayList<Jogador> titulares;
    private ArrayList<Jogador> suplentes;
    
    public Equipa(){
        this.nTitulares = 0;
        this.nSuplentes = 0;
        this.titulares = new ArrayList<Jogador>(0);
        this.suplentes = new ArrayList<Jogador>(0);
    }
    
    public Equipa(int nTitulares, int nSuplentes, ArrayList<Jogador> titulares, ArrayList<Jogador> suplentes){
        this.nTitulares = nTitulares;
        this.nSuplentes = nSuplentes;
        this.titulares = new ArrayList<Jogador>(nTitulares);
        for (Jogador t : titulares) this.titulares.add(t);
        this.suplentes = new ArrayList<Jogador>(nSuplentes);
        for (Jogador s : suplentes) this.suplentes.add(s);
    }
    
    public Equipa(Equipa e){
        this.nTitulares = e.getnTitulares();
        this.nSuplentes = e.getnSuplentes();
        this.titulares = new ArrayList<Jogador>(this.nTitulares);
        for (Jogador t : e.getTitulares()) this.titulares.add(t);
        this.suplentes = new ArrayList<Jogador>(this.nSuplentes);
        for (Jogador s : e.getSuplentes()) this.suplentes.add(s);
    }
    
    public int getnTitulares(){
        return this.nTitulares;
    }
    
    public void setnTitulares(int nTitulares){
        this.nTitulares = nTitulares;
    }
    
    public int getnSuplentes(){
        return this.nSuplentes;
    }
    
    public void setnSuplentes(int nSuplentes){
        this.nSuplentes = nSuplentes;
    }
    
    public ArrayList<Jogador> getTitulares(){
        return this.titulares;
    }
    
    public void setTitulares(ArrayList<Jogador> titulares, int nTitulares){
        this.nTitulares = nTitulares;
        this.titulares = new ArrayList<Jogador>(nTitulares);
        for (Jogador t : titulares) this.titulares.add(t);
    }
    
    public ArrayList<Jogador> getSuplentes(){
        return this.titulares;
    }
    
    public void setSuplentes(ArrayList<Jogador> suplentes, int nSuplentes){
        this.nSuplentes = nSuplentes;
        this.suplentes = new ArrayList<Jogador>(nSuplentes);
        for (Jogador s : suplentes) this.suplentes.add(s);
    }
    
    public double overallEquipa(){
        double overall = 0;
        for (Jogador t : this.titulares) overall += t.overall();
        for (Jogador s : this.suplentes) overall += s.overall();
        return (overall / (this.nTitulares + this.nSuplentes));
    }
    
}
