
package CialoGalois;

import Interfejsy.ArytmetykaWektorowCialaGalois;
import KlasyElementarne.Wektor;
import Wyjatki.DimensionMismatchException;

/**
 *
 * @author Grzegorz
 */
public class WektorCG2N implements ArytmetykaWektorowCialaGalois {
    
    private CG2N cialoGalois;
    
    /**
     * Tworzy objekt klasy WktorCG2N. Objekt WktorCG2N
     * jest określony za pomocą Ciała Galois, które jest używane do operacji
     * na wektorach nad Ciałem Galois.
     *
     * @param cialoGalois CG2N cialoGalois używane do operacji na wektorach
     * nad Ciałem Galois
     *
     */
    public WektorCG2N(CG2N cialoGalois) {
        this.cialoGalois = cialoGalois;
    }
    
    /**
     * Tworzyobiekt klasy WektorCG2N. obiekt klasy WektorCG2N 
     * określony jest za pomocą wielomianu redukcyjnego, który jest używany jako
     * carakterystyczny wielomian redukcyjny dla operacji na wektorach
     * nad Ciałem Galois.
     *
     * @param wymiar n-ty wymiar dla cialoGalois, który
     * oznacza wymiar Ciała Galois.
     */
    public WektorCG2N(int wymiar) {
        cialoGalois = new CG2N(wymiar);
    }
    
    @Override
    public Wektor dodaj(Wektor wektor1, Wektor wektor2) {
        czyPrawidlowy(wektor1, wektor2);

        Wektor wynik = new Wektor(wektor1.getDlugosc());

        for (int x = 0; x < wektor1.getDlugosc(); x++) {
            long wartosc = cialoGalois.dodaj(wektor1.getElement(x), wektor2.getElement(x));
            wynik.setElement(x, wartosc);

        }
        return wynik;
    }

    private void czyPrawidlowy(Wektor wektor1, Wektor wektor2) {

        if (wektor1.getDlugosc() == 0 || wektor2.getDlugosc() == 0) {
            throw new DimensionMismatchException("Wektor, które są parametrami są puste.");
        }

        if (wektor1.getDlugosc() != wektor2.getDlugosc()) {
            throw new DimensionMismatchException("Nie można przeprowadzać operacji na wektorach o różnej długości.");
        }
    }

    @Override
    public Wektor odejmij(Wektor wektor1, Wektor wektor2) {
        czyPrawidlowy(wektor1, wektor2);
        
        return dodaj(wektor1, wektor2);
    }

    @Override
    public Wektor pomnoz(Wektor wektor, long skalar) {
        czyPrawidlowy(wektor);
        
        Wektor wynik = new Wektor(wektor.getDlugosc());
        
        for(int x = 0; x < wektor.getDlugosc(); x++) {
            long wartosc = cialoGalois.pomnoz(wektor.getElement(x), skalar);
            wynik.setElement(x, wartosc);
        }
        
        return wynik;
    }
    
    private void czyPrawidlowy(Wektor wektor) {

        if (wektor.getDlugosc() == 0) {
            throw new DimensionMismatchException("Wektor, który jest parametrem jest pusty.");
        }
    }
}


