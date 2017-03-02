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
 * Klasa Wielomian jest objektową reprezentacją wielomianu. Dane są prztrzymywane
 * w tablicy, każdy współczynnik wielomianu jest dostępny poprzez jego indeks.
 * Największe współczynniki wielomianu są przetrzywane w najwyższej pozycji
 * tablicy.
 *
 * @author Grzegorz Dżaman
 *
 */
public class Wielomian {
   private long[] elementy;
   private int rozmiar;
   
   /**
     * Tworzy wielomian o rozmiarze 0, który ma zero elementów. .
     */
   public Wielomian() {
       elementy = new long[0];
       rozmiar = 0;
   }
   
   /**
     * Tworzy wielomian o określonym rozmiarze. Wszystkie współczynniki 
     * wielomianu są równe zero.
     *
     * @param rozmiar liczba współczynników wielomianu.
     */
   public Wielomian(int rozmiar) {
       elementy = new long[rozmiar];
       this.rozmiar = rozmiar;
   }
   
   /**
     * Tworzy wielomian. Stworzony wielomian jest taki sam jak
     * wielomian podany jako argument konstruktora.
     *
     * @param wielomian wielomian do sklonowania
     */
   
   public Wielomian(Wielomian wielomian) {
       this(wielomian.getRozmiar());
       for(int x = 0; x < rozmiar; x++) {
          elementy[x] = wielomian.getElement(x);
       }
   }
   
   /**
     * Tworzy wielomian. Skonstruowany wielomian jest taki sam jak
     * wielomian reprezentowany przez tablicę, która jest parametrem konstruktora.
     *
     * @param wielomian Wielomian do skopiowania.
     */
   
   public Wielomian(long[] wielomian) {
       rozmiar = wielomian.length;
       elementy = new long[rozmiar]; 
       for(int x = 0; x < rozmiar; x++) {
           elementy[x] = wielomian[x];
       }
   }
   
   public Wielomian(int rozmiar, int liczbaBitow) {
       this(rozmiar);
       if(liczbaBitow < 1) {
           return;
       }
       
       Random rn = new Random();
       
       for(int x = 0; x < rozmiar - 1; x++) {
           elementy[x] = Math.abs(rn.nextLong()) & generujMaskeBitowa(liczbaBitow);
       }

       do {
           elementy[rozmiar - 1] = (Math.abs(rn.nextLong()) & generujMaskeBitowa(liczbaBitow));
       } while(elementy[rozmiar - 1] == 0);
   }
   
   /**
     * Ustawia współczynnik wielomianu na określonej pozycji i o określonej wartości.
     *
     * @param indeks indeks współczynnika
     * @param wartosc wartość do ustawienia
     */
   
   public void setElement(int indeks, long wartosc) {
       elementy[indeks] = wartosc;
   }
     
   /**
     * Zwaraca współczynnik wielomianu na określonej pozycji.
     *
     * @param indeks pozycja współczynnik
     * @return współczynnik na określonej pozycjiindeksu
     */
   
   public long getElement(int indeks) {
       return elementy[indeks];
   } 
   
   /**
     * Ustawia rozmiar wielomianu. Po wywołaniu tej mwetody wszystkie współczynniki są
     * równe zeru.
     *
     * @param rozmiar nowy rozmiar wielomianu
     */
   
   public void setRozmiar(int rozmiar) {
       this.rozmiar = rozmiar;
       elementy = new long[rozmiar];
   }
   
   /**
     * Zwraca rozmiar wielomianu. Rozmiar wielomianu jest równy jego stopniowi - 1
     * dla wszystkich wielomianów które mają niezerowe współczynniki w największym indeksie.
     *
     * @zwraca rozmiar wielomianu
     */
   
   public int getRozmiar() {
       return rozmiar;
   }
   
    /**
     * Czyści wszystkie zerowe wartości najwyższych współczynników wielomianu. Te 
     * współczyniki są usuwane, stopień nowego wielomianu jest zmieniony.
     *
     *  
     * @return wielomian bez zerowych wartości w największych współczynnikach.
     */
   public Wielomian usunZeroweWartosci() {
       long[] noweElementy;
       for(int x = rozmiar - 1; x >= 0; x--) {
           if(elementy[x] != 0) {
               noweElementy = new long[x + 1];
               for(int y = 0; y < x + 1; y++) {
                   noweElementy[y] = elementy[y];
               }
               rozmiar = x + 1;
               return this;
           }
       }
       rozmiar = 0;
       elementy = new long[0];
       return this;
   }
   /**
     * Zwraca napisową reprezenatację wielomianu. Napis zwrócony przez tą metodę
     * jest w formie (a + bx^1 + cx^2 ... zx^n).
     *
     * @return napisową reprezentację wielomianu
     */
   
   public String toStringAsPoly() {
        String wynik = new String();

        wynik += "[";
        if (rozmiar > 0) {
            wynik += elementy[0] + " + ";
        }
        for (int x = 1; x < rozmiar; x++) {
            if (x == rozmiar - 1) {
                wynik += elementy[x] + "x^" + x;
            } else {
                wynik += elementy[x] + "x^" + x + " + ";
            }
        }
        wynik += "]";
        return wynik;
    }
   
   public String toBits(int wymiar) {
        String wynik = new String();
        ConvertToBits bits = new ConvertToBits(wymiar);
        
        wynik += "[";
        if (rozmiar > 0) {
            wynik += bits.show(elementy[0]) + " + ";
        }
        for (int x = 1; x < rozmiar; x++) {
            if (x == rozmiar - 1) {
                wynik += bits.show(elementy[x]) + "x^" + x;
            } else {
                wynik += bits.show(elementy[x]) + "x^" + x + " + ";
            }
        }
        wynik += "]";
        return wynik;
    }
   
   @Override
    public boolean equals(Object wielomian) {
        if (!(wielomian instanceof Wielomian)) {
            return false;
        }

        if (((Wielomian) wielomian).getRozmiar() != rozmiar) {
            return false;
        }

        for (int x = 0; x < rozmiar; x++) {
            if (elementy[x] != ((Wielomian) wielomian).getElement(x)) {
                return false;
            }
        }

        return true;
    }
   
   @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Arrays.hashCode(this.elementy);
        return hash;
    }
   
   @Override
    public String toString() {
        String wynik = new String();

        wynik += "[ ";
        for (int x = 0; x < rozmiar; x++) {
            if (x == rozmiar - 1) {
                wynik += elementy[x];
            } else {
                wynik += elementy[x] + ", ";
            }
        }
        wynik += " ]";

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
