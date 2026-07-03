package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao{
    
    private static final String url = "jdbc:mysql://localhost:3306/sistemavendas";
    private static final String user = "root";
    private static final String password = "admin";

    private static Connection conn;

    public static Connection getConexao(){
        if(conn == null){
            try{
                conn = DriverManager.getConnection(url, user, password);

            }
            catch (SQLException e){
                e.printStackTrace();
            }
    
        }

        return conn;
    
    
    }
    

}
