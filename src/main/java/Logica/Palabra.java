
package Logica;

public class Palabra {
    
    private int intentosTotales;
    private int intentosEjecutados;
    private char[] palabraSecreta;
    private char[] miPalabra;
    private boolean aciertaPalabra;
    private int numeroPalabra;
    
    public Palabra(int numeroPalabra, Juego juego) {
        intentosTotales = 10;
        intentosEjecutados = 0;
        palabraSecreta = juego.getPalabrasVsTematica()[numeroPalabra][0].toCharArray();
        char miPalabra[] = new char[palabraSecreta.length];
        for (int i = 0;i<miPalabra.length;i++) {
            miPalabra[i] = '_';
        }
        aciertaPalabra = false;
        this.numeroPalabra = numeroPalabra;
    }
    
    public boolean evaluarIntento(char letraIngresada) {
        boolean cambios = false;
        for (int i = 0;i<palabraSecreta.length;i++) {
            if (letraIngresada == palabraSecreta[i]) {
                miPalabra[i] = palabraSecreta[i];
                cambios = true;
            }
        }
        return cambios;
    }
    
    public boolean acerto() {
        return palabraSecreta == miPalabra;
    }
}
