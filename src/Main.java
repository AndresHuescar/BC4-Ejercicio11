import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "RIBERA";
        String pass = "ribera";

        // consulta
        String sql = "SELECT id, salario FROM EMPLEADO ORDER BY salario DESC";

        try (
                Connection con = DriverManager.getConnection(url, user, pass);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql)
        ) {
            System.out.println(" EMPLEADOS ORDENADOS POR SALARIO DESC ");

            boolean hayDatos = false;

            while (rs.next()) {
                hayDatos = true;

                int id = rs.getInt("id");
                int salario = rs.getInt("salario");

                System.out.println("ID: " + id + " | Salario: " + salario);
            }

            if (!hayDatos) {
                System.out.println("No empleados en la tabla.");
            }

        } catch (Exception e) {
            System.out.println("Error mostrar empleados:");
            e.printStackTrace();
        }
    }
}