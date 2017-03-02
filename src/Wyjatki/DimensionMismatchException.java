
package Wyjatki;

/**
 * DimensionMismatchException jest rzucany aby wskazać, że metoda 
 * jest wykonywana dla obiektów o złych wymiarach i operacje na tych obiektach
 * nie mogą być wykonywane.
 *
 * @author Grzegorz Dżaman
 */
public class DimensionMismatchException extends MathIllegalArgumentException {

    public DimensionMismatchException() {
    }

    public DimensionMismatchException(String message) {
        super(message);
    }

    public DimensionMismatchException(Throwable cause) {
        super(cause);
    }

    public DimensionMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}