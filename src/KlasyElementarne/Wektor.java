/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyElementarne;

import KlasyDodatkowe.ConvertToBits;
import java.util.Arrays;
import java.util.Random;

/**
 * Klasa Wektor jest obiektową reprezentacją w wektora. Dane są przetrzymywane w tablicy,
 * a dostęp do każdego elementu tablicy otrzymujemy poprzez indeks.
 *
 * @author Grzegorz Dżaman
 *
 */
public class Wektor {
    private final long[] elementy;
    private int dlugosc;
    
    /**
     * Tworzy wektor o rozmiarze 0 bez elementów.
     */
    
    public Wektor() {
        elementy = new long[0];
        dlugosc = 0;
    }
    
    /**
     * Tworzy wektor o określonej długości. Wszystkie elementy tego wktora
     * są równe zero.
     *
     * @param dlugosc dlugosc wektora
     */
    public Wektor(int dlugosc) {
        elementy = new long[dlugosc];
        this.dlugosc = dlugosc;
    }
    
    /**
     * Tworzy wektor. Stworzony wektor jest taki sam jak wektor dany jako
     * parametr konstruktora.
     *
     * @param wektor Wektor do sklonowania
     */
    
    public Wektor(Wektor wektor) {
        this(wektor.getDlugosc());
        for(int x = 0; x < dlugosc; x++) {
            elementy[x] = wektor.getElement(x);
        }
    }
    
    /**
     * Tworzy wektor. Skonstruowany wektor jest taki sam jak wektor
     * reprezentowany przez tablicę, która jest parametrem konstruktora.
     *
     * @param wektor Wektor do sklonowania
     */
    
    public Wektor(long[] wektor) {
        dlugosc = wektor.length;
        elementy = new long[dlugosc];
        for(int x = 0; x < dlugosc; x++) {
            elementy[x] = wektor[x];
        }
    }
    
    /**
     * konstruuje wektor. Skonstruowany wektor ma określoną długość i jest wypełniony
     * liczbami wygenerowanymi losowo z zakresu pomiędzy 0 i 2*ilośćBitów - 1.
     *
     * @param dlugosc dlugosc wektora
     * @param liczbaBitow liczba bitów każdej wartości wektora generowanej losowa
     */
    
    public Wektor(int dlugosc, int liczbaBitow) {
        this(dlugosc);
        if(liczbaBitow < 1) {
            return;
        }
        
        Random rn = new Random();
        
        for(int x = 0; x < dlugosc; x++) {
            elementy[x] = Math.abs(rn.nextLong()) & generujMaskeBitowa(liczbaBitow);
        }
    }
    
    /**
     * Ustaw element wektor na określonej pozycji o określonej wartości.
     *
     * @param indeks indeks elementu
     * @param wartosc wartosc do ustawienia
     */
    
    public void setElement(int indeks, long wartosc) {
        elementy[indeks] = wartosc;
    } 
    
    /**
     * Zwaraca element vektora na określonej pozycji.
     *
     * @param indeks indeks elementu
     * @return element o określonym indeksie.
     */
    public long getElement(int indeks) {
        return elementy[indeks];
    }
    
    /**
     * Zwraca długość wektora.
     *
     * @return długość wektora
     */
    
    public int getDlugosc() {
        return dlugosc;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Arrays.hashCode(this.elementy);
        return hash;
    }

    @Override
    public boolean equals(Object wektor) {
        if(!(wektor instanceof Wektor)) {
            return false;
        }
        
        if(((Wektor) wektor).getDlugosc() != dlugosc) {
            return false;
        }
        
        for(int x = 0; x < dlugosc; x++) {
            if(elementy[x] != ((Wektor) wektor).getElement(x)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        String wynik = new String();

        wynik += "( ";
        for (int x = 0; x < dlugosc; x++) {
            if (x == dlugosc - 1) {
                wynik += elementy[x];
            } else {
                wynik += elementy[x] + ", ";
            }
        }
        wynik += " )";

        return wynik;
    }
    
    public String toBits(int wymiar) {
        String wynik = new String();
        ConvertToBits bits = new ConvertToBits(wymiar);
        wynik += "( ";
        for (int x = 0; x < dlugosc; x++) {
            if (x == dlugosc - 1) {
                wynik += bits.show(elementy[x]);
            } else {
                wynik += bits.show(elementy[x]) + ", ";
            }
        }
        wynik += " )";

        return wynik;
    }
    
    private long generujMaskeBitowa(int dlugosc) {
        int wynik = 0;
        for (int x = 0; x < dlugosc; x++) {
            wynik ^= (1 << x);
        }
        return wynik;
    }
}
