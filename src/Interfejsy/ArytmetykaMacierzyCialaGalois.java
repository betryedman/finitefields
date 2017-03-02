
package Interfejsy;

import KlasyElementarne.Macierz;
import KlasyElementarne.Wektor;

/**
 * Interfejs ArytmetykaMacierzyCialaGalois opisuje podstawowe operacje
 między macierzami i elementami w Ciele Galois.
 *
 * @author Grzegorz Dżaman
 */
public interface ArytmetykaMacierzyCialaGalois {
    /**
     * Ta metoda implementuje dodawanie dwóch macierzy z elementów w Ciele Galois.
     * Macierze są brane pod uwagę jako parametry i zwracana jest nowa macierz.
     *
     * @param macierz1 macierz do którego jest dodawany dodajnik
     * @param macierz2 dodajnik czyli składnik dodawania
     * @return suma macierzy macierz1 i macierz2
     */
    
    Macierz dodaj(Macierz macierz1, Macierz macierz2);

    /**
     * Ta metoda implementuje odejmowanie dwóch macierzy w z elementów w
     * Ciele Galois. Macierz są brane pod uwagę jako parametry i zwracana
     * jest nowa macierz.
     *
     * @param macierz1 macierz odjemna
     * @param macierz2 odjemnik macierzowy
     * @return różnicę macierzy macierz1 i macierz2.
     */
    
    Macierz odejmij(Macierz macierz1, Macierz macierz2);
    
    /**
     * Ta metoda implementujemnozeniedwóch macierzy z elemenów w
     * Ciele Galois. Macierz są brane po uwagę jako parametry i zwracan jest
     * nowa macierz.
     *
     * @param macierz1 mnożna macierz1, format (x wiersze, y kolumny)
     * @param macierz2 mnożnik macierz2, format (y wiersze, z kolumny)
     * @return iloczyn macierzy macierz1 i macierz2
     */
    
        Macierz pomnoz(Macierz macierz1, Macierz macierz2);
        
        /**
     * Ta metoda implementuje mnożenie macierzy z elemntami w Ciele Galois
     * przez wartość skalarną. Macierz i skalar są brane pod uwagę jako parametry
     * i zwracana jest nowa macierz.
     *
     * @param macierz macierz, która ma być pomnożona przez wartość skalarną
     * @param skalar mnożnik, który jest skalarem
     * @return iloczyn macierzy i wartości skalarnej
     */
        
      Macierz pomnoz(Macierz macierz, long skalar);
      
      /**
     * Ta metoda implementuje mnożenie macierzy z elementami w Ciele Galois
     * przez wektor. Macierz i wektor są brane pod uwagę jako parametry
     * i zwracana jest nowa macierz.
     *
     * @param macierz macierz, która ma być pomnożona przez wektor
     * @param wektor mnożnik, który jest wektorem
     * @return zwraca iloczyn macierzy i wektora 
     */
      
     Macierz pomnoz(Macierz macierz, Wektor wektor);
     
     /**
     * Ta metoda implementuje mnożenie wektora z elementami w Ciele Galois
     * przez macierz. Macierz i wektor są brane pod uwagę jako parametry
     * i zwracana jest nowa macierz.
     *
     * @param wektor mnożnik, który jest wektorem
     * @param macierz macierz, która ma być pomnożona przez wektor
     * @return zwraca iloczyn macierzy i wektora 
     */
      
     Macierz pomnoz(Wektor wektor, Macierz macierz);
     
}
