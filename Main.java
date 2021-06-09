import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Controller.run();
        } catch (LinhaIncorretaException | ClassNotFoundException | EquipaException | IOException | JogadorException e) {
            e.printStackTrace();
        }
    }
}