
package Ventana;

import Logica.Juego;


public class ResultadosJuegoGUI extends Plantilla{
  
    private Juego juego;
    
    public ResultadosJuegoGUI(Juego juego){
        this.juego = juego;
        
    
    }
    
    public void iniciarComponentes(){
    
    super.iniciarComponentes();
    lblTitulo.setVisible(false);
    txtAInfo.setBounds(20, 76, 400, 260);
    txtAInfo.setText("\nCantidad de rondas jugadas: "+ juego.getCantidadRondas());
    txtAInfo.append("\nRonda de mayor acierto: "+ juego.getRondaMayorAcierto());
    txtAInfo.append("\nPorcentaje: "+ juego.getPorcentajeMayor());
    txtAInfo.append("\nRonda de menor acierto: "+ juego.getRondaMenorAcierto());
    txtAInfo.append("\nnPorcentaje: "+ juego.getPorcentajeMenor());
    }
}
