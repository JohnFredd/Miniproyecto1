
package Ventana;

import Logica.Juego;
import Logica.Ronda;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ResultadosRondaGUI extends Plantilla {
    
    private JLabel lblOtraRonda;
    private JButton btnSiRonda;
    private JButton btnNoRonda;
    private Juego juego;
    
    public ResultadosRondaGUI(String titulo, Ronda ronda, Juego juego) {
        super(titulo);
        obtenerEstadisticas(ronda);
        this.juego = juego;
    }
    
    public void iniciarComponentes() {
        
        //ETIQUETA OTRA RONDA
        lblOtraRonda = new JLabel("¿Otra ronda?", SwingConstants.CENTER);
        lblOtraRonda.setBounds(222, 300, 140,30);
        lblOtraRonda.setFont(new Font("chiller",Font.BOLD,24));
        lblOtraRonda.setForeground(Color.WHITE);
        this.add(lblOtraRonda);
        
        //BOTON SI
        btnSiRonda = new JButton("SÍ");
        btnSiRonda.setBounds(175, 370, 70,30);
        btnSiRonda.setForeground(Color.BLACK);
        btnSiRonda.setBackground(Color.WHITE);
        btnSiRonda.setFont(new Font("chiller",Font.BOLD,22));
        btnSiRonda.addActionListener(this);
        btnSiRonda.setFocusPainted(false);
        btnSiRonda.addMouseListener(this);
        btnSiRonda.setRolloverEnabled(false);
        this.add(btnSiRonda);
        
        //BOTON NO
        btnNoRonda = new JButton("NO");
        btnNoRonda.setBounds(339, 370, 70,30);
        btnNoRonda.setForeground(Color.BLACK);
        btnNoRonda.setBackground(Color.WHITE);
        btnNoRonda.setFont(new Font("chiller",Font.BOLD,22));
        btnNoRonda.addActionListener(this);
        btnNoRonda.setFocusPainted(false);
        btnNoRonda.addMouseListener(this);
        btnNoRonda.setRolloverEnabled(false);
        this.add(btnNoRonda);
        
        super.iniciarComponentes();
        
        //CONFIGURACION SOBRE PLANTILLA
        btnVolver.setVisible(false);
        lblTitulo.setVisible(false);
        scroll.setBounds(120, 50, 345, 180);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSiRonda){
            irConfiguracionRonda();
        }
        
        if(e.getSource() == btnNoRonda){
            irResultadosJuego();
            
        }
    }
    
    public void irConfiguracionRonda() {
        ConfiguracionRondaGUI ventanaConfigRonda = new ConfiguracionRondaGUI("Configuración de ronda", juego);
        ventanaConfigRonda.setVisible(true);
        this.dispose();
    }
    
    public void irResultadosJuego() {
        ResultadosJuegoGUI ventanaResultadosJuego = new ResultadosJuegoGUI("Resultados juego", juego);
        ventanaResultadosJuego.setVisible(true);
        this.dispose();
    }
    
    public void obtenerEstadisticas(Ronda ronda) {
        int total = ronda.getPalabrasTotales();
        int adivinadas = ronda.getPalabrasAdivinadas();
        double percAdivinadas = adivinadas * 100 / total;
        int noAdivinadas = ronda.getPalabrasNoAdivinadas();
        double percNoAdivinadas = noAdivinadas * 100 / total;
        txtAInfo.setText("\n   Cantidad de palabras adivinadas:   ");
        txtAInfo.append(String.valueOf(adivinadas) + "\n");
        txtAInfo.append("   Porcentaje:   ");
        txtAInfo.append(String.valueOf(percAdivinadas) + "%\n");
        txtAInfo.append("\n   Cantidad de palabras no adivinadas:   ");
        txtAInfo.append(String.valueOf(noAdivinadas) + "\n");
        txtAInfo.append("   Porcentaje:   " + String.valueOf(percNoAdivinadas) + "%");
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == btnSiRonda){
            btnSiRonda.setBackground(Color.BLACK);
            btnSiRonda.setForeground(Color.WHITE);
        }
        
        if(e.getSource() == btnNoRonda){
            btnNoRonda.setBackground(Color.BLACK);
            btnNoRonda.setForeground(Color.WHITE);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == btnSiRonda){
            btnSiRonda.setBackground(Color.WHITE);
            btnSiRonda.setForeground(Color.BLACK);
        }
        
        if(e.getSource() == btnNoRonda){
            btnNoRonda.setBackground(Color.WHITE);
            btnNoRonda.setForeground(Color.BLACK);
        }
    }
}
