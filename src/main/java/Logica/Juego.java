
package Logica;

public class Juego {
    
    private String nombreJugador;
    private int cantidadRondas;
    private int rondaMayorAcierto;
    private double porcentajeMayor;
    private int rondaMenorAcierto;
    private double porcentajeMenor;
    private String palabraMasAcertada;
    private int aciertosPalabra;
    
    public Juego(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        cantidadRondas = 0;
        rondaMayorAcierto = 0;
        porcentajeMayor = 0;
        rondaMenorAcierto = 0;
        porcentajeMenor = 0;
        palabraMasAcertada = "";
        aciertosPalabra = 0;
    }
    
    public void actualizarDatosDeJuego(double porcentajeAciertoRonda, String palabraMasAcertada, int aciertosPalabra) {
        actualizarDatosDeRonda(porcentajeAciertoRonda);
        actualizarDatosDePalabra(palabraMasAcertada, aciertosPalabra);
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
    
    public void actualizarDatosDePalabra(String palabraMasAcertada, int aciertosPalabra) {
        if (this.aciertosPalabra<aciertosPalabra) {
            this.palabraMasAcertada = palabraMasAcertada;
            this.aciertosPalabra = aciertosPalabra;
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

    public String getPalabraMasAcertada() {
        return palabraMasAcertada;
    }

    public void setPalabraMasAcertada(String palabraMasAcertada) {
        this.palabraMasAcertada = palabraMasAcertada;
    }

    public int getAciertosPalabra() {
        return aciertosPalabra;
    }

    public void setAciertosPalabra(int aciertosPalabra) {
        this.aciertosPalabra = aciertosPalabra;
    }
}
