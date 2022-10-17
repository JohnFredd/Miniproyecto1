
package Logica;

import Ventana.ResultadosRondaGUI;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Palabra {
    private int intentosTotales;
    private int intentosEjecutados;
    private char[] palabraSecreta;
    private char[] miPalabra;
    private boolean aciertaPalabra;
    private int numeroPalabra;
    private JLabel lblImagen; //
    private Ronda ronda;  //
    private Juego juego;  //
    
    public Palabra(int numeroPalabra, Juego juego) {  //Palabra(int numeroPalabra, Juego juego, lblImagen, ronda(?
   
        intentosTotales = 10;
        intentosEjecutados = 0;
        palabraSecreta = juego.getPalabrasVsTematica()[numeroPalabra][0].toCharArray();
        char miPalabra[] = new char[palabraSecreta.length];
        for (int i = 0;i<miPalabra.length;i++) {
            miPalabra[i] = '_';
        }
        aciertaPalabra = false;
        this.numeroPalabra = numeroPalabra;
        //this.lblImagen = lblImagen;
        //ImageIcon imagenes = new ImageIcon("/RecursosImages/1.png");
        //lblImagen.setIcon(new ImageIcon(imagenes.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH)));

    }
    /*
    public boolean evaluarIntento(char letraIngresada) {
        boolean cambios = false;
        for (int i = 0;i<palabraSecreta.length;i++) {
            if (letraIngresada == palabraSecreta[i]) {
                miPalabra[i] = palabraSecreta[i];
                cambios = true;
            } else {
                intentosEjecutados +=1;
                //actualizar interfaz
                ImageIcon imagenes = new ImageIcon("/RecursosImages/"+this.intentosEjecutados+".png");
                lblImagen.setIcon(new ImageIcon(imagenes.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH)));
            } 
        }
        return cambios;
    }
    */
    
    public boolean evaluarIntento(char letraIngresada) {
        boolean cambios = false;
        if (intentosEjecutados == intentosTotales){
            mostrarAdNoAdivinoPalabra();
        
        }
        
        for (int i = 0;i<palabraSecreta.length;i++) {
            if (letraIngresada == palabraSecreta[i]) {
                miPalabra[i] = palabraSecreta[i];
                cambios = true;
            } else {
                intentosEjecutados +=1;
                //actualizar interfaz
                ImageIcon imagenes = new ImageIcon("/RecursosImages/"+this.intentosEjecutados+".png");
                lblImagen.setIcon(new ImageIcon(imagenes.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH)));
            } 
        }
        return cambios;
    }

    public void mostrarAdNoAdivinoPalabra(){
        //int palabrasTotales = Integer.parseInt(txtPalPorRonda.getText());                                     //ronda.getPalabrasTotales()
       
        int resp = JOptionPane.showConfirmDialog(null, "¡¡¡Estás ahorcado!!!. \nNo has adivinado la palabra\nDesesas continuar con las", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (resp == JOptionPane.NO_OPTION){
            irResultadosRonda();
        }
        if (resp == JOptionPane.YES_OPTION){
        //
        }
    
    
    }
    //
    public void irResultadosRonda(){
        ResultadosRondaGUI ventanaResulRonda = new ResultadosRondaGUI("Resultados de ronda", ronda, juego);
        ventanaResulRonda.setVisible(true);
        this.dispose();
    }
    public boolean acerto() {
        return palabraSecreta == miPalabra;
    }

    public int getIntentosTotales() {
        return intentosTotales;
    }

    public void setIntentosTotales(int intentosTotales) {
        this.intentosTotales = intentosTotales;
    }

    public int getIntentosEjecutados() {
        return intentosEjecutados;
    }

    public void setIntentosEjecutados(int intentosEjecutados) {
        this.intentosEjecutados = intentosEjecutados;
    }

    public char[] getPalabraSecreta() {
        return palabraSecreta;
    }

    public void setPalabraSecreta(char[] palabraSecreta) {
        this.palabraSecreta = palabraSecreta;
    }

    public char[] getMiPalabra() {
        return miPalabra;
    }

    public void setMiPalabra(char[] miPalabra) {
        this.miPalabra = miPalabra;
    }

    public boolean isAciertaPalabra() {
        return aciertaPalabra;
    }

    public void setAciertaPalabra(boolean aciertaPalabra) {
        this.aciertaPalabra = aciertaPalabra;
    }

    public int getNumeroPalabra() {
        return numeroPalabra;
    }

    public void setNumeroPalabra(int numeroPalabra) {
        this.numeroPalabra = numeroPalabra;
    }
}
