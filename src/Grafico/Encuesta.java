package Grafico;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vicen
 */
public class Encuesta {
    
public  String nombre;
public  String instrucciones;
public  String contenedor[][];

public  int numP;
public  int numR;

public Encuesta(String nombre,int numR,int numP,String instrucciones){

this.nombre=nombre;
this.instrucciones=instrucciones;
contenedor=new String [numR][numP];
        
}

public Encuesta(){}
     
public void setNumP(int numP){
this.numP=numP;
}

public int getNumP(){
return numP;
}

public void setNumR(int numR){
this.numR=numR;
}

public int  getNumR(){
return numR;
}

public void setNombre(String n){
this.nombre=n;
}
public String getNombre(){
return nombre;
}

public void setInstrucciones(String ins){
this.instrucciones=ins;
}
public String getInstrucciones(){
return instrucciones;
}




 
    
}
