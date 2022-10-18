
package Ventana;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InicioGUI2 extends Plantilla implements ActionListener{
    
    
    private JLabel lblIngresarNombre;
    private JTextField txtIngresarNombre;
    private JButton btnParaQueSirve;
    private JButton btnContinuar;
    private JButton btnComoJugar;

    public InicioGUI2(String titulo){
        super(titulo);
        esNumero(txtIngresarNombre);
        }
    
    @Override
    public void iniciarComponentes() {
        
        //ETIQUETA INGRESAR NOMBRE
        lblIngresarNombre = new JLabel("Ingresa tu nombre", SwingConstants.CENTER);
        lblIngresarNombre.setBounds(418, 300, 140,30);
        lblIngresarNombre.setFont(new Font("chiller",Font.BOLD,24));
        lblIngresarNombre.setForeground(Color.WHITE);
        this.add(lblIngresarNombre);

        //CAMPO INGRESAR NOMBRE
        txtIngresarNombre = new JTextField(15);
        txtIngresarNombre.setBackground(Color.WHITE);
        txtIngresarNombre.setBounds(418, 335, 140, 30);
        txtIngresarNombre.setHorizontalAlignment(JTextField.CENTER);
        this.add(txtIngresarNombre);

        //BOTON PARA QUE SIRVE
        btnParaQueSirve = new JButton("Para qué sirve");
        btnParaQueSirve.setBounds(10, 370, 140,30);
        btnParaQueSirve.setForeground(Color.BLACK);
        btnParaQueSirve.setBackground(Color.WHITE);
        btnParaQueSirve.setFont(new Font("chiller",Font.BOLD,22));
        btnParaQueSirve.addActionListener(this);
        btnParaQueSirve.setFocusPainted(false);
        btnParaQueSirve.addMouseListener(this);
        btnParaQueSirve.setRolloverEnabled(false);
        this.add(btnParaQueSirve);
        
        //BOTON COMO JUGAR
        btnComoJugar = new JButton("Cómo jugar");
        btnComoJugar.setBounds(160, 370, 140,30);
        btnComoJugar.setForeground(Color.BLACK);
        btnComoJugar.setBackground(Color.WHITE);
        btnComoJugar.setFont(new Font("chiller",Font.BOLD,22));
        btnComoJugar.addActionListener(this);
        btnComoJugar.setFocusPainted(false);
        btnComoJugar.addMouseListener(this);
        btnComoJugar.setRolloverEnabled(false);
        this.add(btnComoJugar);
        
        //BOTON CONTINUAR
        btnContinuar = new JButton("Continuar");
        btnContinuar.setBounds(418, 370, 140,30);
        btnContinuar.setForeground(Color.BLACK);
        btnContinuar.setBackground(Color.WHITE);
        btnContinuar.setFont(new Font("chiller",Font.BOLD,22));
        btnContinuar.addActionListener(this);
        btnContinuar.setFocusPainted(false);
        btnContinuar.addMouseListener(this);
        btnContinuar.setRolloverEnabled(false);
        this.add(btnContinuar);
        
        super.iniciarComponentes();
        
        //CONFIGURACION SOBRE PLANTILLA
        btnVolver.setVisible(false);
        txtAInfo.setVisible(false);
        scroll.setVisible(false);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnParaQueSirve){
            irParaQueSirve();
        }
        
        if(e.getSource() == btnComoJugar){
            irComoJugar();
            
        }
        
        if(e.getSource() == btnContinuar){
            if (txtIngresarNombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Por favor ingrese un nombre para continuar", "Error", JOptionPane.WARNING_MESSAGE);
            } else if(txtIngresarNombre.getText().length()>=1) {
                
                irConfiguracionRonda();
            }
        }
    }
    
    //Abre ventana Configuracion de Ronda
    public void irConfiguracionRonda(){
        ConfiguracionRondaGUI ventanaConfigRonda = new ConfiguracionRondaGUI("Configuración de ronda", txtIngresarNombre.getText());
        ventanaConfigRonda.setVisible(true);
        this.dispose();
    }
    //Abre ventana Para que sirve
    public void irParaQueSirve(){
        ParaQueSirveGUI ventanaParaQueSirve = new ParaQueSirveGUI("Para qué sirve");
        ventanaParaQueSirve.setVisible(true);
        this.dispose();
    }
    
    //Abre ventana Como jugar
    public void irComoJugar(){
        ComoJugarGUI ventanaComoJugar = new ComoJugarGUI("Cómo jugar");
        ventanaComoJugar.setVisible(true);
        this.dispose();
    }
 
    private void esNumero(JTextField a){
        a.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (Character.isDigit(c)){
                    e.consume();
                    }
            }
        });
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == btnParaQueSirve){
            btnParaQueSirve.setBackground(Color.BLACK);
            btnParaQueSirve.setForeground(Color.WHITE);
        }
        
        if(e.getSource() == btnComoJugar){
            btnComoJugar.setBackground(Color.BLACK);
            btnComoJugar.setForeground(Color.WHITE);
        }
        
        if(e.getSource() == btnContinuar){
            btnContinuar.setBackground(Color.BLACK);
            btnContinuar.setForeground(Color.WHITE);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == btnParaQueSirve){
            btnParaQueSirve.setBackground(Color.WHITE);
            btnParaQueSirve.setForeground(Color.BLACK);
        }
        
        if(e.getSource() == btnComoJugar){
            btnComoJugar.setBackground(Color.WHITE);
            btnComoJugar.setForeground(Color.BLACK);
        }
        
        if(e.getSource() == btnContinuar){
            btnContinuar.setBackground(Color.WHITE);
            btnContinuar.setForeground(Color.BLACK);
        }
    }

}
