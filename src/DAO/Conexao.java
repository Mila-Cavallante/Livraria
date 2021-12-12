//Fazer a conexão com o Banco de dados
package DAO;

import java.util.Properties;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author camil
 */
public class Conexao {
    private Connection con = null;

    public void conectar() {
        Properties prop = new Properties(); 

        prop.setProperty("user", "root");//configuração de usuario
        prop.setProperty("password", "root");//configuração de senha

        try {
            con = DriverManager.getConnection(
                    "jdbc:mariadb://127.0.0.1:3308/library", prop
            );
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConexao() {
        return con;
    }

    public void close() {
        try {
            getConexao().close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}//fim
