package Grafico;


import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vicen
 */
public class iconoMensaje implements Icon {

    public int eleccion;

    public int getEleccion() {
        return eleccion;
    }

    public void setEleccion(int eleccion) {
        this.eleccion = eleccion;
    }

    @Override
    public void paintIcon(Component cmpnt, Graphics grphcs, int i, int i1) {
        if(getEleccion()==1){
         Image image = new ImageIcon(getClass().getResource("/Recursos/icon1.jpg")).getImage();
         grphcs.drawImage(image, i, i1, cmpnt);
        }else{
          Image image = new ImageIcon(getClass().getResource("/Recursos/icon2.jpg")).getImage();
         grphcs.drawImage(image, i, i1, cmpnt);
        }
    }

    @Override
    public int getIconWidth() {
  return 50;
    }

    @Override
    public int getIconHeight() {
    return 50;
    }
    
 
    
}
