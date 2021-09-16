/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasequery;
import java.io.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Uday Gupta
 */
public class Practice {
    public static void main(String []args) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException
    {
        Scanner sc=new Scanner(System.in);
     Connection con=null;
    try{
    Class.forName("com.mysql.jdbc.Driver");
    System.out.println("Driver Loaded");
    con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/query?autoReconnect=true&useSSL=false","root","uday1234");
    System.out.println("Connection eastablished");
    Statement st=con.createStatement();
//        st.execute("create table student1 ( name varchar(20),rollno int, standard int)");

   System.out.println("!-----------For Insertion-------------!");
        System.out.println("Table Created");
        System.out.println("Enter your name:");
        String  name=sc.nextLine();
        System.out.println("Enter your rollno:");
        int rollno=sc.nextInt();
        System.out.println("Enter your standard:");
        int standard=sc.nextInt();
  PreparedStatement ptst1=(PreparedStatement) con.prepareStatement("insert into Student1 values(?,?,?)");//insert the data in table
 ptst1.setString(1, name);
ptst1.setInt(2,rollno);
ptst1.setInt(3, standard);
ptst1.executeUpdate();
System.out.println("Insertion Done");  


    System.out.println("!-----------For Deletion-------------!");
        System.out.println("Enter rollno to delete:");
        int rollno1=sc.nextInt();
        PreparedStatement ptst2=(PreparedStatement) con.prepareStatement("delete from Student1 where rollno='"+rollno1+"'");//Delete the data in table
        ptst2.executeUpdate();
     System.out.println("Deletion Done");
     
     
     
     
     System.out.println("!-----------For Updation-------------!");
    
        System.out.println("Enter your name:");
        String  name2=sc.nextLine();
        System.out.println("Enter your rollno:");
        int rollno2=sc.nextInt();
        PreparedStatement ptst3=(PreparedStatement) con.prepareStatement("update Student1 set name='"+name2+"' where rollno='"+rollno2+"'");//Alter the data in table
        ptst3.executeUpdate();
        System.out.println("Updation Done");
        

        
     
     
     
 
     
     
     
     
     
     
 java.sql.PreparedStatement ptst=con.prepareStatement("Select *from Student1");
ResultSet rs=ptst.executeQuery();
while(rs.next())
{
    System.out.println(rs.getString("name")+" "+rs.getString("rollno")+" "+rs.getString("standard"));
    String p=rs.getString("name");
    String q=rs.getString("rollno");
    String r=rs.getString("standard");
try{
File file=new File("D:/xyz.txt");

if(!file.exists())
{
file.createNewFile();
}
FileWriter fw=new FileWriter(file.getAbsoluteFile(),true);
BufferedWriter fout=new BufferedWriter(fw);
PrintWriter pw=new PrintWriter(fout);
pw.println(p+","+q+","+r);
fout.close();
}catch(Exception e)
{
    System.out.println(e.getMessage());
}

}
    }
     
    catch(Exception e){
        System.out.println(e.getMessage());
        
    }
   
    
}
    
}
