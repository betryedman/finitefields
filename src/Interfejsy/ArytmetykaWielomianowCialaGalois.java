/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfejsy;

import KlasyElementarne.Wielomian;

/**
 * Interfejs ArytmetykaWielomianowCialaGalois opisuje podstawowe operacje
 pomiedzy wielomianami z elementami w Ciele Galois.
 *
 * @author Grzegorz Dżaman
 */
public interface ArytmetykaWielomianowCialaGalois {
    /**
     * Ta metoda implementuje dodawanie dwóch wielomianów z elementami 
     * w Ciele Galois. Wielomiany są brane pod uwagę jako parametry 
     * i zwracany jest nowy wielomian.
     *
     * @param wielomian1 wielomian do którego jest dodawany dodajnik
     * @param wielomian2 dodajnik czyli składnik dodawania
     * @return suma wielomianów wielomian1 i wielomian2
     */
    Wielomian dodaj(Wielomian wielomian1, Wielomian wielomian2);

    /**
     * Te metody implementują odejmowanie dwóch wielomianów z elementami w
     * Ciele Galois. Wielomiany są brane pod uwagę jako parametry i
     * zwracany jest nowy wielomian.
     *
     * @param wielomian1 odjemna wielomianl
     * @param wielomian2 odjemnik wielomianl
     * @return róznica pomiędzy wielomian1 i wielomian2
     */
    Wielomian odejmij(Wielomian wielomian1, Wielomian wielomian2);

    /**
     * Ta metoda implementuje mnożenie dwóch wielomianów z elementami
     * w Ciele Galois. Wielomiany są brane pod uwagę jako parametry 
     * i zwracany jest nowy wielomian.
     *
     * @param wielomian1 mnożna wielomian1
     * @param wielomian2 mnożnik wielomian2
     * @return iloczyn wielomian1 i wielomian2
     */
    Wielomian pomnoz(Wielomian wielomian1, Wielomian wielomian2);
}
