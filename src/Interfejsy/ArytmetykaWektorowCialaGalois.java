
package Interfejsy;

import KlasyElementarne.Wektor;

/**
 * Interfejs ArytmetykaWektorowCialaGalois opisuje podstawowe operacje
 pomiędzy wektorami z elementów w Ciale Galois.
 *
 * @author Grzegorz Dżaman
 */
public interface ArytmetykaWektorowCialaGalois {
    /**
     * Ta metoda implementuje dodawanie dwóch wektorów z elementów w  Ciele Galois.
     * Wektory są brane pod uwagę jako parametry i zwracana jest nowa wartość.
     *
     * @param wektor1 wektor do którego jest dodawany dodajnik
     * @param wektor2 dodajnik czyli składnik dodawania
     * @return suma wektorów vector1 and vector2
     */
    
    Wektor dodaj(Wektor wektor1, Wektor wektor2);
    
    /**
     * Ta metoda implementuje odejmowanie dwóch wektorów z elementów w Ciele Galois.
     * Wektory są brane pod uwagę jako parametry i zwracana jest wartość nowego wektora.
     *
     * @param wektor1 odjemna wektora
     * @param wektor2 odjemnik wektora
     * @return różnica dwóch wektorów wektor1 i wektor2.
     *
     */
    
    Wektor odejmij(Wektor wektor1, Wektor wektor2);
    
    /**
     * Ta metoda implementuje mnożenie wektora z elementów w Ciele Galois
     * przez skalar.
     *
     * @param wektor input vector
     * @param skalar scalar value
     * @return product of vector and scalarValue
     */
    
    Wektor pomnoz(Wektor wektor, long skalar);
}
