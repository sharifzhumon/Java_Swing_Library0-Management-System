package librarymanagmentsystem;

import java.sql.*; //importing elemnts from sql class


public class Conn{

    public Connection c;
    public Statement s;
    
    // Must have to add mysql JDBC library folder in project library folder
    public Conn(){  //constructor 
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // regestering driver class for connection
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/library?serverTimezone=UTC","root",""); // making connection with the database
            s= c.createStatement(); // making statement object for execute queries through it
            System.out.println("Connection successfull"); 
        } catch(Exception e){
            e.printStackTrace(); //printStackTrace method handles exception and errors and provide details about the exception with line number and class name 
        }
       
    
    }

}
