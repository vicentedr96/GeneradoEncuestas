/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;


/**
 *
 * @author vicen
 */
public class UConnection2 {
    private  static Connection con=null;
    
        public static Connection getConnection(){
    
    
    try{
    
    if(con==null){
    
    Runtime.getRuntime().addShutdownHook(new ShutdownHook ());
    
    ResourceBundle rb=ResourceBundle.getBundle("jdbc");
    String driver=rb.getString("driver");
    String url=rb.getString("url");//ruta
    String pwd=rb.getString("pwd");
    String usr=rb.getString("usr");
    
    Class.forName(driver);
    con=DriverManager.getConnection(url, usr, pwd);
    
    }
        return con;
   
    }catch(Exception ex){
    ex.printStackTrace();
    throw new RuntimeException("Error al crear la conexion ",ex);
    
    
    }
    
    }
        
            static class ShutdownHook extends Thread
	{
		public void run()
		{
			try
			{
				Connection con = UConnection2.getConnection();
				con.close();
			}
			catch( Exception ex )
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
}
