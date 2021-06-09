import java.io.IOException;

public class main {
    public static void main(String[] args) {
        try {
            Controller.run();
        } catch (LinhaIncorretaException | ClassNotFoundException | EquipaException | IOException | JogadorException e) {
            e.printStackTrace();
        }
    }
}
