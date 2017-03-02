/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Okna;

import KlasyDodatkowe.DodawanieIMnozenieLiczb;
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
public class DodawanieIMnozenieWCieleSkonczonym implements ActionListener{
    private final JLabel jlab;
    private JLabel jwymiar;
    private JComboBox listaRozwijana;
    private final JScrollPane jscroll;
    private final JCheckBox czyBinarnie;
    private final JButton tabliczkaDodawania;
    private final JButton tabliczkaMnozenia;
    private final JButton wstecz;
    private JFrame frame;
    private boolean binarny;
    private String wymiar = "1";
    private static final String [] wymiary = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
                "28", "29", "30", "31"};
    private JFrame frame1;
    
    //@SuppressWarnings({"LeakingThisInConstructor", "Convert2Lambda"})
    public DodawanieIMnozenieWCieleSkonczonym() {
 
        frame = new JFrame("Tabliczka dodawania liczb nad ciałem skończonym");
        frame.setLayout(new GridLayout(8,5));
        
        frame.setSize(400, 700);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        tabliczkaDodawania = new JButton("Tabliczka dodawania");
        tabliczkaMnozenia = new JButton("Tabliczka mnożenia");
        wstecz = new JButton("Wstecz");
        
        tabliczkaDodawania.addActionListener(this);
        tabliczkaMnozenia.addActionListener(this);
        wstecz.addActionListener(this);
 
        jlab = new JLabel("Naciśnij przycisk", SwingConstants.CENTER);

        listaRozwijana = new JComboBox(wymiary);
        listaRozwijana.setSelectedIndex(0);
        jscroll = new JScrollPane(listaRozwijana);
        
        jscroll.setPreferredSize(new Dimension(120, 40));
        
        jwymiar = new JLabel("Wybierz wymiar", SwingConstants.CENTER);
        
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
        frame.add(tabliczkaDodawania);
        frame.add(tabliczkaMnozenia);
        frame.add(jwymiar);
        frame.add(jscroll);
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
            case "Tabliczka dodawania":
                if(wymiar != null) {
                    if(binarny == true) {
                        JOptionPane.showMessageDialog(null, DodawanieIMnozenieLiczb.tabliczkaDodawania(Integer.parseInt(wymiar)),
                                "Tabliczka dodawania liczb nad ciałem skończonym", JOptionPane.INFORMATION_MESSAGE);
                    } else if(binarny == false) {
                        JOptionPane.showMessageDialog(null, DodawanieIMnozenieLiczb.tabliczkaDodawaniaDziesietnie(Integer.parseInt(wymiar)),
                                "Tabliczka dodawania liczb nad ciałem skończonym", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Proszę wprowadzić liczbę!");
                }   break;
            case "Tabliczka mnożenia":
                if(wymiar != null) {
                    if(binarny == true) {
                        JOptionPane.showMessageDialog(null, DodawanieIMnozenieLiczb.tabliczkaMnoenia(Integer.parseInt(wymiar)),
                                "Tabliczka mnożenia liczb nad ciałem skończonym", JOptionPane.INFORMATION_MESSAGE);
                    } else if(binarny == false){
                        JOptionPane.showMessageDialog(null, DodawanieIMnozenieLiczb.tabliczkaMnoeniaDziesietnie(Integer.parseInt(wymiar)),
                                "Tabliczka mnożenia liczb nad ciałem skończonym", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Proszę wprowadzić liczbę!");
                }   break;
            case "Wstecz":
                frame1 = frame;
                frame1.setVisible(false);
                frame = new DzialaniaNadCialemSkonczonym().getFrame();
                break;
        }
    }
}
