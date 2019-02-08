package Grafico;


import Conexiones.DatosDeEncuestaDTO;
import Conexiones.Facade;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vicen
 */
public class MetodosExtra {
  
public boolean disponible=true;
public boolean ocupado=false;
 Font fuente = new Font("Tahoma", Font.PLAIN, 15);



public void ControlaInstancia(JInternalFrame inter, JDesktopPane jl){

//para centrat el JInternal
 
Dimension desktopSize = jl.getSize();
Dimension FrameSize = inter.getSize();
inter.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
    
boolean mostrar=true;
for (int a=0;a<jl.getComponentCount();a++){     // verificar si es instancia de algun componente que ya este en el jdesktoppane
    if( inter.getClass().isInstance( jl.getComponent(a) )){
    
        mostrar=false;
 
    }else{
        System.out.println("no lo es, puede mostrarse");
    }
}
if(mostrar){
    
jl.add(inter);
inter.show();  
     }
 
}
    
    public void generarPreguntasMustra(JSpinner spnP,JSpinner spnR,JTextArea txtA){
    
      
      int x=((int)spnP.getValue());
      int y=((int)spnR.getValue());
      String texto="";
      char c;
      

      for(int i=1; i<=x; i++){//preguntas
          texto+="\n"+i+" Pregunta De Muestra . \n";
           for(int ii=0; ii<y; ii++){//respuestas
            c=(char)('A'+ii); 
            texto+=c+". opcion_ \t"; 
      }
      }
      txtA.setText(texto);
     
    }
    
    public String [][] guardarPR(JTextArea txtA,JSpinner spnR,JSpinner spnP){
        
    String s="";//para guardar el subString
    char c;// para guardar el caracter
    int contador2=1;//contandor de las preguntas
    int c3=0;//sumar al caracter A para el siguiente B...
    String copia=txtA.getText();
    int nP=((int)spnP.getValue());//se guarda en el 0
    int nR=((int)spnR.getValue()); //por lo que se suma 1
    
    //String datos[][]=new String[nP][nR+1];
    String datos[][]=new String[nP][11];
    

    for (int i=0; i<datos.length; i++){
        
        c3=0;
    int desde=copia.indexOf(Integer.toString(contador2));
    int hasta=copia.indexOf(".");
    
  
       
    if(i>=9){// mas de dos digitos +2 
         datos[i][0]=copia.substring(desde+2,hasta);
         s=copia.substring(desde,hasta+1);
         copia=copia.replaceFirst(s, "");
         contador2++;
        }else{
            datos[i][0]=copia.substring(desde+1,hasta);
            s=copia.substring(desde,hasta+1);
            copia=copia.replaceFirst(s, "");//
            contador2++;
        }
      
      for(int ii=1; ii<nR+1; ii++){//datos[i].length; para que ya no pase hasta 11--nR+1 encontrar mejor solucion
      
    c=(char)('A'+c3);
     desde = copia.indexOf(c);
     hasta = copia.indexOf("_");
    
    if(desde!=-1 || hasta!=-1){
    datos[i][ii]=copia.substring(desde+2,hasta);
    s=copia.substring(desde,hasta+1);
    copia=copia.replaceFirst(s, " ");
    c3++;
    }else{
      
    }
   
    } }
        
    return datos;
       

        
    }
    
    public String eliminarCadenas(int empieza,int termina,String t){
    
     
       int x1=0; //empieza
       int  y1=11;//termina

        
           String  copias="";
        
        for(int x=0; x<t.length(); x++){
        
         
            if(x>=x1 && x<=y1){
 
            copias+="";
            }else{
            
            copias+=t.charAt(x)+"";
            }
    }
        return copias;
    }
    
