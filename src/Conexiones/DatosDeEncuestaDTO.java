/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

/**
 *
 * @author vicen
 */
public class DatosDeEncuestaDTO {

    
    public int id;
    public String intrucciones;
    public String nombreDeEncuesta;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntrucciones() {
        return intrucciones;
    }

    public void setIntrucciones(String intrucciones) {
        this.intrucciones = intrucciones;
    }

    public String getNombreDeEncuesta() {
        return nombreDeEncuesta;
    }

    public void setNombreDeEncuesta(String nombreDeEncuesta) {
        this.nombreDeEncuesta = nombreDeEncuesta;
    }
    
   
    
}
