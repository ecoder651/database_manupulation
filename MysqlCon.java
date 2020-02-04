import java.sql.*; 
import java.util.*;
 
class MysqlCon{  
public static void main(String args[]){
try{
Scanner sc = new Scanner(System.in);
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","xiphos@root1234");
int choice;
boolean go = true;
while(go)
{
System.out.println("\n1.Insert Data\n2.Update Data\n3.Delete Data\n4.View Table\n5.Exit\n");
choice = sc.nextInt();
switch(choice)
{
case 1:
System.out.println("Enter id: ");
int id = sc.nextInt();
System.out.println("Enter name: ");
String name = sc.next();
PreparedStatement stmt=con.prepareStatement("insert into emp_details values(?,?)");  
stmt.setInt(1,id);
stmt.setString(2,name);
stmt.executeUpdate();
System.out.println("1 Value is inserted......");
break;

case 2:
System.out.println("Enter new name: ");
String newName = sc.next();
System.out.println("Enter id of required update name: ");
int newId = sc.nextInt();
PreparedStatement stt=con.prepareStatement("update emp_details set emp_name=? where emp_id=?"); 
stt.setString(1,newName);
stt.setInt(2,newId);
stt.executeUpdate();
System.out.println("1 Value is updated......");
break;

case 3:
System.out.println("Enter the id which need to be deleted: ");
int dNewId = sc.nextInt();
PreparedStatement sttt=con.prepareStatement("delete from emp_details where emp_id=?");
sttt.setInt(1,dNewId);
sttt.executeUpdate();
System.out.println("1 Value is deleted.......");
break;

case 4:
System.out.println();
Statement st=con.createStatement();  
ResultSet rs=st.executeQuery("select * from emp_details");  
while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString(2));
break;
 
case 5:
go = false;
break;

default:
System.out.println("Wrong Choice.......");
break;
}
}
con.close();  
}catch(Exception e){ System.out.println(e);}  
}  
}  