/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CialoGalois;

import Interfejsy.ArytmetykaMacierzyCialaGalois;
import KlasyDodatkowe.ConvertToBits;
import KlasyElementarne.Macierz;
import KlasyElementarne.Wektor;
import Wyjatki.DimensionMismatchException;
import Wyjatki.MathIllegalArgumentException;

/**
 * Class MacierzCG2N implementuje interfejs ArytmetykaMacierzyCialaGalois
 * dla operacjina macierzach w Ciele Galois. Objekt klasy MacierzCG2N
 * jest określony za pomocą wielomianu redukcyjnegow Ciele Galois, lub
 * za pomocą objektu klasy CG2N.
 *
 * @author Grzegorz Dżaman
 *
 */
public class MacierzCG2N implements ArytmetykaMacierzyCialaGalois {
    
    private CG2N cialoGalois;
    
    /**
     * Konstruuje objekt klasy MacierzCG2. Objekt klasy MacierzCG2
     * jest określony za pomocą galoisField, który jest używany do operacji
     * na macierzach na Ciałem Galois.
     *
     * @param cialoGalois cialoGalois jest używany do operacji na macierzach
     * nad ciałem Galois.
     */
    
    public MacierzCG2N(CG2N cialoGalois) {
        this.cialoGalois = cialoGalois;
    }
    
    /**
     * Konstruuje objekt klasy MacierzCG2N. Objekt klasy MacierzCG2N
     * jest określony za pomocą n-tego wymiaru, który jest używany do
     * określenia wielomianu nierozkładalnego służącego do operacji na macierzch nad
     * Ciałem Galois.
     *
     @param wymiar n-ty wymiar dla cialoGalois, który
     * oznacza wymiar Ciała Galois.
     */
    
    public MacierzCG2N(int wymiar) {
        cialoGalois = new CG2N(wymiar);
    }
    
    //sprawdza czy macierze mają ten sam wymiar szy rozmiary wierszy i kolumn nie są zerowe
    private void czyPrawidlowy(Macierz macierz1, Macierz macierz2) {

        if (macierz1.getWiersze() == 0 || macierz2.getWiersze() == 0) {
            throw new MathIllegalArgumentException("Macierze które są parametrami są puste, "
                    + "nie można przeprowadzać operacji.");
        }

        if (macierz1.getKolumny() == 0 || macierz2.getKolumny() == 0) {
            throw new MathIllegalArgumentException("Macierze które są parametrami mają pusty wiersz, "
                    + "nie można przeprowadzać operacji.");
        }

        if ((macierz1.getKolumny() != macierz2.getKolumny()) || (macierz1.getWiersze() != macierz2.getWiersze())) {
            throw new DimensionMismatchException("Macierze które są parametrami majś różne wymiary, "
                    + "nie można przeprowadzać operacji.");
        }
    }
    
    //sprawdza czy macierz nie ma zero kolumn i wierszy
    private void czyPrawidlowy(Macierz macierz) {

        if (macierz.getWiersze() == 0) {
            throw new MathIllegalArgumentException("Macierz, która jest parametrem jest pusta, "
                    + "nie można przeprowadzać operacji.");
        }

        if (macierz.getKolumny() == 0) {
            throw new MathIllegalArgumentException("Macierz, która jest parametrem ma pusty wiersz, "
                    + "nie można wykonywać operacji.");
        }

    }
    
    @Override
    public Macierz dodaj(Macierz macierz1, Macierz macierz2) {
        czyPrawidlowy(macierz1, macierz2);
        
        Macierz wynik = new Macierz(macierz1.getWiersze(),macierz1.getKolumny());
        for (int row = 0; row < macierz1.getWiersze(); row++) {

            for (int col = 0; col < macierz1.getKolumny(); col++) {
                wynik.setElement(row, col,
                        cialoGalois.dodaj(macierz1.getElement(row, col), macierz2.getElement(row, col)));
            }
        }

        return wynik;
        
    }

    @Override
    public Macierz odejmij(Macierz macierz1, Macierz macierz2) {
        czyPrawidlowy(macierz1, macierz2);
        return dodaj(macierz1,macierz2);
    }

    @Override
    public Macierz pomnoz(Macierz macierz1, Macierz macierz2) {
        Macierz wynik = new Macierz(macierz1.getWiersze(), macierz2.getKolumny());
        
        if(macierz1.getWiersze() == 0 || macierz2.getWiersze() == 0) {
            throw new MathIllegalArgumentException("Macierz, która jest parametrem jest pusta, "
                    + "nie można przeprowadzać operacji.");
        }
        
        if(macierz1.getKolumny() == 0 || macierz2.getKolumny() == 0) {
            throw new MathIllegalArgumentException("Macierz, która jest parametrem ma pusty wiersz, "
                    + "nie można przeprowadzać operacji.");
        }
        
        if(macierz1.getKolumny() != macierz2.getWiersze()) {
            throw new MathIllegalArgumentException("Macierze, które są parametrami nie można mnożyć między sobą, "
                    + "maja nieprawidłowe wymiary.");
        }
        
        for (int x = 0; x < macierz1.getWiersze(); x++) {
            for (int y = 0; y < macierz2.getKolumny(); y++) {
                long wartosc = 0;
                for (int z = 0; z < macierz1.getKolumny(); z++) {
                    wartosc = cialoGalois.dodaj(wartosc,
                            cialoGalois.pomnoz(macierz1.getElement(x, z), macierz2.getElement(z, y)));
                }
                wynik.setElement(x, y, wartosc);
            }
        }
        
        return wynik;
    }

    @Override
    public Macierz pomnoz(Macierz macierz, long skalar) {
        czyPrawidlowy(macierz);

        Macierz wynik = new Macierz(macierz.getWiersze(), macierz.getKolumny());
        for (int row = 0; row < macierz.getWiersze(); row++) {
            for (int col = 0; col < macierz.getKolumny(); col++) {
                wynik.setElement(row, col, cialoGalois.pomnoz(macierz.getElement(row, col), skalar));
            }
        }

        return wynik;
    }

    @Override
    public Macierz pomnoz(Wektor wektor, Macierz macierz) {
        Macierz wektorMacierzowy = new Macierz(1, wektor.getDlugosc());

        for (int x = 0; x < wektor.getDlugosc(); x++) {
            wektorMacierzowy.setElement(0, x, wektor.getElement(x));
        }
        return pomnoz(wektorMacierzowy , macierz);
    }

    @Override
    public Macierz pomnoz(Macierz macierz, Wektor wektor) {
        Macierz wektorMacierzowy = new Macierz(wektor.getDlugosc(), 1);
        
        for (int x = 0; x < wektor.getDlugosc(); x++) {
            wektorMacierzowy.setElement(0, x, wektor.getElement(x));
        }
        return pomnoz(wektorMacierzowy, macierz);
    }   
    
}
