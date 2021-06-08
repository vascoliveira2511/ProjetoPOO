import java.io.IOException;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class ControllerFM {
    public static void run(LigaPOO l) throws LinhaIncorretaException, EquipaException, JogadorException, IOException {
        if (l == null){
            l = new LigaPOO();
        }
        String[] s = {"Simular Jogo", "Consultar Jogador", "Consultar Equipa","Transferir Jogador", "Guardar Jogo"};
        Menu m2 = new Menu(s);
        boolean cont = true;
        while (cont) {
            m2.executa();
            int op = m2.getOpcao();
            switch (op) {
                case 1:
                    AbstractMap.SimpleEntry<String, String> eqps = m2.menuEscolherEquipas();
                    Equipa e1 = l.existeEquipa(eqps.getKey());
                    Equipa e2 = l.existeEquipa(eqps.getValue());
                    AbstractMap.SimpleEntry<List<Integer>, List<Integer>> eqT = m2.menuEscolheTitulares(e1, e2);
                    AbstractMap.SimpleEntry<Map<Integer, Integer>, Map<Integer, Integer>> subs = m2.menuEscolheSubstituicoes(e1, eqT.getKey(), e2, eqT.getValue());
                    Jogo jogo1 = l.simulaJogo(eqps.getKey(), eqps.getValue(), eqT.getKey(), eqT.getValue(), subs.getKey(), subs.getValue());
                    m2.imprimeJogo(jogo1);
                case 2:
                    AbstractMap.SimpleEntry<Integer, String> jog1 = m2.menuEscolherJogador();
                    Jogador j1 = l.procuraJogador(jog1.getValue(), jog1.getKey());
                    m2.imprimeJogador(j1);
                case 3:
                    Equipa e3 = l.existeEquipa(m2.menuEscolherEquipa());
                    m2.imprimeEquipa(e3);
                case 4:
                    AbstractMap.SimpleEntry<Integer, AbstractMap.SimpleEntry<String, String>> eqps2 = m2.menuTransferencia();
                    l.transferencia(eqps2.getValue().getKey(), eqps2.getValue().getValue(), eqps2.getKey());
                case 5:
                    String g = m2.menuGuardarFicheiro();
                    l.saveToBinary(g);
                default:
                    cont = false;


            }
        }
    }
}
