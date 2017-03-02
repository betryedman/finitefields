package KlasyElementarne;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import KlasyDodatkowe.ConvertToBits;
import java.util.Arrays;
import java.util.Random;

/**
 * Klasa Macierz jest obiektem reprezentującym macierz. Dane są przetrzymywane w 
 * dwuwymiarowej tablicy, dostęp do każdego elementu macierzy uzyskuje się poprzez jego pozycję w 
 * dwuwymiarowej tablicy korzystając z konstruktora Macierz(wiersz, kolumna). 
 * 
 * @author Grzegorz Dżaman
 * 
 */

public class Macierz {
    private long[][] elementy;
    private int wiersze, kolumny;
    
    /**
     * Tworzy macierz z zerową liczbą wierszy i kolumn bez elementów.
     */
    
    public Macierz() {
        wiersze = 0;
        kolumny = 0;
        elementy = new long[0][0];
    }
    
    /**
     * Tworzy macierz o określonym rozmiarze. Wszystkie elementy tej macierzy są
     * równe zero.
     *
     * @param wiersze liczba wierszy
     * @param kolumny liczba kolumn
     */
    
    public Macierz(int wiersze, int kolumny) {
        this.wiersze = wiersze;
        this.kolumny = kolumny;
        elementy = new long[wiersze][kolumny];
    }
    
    /**
     * Tworzy Macierz. Stworzona macierz jest taka sama jak macierz podana jako
     * parametr konstruktora.
     *
     * @param macierz Macierz do sklonowania
     */
    
    public Macierz(Macierz macierz) {
        wiersze = macierz.getWiersze();
        kolumny = macierz.getKolumny();
        
        elementy = new long[wiersze][kolumny];
        
        for(int x = 0; x < wiersze; x++) {
            for(int y = 0; y < kolumny; y++) {
                elementy[x][y] = macierz.getElement(x, y);
            }
        }
    }
    
    /**
     * Tworzy macierz. Zkonstruowana macierz jest taka sama jak macierz
     * reprezentowana przez dwuwymiarową tablicę daną jako parametr 
     * konstruktora.
     *
     * @param macierz Macierz do klonowania
     */
    
    public Macierz(long[][] macierz) {
        
        wiersze = macierz.length;
        kolumny = macierz[0].length;
        
        elementy = new long[wiersze][kolumny]; 
        
        for(int x = 0; x < wiersze; x++) {
            for(int y = 0; y < kolumny; y++) {
                elementy[x][y] = macierz[x][y];
            }
        }
    }
    
    /**
     * Tworzy macierz o określonej liczbie wierszy i kolumn. .
     * Skonstruowana macierz jest wypełniona liczbami generowanymk losowo z zakresu
     * od 0 do 2^liczbabitów - 1..
     *
     * @param wiersze liczba wierszy
     * @param kolumny liczba kolumn
     * @param liczbaBitow liczba bitów liczb generowanych losowo
     */
    
    public Macierz(int wiersze, int kolumny, int liczbaBitow) {
        this(wiersze, kolumny);
        if(liczbaBitow < 1) {
            return;
        }
        
        Random rn = new Random();
        
        for(int x = 0; x < wiersze; x++) {
            for(int y = 0; y < kolumny; y++) {
                elementy[x][y] = Math.abs(rn.nextLong()) & generujMaskeBitowa(liczbaBitow);
            }
        }
    }
    
    /**
     * Ustawia elementy macierzy w określonej pozycji o określonej wartości.
     *
     * @param x pozycja elementu w wierszu
     * @param y pozycja elementu w kolumnie
     * @param wartosc wartość do ustawienia
     */
    
    public void setElement(int x, int y, long wartosc) {
        elementy[x][y] = wartosc;
    }
    
    /**
     * Zwraca elementy macierzy o określonej pozycji.
     *
     * @param x row position of element
     * @param y column position of element
     * @return element na określonej pozycji
     */
    
    public long getElement(int x, int y) {
        return elementy[x][y];
    }
    
    /**
     * Transponuje macierz.
     */
    
    public void transponuj() {
        long[][] macierzTransponowana = new long[kolumny][wiersze];
        
        for(int x = 0; x < wiersze; x++) {
            for(int y = 0; y < kolumny; y++) {
                macierzTransponowana[y][x] = elementy[x][y];
            }
        }
        
        elementy = macierzTransponowana;
        kolumny = wiersze;
        wiersze = macierzTransponowana.length;
    }
    
    /**
     * Zwraca liczbę wierszy macierzy.
     *
     * @return liczba wierszy
     */
    
    public int getWiersze() {
        return wiersze;
    }
    
    /**
     * Zwraca liczbę kolumn macierzy.
     *
     * @return liczba kolumn
     */
    
    public int getKolumny() {
        return kolumny;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Arrays.deepHashCode(this.elementy);
        return hash;
    }

    @Override
    public boolean equals(Object macierz) {
        if (!(macierz instanceof Macierz)) {
            return false;
        }

        if (((Macierz) macierz).getWiersze() != wiersze || ((Macierz) macierz).getKolumny() != kolumny) {
            return false;
        }

        for (int x = 0; x < wiersze; x++) {
            for (int y = 0; y < kolumny; y++) {
                if (((Macierz) macierz).getElement(x, y) != elementy[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        String wynik = new String();
        for (int x = 0; x < wiersze; x++) {
            wynik += "[ ";
            for (int y = 0; y < kolumny; y++) {
                if (y == kolumny - 1) {
                    wynik += elementy[x][y];
                } else {
                    wynik += elementy[x][y] + ", ";
                }
            }
            wynik += " ]" + "\n";
        }
        return wynik;
    }
    
    public String toBits(int wymiar) {
        String wynik = new String();
        ConvertToBits bits = new ConvertToBits(wymiar);
        for (int x = 0; x < wiersze; x++) {
            wynik += "[ ";
            for (int y = 0; y < kolumny; y++) {
                if (y == kolumny - 1) {
                    wynik += bits.show(elementy[x][y]);
                } else {
                    wynik += bits.show(elementy[x][y]) + ", ";
                }
            }
            wynik += " ]" + "\n";
        }
        return wynik;
    }
 
    private long generujMaskeBitowa(int length) {
        int wynik = 0;
        for(int x = 0; x < length; x++) {
            wynik ^= (1 << x);
        }
        return wynik;
    }
}
