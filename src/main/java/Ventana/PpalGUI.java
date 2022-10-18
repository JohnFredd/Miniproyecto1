
package Ventana;

import Logica.Juego;
import Logica.Palabra;
import Logica.Ronda;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class PpalGUI extends JFrame implements ActionListener{

    private JLabel lblFondo;
    private JLabel lblNombreJugador;
    private JLabel lblPalabraSecreta;
    private JTextArea txtAInfo;
    private JLabel lblImagen;
    private JPanel panel1;
    private Palabra palabra;
    private Juego juego;
    private Ronda ronda;
    
    public PpalGUI(Juego juego, Ronda ronda){
        this.juego = juego;
        this.ronda = ronda;
        otraPalabra();
        iniciarComponentes();
        setSize(600,700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ahorcado");
        setVisible(true);
    }
    
    private void iniciarComponentes() {

        //TEXTAREA
        txtAInfo = new JTextArea();
        txtAInfo.setEditable(false);
        txtAInfo.setVisible(true);

        String intentosTotales = String.valueOf(palabra.getIntentosTotales());
        String intentosEjecutados = String.valueOf(palabra.getIntentosEjecutados());
        String intentosRestantes = String.valueOf(palabra.getIntentosTotales()-palabra.getIntentosEjecutados());
        
        txtAInfo.setFont(new Font("Calibri",Font.PLAIN,16));
        txtAInfo.setText("\nTemática: " + ronda.getTematica());
        txtAInfo.append("\nIntentos totales: " + intentosTotales);
        txtAInfo.append("\nIntentos ejecutados: "+intentosEjecutados);
        txtAInfo.append("\nIntentos restantes: "+ intentosRestantes);
        txtAInfo.setBounds(345, 65, 160, 100);
        this.add(txtAInfo);

        //LBL PALABRA SECRETA
        lblPalabraSecreta = new JLabel(String.valueOf(palabra.getMiPalabra()), SwingConstants.CENTER);
        lblPalabraSecreta.setFont(new Font("Calibri",Font.BOLD,30));
        lblPalabraSecreta.setBounds(318, 260, 220, 30);
        this.add(lblPalabraSecreta);

        //FONDO
        ImageIcon imagen1 = new ImageIcon("10.png");
        lblImagen = new JLabel();  
        lblImagen.setBounds(20, 30, 280, 560);
        lblImagen.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH)));
        this.add(lblImagen);
    
        panel1 = new JPanel();
        panel1.setBounds(295,320,260,240);
        panel1.setLayout(new java.awt.GridLayout(6, 5));
        
        //ALFABETO
        for(int i=65; i<=90; i++){
            JButton boton = new JButton(Character.toString ((char) i));
            boton.setBounds(0,0,15,15);
            boton.setForeground(Color.BLACK);
            boton.setBackground(Color.WHITE);
            boton.setActionCommand(Character.toString ((char) i));
            boton.addActionListener(this);            
            panel1.add(boton); 
            }   
    
        this.getContentPane().add(panel1);
        //IMAGEN JUEGO
        ImageIcon fondo = new ImageIcon("fondo.jpg");
        lblFondo = new JLabel();  
        lblFondo.setBounds(0, 0, 600, 700);
        lblFondo.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_SMOOTH)));
        this.add(lblFondo);    
        }        
    public boolean finDeLaPalabra() {
        if (palabra.acerto() == true) {
            return true;
        }
        return palabra.getIntentosEjecutados() == palabra.getIntentosTotales();
    }
    
    public void otraPalabra() {
        int numPalabra = ronda.escogerPalabra();
        palabra = new Palabra(numPalabra, juego);
    }
    
    public void irResultadosRonda() {
        ResultadosRondaGUI ventanaResultadosRonda = new ResultadosRondaGUI("Resultados ronda", ronda, juego);
        ventanaResultadosRonda.setVisible(true);
        this.dispose();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}

    

