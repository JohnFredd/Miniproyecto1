
package Ventana;

import Logica.Juego;
import Logica.Ronda;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;

public class ConfiguracionRondaGUI extends Plantilla implements ActionListener, ItemListener{
    
    protected JComboBox combTematica;
    protected JLabel lblPalPorRonda;
    protected JTextField txtPalPorRonda;
    protected JButton btnJugar;
    protected String nombreDelJugador;
    protected Juego juego;

    public ConfiguracionRondaGUI(String titulo, Juego juego){
        super(titulo);
        esTexto(txtPalPorRonda);
        this.juego = juego;
        nombreDelJugador = null;
    }
    public ConfiguracionRondaGUI(String titulo, String nombreDelJugador){
        super(titulo);
        esTexto(txtPalPorRonda);

        juego = null;
        this.nombreDelJugador = nombreDelJugador;
    }   
    
    
    public void iniciarComponentes(){
        
        //BOTON JUGAR
        btnJugar = new JButton("Jugar");
        btnJugar.setBounds(418, 370, 140,30);
        btnJugar.setForeground(Color.BLACK);
        btnJugar.setBackground(Color.WHITE);
        btnJugar.setFont(new Font("chiller",Font.BOLD,22));
        btnJugar.setFocusPainted(false);
        btnJugar.addMouseListener(this);
        btnJugar.setRolloverEnabled(false);
        btnJugar.addActionListener(this);
        btnJugar.setEnabled(false);
        this.add(btnJugar);
        
        //CAMPO PALABRAS POR RONDA
        txtPalPorRonda = new JTextField(15);
        txtPalPorRonda.setEnabled(true);
        txtPalPorRonda.setVisible(true);
        txtPalPorRonda.setBackground(Color.WHITE);
        txtPalPorRonda.setBounds(418, 330, 140, 30);
        txtPalPorRonda.setHorizontalAlignment(JTextField.CENTER);      
        this.add(txtPalPorRonda);
        
        //ETIQUETA PALABRAS POR RONDA
        lblPalPorRonda = new JLabel("Palabras por ronda", SwingConstants.CENTER);
        lblPalPorRonda.setVisible(true);
        lblPalPorRonda.setBounds(418, 300, 140,30);
        lblPalPorRonda.setFont(new Font("chiller",Font.BOLD,24));
        lblPalPorRonda.setForeground(Color.WHITE);
        this.add(lblPalPorRonda);
        
        //LISTADO TEMÁTICA

        String[] tematicas = { "Animales", "Colores", "Frutas" };
        combTematica = new JComboBox(tematicas);
        combTematica.setRenderer(new ConfiguracionRondaGUI.MyComboBoxRenderer("Temáticas"));
        combTematica.setSelectedIndex(-1);
        combTematica.setBounds(418, 265, 140, 30);
        combTematica.setFont(new Font("chiller",Font.BOLD,18));
        combTematica.addItemListener(this);
        combTematica.setVisible(true);
        this.add(combTematica);

        super.iniciarComponentes();
        
        //CONFIGURACIÓN PLANTILLA
        txtAInfo.setVisible(false);
        scroll.setVisible(false);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btnVolver){
            if(juego == null){
                super.actionPerformed(e);
                
            } else{
                int resp = JOptionPane.showConfirmDialog(null, "Hay una partida en curso, si regresas ahora mismo se finalizará. \n                                  ¿Deseas regresar?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if(resp == JOptionPane.YES_OPTION){
                    irResultadosJuego();
                }

            }
        }
        
        if(e.getSource() == btnJugar){
            String tematica = (String)combTematica.getSelectedItem();
            int palabrasTotales = Integer.parseInt(txtPalPorRonda.getText());
            if (juego == null){
                juego = new Juego(nombreDelJugador);
            }
            Ronda ronda = new Ronda(juego, tematica, palabrasTotales);
            irPpal(ronda);
        }
    }
    
    //Abre ventana Como jugar
    public void irPpal(Ronda ronda){
        PpalGUI ventanaPpal = new PpalGUI(juego, ronda);
        ventanaPpal.setVisible(true);
        this.dispose();
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        if(e.getSource() == btnJugar){
            btnJugar.setBackground(Color.BLACK);
            btnJugar.setForeground(Color.WHITE);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        if(e.getSource() == btnJugar){
            btnJugar.setBackground(Color.WHITE);
            btnJugar.setForeground(Color.BLACK);
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        
        if(e.getSource() == combTematica) {
            String tematica=(String)combTematica.getSelectedItem();
            btnJugar.setEnabled(true);
        }
    }

    public void irResultadosJuego() {
        ResultadosJuegoGUI ventanaResultadosJuego = new ResultadosJuegoGUI("Resultados juego", juego);
        ventanaResultadosJuego.setVisible(true);
        this.dispose();
    }
    
    // Clase para asignar título principal al ComboBox Temática
    class MyComboBoxRenderer extends JLabel implements ListCellRenderer{
       
        private final String _titulo;

        public MyComboBoxRenderer(String titulo)
        {
            _titulo = titulo;
        }

        @Override
        public Component getListCellRendererComponent(JList lista, Object valor,
                int indice, boolean estaSeleccionado, boolean hasFocus){         
            if (indice == -1 && valor == null) {
                setText(_titulo);
            }
            else setText(valor.toString());
            return this;
        }
    }
    
    private void esTexto(JTextField a){
        a.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (!Character.isDigit(c)){
                    e.consume();
                    }
            }
        });
    }
    
    

    
}
