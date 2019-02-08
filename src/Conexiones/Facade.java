/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import java.util.Collection;

/**
 *
 * @author vicen
 */
public class Facade {
    
    
    public void crearEncuesta(String arr[][]){
    
    PreguntasDao preg=(PreguntasDao)UFactory2.getInstancia("Preguntas");
    preg.crearEncuesta(arr);
        
        
    }
    
    public void crearDatosEspecificos(String arr1[]){
    DatosDeEncuestaDao dat=(DatosDeEncuestaDao)UFactory2.getInstancia("DatosDeEncuesta");
    dat.crearDatosEspecificos(arr1);
    }
    
    public int cantidadDeEncuestas(){
    DatosDeEncuestaDao dat=(DatosDeEncuestaDao)UFactory2.getInstancia("DatosDeEncuesta");
    return  dat.cantidadDeEncuestas();
    }
    
    public Collection <DatosDeEncuestaDTO> obtenerIdNombre(){
    
    DatosDeEncuestaDao dat=(DatosDeEncuestaDao)UFactory2.getInstancia("DatosDeEncuesta");
    return dat.obtenerIdNombre();
    
    
    }
    
    public void eliminarEncuestas(int arr){
    PreguntasDao preg=(PreguntasDao)UFactory2.getInstancia("Preguntas");
    preg.eliminarEncuesta(arr);
    }
    
    public void eliminarDatosEspecificos(int n){
    DatosDeEncuestaDao dat=(DatosDeEncuestaDao)UFactory2.getInstancia("DatosDeEncuesta");
    dat.eliminarDatosEspecificos(n);
    
    }
    public void modificarInstrucciones(int id,String instrucciones){
    DatosDeEncuestaDao dat=(DatosDeEncuestaDao)UFactory2.getInstancia("DatosDeEncuesta");
    dat.modificarInstrucciones(id, instrucciones);
    
    
    }
    public void modificarNombre(int id,String instrucciones){
    DatosDeEncuestaDao dat=(DatosDeEncuestaDao)UFactory2.getInstancia("DatosDeEncuesta");
    dat.modificarNombre(id, instrucciones);
    
    
    }
    
 
            
            
            
}
