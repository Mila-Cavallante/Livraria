package DAL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import livraria.Order;
/**
 *
 * @author camil
 */
public class DAOOrder {
    
    Conexao conect = new Conexao();
   
    public void registrar(Order order) throws SQLException{
       
       conect.conectar();
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
       
       String query ="INSERT INTO library.order(IDBook,IDUser,datahora) VALUES (?,?,?)";   //arrunar o IDUser, esse é gerado auto-incremento
       PreparedStatement prep = conect.getConexao().prepareStatement(query);   
       
       prep.setInt(1,order.getBook().getIDBook());
       prep.setInt(2,order.getUser().getIDUser());
       prep.setString(3,dtf.format(LocalDateTime.now()));
       prep.execute();
       conect.getConexao().commit();
       conect.close();  
    }
    
}//fim da classe
