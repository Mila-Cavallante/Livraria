
package DAL;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import livraria.Book;
import java.sql.ResultSet;


/**
 *
 * @author camil
 */
public class DAOBook {
    
    Conexao conect = new Conexao();
      
    //Listar livros cadastrados
     public List listar(String params){
        conect.conectar(); 
        List<Book> listaLivros = new ArrayList<>(); //criando uma lista de array de livros
        String query = "SELECT * from library.book " + params; //buscando todos os atributos
        
        try{
            PreparedStatement prep = conect.getConexao().prepareStatement(query); //chama query
            ResultSet lista = prep.executeQuery();
            
            while(lista.next()){
                Book book = new Book();
                book.setIDBook(lista.getInt("IDBook"));
                book.setTitle(lista.getString("title"));
                book.setAuthor(lista.getString("author"));
                listaLivros.add(book);
            }
            conect.close();//fecha conexão
        }
        catch(SQLException e){
           e.printStackTrace();
        }
        return listaLivros;
    }
    
    //método incluir
     public void incluir (Book book) throws SQLException{ //throws é o try/catch
        conect.conectar();
        String query = "INSERT INTO library.book(Title,Author) VALUES (?,?)"; //
        PreparedStatement prep = conect.getConexao().prepareStatement(query);

        prep.setString(1, book.getTitle());
        prep.setString(2, book.getAuthor());
        prep.execute();
        conect.getConexao().commit();
        conect.close();                 
    }
     
}//fim da classe
    
    
    
    
    
    
    

