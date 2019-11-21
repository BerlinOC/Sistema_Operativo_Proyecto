package explorador;

import Interfaz.escritorio;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author Sistemas Operativos
 */
public class Interfaz extends JFrame implements MouseListener, ActionListener {

    private final JPanel ventana, menu, contenido, buscador, separador0, separador2, separador3, separador4, separador5;
    private final JButton atras, abrir, crearArchivo, crearDirectorio, copiar, cortar, pegar, eliminar, editar, cerrarSesion, buscar;
    private static JButton ultimo;
    private final JScrollPane jsp;
    private final JTextField txtBuscar;
    public static JPanel ultimoClickeado;
    public final JLabel lblBuscar;

    public Interfaz() {
        super("Explorador de archivos");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int xx = screenSize.width;
        int yy = screenSize.height;
        this.setSize(1360, 900);
        this.setLocationRelativeTo(null);

        ventana = new JPanel();
        ventana.setLayout(new BoxLayout(ventana, BoxLayout.Y_AXIS));
        ventana.setSize(1360, 900);
        ventana.setBackground(Color.WHITE);
        
        
        
        menu = new JPanel();
        menu.setLayout(new GridLayout());
       // menu.setSize(1360, 400);
        menu.setBackground(new Color(255, 255, 255));

        contenido = new JPanel(new GridLayout(0, 10));
        contenido.setSize(1360, 200);
        contenido.setBackground(Color.WHITE);
        jsp = new JScrollPane();
        jsp.setViewportView(contenido);
        
        buscador = new JPanel();
        buscador.setLayout(new BoxLayout(buscador, BoxLayout.X_AXIS));
        buscador.setBackground(new Color(255, 255, 255));
        buscador.setSize(1360, 30);
        
        JLabel label= new JLabel();
        label.setText("Sobre el botón BUSCAR: Aqui puede buscar algún elemento que cree usted que se haya creado, el resultado se mostrará en la pantalla.");
        
        //buscar 
        this.buscar = new JButton();
        this.buscar.setIcon(this.insertarImagen("src/explorador/imagenes/buscar.png", 40, 40));
        this.buscar.setRolloverIcon(this.insertarImagen("src/explorador/imagenes/buscar.png", 35, 35));
        quitarBorde(this.buscar);
        this.buscar.setCursor(new Cursor(12));
        
        //label
        this.lblBuscar = new JLabel();
        this.lblBuscar.setText("Buscar archivo o directorio: ");
        //TextField
        this.txtBuscar = new JTextField();
        
        this.separador0 = new JPanel();
        this.separador0.setLayout(new BorderLayout());
        separador0.setSize(1360, 800);
        
        this.separador2 = new JPanel();
        this.separador2.setLayout(new BorderLayout());
        separador2.setSize(1360, 800);
        
        this.separador3 = new JPanel();
        this.separador3.setLayout(new BorderLayout());
        separador3.setSize(1360, 800);
        
        this.separador4 = new JPanel();
        this.separador4.setLayout(new BorderLayout());
        separador4.setSize(1360, 800);
        
        this.separador5 = new JPanel();
        this.separador5.setLayout(new BorderLayout());
        separador5.setSize(1360, 800);
        
        this.buscador.add(lblBuscar);
        this.buscador.add(txtBuscar);
        this.buscador.add(buscar);
        this.buscador.add(label);
        


        //atras
        this.atras = new JButton();
        this.quitarBorde(this.atras);
        Cursor cursor = new Cursor(12);
        this.atras.setCursor(cursor);
        this.atras.setIcon(this.insertarImagen("src/explorador/imagenes/atras.png", 70, 70));
        this.atras.setRolloverIcon(this.insertarImagen("src/explorador/imagenes/atras.png", 65, 65));
        this.atras.setHorizontalAlignment(0);

        //crear archivo
        crearArchivo = new JButton();
        this.quitarBorde(this.crearArchivo);
        this.crearArchivo.setCursor(cursor);
        this.crearArchivo.setIcon(this.insertarImagen("src/explorador/imagenes/archivo_nuevo.png", 70, 70));
        this.crearArchivo.setRolloverIcon(this.insertarImagen("src/explorador/imagenes/archivo_nuevo.png", 65, 65));

        //crear Directorio
        crearDirectorio = new JButton();
        this.quitarBorde(this.crearDirectorio);
        this.crearDirectorio.setCursor(cursor);
        this.crearDirectorio.setIcon(this.insertarImagen("src/explorador/imagenes/nueva_carpeta.png", 70, 70));
        this.crearDirectorio.setRolloverIcon(this.insertarImagen("src/explorador/imagenes/nueva_carpeta.png", 65, 65));

        //abrir
        abrir = new JButton();
        this.quitarBorde(this.abrir);
        this.abrir.setCursor(cursor);
        this.abrir.setIcon(this.insertarImagen("src/explorador/imagenes/abrir.png", 70, 70));
        this.abrir.setRolloverIcon(this.insertarImagen("src/explorador/imagenes/abrir.png", 65, 65));

        //copiar
        copiar = new JButton();
        this.quitarBorde(this.copiar);
        this.copiar.setCursor(cursor);
        this.copiar.setIcon(this.insertarImagen("src/explorador/imagenes/Copiar.png", 70, 70));
        this.copiar.setRolloverIcon(this.insertarImagen("src/explorador/imagenes/Copiar.png", 65, 65));

        //cortar
        cortar = new JButton();
        this.quitarBorde(this.cortar);
        this.cortar.setCursor(cursor);
        this.cortar.setIcon(this.insertarImagen("src/explorador/imagenes/cortar2.png", 70, 70));
        this.cortar.setRolloverIcon(this.insertarImagen("src/explorador/imagenes/cortar.png", 65, 65));

        //pegar
        pegar = new JButton();
        this.quitarBorde(this.pegar);
        this.pegar.setCursor(cursor);
        this.pegar.setIcon(this.insertarImagen("src/explorador/imagenes/pegar.png", 70, 70));
        this.pegar.setRolloverIcon(this.insertarImagen("src/explorador/imagenes/pegar.png", 65, 65));

        //eliminar
        eliminar = new JButton();
        this.quitarBorde(this.eliminar);
        this.eliminar.setCursor(cursor);
        this.eliminar.setIcon(this.insertarImagen("src/explorador/imagenes/eliminar.png", 70, 70));
        this.eliminar.setRolloverIcon(this.insertarImagen("src/explorador/imagenes/eliminar.png", 65, 65));

        //editar
        editar = new JButton();
        this.quitarBorde(this.editar);
        this.editar.setCursor(cursor);
        this.editar.setIcon(this.insertarImagen("src/explorador/imagenes/editar.png", 70, 70));
        this.editar.setRolloverIcon(this.insertarImagen("src/explorador/imagenes/editar.png", 65, 65));

        //cerrar sesion
        this.cerrarSesion = new JButton();
        this.quitarBorde(this.cerrarSesion);
        this.cerrarSesion.setCursor(cursor);
        this.cerrarSesion.setIcon(this.insertarImagen("src/explorador/imagenes/salir.png", 70, 70));
        this.cerrarSesion.setRolloverIcon(this.insertarImagen("src/explorador/imagenes/salir.png", 68, 68));

        //habilitar o no
        this.abrir.setEnabled(false);
        this.copiar.setEnabled(false);
        this.cortar.setEnabled(false);
        this.pegar.setEnabled(Explorador.estadoPegar);
        this.eliminar.setEnabled(false);
        this.editar.setEnabled(false);

        //funciones
        this.atras.addActionListener(this);
        this.crearArchivo.addActionListener(this);
        this.crearDirectorio.addActionListener(this);
        this.pegar.addActionListener(this);
        this.abrir.addActionListener(this);
        this.copiar.addActionListener(this);
        this.cortar.addActionListener(this);
        this.eliminar.addActionListener(this);
        this.editar.addActionListener(this);
        this.cerrarSesion.addActionListener(this);
        this.buscar.addActionListener(this);

        //agregar al JPanel menu
        menu.add(atras);
        menu.add(crearArchivo);
        menu.add(crearDirectorio);
        menu.add(abrir);
        menu.add(copiar);
        menu.add(cortar);
        menu.add(pegar);
        menu.add(eliminar);
        menu.add(editar);
        menu.add(cerrarSesion);

      pintar();

        ventana.add(menu);
        ventana.add(jsp);
        ventana.add(separador0);
        ventana.add(separador4);
        ventana.add(buscador);
        ventana.add(separador2);
        ventana.add(separador3);
        ventana.add(separador5);
        this.add(ventana);

        this.setResizable(false);
        this.setBackground(Color.LIGHT_GRAY);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void pintar() {
        NodeList listaNodos = Explorador.currentDir.getChildNodes();
        for (int i = 0; i < listaNodos.getLength(); i++) {
            Panel panel = new Panel(listaNodos.item(i).getNodeName(), listaNodos.item(i).getAttributes().getNamedItem("nombre").getTextContent());
            
            JPanel elemento = panel.crear();
            elemento.addMouseListener(this);
            contenido.add(elemento);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (ultimoClickeado != null) {
            ultimoClickeado.setBackground(Color.WHITE);
        }
        me.getComponent().setBackground(new Color(0, 0, 249));
        ultimoClickeado = (JPanel) me.getComponent();
        JLabel tipoComponente = (JLabel) ultimoClickeado.getComponent(1);
        if (tipoComponente.getText().equals("directorio")) {
            abrir.setEnabled(true);
        } else {
            abrir.setEnabled(false);
        }
        cortar.setEnabled(true);
        copiar.setEnabled(true);
        eliminar.setEnabled(true);
        editar.setEnabled(true);
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    //BUSCAR ELEMENTOOOO (lupa)
    public void actionPerformed(ActionEvent ae) {
         if (ae.getSource() == buscar) {
             String aux = "";
             boolean hallado = false;
             if(this.txtBuscar.getText().length()>0){
                 aux = this.txtBuscar.getText(); // ARCHIVO A BUSCAR
                 NodeList listaNodos = Explorador.currentDir.getChildNodes();//TRAIGO LOS NODOS DEL ARBOL
                 int i = 0;
                // se puso el hallado para q sea mas eficiente by cortez 
                while(i < listaNodos.getLength() && !hallado) {
                    this.contenido.getComponent(i).setBackground(new Color(255, 255,255));
                    // FONDO BLANCO
                    if(aux.equalsIgnoreCase(listaNodos.item(i).getAttributes().getNamedItem("nombre").getTextContent())){
                        this.contenido.getComponent(i).setBackground(new Color(0, 211, 249));
                        //FONDO AZUL
                        hallado = true;
                        
                    
                    }
                    i++;
           
                }
                if(hallado == false){
                    JOptionPane.showMessageDialog(rootPane, "Archivo o directorio no existe");
                    this.txtBuscar.setText("");
                }else{
                    this.txtBuscar.setText("");
                }
             }
           
        }
        if (ae.getSource() == crearArchivo) {
            new InterfazCrearElemento("Archivo");
            this.dispose();
        }
        if (ae.getSource() == crearDirectorio) {
            new InterfazCrearElemento("Directorio");
            this.dispose();
        }
        if (ae.getSource() == abrir) {
            JLabel nombreDirectorio = (JLabel) ultimoClickeado.getComponent(2);
            Element ultimo = Directorio.obtenerNodoHijo(nombreDirectorio.getText());
            if (ultimo.getAttribute("lectura").equals("Público") || ultimo.getAttribute("dueño").equals(Explorador.currentUser.getAttribute("nombre"))) {
                Explorador.currentDir = Directorio.obtenerNodoHijo(nombreDirectorio.getText());
                this.dispose();
                new Interfaz();
                Explorador.setCurrentLevel(Explorador.getCurrentLevel() + 1);
            } else {
                JOptionPane.showMessageDialog(null, "No tienes permisos de lectura de este fichero", "Error de acceso", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (ae.getSource() == atras) {
            if (Explorador.getCurrentLevel() > 1) {
                Explorador.currentDir = (Element) Explorador.currentDir.getParentNode();
                this.dispose();
                new Interfaz();
                Explorador.setCurrentLevel(Explorador.getCurrentLevel() - 1);
            }
        }
        if (ae.getSource() == copiar) {
            JLabel nombreElemento = (JLabel) ultimoClickeado.getComponent(2);
            JLabel tipoElemento = (JLabel) ultimoClickeado.getComponent(1);
            if (tipoElemento.getText().equals("archivo")) {
                Explorador.elementoaPegar = Archivo.obtenerNodoHijo(nombreElemento.getText());
            } else {
                Explorador.elementoaPegar = Directorio.obtenerNodoHijo(nombreElemento.getText());
            }
            if (Explorador.elementoaPegar.getAttribute("escritura").equals("Público") || Explorador.elementoaPegar.getAttribute("dueño").equals(Explorador.currentUser.getAttribute("nombre"))) {
                pegar.setEnabled(true);
                Explorador.estadoPegar = true;
            } else {
                JOptionPane.showMessageDialog(null, "No tienes permisos para copiar este elemento", "Acceso denegado", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (ae.getSource() == cortar) {
            JLabel nombreElemento = (JLabel) ultimoClickeado.getComponent(2);
            JLabel tipoElemento = (JLabel) ultimoClickeado.getComponent(1);
            if (tipoElemento.getText().equals("archivo")) {
                Explorador.elementoaPegar = Archivo.obtenerNodoHijo(nombreElemento.getText());
            } else {
                Explorador.elementoaPegar = Directorio.obtenerNodoHijo(nombreElemento.getText());
            }
            if (Explorador.elementoaPegar.getAttribute("escritura").equals("Público") || Explorador.elementoaPegar.getAttribute("dueño").equals(Explorador.currentUser.getAttribute("nombre"))) {
                int id_removido = Integer.parseInt(Explorador.elementoaPegar.getAttribute("id"));
                Elemento removido = new Elemento(id_removido, nombreElemento.getText(), tipoElemento.getText());
                removido.eliminar();
                pegar.setEnabled(true);
                Explorador.estadoPegar = true;
            } else {
                JOptionPane.showMessageDialog(null, "No tienes permisos para cortar este elemento", "Acceso denegado", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (ae.getSource() == pegar) {
            System.out.println(Explorador.elementoaPegar);
            if (Explorador.elementoaPegar.getNodeName().equals("archivo")) {
                Archivo archivo = new Archivo(Explorador.getCurrentId(), Explorador.elementoaPegar.getAttribute("nombre"), "Archivo", "Lorem", true, true, "adm");
                archivo.agregar();
                this.dispose();
                new Interfaz();
            } else {
                Directorio directorio = new Directorio(Explorador.getCurrentId(), Explorador.elementoaPegar.getAttribute("nombre"), "directorio", true, true, "Adm");
                directorio.clonar();
                this.dispose();
                new Interfaz();
            }
        }
        if (ae.getSource() == eliminar) {
           JLabel nombreElemento = (JLabel) ultimoClickeado.getComponent(2);
            JLabel tipoElemento = (JLabel) ultimoClickeado.getComponent(1);
            if (tipoElemento.getText().equals("archivo")) {
                Explorador.elementoaPegar = Archivo.obtenerNodoHijo(nombreElemento.getText());
            } else {
                Explorador.elementoaPegar = Directorio.obtenerNodoHijo(nombreElemento.getText());
            }
            if (Explorador.elementoaPegar.getAttribute("escritura").equals("Público") || Explorador.elementoaPegar.getAttribute("dueño").equals(Explorador.currentUser.getAttribute("nombre"))) {
                int id_removido = Integer.parseInt(Explorador.elementoaPegar.getAttribute("id"));
                Elemento removido = new Elemento(id_removido, nombreElemento.getText(), tipoElemento.getText());
                removido.eliminar();
                pegar.setEnabled(true);
                Explorador.estadoPegar = true;
                System.out.println(Explorador.elementoaPegar);
            if (Explorador.elementoaPegar.getNodeName().equals("archivo")) {
                Archivo archivo = new Archivo(Explorador.getCurrentId(), Explorador.elementoaPegar.getAttribute("nombre"), "Archivo", "Lorem", true, true, "adm");
                archivo.agregarArbolPapelera();
                this.dispose();
                new Interfaz();
            } else {
                Directorio directorio = new Directorio(Explorador.getCurrentId(), Explorador.elementoaPegar.getAttribute("nombre"), "directorio", true, true, "adm");
                directorio.agregarArbolPapelera();
                this.dispose();
                new Interfaz();
            }
                
                
                
            } else {
                JOptionPane.showMessageDialog(null, "No tienes permisos para cortar este elemento", "Acceso denegado", JOptionPane.ERROR_MESSAGE);
            }
           
        }
        if (ae.getSource() == editar) {
            JLabel nombreDirectorio = (JLabel) ultimoClickeado.getComponent(2);
            JLabel tipoElemento = (JLabel) ultimoClickeado.getComponent(1);
            Element ultimo;
            if (tipoElemento.getText().equals("directorio")) {
                ultimo = Directorio.obtenerNodoHijo(nombreDirectorio.getText());
            } else {
                ultimo = Archivo.obtenerNodoHijo(nombreDirectorio.getText());
            }
            if (ultimo.getAttribute("escritura").equals("Público") || ultimo.getAttribute("dueño").equals(Explorador.currentUser.getAttribute("nombre"))) {
                this.dispose();
                new InterfazEditarElemento(tipoElemento.getText());
            } else {
                JOptionPane.showMessageDialog(null, "No tienes permisos para cortar este elemento", "Acceso denegado", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (ae.getSource() == cerrarSesion) {
            Usuario.cerrarSesion();
            this.dispose();
            escritorio a=new escritorio();
            a.setVisible(true);
        }
       
    }

    class Panel {

        private final String tipo, nombre;
        private JButton imagen;

        public Panel(String tipo, String nombre) {
            this.tipo = tipo;
            this.nombre = nombre;
            this.imagen = new JButton();
        }

        public JPanel crear() {
            Cursor cursor = new Cursor(12);
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            JLabel nombre = new JLabel(this.nombre);
            JLabel tipo = new JLabel(this.tipo);
            tipo.setHorizontalAlignment(0);
            panel.setBackground(new Color(255,255,255));
            panel.setCursor(cursor);
            this.quitarBorde(this.imagen);
            if(this.tipo.equalsIgnoreCase("archivo")){
                this.imagen.setIcon(this.insertarImagen("src/explorador/imagenes/archivo.png", 70, 70));
                this.imagen.setRolloverIcon(this.insertarImagen("src/explorador/imagenes/archivo.png", 67, 67));
            }else{
                if(this.tipo.equalsIgnoreCase("directorio")){
                    this.imagen.setIcon(this.insertarImagen("src/explorador/imagenes/carpeta_llena.png", 70, 70));
                    this.imagen.setRolloverIcon(this.insertarImagen("src/explorador/imagenes/carpeta_llena.png", 67, 67));
                }
            }
            
            panel.add(imagen);
            panel.add(tipo);
            panel.add(nombre);
            
            
            
            return panel;
        }

        public ImageIcon insertarImagen(String imagen, int ancho, int altura) {
            ImageIcon imagenPrincipal = new ImageIcon(imagen);
            Image conversion = imagenPrincipal.getImage();
            Image tamaño = conversion.getScaledInstance(ancho, altura, Image.SCALE_SMOOTH);
            ImageIcon imagenFinal = new ImageIcon(tamaño);
            return (imagenFinal);
        }

        public void quitarBorde(JButton btn) {
            btn.setBorder(null);
            btn.setContentAreaFilled(false);
        }
    }

    public ImageIcon insertarImagen(String imagen, int ancho, int altura) {
        ImageIcon imagenPrincipal = new ImageIcon(imagen);
        Image conversion = imagenPrincipal.getImage();
        Image tamaño = conversion.getScaledInstance(ancho, altura, Image.SCALE_SMOOTH);
        ImageIcon imagenFinal = new ImageIcon(tamaño);
        return (imagenFinal);
    }

    public void quitarBorde(JButton btn) {
        btn.setBorder(null);
        btn.setContentAreaFilled(false);
    }
}
