/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.jdbc.Driver;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Carlos Rodriguez
 */

public class JDBCDataAccessClass {
    private Connection _connection;
    
    // Establecer conexion con la BD
    public void initialize(){
        try {
            DriverManager.registerDriver(new Driver());
            _connection = 
            DriverManager.getConnection("jdbc:mysql://localhost/sakila?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","password");
        } catch (Exception e) {
            System.out.println("Error al registrar el controlador" + e.getMessage());
        }
    }
    
    // Contar el numero de empleados
    public int listStaff(){
          Statement statement = null;
          try {
            statement = _connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT LAST_NAME, FIRST_NAME, STAFF_ID FROM STAFF");
        
            int count = 0;
            while(resultSet.next()){
                count++;
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
            }
            return count;
          } catch (Exception e) {
              System.err.println("Error al crear la sentencia" + e.getMessage());
        }
          return 0;
    }
}
