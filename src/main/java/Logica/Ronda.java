
package Logica;

public class Ronda {
    
    private Juego juego;
    private int tematica;
    private int palabrasTotales;
    private int palabrasAdivinadas;
    private int palabrasNoAdivinadas;
    private int palabraActual;
    private int[] palabrasVsAciertos;
    
    public Ronda(Juego juego, int tematica, int palabrasTotales){
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
        int cantidadPalabras = juego.getPalabrasVsAciertos().length;
        int palabraEscogida = (int)(Math.random()*cantidadPalabras);
        return palabraEscogida;
    }
}
