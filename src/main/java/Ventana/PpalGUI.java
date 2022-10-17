
package Ventana;

import Logica.Juego;
import Logica.Ronda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PpalGUI extends JFrame implements ActionListener{

    private JLabel lblFondo;
    private JLabel lblNombreJugador;
    private JLabel lblPalabraSecreta;
    private JTextArea txtAInfo;
    private JButton[] letras;
    private JLabel imagen;
    private JPanel panel1;
    
    public PpalGUI(Juego juego, Ronda ronda){
        iniciarComponentes();
        setSize(600,450);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ahorcado");
    
    
    }
    
    private void iniciarComponentes() {
        
        //Teclado alfabetico
        panel1.setLayout(new java.awt.GridLayout(6, 5));
        panel1.setBounds(100, 100, 50, 50);
        for(int i=65; i<=90; i++){
            JButton boton = new JButton(Character.toString ((char) i));
            boton.setActionCommand(Character.toString ((char) i));
            boton.addActionListener(this);            
            panel1.add(boton);    
        }        
       


    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
