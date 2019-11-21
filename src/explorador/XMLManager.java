package explorador;

import static explorador.Explorador.*;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
/**
 *
 * @author Sistemas operativos
 */
public class XMLManager {
    public void crear(){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            // root element
            Document doc = docBuilder.newDocument();
            doc.setXmlVersion("1.0");
            doc.setXmlStandalone(false);
            Element rootElement = doc.createElement("directorio");
            doc.appendChild(rootElement);
            Attr attr = doc.createAttribute("id");
            attr.setValue(String.valueOf(Explorador.getCurrentId()));
            rootElement.setAttributeNode(attr);
            
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("arbol.xml"));                  
            transformer.transform(source, result);
            Explorador.setCurrentId(Explorador.getCurrentId() + 1);
            arbol = doc;
            arbol.getDocumentElement().normalize();
            currentDir = arbol.getDocumentElement();
            Explorador.setCurrentId(currentDir.getChildNodes().getLength());
            
           
            
        } catch (ParserConfigurationException | TransformerException pce) {
            System.err.print(pce.getMessage());
        }
    }
    
    public void crearArbolPapelera(){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            // root element
            Document doc = docBuilder.newDocument();
            doc.setXmlVersion("1.0");
            doc.setXmlStandalone(false);
            Element rootElement = doc.createElement("directorio2");
            doc.appendChild(rootElement);
            Attr attr = doc.createAttribute("id2");
            attr.setValue(String.valueOf(Explorador.getCurrentId2()));
            rootElement.setAttributeNode(attr);
            
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("papelera.xml"));                  
            transformer.transform(source, result);
            Explorador.setCurrentId2(Explorador.getCurrentId2() + 1);
            arbol2 = doc;
            arbol2.getDocumentElement().normalize();
            currentDir2 = arbol2.getDocumentElement();
            Explorador.setCurrentId2(currentDir2.getChildNodes().getLength());
            
           
            
        } catch (ParserConfigurationException | TransformerException pce) {
            System.err.print(pce.getMessage());
        }
    }
    
    public void crearTablaUsuario(){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            // root element
            Document doc = docBuilder.newDocument();
            doc.setXmlVersion("1.0");
            doc.setXmlStandalone(false);
            Element rootElement = doc.createElement("usuarios");
            doc.appendChild(rootElement);
            
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("usuarios.xml"));                  
            transformer.transform(source, result);
            Explorador.setCurrentId(Explorador.getCurrentId() + 1);
            arbolUsuarios = doc;
            arbolUsuarios.getDocumentElement().normalize();
            usersContainer = arbolUsuarios.getDocumentElement();
        } catch (ParserConfigurationException | TransformerException pce) {
            System.err.print(pce.getMessage());
        }
    }
    
    public void guardar(){
        try{
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(Explorador.arbol);
            StreamResult result = new StreamResult(new File("arbol.xml"));                  
            transformer.transform(source, result);          
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    public void guardarArbolPapelera(){
        try{
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(Explorador.arbol2);
            StreamResult result = new StreamResult(new File("papelera.xml"));                  
            transformer.transform(source, result);          
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void guardarUsuario(){
        try{
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(Explorador.arbolUsuarios);
            StreamResult result = new StreamResult(new File("usuarios.xml"));                  
            transformer.transform(source, result);           
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}


