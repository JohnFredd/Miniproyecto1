
package Ventana;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.*;

public class InicioGUI2 extends Plantilla implements ActionListener{
    
    private JLabel lblIngresarNombre;
    private JTextField txtIngresarNombre;
    private JButton btnParaQueSirve;
    private JButton btnContinuar;
    private JButton btnComoJugar;

    public InicioGUI2(){
        iniciarComponentes();
        esNumero(txtIngresarNombre);
        setSize(600,450);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Inicio");
        }
    
    private void iniciarComponentes() {
        
        //ETIQUETA INGRESAR NOMBRE
        lblIngresarNombre = new JLabel("Ingresa tu nombre", SwingConstants.CENTER);
        lblIngresarNombre.setVisible(true);
        lblIngresarNombre.setBounds(418, 300, 140,30);
        lblIngresarNombre.setFont(new Font("chiller",Font.BOLD,24));
        lblIngresarNombre.setForeground(Color.WHITE);
        this.add(lblIngresarNombre);

        //CAMPO INGRESAR NOMBRE
        txtIngresarNombre = new JTextField(15);
        txtIngresarNombre.setEnabled(true);
        txtIngresarNombre.setVisible(true);
        txtIngresarNombre.setBackground(Color.WHITE);
        txtIngresarNombre.setBounds(0, 0, 140, 30);
        txtIngresarNombre.setHorizontalAlignment(JTextField.CENTER);
        this.add(txtIngresarNombre);

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
        
        //BOTON CONTINUAR
        btnContinuar = new JButton("Continuar");
        btnContinuar.setEnabled(true);
        btnContinuar.setVisible(true);
        btnContinuar.setBounds(0, 35, 140,30);
        btnContinuar.setForeground(Color.BLACK);
        btnContinuar.setBackground(Color.WHITE);
        btnContinuar.setFont(new Font("chiller",Font.BOLD,22));
        btnContinuar.addActionListener(this);
        this.add(btnContinuar);
        
        Plantilla.iniciarComponentes();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btnParaQueSirve){
            
            lblTitulo.setText("PARA QUÉ SIRVE");
            lblTitulo.setBounds(145, 22, 280,30);  // En minúsculas 430,22,130,30
            lblTitulo.setFont(new Font("chiller",Font.BOLD,42));
            lblTitulo.setForeground(Color.WHITE);
            irParaQueSirve();
        }
        
        if(e.getSource() == btnComoJugar){
            
            lblTitulo.setText("COMO JUGAR");
            lblTitulo.setBounds(168, 22, 240,30);  // En minúsculas 430,22,130,30
            lblTitulo.setFont(new Font("chiller",Font.BOLD,42));
            lblTitulo.setForeground(Color.WHITE);
            irComoJugar();
            
        }
        
        if(e.getSource() == btnContinuar){
            if (txtIngresarNombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Por favor ingrese un nombre para continuar", "Error", JOptionPane.WARNING_MESSAGE);
            }
            if (txtIngresarNombre.getText().contains(".")){
                JOptionPane.showMessageDialog(null, "Por favor ingrese un nombre válido para continuar", "Error", JOptionPane.WARNING_MESSAGE);

            }
            else if(txtIngresarNombre.getText().length()>=1){
                this.configuracionRonda();

                
            }
        }
      
    }
    
    //Abre ventana Configuracion de Ronda
    public void irConfiguracionRonda(){
        ConfiguracionRondaGUI ventanaConfigRonda = new ConfiguracionRondaGUI;;
        ventanaConfigRonda.setVisible(true);
        this.dispose();
    }
    //Abre ventana Para que sirve
    public void irParaQueSirve(){
        ParaQueSirveGUI ventanaParaQueSirve = new ParaQueSirveGUI;
        ventanaParaQueSirve.setVisible(true);
        this.dispose();
    }
    
    //Abre ventana Como jugar
    public void irComoJugar(){
        ComoJugarGUI ventanaComoJugar = new ComoJugarGUI;
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

}