/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Okna;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 *
 * @author Grzegorz
 */
class OperacjeMnozeniaMacierzyNadCialeSkonczonym  implements ActionListener {
    private JFrame frame;
    private JFrame frame1;
    private JLabel jlab;
    private JComboBox listaRozwijana;
    private final JScrollPane jscroll;
    private JButton wybierz;
    private JButton wstecz;
    private String rodzajMnozenia = "macierz przez macierz";
    private String[] rodzajeMnozenia = new String[]{"macierz przez macierz", "wektor przez macierz"};
    
    public OperacjeMnozeniaMacierzyNadCialeSkonczonym() {
        frame = new JFrame("Operacje mnożenia macierzy nad ciałem skończonym");
        frame.setLayout(new GridLayout(8,5));
        
        frame.setSize(400, 700);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        wybierz = new JButton("Wybierz");    
        wstecz = new JButton("Wstecz");
        
        wybierz.addActionListener(this);
        wstecz.addActionListener(this);
        
        listaRozwijana = new JComboBox(rodzajeMnozenia);
        jscroll = new JScrollPane(listaRozwijana);
        jlab = new JLabel("Wybierz operacje", SwingConstants.CENTER);
        
        listaRozwijana.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                int idx = listaRozwijana.getSelectedIndex();
                
                if(idx != -1) {
                    rodzajMnozenia = rodzajeMnozenia[idx];
                } else {
                    jlab.setText("Podaj nazwę operacji!");
                }
            }
            
        });
        
        frame.add(jlab);
        frame.add(jscroll);
        frame.add(wybierz);
        frame.add(wstecz);
        
        frame.setVisible(true);
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Wybierz")) {
            if(rodzajMnozenia == "macierz przez macierz") {
                frame1 = frame;
                frame = new MnozenieMacierzyPrzezMacierzNadCialemSkonczonym().getFrame();
                
                frame1.setVisible(false);
            } else if(rodzajMnozenia == "wektor przez macierz") {
                frame1 = frame;
                frame = new MnozenieWektoraPrzezMacierzNadCialemSkonczonym().getFrame();
                
                frame1.setVisible(false);
            } 
        } else if(e.getActionCommand().equals("Wstecz")) {
                frame1 = frame;
                frame1.setVisible(false);
            
                frame = new DziałaniaNaMacierzachNadCialemCieleSkonczonym().getFrame();
        }
    }
    
}
