/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Okna;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Grzegorz
 */
public class DzialaniaNaWektorachNadCialemSkonczonym implements ActionListener{
    private JFrame frame;
    private final JButton dodawanie;
    private final JButton mnozenie;
    private final JButton wstecz;
    private JFrame frame1;
    private final JLabel jlab;
    
    public DzialaniaNaWektorachNadCialemSkonczonym() {
        frame = new JFrame("Działania na wektorach nad ciałem skończonym");
        frame.setLayout(new GridLayout(8,5));
        
        frame.setSize(400, 700);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        dodawanie = new JButton("Dodawanie");
        mnozenie = new JButton("Mnożenie");
        wstecz = new JButton("Wstecz");
        
        dodawanie.addActionListener(this);
        mnozenie.addActionListener(this);
        wstecz.addActionListener(this);

        jlab = new JLabel("Naciśnij przycisk", SwingConstants.CENTER);
        
        frame.add(jlab);
        frame.add(dodawanie);
        frame.add(mnozenie);
        frame.add(wstecz);
        
        frame.setVisible(true);
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Dodawanie":
                frame1 = frame;
                frame = new DodawanieWektorowNadCialemSkonczonym().getFrame();
                frame.setVisible(true);
                frame1.setVisible(false);
                break;
            case "Mnożenie":
                frame1 = frame;
                frame = new MnozenieWektoraPrzezSkalarNadCialemSkonczonym().getFrame();
                frame.setVisible(true);
                frame1.setVisible(false);
                break;
            case "Wstecz":
                frame1 = frame;
                frame1.setVisible(false);
                frame = new DzialaniaNadCialemSkonczonym().getFrame();
                break;
        }
    }
    
}
