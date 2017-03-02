
package Wyjatki;

/**
 * MathIllegalArgumentException jest klasą bazową wszystkich klas
 * wyjątków rzucanych w tym projekcie. 
 *
 * @author Grzegorz Dżaman
 */
public class MathIllegalArgumentException extends IllegalArgumentException {

    public MathIllegalArgumentException() {
    }

    public MathIllegalArgumentException(String message) {
        super(message);
    }

    public MathIllegalArgumentException(Throwable cause) {
        super(cause);
    }

    public MathIllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
}
