package explorador;

import org.w3c.dom.NodeList;

/**
 *
 * @author sistemas Operativos
 */
public class Elemento {
    private int id;
    private String nombre;
    private String tipo;
    
    public Elemento(int id, String nombre, String tipo){
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void agregar(){
        
    }
    
    public void eliminar(){
        NodeList nodeList = Explorador.currentDir.getChildNodes();
        //NodeList --> son colecciones de nodos
        //Colección de nodos a los que se puede acceder por medio de un índice.
        
        //
        boolean eliminado = false;
        for(int i = 0; i < nodeList.getLength(); i++){
            if(nodeList.item(i).getAttributes().getNamedItem("id").getTextContent().equals(String.valueOf(this.getId())) && !eliminado){
                Explorador.currentDir.removeChild(nodeList.item(i));
                Explorador.id_soltados.add(this.getId());
                eliminado = true;
            }     
        }        
        XMLManager xml = new XMLManager();       
        xml.guardar();
    }
    
    public void eliminarPapelera(){
        NodeList nodeList = Explorador.currentDir2.getChildNodes();
        //NodeList --> son colecciones de nodos
        //Colección de nodos a los que se puede acceder por medio de un índice.
        
        //
        boolean eliminado = false;
        for(int i = 0; i < nodeList.getLength(); i++){
            if(nodeList.item(i).getAttributes().getNamedItem("id").getTextContent().equals(String.valueOf(this.getId())) && !eliminado){
                Explorador.currentDir2.removeChild(nodeList.item(i));
                Explorador.id_soltados2.add(this.getId());
                eliminado = true;
            }     
        }        
        XMLManager xml = new XMLManager();       
        xml.guardarArbolPapelera();
    }
    
    
}