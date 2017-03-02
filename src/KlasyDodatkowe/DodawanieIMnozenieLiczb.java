/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyDodatkowe;

import CialoGalois.CG2N;

/**
 *
 * @author Grzegorz
 */
public class DodawanieIMnozenieLiczb {
    public static String tabliczkaDodawania(int wymiar) {
        String napis = "";
    ConvertToBits bits = new ConvertToBits(wymiar);
    CG2N cialoGalois = new CG2N(wymiar);
    // Wyświetla nagłówek
    String output = "                Tabliczka dodawania\n";
    output += "-------------------------------------------------\n";

    // Display the number title
    
    for(int i = 0; i < cialoGalois.getWymiar() * 2; i++) {
        napis += " ";   
    }
    
    output += napis + "  | ";
    for (int j = 0; j < Math.pow(2, cialoGalois.getWymiar()); j++)
      output += "  " + bits.show(j);

    output += "\n";
    
    // Wyświetla ciało tabeli
    for (int i = 0; i < Math.pow(2, cialoGalois.getWymiar()); i++) {
      output += bits.show(i) + " | ";
      for (int j = 0; j < Math.pow(2, cialoGalois.getWymiar()); j++) {
        // Wyświetla sumę
          output += "  " + bits.show(cialoGalois.dodaj(i, j));
      }
      output += "\n";    
    }
    return output;
    }
    
    public static String tabliczkaMnoenia(int wymiar) {
    String napis = "";
    ConvertToBits bits = new ConvertToBits(wymiar);
    CG2N cialoGalois = new CG2N(wymiar);
    // Wyświetla nagłówek
    String output = "                Tabliczka Mzożenia\n";
    output += "-------------------------------------------------\n";

    // Wyświetla numer liczby do przemnożenia
    
    for(int i = 0; i < cialoGalois.getWymiar() * 2; i++) {
        napis += " ";   
    }
    
    output += napis + "  | ";
    
    for (int j = 0; j < Math.pow(2, cialoGalois.getWymiar()); j++)
      output += "  " + bits.show(j);

    output += "\n";
    
    // Wyswietla ciało tabeli
    for (int i = 0; i < Math.pow(2, cialoGalois.getWymiar()); i++) {
      output += bits.show(i) + " | ";
      for (int j = 0; j < Math.pow(2, cialoGalois.getWymiar()); j++) {
        // Wyświetla iloczyny
          output += "  " + bits.show(cialoGalois.pomnoz(i, j));
      }
      output += "\n";
    }
    return output;
    }
    
    public static String tabliczkaDodawaniaDziesietnie(int wymiar) {
    ConvertToBits bits = new ConvertToBits(wymiar);
    CG2N cialoGalois = new CG2N(wymiar);
    // Wyświetla nagłówek
    String output = "                Tabliczka dodawania\n";
    output += "-------------------------------------------------\n";

    // Display the number title
     
    output +="     |     ";
    for (int j = 0; j < Math.pow(2, cialoGalois.getWymiar()); j++)
        output += j + "    ";


    output += "\n";
    
    // Wyświetla ciało tabeli
    for (int i = 0; i < Math.pow(2, cialoGalois.getWymiar()); i++) {
        if(i < 10) {
            output += i + "   | ";
        } else {
            output += i + " | ";
        }
      for (int j = 0; j < Math.pow(2, cialoGalois.getWymiar()); j++) {
        // Wyświetla sumę
          if(cialoGalois.dodaj(wymiar, wymiar) < 10) {
            output += "    " + cialoGalois.dodaj(i, j);
          } else {
            output += "  " + cialoGalois.dodaj(i, j);    
          }
      }
      output += "\n";    
    }
    return output;
    }
    
    public static String tabliczkaMnoeniaDziesietnie(int wymiar) {
        ConvertToBits bits = new ConvertToBits(wymiar);
        CG2N cialoGalois = new CG2N(wymiar);
        // Wyświetla nagłówek
        String output = "                Tabliczka Mzożenia\n";
        output += "-------------------------------------------------\n";

        // Wyświetla numer liczby do przemnożenia
    
        output +="     |     ";
        for (int j = 0; j < Math.pow(2, cialoGalois.getWymiar()); j++)
        if(j < 10) {
                output += j + "    ";
            } else {
                output += j + "  ";
        }

        output += "\n";
    
        // Wyswietla ciało tabeli
        for (int i = 0; i < Math.pow(2, cialoGalois.getWymiar()); i++) {
            if(i < 10) {
                output += i + "   | ";
            } else {
                output += i + " | ";
            }
            for (int j = 0; j < Math.pow(2, cialoGalois.getWymiar()); j++) {
                // Wyświetla iloczyny
                if(cialoGalois.pomnoz(i, j) < 10) {
                    output += "    " + cialoGalois.pomnoz(i, j);
                } else {
                    output += "  " + cialoGalois.pomnoz(i, j);    
                }
            }
            output += "\n";
        }
        return output;
    }
}
