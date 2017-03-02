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
public class DodawanieMacierzyNadCialeSkonczonym implements ActionListener {
    private final JLabel jlab;
    private JLabel jwymiar;
    private JFrame frame;
    private JFrame frame1;
    private JComboBox listaRozwijana;
    private JComboBox listaRozwijanaWierszy;
    private JComboBox listaRozwijanaKolumn;
    private final JScrollPane jscroll;
    private final JScrollPane jscrollWierszy;
    private final JScrollPane jscrollKolumn;
    private final JCheckBox czyBinarnie;
    private final JButton dodaj;
    private boolean binarny;
    private String wymiar = "1";
    private final JButton wstecz;
    private static final String [] wymiary = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
                "28", "29", "30", "31"};
    private static final String [] wiersze = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
                "28", "29", "30", "31"};
    private static final String [] kolumny = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
                "28", "29", "30", "31"};
    private String liczbaWierszy = "1";
    private String liczbaKolumn = "1";
    private JLabel jkolumna;
    private JLabel jwiersz;
    
    public DodawanieMacierzyNadCialeSkonczonym() {
        frame = new JFrame("Dodawanie macierzy nad ciałem skońconym");
        frame.setLayout(new GridLayout(8,5));
        
        frame.setSize(400, 700);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        dodaj = new JButton("Dodaj"); 
        wstecz = new JButton("Wstecz");
        jlab = new JLabel("Naciśnij przycisk", SwingConstants.CENTER);
        
        dodaj.addActionListener(this);
        wstecz.addActionListener(this);
        
        listaRozwijana = new JComboBox(wymiary);
        listaRozwijana.setSelectedIndex(0);
        listaRozwijanaWierszy = new JComboBox(wiersze);
        listaRozwijanaWierszy.setSelectedIndex(0);
        listaRozwijanaKolumn = new JComboBox(kolumny);
        listaRozwijanaKolumn.setSelectedIndex(0);
        
        jscroll = new JScrollPane(listaRozwijana);
        jscrollWierszy = new JScrollPane(listaRozwijanaWierszy);
        jscrollKolumn = new JScrollPane(listaRozwijanaKolumn);
        
        jscroll.setPreferredSize(new Dimension(120, 40));
        jscrollWierszy.setPreferredSize(new Dimension(120, 40));
        jscrollKolumn.setPreferredSize(new Dimension(120, 40));
        
        jwymiar = new JLabel("Wybierz wymiar", SwingConstants.CENTER);
        jwiersz = new JLabel("Podaj liczbę wierszy", SwingConstants.CENTER);
        jkolumna = new JLabel("Podaj liczbę kolumn", SwingConstants.CENTER);
        
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
        
        listaRozwijanaWierszy.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                int idx = listaRozwijanaWierszy.getSelectedIndex();
                
                if(idx != -1) {
                    liczbaWierszy = wiersze[idx];
                } else {
                    jwiersz.setText("Podaj liczbę wierszy!");
                }
            }
            
        });
        
        listaRozwijanaKolumn.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                int idx = listaRozwijanaKolumn.getSelectedIndex();
                
                if(idx != -1) {
                    liczbaKolumn = kolumny[idx];
                } else {
                    jkolumna.setText("Podaj liczbę kolumn!");
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
        frame.add(dodaj);
        frame.add(jwymiar);
        frame.add(jscroll);
        frame.add(jwiersz);
        frame.add(jscrollWierszy);
        frame.add(jkolumna);
        frame.add(jscrollKolumn);
        frame.add(czyBinarnie);

        frame.add(wstecz);
        
        frame.setVisible(true);
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Dodaj":
                CG2N cialoGalois = new CG2N(Integer.parseInt(wymiar));
                if(wymiar != null) {
                    if(binarny == true) {
                        JOptionPane.showMessageDialog(null, DodawanieIMnozenieMacierzy.dodaj(new Macierz(Integer.parseInt(liczbaWierszy),
                                Integer.parseInt(liczbaKolumn), cialoGalois.getRozmiarCiala()),new Macierz(Integer.parseInt(liczbaWierszy),
                                Integer.parseInt(liczbaKolumn),cialoGalois.getRozmiarCiala()), new MacierzCG2N(cialoGalois.getRozmiarCiala()),
                                Integer.parseInt(wymiar)),"Wynik dodawania macierzy nad ciałem skończonym", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, DodawanieIMnozenieMacierzy.dodajDziesietnie(new Macierz(Integer.parseInt(liczbaWierszy),
                                Integer.parseInt(liczbaKolumn), cialoGalois.getRozmiarCiala()),new Macierz(Integer.parseInt(liczbaWierszy),
                                Integer.parseInt(liczbaKolumn),cialoGalois.getRozmiarCiala()), new MacierzCG2N(cialoGalois.getRozmiarCiala())),
                                "Wynik mnożenia macierzy nad ciałem skończonym", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Proszę wprowadzić liczbę!");
                }   break;
            case "Wstecz":
                frame1 = frame;
                frame1.setVisible(false);
                frame = new DziałaniaNaMacierzachNadCialemCieleSkonczonym().getFrame();
                break;
        }
    }
    
}
