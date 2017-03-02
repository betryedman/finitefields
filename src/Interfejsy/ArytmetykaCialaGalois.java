
package Interfejsy;

/**
 * Interfejs ArytmetykaCialaGalois opisuje podstwaowe operacje
 dla elementów w Ciele Galois.
 *
 * @author Grzegorz Dżaman
 */
public interface ArytmetykaCialaGalois {
    /**
     * Ta metoda implementuje dodawanie dwóch elementów Ciała Galois. Elementy
     * są brane pod uwagę jako parametry i zwracana jest nowa wartość.
     * liczba do której jest dodawany dodajnik
     * @param element1 liczba do której jest dodawany dodajnik
     * @param element2 dodajnik czyli składnik dodawania
     * @return suma elementów element1 i element2.
     */
    
    long dodaj(long element1,long element2);
    
    /**
     * Ta metoda implementuje odejmowanie dwóch elementów Ciała Galois.
     * Elementy są brane pod uwagę jako parametry i zwracana jest nowa wartość.
     *
     * @param element1 odjemna
     * @param element2 odjemnik
     * @return różnica elementów element1 i element2.
     */
    
    long odejmij(long element1, long element2);
    
    /**
     * Ta metoda implementuje mnożenie dwóch elementów Ciałą Galois.
     * Elementy są brane pod uwagę jako parametry i zwracana jestnowa wartość.
     *
     * @param element1 multiplicand
     * @param element2 multiplier
     * @return iloczyn elementów element1 and element2
     */
    
    long pomnoz(long element1, long element2);  
}
