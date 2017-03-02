/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyDodatkowe;

import CialoGalois.WielomianCG2N;
import KlasyElementarne.Wielomian;

/**
 *
 * @author Grzegorz
 */
public class DodawanieIMnozenieWielomianow {
    public static String dodaj(Wielomian wielomian1, Wielomian wielomian2, WielomianCG2N wielomianCG2N, int wymiar) {
        String wynik = "";
        
        wynik += wielomian1.toBits(wymiar) + " + " + wielomian2.toBits(wymiar)
                + " = " + wielomianCG2N.dodaj(wielomian1, wielomian2).toBits(wymiar);
        
        return wynik;
    }
    
    public static String pomnoz(Wielomian wielomian1, Wielomian wielomian2, WielomianCG2N wielomianCG2N, int wymiar) {
        String wynik = "";
        
        wynik += wielomian1.toBits(wymiar) + " * " + wielomian2.toBits(wymiar)
                + " = " + wielomianCG2N.pomnoz(wielomian1, wielomian2).toBits(wymiar);
        
        return wynik;
    }
    
    public static String dodajDziesietnie(Wielomian wielomian1, Wielomian wielomian2, WielomianCG2N wielomianCG2N) {
        String wynik = "";
        
        wynik += wielomian1.toStringAsPoly() + " + " + wielomian2.toStringAsPoly()
                + " = " + wielomianCG2N.dodaj(wielomian1, wielomian2).toStringAsPoly();
        
        return wynik;
    }
    
    public static String pomnozDziesietnie(Wielomian wielomian1, Wielomian wielomian2, WielomianCG2N wielomianCG2N) {
        String wynik = "";
        
        wynik += wielomian1.toStringAsPoly() + " * " + wielomian2.toStringAsPoly()
                + " = " + wielomianCG2N.pomnoz(wielomian1, wielomian2).toStringAsPoly();
        
        return wynik;
    }
}
