
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
        palabrasVsAciertos = new int[6];
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
        /*int cantidadPalabras = juego.getPalabrasVsAciertos().length;
        int palabraEscogida = (int)(Math.random()*cantidadPalabras);
        return palabraEscogida;*/
    }
}
