package DAL;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;//para utilizar a data e hora do sistema
import java.time.format.DateTimeFormatter;//para formatar a data e hora


import livraria.Order;
/**
 *
 * @author camil
 */
public class DAOOrder {
    
    Conexao conect = new Conexao();
   
    public void registrar(Order order) throws SQLException{
       
       conect.conectar();
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");//formatando o modelo de apresentaçao da data e hora
       
       String query ="INSERT INTO library.order(IDBook,IDUser,datahora) VALUES (?,?,?)";   //arrunar o IDUser, esse é gerado auto-incremento
       PreparedStatement prep = conect.getConexao().prepareStatement(query);   
       
       prep.setInt(1,order.getBook().getIDBook());//retorna IDBook
       prep.setInt(2,order.getUser().getIDUser());//retorna User
       prep.setString(3,dtf.format(LocalDateTime.now()));//retorna data e hora
       prep.execute();
       conect.getConexao().commit();
       conect.close();  
    }
    
}//fim da classe
