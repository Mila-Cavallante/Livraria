
package DAL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import livraria.Customer;
/**
 *
 * @author camil
 */
public class DAOCustomer {
    Conexao conect = new Conexao();
    
    //metodo incluir
     public void incluir (Customer customer) throws SQLException{
        conect.conectar();
        String query = "INSERT INTO library.customer(Name,emailAddres) VALUES (?,?)";
        PreparedStatement prep = conect.getConexao().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        prep.setString(1, customer.getName());
        prep.setString(2, customer.getEmailAddres());
        prep.execute();
        ResultSet ultimoID = prep.getGeneratedKeys(); //retorna o ultimo ID gerado na inserção de customer 
        ultimoID.next(); 
        customer.setIDUser(ultimoID.getInt(1)); //setando o valor de ID em Costumer
        conect.getConexao().commit();
        conect.close();                 
    }
    
    
}
