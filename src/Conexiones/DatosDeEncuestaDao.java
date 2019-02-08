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
import java.util.Collection;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vicen
 */
public  abstract class DatosDeEncuestaDao {
    
        public void crearDatosEspecificos(String arr1[]){



            Connection con = null;
            PreparedStatement pstm = null;
        
        try {
            con = UConnection2.getConnection();
            con.setAutoCommit(false);
            String sql="";
            sql+="Insert into datosdeencuesta (intrucciones,nombreDeEncuesta) ";
            sql+=" Values(?,?)";
            
            pstm=con.prepareStatement(sql);
            
            
            pstm.setString(1, arr1[0]);
            pstm.setString(2, arr1[1]);
    
            int rtdo=pstm.executeUpdate();
            
            if(rtdo==1){
            
                System.out.println("exito ");
                 con.commit();
               }else{
            
                System.out.println("falla");
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
        
        
        
        
        ///
        

        
        public int  cantidadDeEncuestas()
	{
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int dato = 0;
		try
		{
			con = UConnection2.getConnection();
			String sql = "";
		        sql+="select count(id) ";
                        sql+="from datosdeencuesta ";
			
			pstm = con.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			
                        if(rs.next()) {
    
                          dato=rs.getInt(1);
            
                        }else{
            
            
                        }
                        
			
			return dato;
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally
		{
			try
			{
				if( rs!=null ) rs.close();
				if( pstm!=null ) pstm.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
        
        
        ///
        
        
        //consulta para obtener id y nombre de la encuesta
        public Collection <DatosDeEncuestaDTO> obtenerIdNombre()
	{
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			con = UConnection2.getConnection();
			String sql = "";
			sql+="SELECT id,nombreDeEncuesta ";
			sql+="FROM DatosDeEncuesta";
			
			pstm = con.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			
			Vector<DatosDeEncuestaDTO> ret = new Vector<DatosDeEncuestaDTO>();
			DatosDeEncuestaDTO dto = null;
			
			while( rs.next() )
			{
				dto = new DatosDeEncuestaDTO();
				dto.setId(rs.getInt("id") );
				dto.setNombreDeEncuesta(rs.getString("nombreDeEncuesta") );
				ret.add(dto);
			}
			
			return ret;
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally
		{
			try
			{
				if( rs!=null ) rs.close();
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
        
                public void eliminarDatosEspecificos(int n){
        //el array debe estar incializado en en el 2 [] en 11 

            Connection con = null;
            PreparedStatement pstm = null;
        
        try {
            con = UConnection2.getConnection();

            con.setAutoCommit(false);
            String sql="";
            sql+="DELETE FROM DatosDeEncuesta ";
            sql+=" WHERE id= ? ";
            
            pstm=con.prepareStatement(sql);
            pstm.setInt(1,n);
 
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
                
          public void modificarInstrucciones(int id,String instrucciones){
        //el array debe estar incializado en en el 2 [] en 11 

            Connection con = null;
            PreparedStatement pstm = null;
        
        try {
            con = UConnection2.getConnection();

            con.setAutoCommit(false);
            String sql="";
            sql+="UPDATE DatosDeEncuesta ";
            sql+="SET INTRUCCIONES= ?";
            sql+=" WHERE id= ? ";

            pstm=con.prepareStatement(sql);
            pstm.setString(1,instrucciones);
            pstm.setInt(2,id);
 
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
          
          
            public void modificarNombre(int id,String nombre){
        //el array debe estar incializado en en el 2 [] en 11 

            Connection con = null;
            PreparedStatement pstm = null;
        
        try {
            con = UConnection2.getConnection();

            con.setAutoCommit(false);
            String sql="";
            sql+="UPDATE DatosDeEncuesta ";
            sql+="SET NOMBREDEENCUESTA= ? ";
            sql+=" WHERE id= ? ";

            pstm=con.prepareStatement(sql);
            pstm.setString(1,nombre);
            pstm.setInt(2,id);
 
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
                
}


