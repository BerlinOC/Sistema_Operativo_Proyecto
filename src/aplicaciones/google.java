/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaciones;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


public class google {
    
   public void llamadaGoogle() throws IOException{
     

  Runtime myRuntime = Runtime.getRuntime(); 
        try{ 
            myRuntime.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe www.google.com"); 
        }catch(Exception ex){ 
        ex.printStackTrace();}

}
  
    
}

