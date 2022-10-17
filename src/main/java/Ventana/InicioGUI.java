
package Ventana;

import java.awt.*;
import javax.swing.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class InicioGUI extends JFrame implements ActionListener, ItemListener{
  
  private String nombre;
  private int palPorRonda;
  private int tematica;
  private boolean hayPartida;
  
  private JPanel panel1;
  private JPanel panel2;
  
  private JLabel lblTitulo;
  private JLabel lblIngresarNombre;
  
  private JLabel lblPalPorRonda;
  private JTextField txtPalPorRonda;
  
  private JLabel lblImagen;
  private JTextField txtIngresarNombre;
  
  private JScrollPane scroll;
  private JScrollPane scroll2;

  private JButton btnParaQueSirve;
  private JButton btnContinuar;
  private JButton btnComoJugar;
  private JButton btnVolver;
  private JButton btnVolver2;

  private JButton btnJugar;

  private JTextArea txtAParaQueSirve;
  private JTextArea txtAComoJugar;
  
  private JComboBox combTematica;
  private Container contenedorPpal;
 
  public InicioGUI() {
    iniciarComponentes();
    esNumero(txtIngresarNombre);
    esTexto(txtPalPorRonda);
    setSize(600,450);
    setVisible(true);
    setLocationRelativeTo(null);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Inicio");
  }

  public void iniciarComponentes(){
    
    panel1 = new JPanel();
    panel1.setBackground(Color.LIGHT_GRAY);
    //panel1.setSize(100, 50);
    panel1.setLayout(null);
    panel1.setVisible(true);
    //panel1.setBounds(100, 100, 200, 50);
    
    panel2 = new JPanel();
    //panel2.setBackground(Color.BLUE);
    //panel2.setSize(100, 50);
    panel2.setLayout(null);
    panel2.setBounds(420, 335, 135, 65);
    panel2.setVisible(true);
    

    //AGREGANDO PANELES
    this.getContentPane().add(panel2);
    this.getContentPane().add(panel1);

    //AGREGANDO COMPONENTES
    this.cargarComponentesPanel1();
    this.cargarComponentesPanel2();
  }
  
  public void cargarComponentesPanel1(){
      
      //TITULO
      lblTitulo = new JLabel("AHORCADO",SwingConstants.CENTER);
      lblTitulo.setBounds(400, 22, 180,30);  // En minúsculas 430,22,130,30
      lblTitulo.setFont(new Font("chiller",Font.BOLD,42));
      lblTitulo.setForeground(Color.WHITE);
      panel1.add(lblTitulo);
      
      //ETIQUETA INGRESAR NOMBRE
      lblIngresarNombre = new JLabel("Ingresa tu nombre", SwingConstants.CENTER);
      lblIngresarNombre.setVisible(true);
      lblIngresarNombre.setBounds(418, 300, 140,30);
      lblIngresarNombre.setFont(new Font("chiller",Font.BOLD,24));
      lblIngresarNombre.setForeground(Color.WHITE);
      panel1.add(lblIngresarNombre);
      
      //AREA DE TEXTO PARA QUE SIRVE
      txtAParaQueSirve = new JTextArea();
      txtAParaQueSirve.setEditable(false);
      txtAParaQueSirve.setVisible(false);
      txtAParaQueSirve.setFont(new Font("Lato",Font.PLAIN,17));
      
      txtAParaQueSirve.setText(""" 
                                 
                                 El tradicional juego del ahorcado pone a prueba el ingenio del jugador,
                                 su conocimiento del vocabulario involucrado y su capacidad de crear 
                                 estrategias para adivinar cada palabra y hacer deducciones, mientras 
                                 pasa un rato divertido jugando y aprendiendo al mismo tiempo.
                               
                                 El juego del ahorcado se convierte en una estrategia divertida de 
                                 enseñanza, en donde los estudiantes podrán adquirir nuevo vocabulario,
                                 aprender reglas gramáticales y de pronunciación e incluso entrenar su 
                                 concentración y atención,de manera divertida.
      
                               """);

      scroll2 = new JScrollPane(txtAParaQueSirve);
      scroll2.setBounds(20, 76, 545, 270);
      //scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      scroll2.setVisible(false);
      panel1.add(scroll2);
      
      //AREA DE TEXTO CÓMO JUGAR
      txtAComoJugar = new JTextArea();
      txtAComoJugar.setEditable(false);
      txtAComoJugar.setVisible(false);
      txtAComoJugar.setFont(new Font("Lato",Font.PLAIN,15));
      txtAComoJugar.setText("""
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
      //txtAComoJugar.append("\nnombre y presionar en el botón");
      //txtAComoJugar.append("\nde continuar.");
      //txtAComoJugar.setBounds(391, 66, 185, 300);
      scroll = new JScrollPane(txtAComoJugar);
      scroll.setBounds(20, 76, 545, 270);
      //scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      scroll.setVisible(false);
      panel1.add(scroll);

      //BOTON PARA QUE SIRVE
      btnParaQueSirve = new JButton("Para qué sirve");
      btnParaQueSirve.setEnabled(true);
      btnParaQueSirve.setVisible(true);
      btnParaQueSirve.setBounds(10, 370, 140,30);
      btnParaQueSirve.setForeground(Color.BLACK);
      btnParaQueSirve.setBackground(Color.WHITE);
      btnParaQueSirve.setFont(new Font("chiller",Font.BOLD,22));
      btnParaQueSirve.addActionListener(this);
      panel1.add(btnParaQueSirve);

      //BOTON COMO JUGAR
      btnComoJugar = new JButton("Cómo jugar");
      btnComoJugar.setEnabled(true);
      btnComoJugar.setVisible(true);
      btnComoJugar.setBounds(160, 370, 140,30);
      btnComoJugar.setForeground(Color.BLACK);
      btnComoJugar.setBackground(Color.WHITE);
      btnComoJugar.setFont(new Font("chiller",Font.BOLD,22));
      btnComoJugar.addActionListener(this);
      panel1.add(btnComoJugar);
      
      //BOTON VOLVER
      btnVolver = new JButton("Volver");
      btnVolver.setVisible(false);
      btnVolver.setBounds(10, 370, 140,30);
      btnVolver.setForeground(Color.BLACK);
      btnVolver.setBackground(Color.WHITE);
      btnVolver.setFont(new Font("chiller",Font.BOLD,22));
      btnVolver.addActionListener(this);
      panel1.add(btnVolver);
      
      //BOTON JUGAR
      btnJugar = new JButton("Jugar");
      btnJugar.setEnabled(true);
      btnJugar.setVisible(false);
      btnJugar.setBounds(418, 370, 140,30);
      btnJugar.setForeground(Color.BLACK);
      btnJugar.setBackground(Color.WHITE);
      btnJugar.setFont(new Font("chiller",Font.BOLD,22));
      btnJugar.addActionListener(this);
      panel1.add(btnJugar);
      
      //CAMPO PALABRAS POR RONDA
      txtPalPorRonda = new JTextField(15);
      txtPalPorRonda.setEnabled(true);
      txtPalPorRonda.setVisible(false);
      txtPalPorRonda.setBackground(Color.WHITE);
      txtPalPorRonda.setBounds(418, 330, 140, 30);
      txtPalPorRonda.setHorizontalAlignment(JTextField.CENTER);      
      panel1.add(txtPalPorRonda);
      
      //BOTON VOLVER2
      btnVolver2 = new JButton("Volver");
      btnVolver2.setVisible(false);
      btnVolver2.setBounds(10, 370, 140,30);
      btnVolver2.setForeground(Color.BLACK);
      btnVolver2.setBackground(Color.YELLOW);
      btnVolver2.setFont(new Font("chiller",Font.BOLD,22));
      btnVolver2.addActionListener(this);
      panel1.add(btnVolver2);      
      
      //ETIQUETA PALABRAS POR RONDA
      lblPalPorRonda = new JLabel("Palabras por ronda", SwingConstants.CENTER);
      lblPalPorRonda.setVisible(false);
      lblPalPorRonda.setBounds(418, 300, 140,30);
      lblPalPorRonda.setFont(new Font("chiller",Font.BOLD,24));
      lblPalPorRonda.setForeground(Color.WHITE);
      panel1.add(lblPalPorRonda);

      //LISTADO TEMÁTICA
     
      String[] tematicas = { "Animales", "Colores", "Frutas" };
      combTematica = new JComboBox(tematicas);
      combTematica.setRenderer(new MyComboBoxRenderer("Temáticas"));
      combTematica.setSelectedIndex(-1);
      combTematica.setBounds(418, 265, 140, 30);
      combTematica.setFont(new Font("chiller",Font.BOLD,18));
      combTematica.addItemListener(this);
      combTematica.setVisible(false);
      panel1.add(combTematica);
      
      //IMAGEN JUEGO
      ImageIcon imagen1 = new ImageIcon("Ahorcamesta.jpeg");
      lblImagen = new JLabel();  
      lblImagen.setBounds(0, 0, 600, 450);   //10, 65, 380, 260
      lblImagen.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH)));
      panel1.add(lblImagen);
    
    }
  
  public void cargarComponentesPanel2(){
            
      //CAMPO INGRESAR NOMBRE
      txtIngresarNombre = new JTextField(15);
      txtIngresarNombre.setEnabled(true);
      txtIngresarNombre.setVisible(true);
      txtIngresarNombre.setBackground(Color.WHITE);
      txtIngresarNombre.setBounds(0, 0, 140, 30);
      txtIngresarNombre.setHorizontalAlignment(JTextField.CENTER);
      
      //BOTON CONTINUAR
      btnContinuar = new JButton("Continuar");
      btnContinuar.setEnabled(true);
      btnContinuar.setVisible(true);
      btnContinuar.setBounds(0, 35, 140,30);
      btnContinuar.setForeground(Color.BLACK);
      btnContinuar.setBackground(Color.WHITE);
      btnContinuar.setFont(new Font("chiller",Font.BOLD,22));
      btnContinuar.addActionListener(this);
      
      panel2.add(btnContinuar);
      panel2.add(txtIngresarNombre);
    }
  
  public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == btnParaQueSirve){
      panel2.setVisible(false);
      btnParaQueSirve.setVisible(false);
      lblIngresarNombre.setVisible(false);
      txtIngresarNombre.setVisible(false);
      scroll.setVisible(false);
      btnContinuar.setVisible(false);
      txtAComoJugar.setVisible(false);
      
      btnComoJugar.setVisible(true);
      btnVolver.setVisible(true);
      scroll2.setVisible(true);
      txtAParaQueSirve.setVisible(true);
      
      lblTitulo.setText("PARA QUÉ SIRVE");
      lblTitulo.setBounds(145, 22, 280,30);  // En minúsculas 430,22,130,30
      lblTitulo.setFont(new Font("chiller",Font.BOLD,42));
      lblTitulo.setForeground(Color.WHITE);

    }
    
    if(ae.getSource() == btnComoJugar){
      panel2.setVisible(false);
      btnComoJugar.setVisible(false);
      lblIngresarNombre.setVisible(false);
      txtIngresarNombre.setVisible(false);
      txtAParaQueSirve.setVisible(false);
      btnContinuar.setVisible(false);
      scroll2.setVisible(false);
      scroll.setVisible(true);
      btnParaQueSirve.setVisible(true);
      btnParaQueSirve.setBounds(160, 370, 140,30);
      btnVolver.setVisible(true);
      txtAComoJugar.setVisible(true);
      lblTitulo.setText("COMO JUGAR");
      lblTitulo.setBounds(168, 22, 240,30);  // En minúsculas 430,22,130,30
      lblTitulo.setFont(new Font("chiller",Font.BOLD,42));
      lblTitulo.setForeground(Color.WHITE);


    }
    
    if(ae.getSource() == btnVolver){
      panel2.setVisible(true);
      btnVolver.setVisible(false);
      txtAParaQueSirve.setVisible(false);
      txtAComoJugar.setVisible(false);
      scroll.setVisible(false);
      scroll2.setVisible(false);
      btnContinuar.setVisible(true);
      lblIngresarNombre.setVisible(true);
      txtIngresarNombre.setVisible(true);
      btnParaQueSirve.setVisible(true);
      btnParaQueSirve.setBounds(10, 370, 140,30);
      btnComoJugar.setVisible(true);
      lblTitulo.setText("AHORCADO");
      lblTitulo.setBounds(400, 22, 180,30);  // En minúsculas 430,22,130,30
      lblTitulo.setFont(new Font("chiller",Font.BOLD,42));
      lblTitulo.setForeground(Color.WHITE);
    
    }
    
    if(ae.getSource() == btnVolver2){
      panel2.setVisible(true);        
      btnVolver2.setVisible(false);
      txtPalPorRonda.setVisible(false);
      lblPalPorRonda.setVisible(false);
      combTematica.setVisible(false);
      btnJugar.setVisible(false);
      btnContinuar.setVisible(true);
      txtIngresarNombre.setVisible(true);
      lblIngresarNombre.setVisible(true);
      btnParaQueSirve.setVisible(true);
      btnParaQueSirve.setBounds(10, 370, 140,30);
      btnComoJugar.setVisible(true);
    
    }    
    
    
    if(ae.getSource() == btnContinuar){
        if (txtIngresarNombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor ingrese un nombre para continuar", "Error", JOptionPane.WARNING_MESSAGE);
            }
            if (txtIngresarNombre.getText().contains(".")){
                JOptionPane.showMessageDialog(null, "Por favor ingrese un nombre válido para continuar", "Error", JOptionPane.WARNING_MESSAGE);

                }
                else if(txtIngresarNombre.getText().length()>=1){
                    panel2.setVisible(false);
                    btnParaQueSirve.setVisible(false);
                    btnComoJugar.setVisible(false);
                    btnContinuar.setVisible(false);
                    lblIngresarNombre.setVisible(false);
                    txtIngresarNombre.setVisible(false);

                    combTematica.setVisible(true);
                    lblPalPorRonda.setVisible(true);
                    txtPalPorRonda.setVisible(true);
                    btnJugar.setVisible(true);
                    btnVolver2.setVisible(true);
                    nombre = txtIngresarNombre.getText();
                    System.out.println("Mi nombre es: "+ nombre);
                    }
        }
    
    if(ae.getSource() == btnJugar){
       int tematica = combTematica.getSelectedIndex();
       int palPorRonda = Integer.parseInt(txtPalPorRonda.getText());
       boolean hayPartida = true;
        System.out.println("Temática: "+ tematica);
        System.out.println("PPr: "+ palPorRonda);

    }
    
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
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == combTematica) {
            String tematica=(String)combTematica.getSelectedItem();
            setTitle(tematica);
        
        }
    }

    public String cualEsElNombre(){
        return nombre;
    }
    public int cualEsLaTematica(){
        return tematica;
    }
    public int cuantasPalPorRonda(){
        return palPorRonda;
    }
    //public boolean
    
    
 
// Clase para asignar título principal al ComboBox Temática
  class MyComboBoxRenderer extends JLabel implements ListCellRenderer
    {
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

