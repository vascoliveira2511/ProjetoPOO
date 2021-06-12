import java.io.IOException;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class ControllerFM {
    public static void run(LigaPOO l) throws LinhaIncorretaException, EquipaException, JogadorException, IOException {
        if (l == null) {
            l = new LigaPOO();
        }
        String[] s = { "Simular Jogo", "Simular reecontro", "Consultar Jogador", "Consultar Equipa", "Consultar Jogadores sem Clube",
                "Criar Jogador", "Criar Equipa", "Adicionar jogador a Equipa", "Transferir Jogador", "Guardar Jogo" };
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
                    AbstractMap.SimpleEntry<Map<Integer, Integer>, Map<Integer, Integer>> subs = m2
                            .menuEscolheSubstituicoes(e1, eqT.getKey(), e2, eqT.getValue());
                    Jogo jogo1 = l.simulaJogo(eqps.getKey(), eqps.getValue(), eqT.getKey(), eqT.getValue(),
                            subs.getKey(), subs.getValue());
                    m2.imprimeObj(jogo1);
                    m2.continuar();
                    break;
                case 2:
                    Jogo reencontro = l.simulaJogo(l.getJogos().get(m2.escolheJogo(l.getJogos())));
                    m2.imprimeObj(reencontro);
                    m2.continuar();
                    break;
                case 3:
                    AbstractMap.SimpleEntry<Integer, String> jog1 = m2.menuEscolherJogador();
                    Jogador j1 = l.procuraJogador(jog1.getValue(), jog1.getKey());
                    m2.imprimeObj(j1);
                    m2.continuar();
                    break;
                case 4:
                    Equipa e3 = l.existeEquipa(m2.menuEscolherEquipa());
                    m2.imprimeObj(e3);
                    m2.continuar();
                    break;
                case 5:
                    m2.imprimeObj(l.getJogSemEquipa().values());
                    m2.continuar();
                    break;
                case 6:
                    Jogador jc = m2.menuCriarJogador();
                    l.adicionaJogSemEquipa(jc);
                    m2.imprimeObj(jc);
                    m2.continuar();
                    break;
                case 7:
                    String nEquipa = m2.menuEscolherEquipa();
                    Equipa eNova = new Equipa(nEquipa);
                    m2.imprimeObj(eNova);
                    l.adicionaEquipa(eNova);
                    m2.continuar();
                    break;
                case 8:
                    AbstractMap.SimpleEntry<Integer, String> ns = m2.menuAdiconaJogador();
                    l.transferencia(ns.getValue(), ns.getKey());
                    m2.imprimeMsg("Jogador com numero " + ns.getKey() + " adicionado à equipa " +
                            ns.getValue() + " com sucesso!");
                    break;
                case 9:
                    AbstractMap.SimpleEntry<Integer, AbstractMap.SimpleEntry<String, String>> eqps2 = m2
                            .menuTransferencia();
                    l.transferencia(eqps2.getValue().getKey(), eqps2.getValue().getValue(), eqps2.getKey());
                    m2.imprimeMsg("Transferência do jogador num " + eqps2.getKey() +
                                    " do "+ eqps2.getValue().getKey() +
                                    " para o " + eqps2.getValue().getValue() + " concluida com sucesso!");
                    m2.continuar();
                    break;
                case 10:
                    String g = m2.menuGuardarFicheiro();
                    l.saveToBinary(g);
                    m2.continuar();
                    break;
                default:
                    m2.clearScreen();
                    l = null;
                    cont = false;
                    break;
            }
        }
    }
}
