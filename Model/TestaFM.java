import java.util.ArrayList;

public class TestaFM {
    public static void main(String args[]) {
        ArrayList<Jogador> jogadores1 = new ArrayList<>();
        Parser.lerFicheiro("logs.txt");
        Equipa e1 = new Equipa("Visitados", jogadores1);
    }
}