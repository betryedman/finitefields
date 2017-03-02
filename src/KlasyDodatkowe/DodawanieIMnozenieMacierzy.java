/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyDodatkowe;

import CialoGalois.MacierzCG2N;
import KlasyElementarne.Macierz;
import KlasyElementarne.Wektor;

/**
 *
 * @author Grzegorz
 */
public class DodawanieIMnozenieMacierzy {

    
    public static String dodaj(Macierz macierz1, Macierz macierz2, MacierzCG2N macierzCG2N, int wymiar) {
        String wynik = "";
            
        wynik += macierz1.toBits(wymiar) + " + \n" + macierz2.toBits(wymiar) + " = \n"
                + macierzCG2N.dodaj(macierz1, macierz2).toBits(wymiar);
        
        return wynik;
    }
    
    public static String dodajDziesietnie(Macierz macierz1, Macierz macierz2, MacierzCG2N macierzCG2N) {
        String wynik = "";
            
        wynik += macierz1.toString() + " + \n" + macierz2.toString() + " = \n"
                + macierzCG2N.dodaj(macierz1, macierz2).toString();
        
        return wynik;
    }
    
    public static String pomnoz(Macierz macierz1, Macierz macierz2, MacierzCG2N macierzCG2N, int wymiar) {
        String wynik = "";
            
        wynik += macierz1.toBits(wymiar) + " * \n" + macierz2.toBits(wymiar) + " = \n"
                + macierzCG2N.pomnoz(macierz1, macierz2).toBits(wymiar);
        
        return wynik;
    }
    
    public static String pomnozDziesietnie(Macierz macierz1, Macierz macierz2, MacierzCG2N macierzCG2N) {
        String wynik = "";
            
        wynik += macierz1.toString() + " * \n" + macierz2.toString() + " = \n"
                + macierzCG2N.pomnoz(macierz1, macierz2).toString();
        
        return wynik;
    }
    
    public static String pomnoz(Wektor wektor, Macierz macierz, MacierzCG2N macierzCG2N, int wymiar) {
        String wynik = "";
            
        wynik += wektor.toBits(wymiar) + "\n * \n" + macierz.toBits(wymiar) + " = \n"
                + macierzCG2N.pomnoz(wektor, macierz).toBits(wymiar);
        
        return wynik;
    }
    
    public static String pomnozDziesietnie(Wektor wektor, Macierz macierz, MacierzCG2N macierzCG2N) {
        String wynik = "";
            
        wynik += wektor.toString() + "\n * \n" + macierz.toString() + " = \n"
                + macierzCG2N.pomnoz(wektor, macierz).toString();
        
        return wynik;
    }
}
