
package Ventana;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ComoJugarGUI extends Plantilla implements ActionListener{
    protected JButton btnParaQueSirve;
    
    public ComoJugarGUI(String titulo){
        super(titulo);
    
    }
    
    public void iniciarComponentes(){
       
        //BOTON PARA QUE SIRVE
        btnParaQueSirve = new JButton("Para qué sirve");
        btnParaQueSirve.setEnabled(true);
        btnParaQueSirve.setVisible(true);
        btnParaQueSirve.setBounds(10, 370, 140,30);
        btnParaQueSirve.setForeground(Color.BLACK);
        btnParaQueSirve.setBackground(Color.WHITE);
        btnParaQueSirve.setFont(new Font("chiller",Font.BOLD,22));
        btnParaQueSirve.addActionListener(this);
        this.add(btnParaQueSirve);
        
        super.iniciarComponentes();
        txtAInfo.setText("""
                              El jugador deberá ingresar su nombre y presionar en el botón de continuar. 
                            
                              Antes de iniciar a jugar, se deberá de configurar la ronda de juego. 
                              Para ello, primero seleccione una de las temáticas para las palabras a adivinar 
                              disponibles en la lista desplegable, luego ingrese la cantidad de palabras 
                              que desea adivinar en la ronda.
                            
                              **Podrá adivinar un mínimo de 1 palabra y un máximo de 10 palabras**
                              
                              Presione en el botón JUGAR para comenzar la ronda de juego.
                              
                              Una vez comenzado el juego, el objetivo del jugador será adivinar la mayor 
                              cantidad de palabras, de acuerdo a la cantidad indicada.
                              En pantalla se mostrarán una serie de líneas, una por cada letra de la palabra 
                              a adivinar, indicando el largo de la misma.
                            
                              El jugador contará con 10 intentos para adivinar la palabra secreta. 
                              Podrá seleccionar las letras del abecedario en el orden en el que desee o 
                              deduzca y el sistema le indicará si pertenece a la palabra secreta o no.
                            
                              Cada vez que seleccione una de las letras, consumirá un intento. 
                              Si consume los 10 intentos disponibles antes de adivinar la palabra, se 
                              contará como palabra no adivinada y el jugador se ahorcará D:
                            
                              Se le preguntará si desea continuar con la siguiente palabra. 
                              Si desea continuar, tendrá 10 nuevos intentos para adivinar una nueva 
                              palabra de la misma temática.
                            
                              La ronda terminará cuando el jugador indique no continuar con otra 
                              palabra o cuando se hayan terminado la cantidad de palabras indicadas.
                            
                              Al finalizar cada ronda, se mostrarán las estadísticas de la misma y el 
                              jugador podrá iniciar una nueva ronda presionando en SI, indicando otra 
                              temática y cantidad de palabras a adivinar si así lo desea, o finalizar el 
                              juego, presionando en NO.
                              
                              Si elige no jugar otra ronda, se mostrarán las estadísticas generales de juego. 
                              Un nuevo jugador podrá comenzar un juego presionando en 
                              VOLVER AL INICIO.
                            
                              Dicho esto, a JUGAR!
                            
                            
                            """);    
        lblTitulo.setText("Para qué sirve");
        lblTitulo.setBounds(145, 22, 280,30);  // En minúsculas 430,22,130,30
    
    }
    
    
}
