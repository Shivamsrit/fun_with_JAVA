package JDBC_1;

import java.sql.*;

public class JDBC_1 {
    public static void main( String[] args){
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet= null;
// jdbc.4-X autoloading feature enable to load jars
        try{
        // step1: load and register the driver

            // it is optional
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver is loaded........mn  ");
            
// JRE → external library → mysql-connector-j-9.0.3.jar → META-INF/services/java.sql.Driver → com.mysql.cj.jdbc.Driver —
// loads the driver automatically, no need to load manually.

            // step 2:-  Establsh connection between with database
            String url = "jdbc:mysql://localhost:3306/ecoplate";
            //If our database is present on the same machine and the default port number is 3306,
            // then it's optional to write localhost:3306 because the JRE understands where the database is located.
            String userName = "root";
            String Pass ="Shivam9981@";
           connection =DriverManager.getConnection(url,userName,Pass);
           System.out.println("connectton establish successfully");
           System.out.println("the implement class name is "+connection.getClass().getName());


           // step 3:- create staement object and execute the querry

            statement= connection.createStatement();
            System.out.println("the implementation class is"+statement.getClass().getName());

            String sqlquerry = "Select country_id,name from countries" ;
            resultSet = statement.executeQuery(sqlquerry);
            System.out.println("the implementation class is"+resultSet.getClass().getName());

            // step 4:- process the result set
            while (resultSet.next())
        {
                int  address_id= resultSet.getInt(1);
                String address= resultSet.getString(2);

                System.out.println(address_id+"\t"+address);
            }
            // step 6:- close the connection
            connection.close();
            statement.close();
            resultSet.close();
            System.out.println("Closing the resources........");




        }
        // step 5: handle sql exception if generated
        catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        catch(SQLException ce){
            ce.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }





}
