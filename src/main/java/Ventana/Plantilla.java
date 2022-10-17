
package Ventana;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Plantilla extends JFrame implements ActionListener, MouseListener {
    
    protected JLabel lblFondo;
    protected JLabel lblTitulo;
    protected JButton btnVolver;
    protected JTextArea txtAInfo;
    protected JScrollPane scroll;
    
    public Plantilla(String titulo) {
        iniciarComponentes();
        setSize(600,450);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(titulo);
    }
    
    public void iniciarComponentes(){
        UIManager.put( "Button.select", false );
        
        //LABEL TITULO
        lblTitulo = new JLabel("AHORCADO",SwingConstants.CENTER);
        lblTitulo.setBounds(400, 22, 180,30);  // En minúsculas 430,22,130,30
        lblTitulo.setFont(new Font("chiller",Font.BOLD,42));
        lblTitulo.setForeground(Color.WHITE);
        this.add(lblTitulo);
        
        //BOTON VOLVER
        btnVolver = new JButton("Volver");
        btnVolver.setBounds(10, 370, 140,30);
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setBackground(Color.WHITE);
        btnVolver.setFont(new Font("chiller",Font.BOLD,22));
        btnVolver.setFocusPainted(false);
        btnVolver.addMouseListener(this);
        btnVolver.setRolloverEnabled(false);
        btnVolver.addActionListener(this);
        this.add(btnVolver);
        
        //TEXTAREA
        txtAInfo = new JTextArea();
        txtAInfo.setEditable(false);
        txtAInfo.setFont(new Font("Lato",Font.PLAIN,17));
        scroll = new JScrollPane(txtAInfo);
        scroll.setBounds(20, 76, 545, 270);
        this.add(scroll);
        
        //FONDO
        ImageIcon imagen1 = new ImageIcon("Ahorcamesta.jpeg");
        lblFondo = new JLabel();  
        lblFondo.setBounds(0, 0, 600, 450);   //10, 65, 380, 260
        lblFondo.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_SMOOTH)));
        this.add(lblFondo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnVolver){
            InicioGUI2 ventanaInicioGUI2 = new InicioGUI2("Inicio");
            ventanaInicioGUI2.setVisible(true);
            this.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == btnVolver){
            btnVolver.setBackground(Color.BLACK);
            btnVolver.setForeground(Color.WHITE);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == btnVolver){
            btnVolver.setBackground(Color.WHITE);
            btnVolver.setForeground(Color.BLACK);
        }
    }
}
