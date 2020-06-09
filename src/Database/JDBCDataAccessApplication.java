
package Database;

public class JDBCDataAccessApplication {
    public static void main(String[] args) {
        JDBCDataAccessClass jdbc = new JDBCDataAccessClass();
        
        jdbc.initialize();
        int empCount = jdbc.listStaff();
        System.out.println("El total de empleados es: " + empCount);
    }
    
}
