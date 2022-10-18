
package Logica;

public class Juego {
    
    private String nombreJugador;
    private int cantidadRondas;
    private int rondaMayorAcierto;
    private double porcentajeMayor;
    private int rondaMenorAcierto;
    private double porcentajeMenor;
    private int[] palabrasVsAciertos;
    private String[][] palabrasVsTematica = {
    {"PERRO","Animales"},
    {"GATO","Animales"},
    {"AMARILLO","Colores"},
    {"AZUL","Colores"},
    {"PAPAYA","Frutas"},
    {"MANZANA","Frutas"}};
    
    public Juego(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        cantidadRondas = 0;
        rondaMayorAcierto = 0;
        porcentajeMayor = 0;
        rondaMenorAcierto = 0;
        porcentajeMenor = 0;
        palabrasVsAciertos = new int[palabrasVsTematica.length];
    }
    
    public void actualizarDatosDeJuego(double porcentajeAciertoRonda, int[] palabrasVsAciertos) {
        actualizarDatosDeRonda(porcentajeAciertoRonda);
        actualizarDatosDePalabra(palabrasVsAciertos);
    }
    
    public void actualizarDatosDeRonda(double porcentajeAciertoRonda) {
        cantidadRondas += 1;
        
        if (porcentajeMayor<porcentajeAciertoRonda) {
            rondaMayorAcierto = cantidadRondas;
            porcentajeMayor = porcentajeAciertoRonda;
        }
        
        if (porcentajeMenor>porcentajeAciertoRonda) {
            rondaMenorAcierto = cantidadRondas;
            porcentajeMenor = porcentajeAciertoRonda;
        }
    }
    
    public void actualizarDatosDePalabra(int[] palabrasVsAciertos) {
        for (int i = 0;i<this.palabrasVsAciertos.length;i++) {
            this.palabrasVsAciertos[i] += palabrasVsAciertos[i];
        }
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getCantidadRondas() {
        return cantidadRondas;
    }

    public void setCantidadRondas(int cantidadRondas) {
        this.cantidadRondas = cantidadRondas;
    }

    public int getRondaMayorAcierto() {
        return rondaMayorAcierto;
    }

    public void setRondaMayorAcierto(int rondaMayorAcierto) {
        this.rondaMayorAcierto = rondaMayorAcierto;
    }

    public double getPorcentajeMayor() {
        return porcentajeMayor;
    }

    public void setPorcentajeMayor(double porcentajeMayor) {
        this.porcentajeMayor = porcentajeMayor;
    }

    public int getRondaMenorAcierto() {
        return rondaMenorAcierto;
    }

    public void setRondaMenorAcierto(int rondaMenorAcierto) {
        this.rondaMenorAcierto = rondaMenorAcierto;
    }

    public double getPorcentajeMenor() {
        return porcentajeMenor;
    }

    public void setPorcentajeMenor(double porcentajeMenor) {
        this.porcentajeMenor = porcentajeMenor;
    }

    public int[] getPalabrasVsAciertos() {
        return palabrasVsAciertos;
    }

    public void setPalabrasVsAciertos(int[] palabrasVsAciertos) {
        this.palabrasVsAciertos = palabrasVsAciertos;
    }

    public String[][] getPalabrasVsTematica() {
        return palabrasVsTematica;
    }

    public void setPalabrasVsTematica(String[][] palabrasVsTematica) {
        this.palabrasVsTematica = palabrasVsTematica;
    }
}
