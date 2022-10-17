
package Ventana;

import Logica.Juego;
import Logica.Palabra;
import Logica.Ronda;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
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
    //private JButton[] letras;
    private JLabel lblImagen;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private Palabra palabra;
    private Juego juego;
    private Ronda ronda;
    
    public PpalGUI(Juego juego, Ronda ronda){
        super("GridBagLayout");
        this.juego = juego;
        this.ronda = ronda;
        this.setSize(650,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ahorcado");
        iniciarComponentes();
    
    
    }
    
    private void iniciarComponentes() {
        
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        
        panel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel1.setLayout(new java.awt.BorderLayout());
        
        
        
        lblImagen = new JLabel();
        ImageIcon imagenes = new ImageIcon("/RecursosImages/1.png");
        lblImagen.setIcon(new ImageIcon(imagenes.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH)));
        
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
