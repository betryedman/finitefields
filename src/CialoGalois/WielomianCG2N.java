/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CialoGalois;

import Interfejsy.ArytmetykaWielomianowCialaGalois;
import KlasyElementarne.Wielomian;

/**
 * Klasa WielomianCG2N implementuje interfejs ArytmetykaWielomianowCialaGalois dla
 operacji na wielomianach w Ciele Galois. Objekt klasy WielomianCG2N
 może być oreślony za pomocą wielomianu redukcyjnego dla Ciała Galois, lub
 za pomocą obiektu klasy CG2N.
 *
 * @author Grzegorz Dżaman
 *
 */
public class WielomianCG2N implements ArytmetykaWielomianowCialaGalois {
    
    private final CG2N cialoGalois;

    /**
     * Konstruuje obiekt klasy WielomianlCG2N. Objekt klasy WielomianlCG2N
     * jest okreslony za pomocą cialoGalois, który jest używany do obliczeń
     * na wielomianach nad Ciałem Galois.
     *
     * @param cialoGalois CG2N cialoGalois jest używany do obliczeńna wielomianach
     * nad ciałem Galois.
     *
     */
    public WielomianCG2N(CG2N cialoGalois) {
        this.cialoGalois = cialoGalois;
    }

    /**
     * Constructs an object of PolynomialGF2N class. Object of PolynomialGF2N
     * class has to be specified by reducingPolynomial, which is used as
     * characteristic reducingPolynomial for computation with polynomials over
     * Galois Field.
     *
     @param wymiar n-ty wymiar dla cialoGalois, który
     * oznacza wymiar Ciała Galois.
     */
    public WielomianCG2N(int wymiar) {
        cialoGalois = new CG2N(wymiar);

    }
    
    @Override
    public Wielomian dodaj(Wielomian wielomian1, Wielomian wielomian2) {
        int length = Math.max(wielomian1.getRozmiar(), wielomian2.getRozmiar());
        Wielomian wynik = new Wielomian(length);

        for (int x = 0; x < length; x++) {
            try {
                long value = cialoGalois.dodaj(wielomian1.getElement(x), wielomian2.getElement(x));
                wynik.setElement(x, value);
            } catch (IndexOutOfBoundsException ex) {
                if (x >= wielomian1.getRozmiar()) {
                    wynik.setElement(x, wielomian2.getElement(x));
                } else {
                    wynik.setElement(x, wielomian1.getElement(x));
                }
            }
        }

        return wynik.usunZeroweWartosci();
    }

    @Override
    public Wielomian odejmij(Wielomian wielomian1, Wielomian wielomian2) {
        return dodaj(wielomian1, wielomian2);
    }

    @Override
    public Wielomian pomnoz(Wielomian wielomian1, Wielomian wielomian2) {
        if (czyZerowy(wielomian1) || czyZerowy(wielomian2)) {
            return new Wielomian();
        }

        Wielomian wynik = new Wielomian(wielomian1.getRozmiar() + wielomian2.getRozmiar() - 1);

        for (int x = 0; x < wielomian2.getRozmiar(); x++) {
            for (int y = 0; y < wielomian1.getRozmiar(); y++) {
                if (wielomian1.getElement(y) != 0) {
                    int indeks = y + x;
                    long wynikMnozenia = cialoGalois.pomnoz(wielomian1.getElement(y), wielomian2.getElement(x));
                    long wartoscPocztkowa = wynik.getElement(indeks);
                    wynik.setElement(indeks, cialoGalois.dodaj(wartoscPocztkowa, wynikMnozenia));
                }
            }
        }

        return wynik.usunZeroweWartosci();
    }
    //sprawdza, czy wielomian nie jest równy zero
    private boolean czyZerowy(Wielomian wielomian) {
        if (wielomian.getRozmiar() == 0) {
            return true;
        }

        for (int x = 0; x < wielomian.getRozmiar(); x++) {
            if (wielomian.getElement(x) != 0) {
                return false;
            }
        }
        return true;
    }
}
