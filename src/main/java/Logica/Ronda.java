
package Logica;

import java.util.LinkedList;

public class Ronda {
    
    private Juego juego;
    private String tematica;
    private int palabrasTotales;
    private int palabrasAdivinadas;
    private int palabrasNoAdivinadas;
    private int palabraActual;
    private int[] palabrasVsAciertos;
    
    public Ronda(Juego juego, String tematica, int palabrasTotales){
        this.juego = juego;
        this.tematica = tematica;
        this.palabrasTotales = palabrasTotales;
        palabrasAdivinadas = 0;
        palabrasNoAdivinadas = 0;
        palabraActual = 0;
        palabrasVsAciertos = new int[18];
    }
    
    public void actualizarDatos(int palabra, boolean aciertaPalabra) {
        if (aciertaPalabra == true) {
            palabrasAdivinadas += 1;
            palabrasVsAciertos[palabra] += 1;
        } else {
            palabrasNoAdivinadas += 1;
        }
        palabraActual += 1;
    }
    
    public int escogerPalabra() {
        int palabraEscogida;
        while(true) {
            palabraEscogida = (int)(Math.random()*juego.getPalabrasVsTematica().length);
            if (juego.getPalabrasVsTematica()[palabraEscogida][1] == tematica) {
                break;
            }
        }
        return palabraEscogida;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public int getPalabrasTotales() {
        return palabrasTotales;
    }

    public void setPalabrasTotales(int palabrasTotales) {
        this.palabrasTotales = palabrasTotales;
    }

    public int getPalabrasAdivinadas() {
        return palabrasAdivinadas;
    }

    public void setPalabrasAdivinadas(int palabrasAdivinadas) {
        this.palabrasAdivinadas = palabrasAdivinadas;
    }

    public int getPalabrasNoAdivinadas() {
        return palabrasNoAdivinadas;
    }

    public void setPalabrasNoAdivinadas(int palabrasNoAdivinadas) {
        this.palabrasNoAdivinadas = palabrasNoAdivinadas;
    }

    public int getPalabraActual() {
        return palabraActual;
    }

    public void setPalabraActual(int palabraActual) {
        this.palabraActual = palabraActual;
    }

    public int[] getPalabrasVsAciertos() {
        return palabrasVsAciertos;
    }

    public void setPalabrasVsAciertos(int[] palabrasVsAciertos) {
        this.palabrasVsAciertos = palabrasVsAciertos;
    }
    
    
}
