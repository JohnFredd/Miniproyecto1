
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
        if (cambios == false) {
            intentosEjecutados += 1;
        }
        return cambios;
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
