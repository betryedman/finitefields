/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyDodatkowe;

import CialoGalois.WektorCG2N;
import KlasyElementarne.Wektor;

/**
 *
 * @author Grzegorz
 */
public class DodawanieImnozeniwWektorow {
    public static String dodaj(Wektor wektor1, Wektor wektor2, WektorCG2N wektorCG2N, int wymiar) {
        String wynik = "";
        
        wynik += wektor1.toBits(wymiar) + " + " + wektor2.toBits(wymiar) + " = " 
        + wektorCG2N.dodaj(wektor1, wektor2).toBits(wymiar);
        
        return wynik;
    }
    
    public static String pomnoz(Wektor wektor, long skalar, WektorCG2N wektorCG2N, int wymiar) {
        String wynik = "";
        ConvertToBits bits = new ConvertToBits(wymiar);
        
        wynik += wektor.toBits(wymiar) + " * " + bits.show(skalar) + " = " 
        + wektorCG2N.pomnoz(wektor, skalar).toBits(wymiar);
        
        return wynik;
    }
    
    public static String dodajDziesietnie(Wektor wektor1, Wektor wektor2, WektorCG2N wektorCG2N) {
        String wynik = "";
        
        wynik += wektor1.toString() + " + " + wektor2.toString() + " = " 
        + wektorCG2N.dodaj(wektor1, wektor2).toString();
        
        return wynik;
    }
    
    public static String pomnozDziesietnie(Wektor wektor, long skalar, WektorCG2N wektorCG2N) {
        String wynik = "";
        
        wynik += wektor.toString()+ " * " + skalar + " = " 
        + wektorCG2N.pomnoz(wektor, skalar).toString();
        
        return wynik;
    }
}
