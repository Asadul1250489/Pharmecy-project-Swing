
package Pharmecy;

import com.sun.xml.internal.bind.v2.model.core.ID;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Repository {

    private int result;

    public Repository()  {
        
        try{
         Class.forName("com.mysql.jdbc.Driver");
        
           
        
        }catch(ClassNotFoundException e)
        
        {System.out.println(" found");}
      
        
        }
    public int insert(String name, int quantity, float price,int avail){
        int result =0;
      try{
       Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sohag","root","");
      
          PreparedStatement stmt = con.prepareStatement("INSERT INTO Medicinelist( MedicineName, quantity, price,avail) VALUES (?,?,?,?);");
          
       stmt.setString(1, name);
       stmt.setInt(2, quantity);
       stmt.setFloat(3, price);
       stmt.setInt(4, avail);
       result = stmt.executeUpdate();
       
       con.close();
       stmt.close();
      }catch(Exception e){
      
          System.out.println("Error i insert"+e.getMessage());
          return result;
      }
     
     return result;
    }
  public ArrayList<Products> loadProducts(){
  ArrayList <Products> products = new ArrayList<>();
  try{
  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sohag","root","");
      Statement stmt = con.createStatement();
      
      ResultSet result = stmt.executeQuery("SELECT reference_id,MedicineName,quantity,price,avail FROM Medicinelist");
       while(result.next()){
     products.add(new Products(result.getInt(1),result.getString(2),result.getInt(3),result.getFloat(4),result.getInt(5)));
       }
       result.close();
       stmt.close();
       con.close();
           
  }catch(Exception ex){
      System.out.println("Error in loadproducts "+ex.getMessage());
  
  return products;
  }
  
  
  
  return products;
  
  }
      public void updateProduct(int id,int quantity){
      
      try{
      Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/sohag","root","");
      PreparedStatement stmt = con.prepareStatement("UPDATE Medicinelist SET quantity=? WHERE reference_id=?");
      
      stmt.setInt(1, quantity);
      stmt.setInt(2, id);
      int result =stmt.executeUpdate();
      
      stmt.close();
      stmt.close();
      }catch(Exception e){
          System.out.println("Error in updateProducts"+e.getMessage());
      }
      }    

    public void getDiseases(){
    
    
    }
    
    
          }
    

