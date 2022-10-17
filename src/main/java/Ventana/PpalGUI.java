
package Ventana;

import Logica.Juego;
import Logica.Palabra;
import Logica.Ronda;
import java.awt.Font;
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
    private Palabra palabra;
    private Juego juego;
    private Ronda ronda;
    
    public PpalGUI(Juego juego, Ronda ronda){
        this.juego = juego;
        this.ronda = ronda;
        iniciarComponentes();
        setSize(600,450);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ahorcado");
    
    
    }
    
    private void iniciarComponentes() {
        
        String intentosTotales = String.valueOf(palabra.getIntentosTotales());
        String intentosEjecutados = String.valueOf(palabra.getIntentosEjecutados());
        String intentosRestantes = String.valueOf(palabra.getIntentosTotales()-palabra.getIntentosEjecutados());

        //TEXTAREA
        txtAInfo = new JTextArea();
        txtAInfo.setEditable(false);
        txtAInfo.setFont(new Font("Calibri",Font.PLAIN,15));
        txtAInfo.setText("Temática: "+"");
        txtAInfo.append("\nIntentos totales: " + intentosTotales);
        txtAInfo.append("\nIntentos ejecutados: " + intentosEjecutados);
        txtAInfo.append("\nIntentos restantes: " + intentosRestantes);
        txtAInfo.setBounds(390, 20, 200, 180);
        this.add(txtAInfo);        
        
        //ETIQUETA DE LA PALABRA SECRETA
        lblPalabraSecreta = new JLabel();
        lblPalabraSecreta.setText(String.valueOf(palabra.getMiPalabra()));
        lblPalabraSecreta.setBounds(160, 100, 200, 30);
        
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
