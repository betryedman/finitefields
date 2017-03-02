
package Wyjatki;

/**
 * ElementNotInFieldException jest rzucany aby wskazać, że metoda przyjmuje 
 * elementy spoza ciała.
 *
 * @author Grzegorz Dżaman
 */
public class ElementNotInFieldException extends MathIllegalArgumentException {

    public ElementNotInFieldException() {
    }

    public ElementNotInFieldException(String message) {
        super(message);
    }

    public ElementNotInFieldException(Throwable cause) {
        super(cause);
    }

    public ElementNotInFieldException(String message, Throwable cause) {
        super(message, cause);
    }
}