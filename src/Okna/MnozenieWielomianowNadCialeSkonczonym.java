/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Okna;

import CialoGalois.CG2N;
import CialoGalois.WielomianCG2N;
import KlasyDodatkowe.DodawanieIMnozenieWielomianow;
import KlasyElementarne.Wielomian;
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
public class MnozenieWielomianowNadCialeSkonczonym implements ActionListener{
    private JFrame frame;
    private JLabel jwymiar;
    private JFrame frame1;
    private JComboBox listaRozwijana;
    private JComboBox listaRozwijanaDlugosc1;
    private JComboBox listaRozwijanaDlugosc2;
    private final JScrollPane jscroll;
    private final JScrollPane jscrollDlugosc1;
    private final JScrollPane jscrollDlugosc2;
    private final JCheckBox czyBinarnie;
    private final JButton pomnoz;
    private boolean binarny;
    private String wymiar = "1";
    private final JButton wstecz;
    private static final String [] wymiary = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
                "28", "29", "30", "31"};
    private static final String [] dlugosc1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
                "28", "29", "30", "31"};
    private static final String [] dlugosc2 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
                "28", "29", "30", "31"};
    
    private String dlugoscWielomianu1 = "1";
    private String dlugoscWielomianu2 = "1";
    private JLabel jdlugosc1;
    private JLabel jdlugosc2;
    private JLabel jlab;
    
    public MnozenieWielomianowNadCialeSkonczonym() {
        frame = new JFrame("Mnożenie wielomianów nad ciałem skończonym");
        frame.setLayout(new GridLayout(8,5));
        
        frame.setSize(400, 700);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pomnoz = new JButton("Pomnóż");    
        wstecz = new JButton("Wstecz");
        
        pomnoz.addActionListener(this);
        wstecz.addActionListener(this);
        
        listaRozwijana = new JComboBox(wymiary);
        listaRozwijana.setSelectedIndex(0);
        listaRozwijanaDlugosc1 = new JComboBox(dlugosc1);
        listaRozwijanaDlugosc1.setSelectedIndex(0);
        listaRozwijanaDlugosc2 = new JComboBox(dlugosc2);
        listaRozwijanaDlugosc2.setSelectedIndex(0);
        
        jscroll = new JScrollPane(listaRozwijana);
        jscrollDlugosc1 = new JScrollPane(listaRozwijanaDlugosc1);
        jscrollDlugosc2 = new JScrollPane(listaRozwijanaDlugosc2);
        
        jscroll.setPreferredSize(new Dimension(120, 40));
        jscrollDlugosc1.setPreferredSize(new Dimension(120, 40));
        jscrollDlugosc2.setPreferredSize(new Dimension(120, 40));
        
        jlab = new JLabel("Naciśnij przycisk", SwingConstants.CENTER);
        jwymiar = new JLabel("Wybierz wymiar", SwingConstants.CENTER);
        jdlugosc1 = new JLabel("Podaj długośc pierwszego wielomianu", SwingConstants.CENTER);
        jdlugosc2 = new JLabel("Podaj długośc drugiego wielomianu", SwingConstants.CENTER);
        
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
        
        listaRozwijanaDlugosc1.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                int idx = listaRozwijanaDlugosc1.getSelectedIndex();
                
                if(idx != -1) {
                    dlugoscWielomianu1 = dlugosc1[idx];
                } else {
                    jdlugosc1.setText("Podaj długość wielomianu!");
                }
            }
            
        });
        
        listaRozwijanaDlugosc2.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                int idx = listaRozwijanaDlugosc2.getSelectedIndex();
                
                if(idx != -1) {
                    dlugoscWielomianu2 = dlugosc2[idx];
                } else {
                    jdlugosc2.setText("Podaj długość wielomianu!");
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
        frame.add(jdlugosc1);
        frame.add(jscrollDlugosc1);
        frame.add(jdlugosc2);
        frame.add(jscrollDlugosc2);
        frame.add(czyBinarnie);

        frame.add(wstecz);
        
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Pomnóż":
                CG2N cialoGalois = new CG2N(Integer.parseInt(wymiar));
                if(wymiar != null) {
                    if(binarny == true) {
                        JOptionPane.showMessageDialog(null, DodawanieIMnozenieWielomianow.pomnoz(
                                new Wielomian(Integer.parseInt(dlugoscWielomianu1), cialoGalois.getRozmiarCiala()),
                                new Wielomian(Integer.parseInt(dlugoscWielomianu2), cialoGalois.getRozmiarCiala()),
                                new WielomianCG2N(cialoGalois), Integer.parseInt(wymiar)),
                                "Wynik mnożenia wielomianu przez wielomian nad ciałem Skończonym", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, DodawanieIMnozenieWielomianow.pomnozDziesietnie(
                                new Wielomian(Integer.parseInt(dlugoscWielomianu1), cialoGalois.getRozmiarCiala()),
                                new Wielomian(Integer.parseInt(dlugoscWielomianu2), cialoGalois.getRozmiarCiala()),
                                new WielomianCG2N(cialoGalois)),
                                "Wynik mnożenia wielomianu przez wielomian nad ciałem skończonym", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Proszę wprowadzić liczbę!");
                }   break;
            case "Wstecz":
                frame1 = frame;
                frame1.setVisible(false);
                frame = new DzialaniaNaWielomianachNadCialemCieleSkonczonym().getFrame();
                break;
        }
    }
    
    public JFrame getFrame() {
        return frame;
    }
}
