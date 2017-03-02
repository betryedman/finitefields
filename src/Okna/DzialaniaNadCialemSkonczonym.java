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
public class DzialaniaNadCialemSkonczonym implements ActionListener{
    private final JLabel jlab;
    private final JButton dzialaniaNaLiczbach;
    private final JButton dzialaniaNaMacierzach;
    private final JButton dzialaniaNaWielomianach;
    private final JButton dzialaniaNaWektorach;
    private JFrame frame;
    private final JFrame frame1;
    
    public DzialaniaNadCialemSkonczonym() {
        frame = new JFrame("Działania nad ciałem skończonym");
        frame1 = frame;
        frame.setLayout(new GridLayout(8,5));
        
        frame.setSize(400, 700);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        dzialaniaNaLiczbach = new JButton("Działania na liczbach");
        dzialaniaNaMacierzach = new JButton("Działania na macierzach");
        dzialaniaNaWielomianach = new JButton("Działania na wielomianach");
        dzialaniaNaWektorach = new JButton("Działania na wiektorach");
        jlab = new JLabel("Naciśnij przycisk", SwingConstants.CENTER);
        
        dzialaniaNaLiczbach.addActionListener(this);
        dzialaniaNaMacierzach.addActionListener(this);
        dzialaniaNaWielomianach.addActionListener(this);
        dzialaniaNaWektorach.addActionListener(this);
        
        frame.add(jlab);
        frame.add(dzialaniaNaLiczbach);
        frame.add(dzialaniaNaMacierzach);
        frame.add(dzialaniaNaWielomianach);
        frame.add(dzialaniaNaWektorach);
        
        frame.setVisible(true);
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Działania na liczbach":
                frame = new DodawanieIMnozenieWCieleSkonczonym().getFrame();
                frame.setVisible(true);
                frame1.setVisible(false);
                break;
            case "Działania na macierzach":
                frame = new DziałaniaNaMacierzachNadCialemCieleSkonczonym().getFrame();
                frame.setVisible(true);
                frame1.setVisible(false);
                break;
            case "Działania na wielomianach":
                frame = new DzialaniaNaWielomianachNadCialemCieleSkonczonym().getFrame();
                frame.setVisible(true);
                frame1.setVisible(false);
                break;
            case "Działania na wiektorach":
                frame = new DzialaniaNaWektorachNadCialemSkonczonym ().getFrame();
                frame.setVisible(true);
                frame1.setVisible(false);
                break;
        }
    }
    
}
