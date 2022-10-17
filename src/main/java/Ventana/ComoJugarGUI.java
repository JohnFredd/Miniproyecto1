
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
    
    
    
    }
    
    
}
