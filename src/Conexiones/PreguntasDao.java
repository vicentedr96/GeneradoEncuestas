/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vicen
 */
public abstract class PreguntasDao {
    
    
    
    
    public void crearEncuesta(String arr[][]){
        //el array debe estar incializado en en el 2 [] en 11 

        //necesito el dato del ultimo registro o irme a la otra tabla
        
            Connection con = null;
            PreparedStatement pstm = null;
        
        try {
            con = UConnection2.getConnection();
            
            int contador=1;
            for(int i=0; i<arr.length; i++){
            con.setAutoCommit(false);    

            String sql="";
          
            sql+="INSERT INTO  preguntas(id,numero,pregunta,opcion1,opcion2,opcion3,opcion4,opcion5,\n" +
"                       opcion6,opcion7,opcion8,opcion9,opcion10)";
            
            sql+=" Values((SELECT MAX(id) from datosdeencuesta),?,?,?,?,?,?,?,?,?,?,?,?)";
             
          
            
            pstm=con.prepareStatement(sql);
            pstm.setInt(1, contador);
            pstm.setString(2, arr[i][0]);//pregunta
            pstm.setString(3, arr[i][1]);
            pstm.setString(4, arr[i][2]);    
            pstm.setString(5, arr[i][3]);
            pstm.setString(6, arr[i][4]);
            pstm.setString(7, arr[i][5]);
            pstm.setString(8, arr[i][6]);
            pstm.setString(9,arr[i][7]);
            pstm.setString(10,arr[i][8]);
            pstm.setString(11,arr[i][9]);
            pstm.setString(12,arr[i][10]);
            
            
            contador++;
            
            int rtdo=pstm.executeUpdate();
            if(rtdo==1){
            
                System.out.println("exito ");
                con.commit();
               }else{
                
                System.out.println("fallo");
               }
           }
           
           } catch (SQLException ex) {
            Logger.getLogger(PreguntasDao.class.getName()).log(Level.SEVERE, null, ex);
           }
           finally{
			try
			{
				if(con!=null)con.rollback();
				if( pstm!=null ) pstm.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
        
        }
    
    //
    
        public void eliminarEncuesta(int arr){
        //el array debe estar incializado en en el 2 [] en 11 

            Connection con = null;
            PreparedStatement pstm = null;
        
        try {
            con = UConnection2.getConnection();
    
            con.setAutoCommit(false);
            String sql="";
            sql+="DELETE FROM PREGUNTAS ";
            sql+=" WHERE id= ? ";
            
            pstm=con.prepareStatement(sql);
            pstm.setInt(1,arr);
 
            int rtdo=pstm.executeUpdate();
            if(rtdo>0){ //1
            
                System.out.println("exito ");
                con.commit();
               }else{
                
                System.out.println("fallo");
               }
            
           
           } catch (SQLException ex) {
            Logger.getLogger(PreguntasDao.class.getName()).log(Level.SEVERE, null, ex);
           }
           finally{
			try
			{
				if(con!=null)con.rollback();
				if( pstm!=null ) pstm.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
        
        } 
        
       //
        
       
        
 
        
        
}
        
        
       
    
            
            



