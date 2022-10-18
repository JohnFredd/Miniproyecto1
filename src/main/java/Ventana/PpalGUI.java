
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
import javax.swing.JOptionPane;
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
    private JButton[] botones;
    
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
    }
    
    private void iniciarComponentes() {
        
        //NOMBRE JUGADOR
        lblNombreJugador = new JLabel(juego.getNombreJugador(),SwingConstants.CENTER);
        lblNombreJugador.setFont(new Font("Calibri", Font.BOLD,20));
        lblNombreJugador.setBounds(40, 30, 100, 30);
        this.add(lblNombreJugador);
        
        //TEXTAREA
        txtAInfo = new JTextArea();
        txtAInfo.setEditable(false);
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
        
        //IMAGEN DEL MUÑECO
        ImageIcon imagen1 = new ImageIcon("11.png");
        lblImagen = new JLabel();  
        lblImagen.setBounds(20, 30, 280, 560);
        lblImagen.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH)));
        this.add(lblImagen);
        panel1 = new JPanel();
        panel1.setBounds(295,320,260,240);
        panel1.setLayout(new java.awt.GridLayout(6, 5));
        panel1.setOpaque(false);
        
        //ALFABETO
        botones = new JButton[90-65+1];
        for(int i=65; i<=90; i++){
            botones[i-65] = new JButton(Character.toString ((char) i));
            botones[i-65].setBounds(0,0,15,15);
            botones[i-65].setForeground(Color.BLACK);
            botones[i-65].setBackground(Color.WHITE);
            botones[i-65].setActionCommand(Character.toString ((char) i));
            botones[i-65].setFocusPainted(false);
            botones[i-65].addActionListener(this);
            panel1.add(botones[i-65]); 
            }
    
        this.getContentPane().add(panel1);
        
        //IMAGEN FONDO
        ImageIcon fondo = new ImageIcon("fondo.jpg");
        lblFondo = new JLabel();  
        lblFondo.setBounds(0, 0, 600, 700);
        lblFondo.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_SMOOTH)));
        this.add(lblFondo);
        
    }
    public boolean finDeLaPalabra() {
        if (palabra.acerto()) {
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
        String str = e.getActionCommand();
        for (int i = 65; i<=90; i++) {
            if (e.getSource() == botones[i-65]) {
                botones[i-65].setEnabled(false);
                botones[i-65].setBackground(Color.BLACK);
                botones[i-65].setForeground(Color.WHITE);
            }
        }
        if (palabra.evaluarIntento(str.charAt(0))) {
            lblPalabraSecreta.setText(String.valueOf(palabra.getMiPalabra()));
        } else {
            String intentosTotales = String.valueOf(palabra.getIntentosTotales());
            String intentosEjecutados = String.valueOf(palabra.getIntentosEjecutados());
            String intentosRestantes = String.valueOf(palabra.getIntentosTotales()-palabra.getIntentosEjecutados());
            txtAInfo.setText("\nTemática: " + ronda.getTematica());
            txtAInfo.append("\nIntentos totales: " + intentosTotales);
            txtAInfo.append("\nIntentos ejecutados: "+intentosEjecutados);
            txtAInfo.append("\nIntentos restantes: "+ intentosRestantes);
            
            //actualizar interfaz
            ImageIcon imagenes = new ImageIcon(intentosEjecutados+".png");
            lblImagen.setIcon(new ImageIcon(imagenes.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH)));
        }
        
        if (finDeLaPalabra()) {
            if (ronda.getPalabrasTotales() -1 == ronda.getPalabraActual()) {
                if (palabra.acerto()) {
                    JOptionPane.showConfirmDialog(null, "¡¡¡Felicidades!!!. \nHas acertado la palabra", "Alerta!", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    ronda.actualizarDatos(palabra.getNumeroPalabra(),true);
                    irResultadosRonda();
                } else {
                    JOptionPane.showConfirmDialog(null, "¡¡¡Estás ahorcado!!!. \nNo has adivinado la palabra", "Alerta!", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    ronda.actualizarDatos(palabra.getNumeroPalabra(),false);
                    irResultadosRonda();
                }
            } else {
                if (palabra.acerto()) {
                    int resp = JOptionPane.showConfirmDialog(null, "¡¡¡Felicidades!!!. \nHas acertado la palabra\n¿Desesas continuar con las palabras restantes?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (resp == JOptionPane.NO_OPTION){
                        ronda.actualizarDatos(palabra.getNumeroPalabra(),true);
                        irResultadosRonda();
                    }
                    if (resp == JOptionPane.YES_OPTION){
                        ImageIcon imagenes = new ImageIcon("11.png");
                        lblImagen.setIcon(new ImageIcon(imagenes.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH)));
                        ronda.actualizarDatos(palabra.getNumeroPalabra(),true);
                        otraPalabra();
                        lblPalabraSecreta.setText(String.valueOf(palabra.getMiPalabra()));
                        for (int i = 65; i<=90; i++) {
                            botones[i-65].setEnabled(true);
                            botones[i-65].setBackground(Color.WHITE);
                            botones[i-65].setForeground(Color.BLACK);
                        }
                        String intentosTotales = String.valueOf(palabra.getIntentosTotales());
                        String intentosEjecutados = String.valueOf(palabra.getIntentosEjecutados());
                        String intentosRestantes = String.valueOf(palabra.getIntentosTotales()-palabra.getIntentosEjecutados());
                        txtAInfo.setText("\nTemática: " + ronda.getTematica());
                        txtAInfo.append("\nIntentos totales: " + intentosTotales);
                        txtAInfo.append("\nIntentos ejecutados: "+intentosEjecutados);
                        txtAInfo.append("\nIntentos restantes: "+ intentosRestantes);
                    }
                } else {
                    int resp = JOptionPane.showConfirmDialog(null, "¡¡¡Estás ahorcado!!!. \nNo has adivinado la palabra\n¿Desesas continuar con las palabras restantes?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (resp == JOptionPane.NO_OPTION){
                        ronda.actualizarDatos(palabra.getNumeroPalabra(),false);
                        irResultadosRonda();
                    }
                    if (resp == JOptionPane.YES_OPTION){
                        ImageIcon imagenes = new ImageIcon("11.png");
                        lblImagen.setIcon(new ImageIcon(imagenes.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH)));
                        ronda.actualizarDatos(palabra.getNumeroPalabra(),false);
                        otraPalabra();
                        lblPalabraSecreta.setText(String.valueOf(palabra.getMiPalabra()));
                        for (int i = 65; i<=90; i++) {
                            botones[i-65].setEnabled(true);
                            botones[i-65].setBackground(Color.WHITE);
                            botones[i-65].setForeground(Color.BLACK);
                        }
                        String intentosTotales = String.valueOf(palabra.getIntentosTotales());
                        String intentosEjecutados = String.valueOf(palabra.getIntentosEjecutados());
                        String intentosRestantes = String.valueOf(palabra.getIntentosTotales()-palabra.getIntentosEjecutados());
                        txtAInfo.setText("\nTemática: " + ronda.getTematica());
                        txtAInfo.append("\nIntentos totales: " + intentosTotales);
                        txtAInfo.append("\nIntentos ejecutados: "+intentosEjecutados);
                        txtAInfo.append("\nIntentos restantes: "+ intentosRestantes);
                    }
                }
            }
        }
    }
}
