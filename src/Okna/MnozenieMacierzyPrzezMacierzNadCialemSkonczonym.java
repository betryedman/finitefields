/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Okna;

import CialoGalois.CG2N;
import CialoGalois.MacierzCG2N;
import KlasyDodatkowe.DodawanieIMnozenieMacierzy;
import KlasyElementarne.Macierz;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 *
 * @author Grzegorz
 */
public class MnozenieMacierzyPrzezMacierzNadCialemSkonczonym implements ActionListener {
    JFrame frame;
    JFrame frame1;
    private final JLabel jlab;
    private final JLabel jhint;
    private JComboBox listaRozwijana;
    private JComboBox macierz1Wiersze;
    private JComboBox macierz1Kolumny;
    private JComboBox macierz2Wiersze;
    private JComboBox macierz2Kolumny;
    private final JScrollPane jscroll;
    private final JScrollPane jscrollMaciersz1Wiersze;
    private final JScrollPane jscrollMaciersz1Kolumny;
    private final JScrollPane jscrollMaciersz2Wiersze;
    private final JScrollPane jscrollMaciersz2Kolumny;
    private final JButton pomnoz;
    private final JButton wstecz;
    private final JCheckBox czyBinarnie;
    private String wymiar = "1";
    private boolean binarny;
    private static final String [] wymiary = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
                "28", "29", "30", "31"};
    private static final String [] wiersze = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
                "28", "29", "30", "31"};
    private static final String [] kolumny = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
                "28", "29", "30", "31"};
    private String liczbaWierszyMacierz1 = "1";
    private String liczbaKolumnMacierz1 = "1";
    private String liczbaWierszyMacierz2 = "1";
    private String liczbaKolumnMacierz2 = "1";
    private JLabel jkolumnaMacierz1;
    private JLabel jwierszMacierz1;
    private JLabel jkolumnaMacierz2;
    private JLabel jwierszMacierz2;
    private JLabel jwymiar;
    
    public MnozenieMacierzyPrzezMacierzNadCialemSkonczonym() {
        frame = new JFrame("Mnożenie macierzy przez macierz nad ciałem skończonym");
        frame.setLayout(new GridLayout(8,5));
        
        frame.setSize(400, 700);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pomnoz = new JButton("Pomnóż");
        wstecz = new JButton("Wstecz");
        
        pomnoz.addActionListener(this);
        wstecz.addActionListener(this);
        jlab = new JLabel("Naciśnij przycisk", SwingConstants.CENTER);
        jhint = new JLabel();
        
        listaRozwijana = new JComboBox(wymiary);
        listaRozwijana.setSelectedIndex(0);
        macierz1Wiersze = new JComboBox(wiersze);
        macierz1Wiersze.setSelectedIndex(0);
        macierz1Kolumny = new JComboBox(kolumny);
        macierz1Kolumny.setSelectedIndex(0);
        macierz2Wiersze = new JComboBox(wiersze);
        macierz2Wiersze.setSelectedIndex(0);
        macierz2Kolumny = new JComboBox(kolumny);
        macierz2Kolumny.setSelectedIndex(0);
        
        jscroll = new JScrollPane(listaRozwijana);
        jscrollMaciersz1Wiersze = new JScrollPane(macierz1Wiersze);
        jscrollMaciersz1Kolumny = new JScrollPane(macierz1Kolumny);
        jscrollMaciersz2Wiersze = new JScrollPane(macierz2Wiersze);
        jscrollMaciersz2Kolumny = new JScrollPane(macierz2Kolumny);
        
        jscroll.setPreferredSize(new Dimension(120, 40));
        jscrollMaciersz1Wiersze.setPreferredSize(new Dimension(120, 40));
        jscrollMaciersz1Kolumny.setPreferredSize(new Dimension(120, 40));
        jscrollMaciersz2Wiersze.setPreferredSize(new Dimension(120, 40));
        jscrollMaciersz2Kolumny.setPreferredSize(new Dimension(120, 40));
        
        jwymiar = new JLabel("Wybierz wymiar", SwingConstants.CENTER);
        jwierszMacierz1 = new JLabel("Liczba wierszy pierwszej macierzy", SwingConstants.CENTER);
        jkolumnaMacierz1 = new JLabel("Liczba kolumn pierwszej macierzy", SwingConstants.CENTER);
        jwierszMacierz2 = new JLabel("Liczba wierszy drugiej macierzy", SwingConstants.CENTER);
        jkolumnaMacierz2 = new JLabel("Liczba kolumn drugiej macierzy", SwingConstants.CENTER);
        
        listaRozwijana.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                int idx = listaRozwijana.getSelectedIndex();
                
                if(idx != -1) {
                    wymiar = wymiary[idx];
                } else {
                    jwymiar.setText("Podaj wymiar!");
                }
            }
            
        });
        
        macierz1Wiersze.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                int idx = macierz1Wiersze.getSelectedIndex();
                
                if(idx != -1) {
                    liczbaWierszyMacierz1 = wiersze[idx];                     
                } else {
                    jwierszMacierz1.setText("Podaj liczbę wierszy!");
                }
            }
            
        });
        
        macierz1Kolumny.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                int idx = macierz1Kolumny.getSelectedIndex();
                
                if(idx != -1) {
                    liczbaKolumnMacierz1 = kolumny[idx];
                } else {
                    jkolumnaMacierz1.setText("Podaj liczbę kolumn!");
                }
            }
            
        });
        
        macierz2Wiersze.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                int idx = macierz2Wiersze.getSelectedIndex();
                
                if(idx != -1) {
                    liczbaWierszyMacierz2 = wiersze[idx];
                } else {
                    jwierszMacierz2.setText("Podaj liczbę wierszy!");
                }
            }
            
        });
        
        macierz2Kolumny.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                int idx = macierz2Kolumny.getSelectedIndex();
                
                if(idx != -1) {
                    liczbaKolumnMacierz2 = kolumny[idx]; 
                } else {
                    jkolumnaMacierz2.setText("Podaj liczbę kolumn!");
                }
            }
            
        });
        
        czyBinarnie = new JCheckBox("Zapis binarny");
        czyBinarnie.setHorizontalAlignment(SwingConstants.CENTER);
        
        czyBinarnie.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                
                JCheckBox cb = (JCheckBox) e.getItem();
                
                if(cb.isSelected()) {
                    binarny = true;
                } else {
                    binarny = false;
                }
            }
        });
        
        frame.add(jlab);
        frame.add(pomnoz);
        frame.add(jwymiar);
        frame.add(jscroll);
        frame.add(jwierszMacierz1);
        frame.add(jscrollMaciersz1Wiersze);
        frame.add(jkolumnaMacierz1);
        frame.add(jscrollMaciersz1Kolumny);
        frame.add(jwierszMacierz2);
        frame.add(jscrollMaciersz2Wiersze);
        frame.add(jkolumnaMacierz2);
        frame.add(jscrollMaciersz2Kolumny);
        frame.add(czyBinarnie);
        frame.add(jhint);
        
        frame.add(wstecz);
        
        frame.setVisible(true);
    }
    
    
    public JFrame getFrame() {
        return frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Pomnóż":
                CG2N cialoGalois = new CG2N(Integer.parseInt(wymiar));
                if(liczbaWierszyMacierz1.equals(liczbaKolumnMacierz2) && liczbaKolumnMacierz1.equals(liczbaWierszyMacierz2)) {
                    if(wymiar != null) {
                        if(binarny == true) {
                            JOptionPane.showMessageDialog(null, DodawanieIMnozenieMacierzy.pomnoz(new Macierz(Integer.parseInt(liczbaWierszyMacierz1),
                                    Integer.parseInt(liczbaKolumnMacierz1), cialoGalois.getRozmiarCiala()),new Macierz(Integer.parseInt(liczbaWierszyMacierz2),
                                            Integer.parseInt(liczbaKolumnMacierz2),cialoGalois.getRozmiarCiala()), new MacierzCG2N(cialoGalois.getRozmiarCiala()),
                                            Integer.parseInt(wymiar)),"Wynik mnożenia macierzy przez macierz nad ciałem skończonym", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, DodawanieIMnozenieMacierzy.pomnozDziesietnie(new Macierz(Integer.parseInt(liczbaWierszyMacierz1),
                                    Integer.parseInt(liczbaKolumnMacierz1), cialoGalois.getRozmiarCiala()),new Macierz(Integer.parseInt(liczbaWierszyMacierz2),
                                            Integer.parseInt(liczbaKolumnMacierz2),cialoGalois.getRozmiarCiala()), new MacierzCG2N(cialoGalois.getRozmiarCiala())),
                                    "Wynik mnożenia macierzy przez macierz nad ciałem skończonym", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Proszę wprowadzić liczbę!");
                    }
                } else if(!liczbaWierszyMacierz1.equals(liczbaKolumnMacierz2)){
                    jhint.setText("Liczba wierszy pierwszej macierzy musi być równa liczbie kolumn drugiej");
                } else if(!liczbaKolumnMacierz1.equals(liczbaWierszyMacierz2)) {
                    jhint.setText("Liczba kolumn pierwszej macierzy musi być równa liczbie wierszy drugiej");
                }   break;
            case "Wstecz":
                frame1 = frame;
                frame1.setVisible(false);
                frame = new OperacjeMnozeniaMacierzyNadCialeSkonczonym().getFrame();
                break;
        }
    }
}
