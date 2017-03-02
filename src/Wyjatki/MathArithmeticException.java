
package Wyjatki;

/**
 * MathArithmeticException jest rzucany by wskazać, że operacje nie mają
 * rozwiązań dla argumentów, które były przyjmowane przez tę metodę.
 *
 * @author Grzegorz Dżaman
 */
public class MathArithmeticException extends MathIllegalArgumentException {

    public MathArithmeticException() {
    }

    public MathArithmeticException(String message) {
        super(message);
    }

    public MathArithmeticException(Throwable cause) {
        super(cause);
    }

    public MathArithmeticException(String message, Throwable cause) {
        super(message, cause);
    }
}
