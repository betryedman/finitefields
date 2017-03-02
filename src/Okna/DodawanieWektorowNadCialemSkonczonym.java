/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Okna;

import CialoGalois.CG2N;
import CialoGalois.WektorCG2N;
import KlasyDodatkowe.DodawanieImnozeniwWektorow;
import KlasyElementarne.Wektor;
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
public class DodawanieWektorowNadCialemSkonczonym implements ActionListener{
    private JFrame frame;
    private JLabel jwymiar;
    private JFrame frame1;
    private JComboBox listaRozwijana;
    private JComboBox listaRozwijanaDlugosc;
    private final JScrollPane jscroll;
    private final JScrollPane jscrollDlugosc;
    private final JCheckBox czyBinarnie;
    private final JButton dodaj;
    private boolean binarny;
    private String wymiar = "1";
    private final JButton wstecz;
    private static final String [] wymiary = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
                "28", "29", "30", "31"};
    private static final String [] dlugosc = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
                "28", "29", "30", "31"};
    
    private String dlugoscWektora = "1";
    private JLabel jdlugosc;
    private final JLabel jlab;
    
    public DodawanieWektorowNadCialemSkonczonym() {
        frame = new JFrame("Dodawanie wektorów nad ciałem skończonym");
        frame.setLayout(new GridLayout(8,5));
        
        frame.setSize(400, 700);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        dodaj = new JButton("Dodaj");    
        wstecz = new JButton("Wstecz");
        
        dodaj.addActionListener(this);
        wstecz.addActionListener(this);
        
        listaRozwijana = new JComboBox(wymiary);
        listaRozwijana.setSelectedIndex(0);
        listaRozwijanaDlugosc = new JComboBox(dlugosc);
        listaRozwijanaDlugosc.setSelectedIndex(0);
        
        jscroll = new JScrollPane(listaRozwijana);
        jscrollDlugosc = new JScrollPane(listaRozwijanaDlugosc);
        
        jscroll.setPreferredSize(new Dimension(120, 40));
        jscrollDlugosc.setPreferredSize(new Dimension(120, 40));
        
        jlab = new JLabel("Naciśnij przycisk", SwingConstants.CENTER);
        jwymiar = new JLabel("Wybierz wymiar", SwingConstants.CENTER);
        jdlugosc = new JLabel("Podaj długośc obu wektorów", SwingConstants.CENTER);
        
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
        
        listaRozwijanaDlugosc.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                int idx = listaRozwijanaDlugosc.getSelectedIndex();
                
                if(idx != -1) {
                    dlugoscWektora = dlugosc[idx];
                } else {
                    jdlugosc.setText("Podaj długość wielomianu!");
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
        frame.add(jdlugosc);
        frame.add(jscrollDlugosc);
        frame.add(czyBinarnie);

        frame.add(wstecz);
        
        frame.setVisible(true);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Dodaj":
                CG2N cialoGalois = new CG2N(Integer.parseInt(wymiar));
                if(wymiar != null) {
                    if(binarny == true) {
                        JOptionPane.showMessageDialog(null, DodawanieImnozeniwWektorow.dodaj(
                                new Wektor(Integer.parseInt(dlugoscWektora), cialoGalois.getRozmiarCiala()),
                                new Wektor(Integer.parseInt(dlugoscWektora), cialoGalois.getRozmiarCiala()),
                                new WektorCG2N(cialoGalois), Integer.parseInt(wymiar)),
                                "Wynik dodawania wektorów na ciałem skończonym", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, DodawanieImnozeniwWektorow.dodajDziesietnie(
                                new Wektor(Integer.parseInt(dlugoscWektora), cialoGalois.getRozmiarCiala()),
                                new Wektor(Integer.parseInt(dlugoscWektora), cialoGalois.getRozmiarCiala()),
                                new WektorCG2N(cialoGalois)),
                                "Wynik dodawania wektorów na ciałem skończonym", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Proszę wprowadzić liczbę!");
                }   break;
            case "Wstecz":
                frame1 = frame;
                frame1.setVisible(false);
                frame = new DzialaniaNaWektorachNadCialemSkonczonym().getFrame();
                break;
        }
    }
    
    public JFrame getFrame() {
        return frame;
    }
}
