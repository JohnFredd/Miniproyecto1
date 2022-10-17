
package Ventana;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class ParaQueSirveGUI extends Plantilla implements ActionListener{
    protected JButton btnComoJugar;
    
    public ParaQueSirveGUI(String titulo){
        super(titulo);
    }
    
    public void iniciarComponentes(){      
        
        //BOTON COMO JUGAR
        btnComoJugar = new JButton("Cómo jugar");
        btnComoJugar.setEnabled(true);
        btnComoJugar.setVisible(true);
        btnComoJugar.setBounds(160, 370, 140,30);
        btnComoJugar.setForeground(Color.BLACK);
        btnComoJugar.setBackground(Color.WHITE);
        btnComoJugar.setFont(new Font("chiller",Font.BOLD,22));
        btnComoJugar.addActionListener(this);
        this.add(btnComoJugar);
      
        super.iniciarComponentes();
      
        //CONFIGURACION PLANTILLA
        txtAInfo.setText(""" 

                                   El tradicional juego del ahorcado pone a prueba el ingenio del jugador,
                                   su conocimiento del vocabulario involucrado y su capacidad de crear 
                                   estrategias para adivinar cada palabra y hacer deducciones, mientras 
                                   pasa un rato divertido jugando y aprendiendo al mismo tiempo.

                                   El juego del ahorcado se convierte en una estrategia divertida de 
                                   enseñanza, en donde los estudiantes podrán adquirir nuevo vocabulario,
                                   aprender reglas gramáticales y de pronunciación e incluso entrenar su 
                                   concentración y atención,de manera divertida.

                                 """);       

        lblTitulo.setText("Para qué sirve");
        lblTitulo.setBounds(145, 22, 280,30);  // En minúsculas 430,22,130,30    
    
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        super.actionPerformed(ae);
        if(ae.getSource() == btnComoJugar)
            irComoJugar();
    
    
    
    }
    
    //Abre ventana Como jugar
    public void irComoJugar(){
        /*ComoJugarGUI ventanaComoJugar = new ComoJugarGUI("Cómo jugar");
        ventanaComoJugar.setVisible(true);
        this.dispose();*/
    }
}
