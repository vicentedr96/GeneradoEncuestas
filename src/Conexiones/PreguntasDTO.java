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
public class PreguntasDTO {
    
    public int id;
    public int numero;
    public String pregunta;
    public String opcion1;
    public String opcion2;
    public String opcion3;
    public String opcion4;
    public String opcion5;
    public String opcion6;
    public String opcion7;
    public String opcion8;
    public String opcion9;
    public String opcion10;

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getOpcion4() {
        return opcion4;
    }

    public void setOpcion4(String opcion4) {
        this.opcion4 = opcion4;
    }

    public String getOpcion5() {
        return opcion5;
    }

    public void setOpcion5(String opcion5) {
        this.opcion5 = opcion5;
    }

    public String getOpcion6() {
        return opcion6;
    }

    public void setOpcion6(String opcion6) {
        this.opcion6 = opcion6;
    }

    public String getOpcion7() {
        return opcion7;
    }

    public void setOpcion7(String opcion7) {
        this.opcion7 = opcion7;
    }

    public String getOpcion8() {
        return opcion8;
    }

    public void setOpcion8(String opcion8) {
        this.opcion8 = opcion8;
    }

    public String getOpcion9() {
        return opcion9;
    }

    public void setOpcion9(String opcion9) {
        this.opcion9 = opcion9;
    }

    public String getOpcion10() {
        return opcion10;
    }

    public void setOpcion10(String opcion10) {
        this.opcion10 = opcion10;
    }

    public void setId(int i){
    this.id=i;
    }
    public int getId(){
    return id;
    }
    
    public void setNumero(int n){
    this.numero=n;
    }
    public int getNumero(){
    return numero;
    }
    
    public void setPregunta(String p){
    this.pregunta=p;
    }
    public String getPregunta(){
    return pregunta;
    }
    
    
}
