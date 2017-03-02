/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyDodatkowe;

/**
 *
 * @author Grzegorz
 */
public class ConvertToBits {

    int numbits;
    
    public ConvertToBits(int n) {
        numbits = n;
    }
    
    public String show(long val) {
        long mask = 1;
        
        String wynik = "";
        
        mask = mask << numbits - 1;
        
        int spacer = 0;
        for(; mask != 0; mask >>>= 1) {
            
            if((val & mask) != 0) {
                wynik += "1";
            } else {
                wynik += "0";
            }
            spacer++;
            if((spacer % 8) == 0) {
                wynik += " ";
                spacer = 0;
            }
        }
        return wynik;
    }
}