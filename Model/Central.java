public class Central extends Jogador {

    public Central(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p) {
        super(nomeJ, numeroJ, vel, res, des, imp, cab, rem, p);
    }

    public Central(Central c) {
        super(c);
    }

    public static Central parse(String input) {
        String[] campos = input.split(",");
        return new Central(campos[0], Integer.parseInt(campos[1]), Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]), Integer.parseInt(campos[4]), Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]), Integer.parseInt(campos[7]), Integer.parseInt(campos[8]));
    }

    public double overall() {
        return ((super.getVelocidade() * 0.30 + super.getResistencia() * 0.15 + super.getDestreza() * 0.1
                + super.getImpulsao() * 0.0025 + super.getJogoDeCabeca() * 0.025 + super.getRemate() * 0.1
                + super.getCapacidadeDePasse() * 0.30));
    }

    public Central clone() {
        return new Central(this);
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Lateral l = (Lateral) o;
        return super.equals(l);
    }
}
