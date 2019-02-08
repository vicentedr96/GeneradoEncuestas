/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import java.util.Hashtable;
import java.util.ResourceBundle;

/**
 *
 * @author vicen
 */
public class UFactory2 {
    
     private static Hashtable<String,Object> instancias = new Hashtable<String,Object>();
  
    
    public static Object getInstancia(String objName){
    
        
        try{
            Object obj=instancias.get(objName);
            
            if(obj==null){
            
            ResourceBundle rb = ResourceBundle.getBundle("factory");
            String sClassname=rb.getString(objName);
            obj=Class.forName(sClassname).newInstance();
            
            instancias.put(objName, obj);
            
            }
            return obj;
            
        
        }catch(Exception ex){
        ex.printStackTrace();
        throw new RuntimeException(ex);
        }
    }
}