    // controlar los colores
    public void corregirColor(JTextField txtFNocmbre,JSpinner spnR,JSpinner spnP,JTextArea txtaIntr,JTextArea txtaPR,
    JLabel lbl1,JLabel lbl2,JLabel lbl3,JLabel lbl4){

    String texto=txtFNocmbre.getText();
    String texto2=txtaIntr.getText();

    texto=texto.replaceAll(" ", "");
    texto2=texto2.replaceAll(" ", "");
    
    if(texto.length()==0){
       
       lbl1.setForeground(Color.RED);
       }else{
       lbl1.setForeground(Color.BLACK);
       } 
       
       if( (int)(spnR.getValue())==0){
       lbl2.setForeground(Color.RED);
       }else{
       lbl2.setForeground(Color.BLACK);
       } 
        
       if((int)(spnP.getValue())==0){
       lbl3.setForeground(Color.RED);
       }else{
       lbl3.setForeground(Color.BLACK);
       }
       
       if(texto2.length()==0){
       
       lbl4.setForeground(Color.RED);
       }else{
       lbl4.setForeground(Color.BLACK);
       } 

}
    
    public void muestra(String a[][],JButton btn){// al estar abierto y invoarlo de nuevo error
   
       
    File file =new File("prueba.doc");
  
    file.delete();
    
 
   if(!file.exists()){
    
    try {
        
        file.createNewFile();
        
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    }

if (! Desktop.isDesktopSupported ()) {
JOptionPane.showMessageDialog(null, "Desktop no es compatible");
}else{
    
        try {
          //  FileWriter fw =new FileWriter(file,true);
       PrintWriter fw=new PrintWriter(file,"utf-8");
       for(int i=0; i<a.length;  i++){
           fw.println();
           fw.println();
           fw.print(i+"."+a[i][0]);
           fw.println();     
       for(int ii=1; ii<a[i].length; ii++){
       
           fw.print(a[i][ii]+",");    
       }
       }
        fw.close();
       }catch (Exception ex) {
        ex.printStackTrace();
       }

 try {
        
            Desktop.getDesktop().open(file);
            btn.setEnabled(false);
          
     }catch (IOException ex) {
            System.out.println(ex);
  }  
}  }
    
    
    public String [] obtenerDatosEspeificos(JTextArea txtA,JTextField txtF){
    
        String arr1[]=new String[2];
        arr1[0]=txtA.getText();//instrucciones
        arr1[1]=txtF.getText();//nombre de encuesta
                

        
        return arr1;
    }
    
    public void moficarTabla(JTable table ,DefaultTableModel modelo){

    modelo.addColumn("ID");
    modelo.addColumn("Nombre De Encuesta");
  
    table.setModel(modelo);
     // table.setBackground(Color.white);
   table.setFont(fuente);
 
    //JScrollPane scrollpane = new JScrollPane(table);
    }
    
    public void limpiarTabla(JTable table, DefaultTableModel modelo){
        
         for (int i = 0; i < table.getRowCount(); i++) {
         modelo.removeRow(i);
         i-=1;
         }
}
    
    
        public Object[][] obtenerMatrizDatos(){
        
        Facade f=new Facade();
        Collection <DatosDeEncuestaDTO> coll=f.obtenerIdNombre();
        Object  []Columnas={"Id","Nombre De Encuesta"};
        Object[][] datos = new Object[coll.size()][Columnas.length];
        System.out.println(coll.size()+","+Columnas.length);
        int r=0;
        for(DatosDeEncuestaDTO dto2:coll){
       
         datos[r][0]=dto2.getId();
      
         datos[r][1]=dto2.getNombreDeEncuesta();
         System.out.println("e"+datos[r][0]+","+datos[r][1]);
         r++;
         }
        System.out.println("salio");
        return datos;
        
        }
        
        public void actualizarTabla(JTable tableDatos,DefaultTableModel modelo){
        
        
          limpiarTabla(tableDatos, modelo);
          Object[][] datoss=obtenerMatrizDatos();
          int i=0;
          for(Object d:datoss){
          modelo.addRow(datoss[i]);
          i++; }
        }
        
        
public void filtro(JTextField txtF,TableRowSorter trsfiltro,int i) {
trsfiltro.setRowFilter(RowFilter.regexFilter(txtF.getText(), i));
}
public int obtnerCombo( JComboBox j){
    
    int i=0;
   
    String valorComboBox = j.getSelectedItem().toString();
  
    if(valorComboBox.equals("NOMBRE")){
    
     return   i=1;
        
    }else{
    
  return  i=0;
    }
    
    
}









}