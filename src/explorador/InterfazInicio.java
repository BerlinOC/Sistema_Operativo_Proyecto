package explorador;

import Interfaz.escritorio;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Sistemas Operativos
 */
public class InterfazInicio extends JFrame implements ActionListener{
    
    private JPanel cabecera, img, ventana, campoNombre, campoPass, campoBotones, divisor;
    private JLabel header, nombre, pass;
    private JLabel imagen;
    private JButton ingresar, crearCuenta;
    private JTextField tnombre;
    private JPasswordField Ppass;
    
    public InterfazInicio(){
        super("Iniciar Sesión");
        int x = 500;
        int y = 650;
        this.setSize(x, y);
        this.setLocationRelativeTo(null);
        
        ventana = new JPanel();
        ventana.setLayout(new BoxLayout(ventana, BoxLayout.Y_AXIS));
        ventana.setSize(x, y);
        Font font =new Font("Segoe UI", Font.BOLD, 27);
        Font texto = new Font("Verdana", Font.BOLD, 18);
        
        header = new JLabel("INICIAR SESIÓN");
        header.setFont(font);
        this.imagen = new JLabel();
        this.imagen.setHorizontalAlignment(0);
        this.imagen.setIcon(this.insertarImagen("src/explorador/imagenes/login.png", 200,200));
        this.header.setHorizontalAlignment(0);
        this.cabecera = new JPanel(new GridLayout(1,1));
        this.cabecera.setMaximumSize(new Dimension(x, 50));
        this.cabecera.add(header);
        
        this.img = new JPanel(new GridLayout(1,1));
        this.img.setMaximumSize(new Dimension(x, 220));
        this.img.add(imagen);
        
        campoNombre = new JPanel(new GridLayout(2, 1));
        campoNombre.setMaximumSize(new Dimension((int)(x*0.4), 50));
        
        nombre = new JLabel("Nombre de usuario");
        nombre.setFont(texto);
        nombre.setHorizontalAlignment(0);
        tnombre = new JTextField();
        tnombre.setFont(texto);
        campoNombre.add(nombre);
        campoNombre.add(tnombre);
        
        campoPass = new JPanel(new GridLayout(2, 1));
        campoPass.setMaximumSize(new Dimension((int)(x*0.4), 50));
        pass = new JLabel("Contraseña");
        pass.setFont(texto);
        pass.setHorizontalAlignment(0);
        Ppass = new JPasswordField();
        campoPass.add(pass);
        campoPass.add(Ppass);
        
        divisor = new JPanel();
        divisor.setMaximumSize(new Dimension(x, 10));
        
        ingresar = new JButton();
        Cursor cursor = new Cursor(12);
        
        this.quitarBorde(this.ingresar);
        this.ingresar.setCursor(cursor);
        ingresar.setIcon(this.insertarImagen("src/explorador/imagenes/iniciar_sesion.png", 230,80));
        ingresar.setRolloverIcon(this.insertarImagen("src/explorador/imagenes/iniciar_sesion.png", 227,77));
        crearCuenta = new JButton();
        
        this.quitarBorde(this.crearCuenta);
        this.crearCuenta.setCursor(cursor);
        crearCuenta.setIcon(this.insertarImagen("src/explorador/imagenes/registrar.png", 220,70));
        crearCuenta.setRolloverIcon(this.insertarImagen("src/explorador/imagenes/registrar.png", 218,68));
        
        ingresar.addActionListener(this);
        crearCuenta.addActionListener(this);
        
        campoBotones = new JPanel();
        campoBotones.setLayout(new GridLayout(2, 1));
        campoBotones.setMaximumSize(new Dimension((int) (x*0.5), 190));
        campoBotones.add(ingresar);
        //campoBotones.add(divisor);
        campoBotones.add(crearCuenta);
        
        ventana.add(cabecera);
        ventana.add(img);
        ventana.add(campoNombre);
        ventana.add(campoPass);  
        ventana.add(divisor);
        ventana.add(campoBotones);
        
        this.add(ventana);       
        this.setResizable(false);
        this.setBackground(Color.WHITE);
        this.setVisible(true);       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String nombre = tnombre.getText();
        String pass = Ppass.getText();
        if(ae.getSource() == ingresar){
            if(!nombre.isEmpty() && !pass.isEmpty()){
                Usuario usuario = new Usuario(Usuario.getCurrentId(), nombre, "", pass);
                if(usuario.existeUsuario()){
                    usuario.iniciarSesion();
                    this.dispose();
                   // new Interfaz();
                   escritorio a=new escritorio();
                   a.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "El usuario no existe", "El usuario no existe", JOptionPane.ERROR_MESSAGE);
                }
            }else
                JOptionPane.showMessageDialog(null, "Ingresa un nombre y una contraseña", "Datos incompletos", JOptionPane.ERROR_MESSAGE);
        }
        if(ae.getSource() == crearCuenta){
            this.dispose();
            new InterfazRegistro();
        }
    }
    
    public ImageIcon insertarImagen(String imagen, int ancho, int altura){
        ImageIcon imagenPrincipal = new ImageIcon(imagen);
        Image conversion = imagenPrincipal.getImage();
        Image tamaño = conversion.getScaledInstance(ancho, altura, Image.SCALE_SMOOTH);
        ImageIcon imagenFinal = new ImageIcon(tamaño);
        return (imagenFinal);
    }
    
     public void quitarBorde(JButton btn){
        btn.setBorder(null);
        btn.setContentAreaFilled(false);
    }
}
