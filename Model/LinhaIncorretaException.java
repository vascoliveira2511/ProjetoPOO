/**
 * Classe de excessão no caso de uma linha não existir.
 */
public class LinhaIncorretaException extends Exception {

    public LinhaIncorretaException() {
        super();
    }

    public LinhaIncorretaException(String s) {
        super(s);
    }
}