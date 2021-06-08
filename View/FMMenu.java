import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FMMenu {
    public static void main(String[] args) throws IOException, InterruptedException, JogadorException {
        try {
            Controller.run();
        } catch (LinhaIncorretaException | ClassNotFoundException | EquipaException e) {
            e.printStackTrace();
        }/*
        LigaPOO l = null;
        try {
            ControllerFM.run(l);
        } catch (LinhaIncorretaException | EquipaException e) {
            e.printStackTrace();
        }*/
    }
}
