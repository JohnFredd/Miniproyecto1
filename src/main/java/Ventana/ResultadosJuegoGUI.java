
package Ventana;

import Logica.Juego;


public class ResultadosJuegoGUI extends Plantilla{
    
    public ResultadosJuegoGUI(String titulo, Juego juego){
        super(titulo);
        obtenerEstadisticas(juego);
    }
    
    public void iniciarComponentes(){
    
    super.iniciarComponentes();
    
    //CONFIGURACION SOBRE PLANTILLA
    lblTitulo.setVisible(false);
    scroll.setBounds(120, 50, 345, 230);
    }
    
    public void obtenerEstadisticas(Juego juego) {
        int total = juego.getCantidadRondas();
        int mayor = juego.getRondaMayorAcierto();
        double percMayor = juego.getPorcentajeMayor();
        int menor = juego.getRondaMenorAcierto();
        double percMenor = juego.getPorcentajeMenor();
        int palabras[] = juego.getPalabrasVsAciertos();
        int numPalabraMasAcertada = 0;
        for(int i=0;i<palabras.length;i++) {
            if (palabras[i]>numPalabraMasAcertada) {
                numPalabraMasAcertada = i;
            }
        }
        String txtPalabraMasAcertada = juego.getPalabrasVsTematica()[numPalabraMasAcertada][0];
        
        txtAInfo.setText("\n   Cantidad de rondas jugadas:   ");
        txtAInfo.append(String.valueOf(total) + "\n");
        txtAInfo.append("\n   Ronda de mayor acierto:   ");
        txtAInfo.append(String.valueOf(mayor) + "\n");
        txtAInfo.append("   Porcentaje:   ");
        txtAInfo.append(String.valueOf(percMayor) + "%\n");
        txtAInfo.append("\n   Ronda de menor acierto:   ");
        txtAInfo.append(String.valueOf(menor) + "\n");
        txtAInfo.append("   Porcentaje:   ");
        txtAInfo.append(String.valueOf(percMenor) + "%\n");
        txtAInfo.append("\n   Palabra más acertada:   ");
        txtAInfo.append(txtPalabraMasAcertada);
    }
}
