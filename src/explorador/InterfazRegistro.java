package explorador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.Icon;
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
 * @author Sistemas operativos
 */
public class InterfazRegistro extends JFrame implements ActionListener{
    
    private JPanel cabecera,img, ventana, campoNombre, campoPass, campoBotones, divisor;
    private JLabel header, nombre, pass;
    private JButton registrar, cancelar;
    private JTextField tnombre;
    private JPasswordField Ppass;
    private final JLabel imagen;
    
    public InterfazRegistro(){
        super("Registro");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int xx = screenSize.width;
        int yy = screenSize.height;
        int x = 300;
        int y = 150;
        this.setSize(x, y);
        this.setLocationRelativeTo(null);
        
        ventana = new JPanel();
        ventana.setLayout(new BoxLayout(ventana, BoxLayout.Y_AXIS));
        ventana.setSize(x, y);
        Font font =new Font("Segoe UI", Font.BOLD, 24);
        Font texto = new Font("Verdana", Font.BOLD, 15);
        header = new JLabel("Registro");
        header.setFont(font);
        this.imagen = new JLabel();
        this.imagen.setHorizontalAlignment(0);
        this.imagen.setIcon(this.insertarImagen("src/explorador/imagenes/registro.png", 200,200));
        this.header.setHorizontalAlignment(0);
        this.cabecera = new JPanel(new GridLayout(1,1));
        this.cabecera.setMaximumSize(new Dimension(x, 50));
        this.cabecera.add(header);
        
        this.img = new JPanel(new GridLayout(1,1));
        this.img.setMaximumSize(new Dimension(x, 220));
        this.img.add(imagen);
        
        campoNombre = new JPanel(new GridLayout(1, 2));
        campoNombre.setMaximumSize(new Dimension(x, 20));
        nombre = new JLabel("Nombre de usuario");
        tnombre = new JTextField();
        campoNombre.add(nombre);
        campoNombre.add(tnombre);
        
        campoPass = new JPanel(new GridLayout(1, 2));
        campoPass.setMaximumSize(new Dimension(x, 20));
        pass = new JLabel("Contraseña");
        Ppass = new JPasswordField();
        campoPass.add(pass);
        campoPass.add(Ppass);
        
        divisor = new JPanel();
        divisor.setMaximumSize(new Dimension(x, 20));
        
        campoBotones = new JPanel();
        campoBotones.setMaximumSize(new Dimension(x * 8 / 10, 20));
        campoBotones.setLayout(new GridLayout(1, 2));
        registrar = new JButton("Registrar");
        registrar.addActionListener(this);
        cancelar = new JButton("Cancelar");
        cancelar.addActionListener(this);
        campoBotones.add(registrar);
        campoBotones.add(cancelar);
        
        ventana.add(header);
        ventana.add(campoNombre);
        ventana.add(campoPass);  
        ventana.add(divisor);
        ventana.add(campoBotones);
        
        this.add(ventana);       
        this.setResizable(false);
        this.setBackground(Color.LIGHT_GRAY);
        this.setVisible(true);       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == registrar){
            String nombre = tnombre.getText();
            String pass = Ppass.getText();
            if(!pass.isEmpty() && !nombre.isEmpty()){
                if(Explorador.usersContainer.getChildNodes().getLength() == 0){
                    Usuario usuario = new Usuario(Usuario.getCurrentId(), nombre, "administrador", pass);
                    usuario.agregar();
                    usuario.iniciarSesion();
                    this.dispose();
                    new Interfaz();
                }else{
                    Usuario usuario = new Usuario(Usuario.getCurrentId(), nombre, "normal", pass);
                    if(!usuario.existeUsuario()){
                        usuario.agregar();
                        usuario.iniciarSesion();
                        this.dispose();
                        new Interfaz();
                    }else
                        JOptionPane.showMessageDialog(null, "El nombre ya existe", "Usuario existente", JOptionPane.ERROR_MESSAGE);                   
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingresa un nombre y una contraseña", "Datos incompletos", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(ae.getSource() == cancelar){
            this.dispose();
            new InterfazInicio();
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
