/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

/**
 *
 * @author aluno
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class Conexao {
    
    public Connection getConnection() throws ClassNotFoundException, SQLException {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://143.106.241.3:3306/cl203228";
    String usuario = "cl203228";
    String senha = "cl*11112006";
    Class.forName(driver);
    return (Connection) DriverManager.getConnection(url,usuario,senha);
    }
}

