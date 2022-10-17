
package Ventana;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;

public class ConfiguracionRondaGUI extends Plantilla implements ActionListener, ItemListener{
    
    protected JComboBox combTematica;
    protected JLabel lblPalPorRonda;
    protected JTextField txtPalPorRonda;
    protected JButton btnJugar;
    protected String nombreDelJugador;
    //protected Juego juego;

    public ConfiguracionRondaGUI(String titulo){
        super(titulo);
        
    }
    
    public void iniciarComponentes(){
        
        //BOTON JUGAR
        btnJugar = new JButton("Jugar");
        btnJugar.setEnabled(true);
        btnJugar.setVisible(true);
        btnJugar.setBounds(418, 370, 140,30);
        btnJugar.setForeground(Color.BLACK);
        btnJugar.setBackground(Color.WHITE);
        btnJugar.setFont(new Font("chiller",Font.BOLD,22));
        btnJugar.addActionListener(this);
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
        super.actionPerformed(e);
        
        if(e.getSource() == btnJugar){
            /*
            int tematica = combTematica.getSelectedIndex();
            int palPorRonda = Integer.parseInt(txtPalPorRonda.getText());
            boolean hayPartida = true;
            System.out.println("Temática: "+ tematica);
            System.out.println("PPr: "+ palPorRonda);*/
            
            //irPpal();
            

    }

    }
    /*
    //Abre ventana Como jugar
    public void irPpal(){
        PpalGUI ventanaPpal = new PpalGUI;
        ventanaPpal.setVisible(true);
        this.dispose
    }
    */
    @Override
    public void itemStateChanged(ItemEvent e) {
        
        if(e.getSource() == combTematica) {
            String tematica=(String)combTematica.getSelectedItem();
            setTitle(tematica);
        
        }
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
    


    
}
