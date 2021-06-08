import java.io.IOException;

public class Controller {
    public static void run()
            throws LinhaIncorretaException, IOException, ClassNotFoundException, EquipaException, JogadorException {
        String[] s = { "Ler Jogo anterior", "Jogar FM-POO EDITION" };
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
                    System.out.println(l.getJogos());
                    ControllerFM.run(l);
                    break;
                case 2:
                    ControllerFM.run(l);
                    break;
                default:
                    cont = false;
                    m.closeScanner();
                    break;

            }
        }

    }
}
