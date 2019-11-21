/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaciones;

import java.io.IOException;
import javax.swing.JOptionPane;


public class Juego {
    
    public void pacMan(){
        try{
          Runtime pacman = Runtime.getRuntime();  
          pacman.exec("pacman\\juego\\Pac-Man..exe");
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error de ejecucion de Pac-Man", "Acceso denegado", JOptionPane.ERROR_MESSAGE);
        }
    
    }
}
