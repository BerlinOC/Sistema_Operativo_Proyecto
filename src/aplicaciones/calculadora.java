/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaciones;

import java.io.IOException;


public class calculadora {
    public void llamadaCaluladora(){
    try        
    {
        Runtime rt = Runtime.getRuntime();           
        Process p = rt.exec("calc");            
        p.waitFor();        
    }        
    catch ( IOException ioe )       
    {            
        ioe.printStackTrace();
    }         
    catch ( InterruptedException ie )
    {            
        ie.printStackTrace();     
    }
    }
    
}
