package com.erivas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ODBCData {
	



	public static class empresa {
		 
        private int ID;
        private String Nombre;   
        private String Empresa;
 
        private empresa(int i, String _Nombre, String _Empresa ) {
            ID = i;
            Nombre = _Nombre;           
            Empresa = _Empresa;
        }
        
    }
	

	public static void main(String[] args) {
		
		
		
		List<empresa> ejemploLista = new ArrayList<empresa>();
		
		// TODO Auto-generated method stub
		List tuLista=new ArrayList();
		
		try
		{
		    Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gpconsul_sma?autoReconnect=true&useSSL=false", "root", "");//Establishing connection
		    System.out.println("Conectado a la Base de datos MySQL");
		    Statement s = connection.createStatement();
		    ResultSet rs = s.executeQuery ("select * from clients");
		    while (rs.next())
		    {
		        System.out.println (rs.getInt (1) + " " + rs.getString (2)+ " " + rs.getString (3));
		     
		        ejemploLista.add(new empresa(rs.getInt(1),rs.getString (2),rs.getString (3)));
		        
		      
		    }
		    connection.close();
		} 
		catch (SQLException e) 
		{
		  System.out.println("Error mientras se conecta a la base de datos");
		}
		 System.out.println(ejemploLista.size());
		 
		 /*for (int i = 0; i <= ejemploLista.size()-1; i++) {
	            System.out.println("ID: " + ejemploLista.get(i).ID + " Nombre: "
	                    + ejemploLista.get(i).Nombre + " " +
	                  " Empresa: " + ejemploLista.get(i).Empresa);
	        }*/
		 sendDataCliente(ejemploLista);
	
	}
	
	 public static void sendDataCliente(List<empresa> ejemploLista)
	 {
		 
		
		 
		/* for (int i = 0; i <= ejemploLista.size()-1; i++) {
	            System.out.println("ID: " + ejemploLista.get(i).ID + " Nombre: "
	                    + ejemploLista.get(i).Nombre + " " +
	                  " Empresa: " + ejemploLista.get(i).Empresa);
	        }*/
		
		 
		 try
			{
			    Connection connection = DriverManager.getConnection("jdbc:mysql://gpcumplimiento.cl:3306/gpcumpli_enlinea?autoReconnect=true&useSSL=false", "gpcumpli_admin", "30cuY2[OAgAr");//Establishing connection
			    Statement s = connection.createStatement();
			    
			    for (int i = 0; i <= ejemploLista.size()-1; i++)
			    {
			    	
			    	String query = "insert into clientes(nombre,empresa) values('"+ejemploLista.get(i).Nombre+"','"+ejemploLista.get(i).Empresa+"')";		
			    	int action =  s.executeUpdate(query);
			    	 if (action > 0) {
			             System.out.println("success");
			         } else {
			             System.out.println("stuck somewhere");
			         }
				  
			    }		    
			    
			    
			    /*
			    String query = "insert into clientes(nombre,empresa) values('"+Name+"','"+Company+"')";		
			    s.executeUpdate(query);*/
			    
			    System.out.println("Conectado a la Base de datos MySQL clientes Remota");
		
		
			} 
			catch (SQLException e) 
			{
			  System.out.println("Error mientras se conecta a la base de datos");
			}		
		
		
	 }
	 public static void sendRemotDatabase()
	 {
		 
	 }

}
