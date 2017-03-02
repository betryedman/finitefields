/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Okna.DzialaniaNadCialemSkonczonym;
import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;

/**
 *
 * @author Grzegorz
 */
public class Obliczenia {
    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                DzialaniaNadCialemSkonczonym dzialaniaNaCialachSkonczonych = new DzialaniaNadCialemSkonczonym();
            }
        });
    }
}
