import java.io.IOException;

public class Controller {
    public static void run()
            throws LinhaIncorretaException, IOException, ClassNotFoundException, EquipaException, JogadorException {
        String[] s = { "Carregar Jogo", "Iniciar novo Jogo" };
        Menu m = new Menu(s);
        LigaPOO l = null;
        boolean cont = true;
        while (cont) {
            m.executa();
            int op = m.getOpcao();
            switch (op) {
                case 1:
                    String r = m.menuLerFicheiro();
                    l = LigaPOO.readFromBinary(r);
                    ControllerFM.run(l);
                    break;
                case 2:
                    ControllerFM.run(l);
                    break;
                default:
                    cont = false;
                    break;

            }
        }

    }
}
