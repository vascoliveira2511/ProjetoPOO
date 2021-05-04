import java.time.LocalDateTime;

public class Jogo {
    private LocalDateTime data;
    private Equipa visitados;
    private int golosVisitados;
    private Equipa visitantes;
    private int golosVisitantes;
    private int nSubstituicoes;

    public Jogo(Equipa visitados, Equipa visitantes) {
        this.visitados = visitados.clone();
        this.visitantes = visitantes.clone();
    }

    public Jogo(Jogo jogo) {
        setData(jogo.getData());
        setEquipaVisitados(jogo.getEquipaVisitados());
        setEquipaVisitantes(jogo.getEquipaVisitantes());
        setGolosVisitados(jogo.getGolosVisitados());
        setGolosVisitantes(jogo.getGolosVisitantes());
        setNSubstituicoes(jogo.getNSubstituicoes());
    }

    public LocalDateTime getData() {
        return this.data;
    }

    public Equipa getEquipaVisitados() {
        return this.visitados;
    }

    public Equipa getEquipaVisitantes() {
        return this.visitantes;
    }

    public int getGolosVisitados() {
        return this.golosVisitados;
    }

    public int getGolosVisitantes() {
        return this.golosVisitantes;
    }

    public int getNSubstituicoes() {
        return this.nSubstituicoes;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setEquipaVisitados(Equipa visitados) {
        this.visitados = visitados;
    }

    public void setEquipaVisitantes(Equipa visitantes) {
        this.visitantes = visitantes;
    }

    public void setGolosVisitados(int golosVisitados) {
        this.golosVisitados = golosVisitados;
    }

    public void setGolosVisitantes(int golosVisitantes) {
        this.golosVisitantes = golosVisitantes;
    }

    public void setNSubstituicoes(int nSubstituicoes) {
        this.nSubstituicoes = nSubstituicoes;
    }

    public Jogo clone() {
        return new Jogo(this);
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null || o.getClass() != this.getClass())
            return false;
        Jogo j = (Jogo) o;
        return this.data == j.getData() && this.visitados.equals(j.getEquipaVisitados())
                && this.visitantes.equals(j.getEquipaVisitantes()) && this.golosVisitados == j.getGolosVisitados()
                && this.golosVisitantes == j.getGolosVisitantes() && this.nSubstituicoes == j.getNSubstituicoes();
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Data: " + this.data.toString() + "\n");
        str.append("Equipa Visitados: " + this.visitados.toString() + "\n");
        str.append("Equipa Visitantes: " + this.visitantes.toString() + "\n");
        str.append("Golos Visitados: " + this.golosVisitados + "\n");
        str.append("Golos Visitantes: " + this.golosVisitantes + "\n");
        str.append("Numero de substituições" + this.nSubstituicoes);
        return str.toString();
    }

}
