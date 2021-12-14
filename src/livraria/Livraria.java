//-----PROGRAMA PRINCIPAL-----//

package livraria;

import DAL.Conexao;
import DAL.DAOBook;
import DAL.DAOCustomer;
import DAL.DAOOrder;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author camil
 */
public class Livraria {

    public static void main(String[] args) throws SQLException {
        Conexao conect = new Conexao();
        conect.conectar();
        System.out.println(conect.getConexao());
        Customer novoUser = new Customer();
        DAOCustomer novocust = new DAOCustomer();
        Scanner scan = new Scanner(System.in);
        DAOOrder dorder = new DAOOrder();
        Order orderr = new Order();
        Book boo=new Book();
        
        
        System.out.println("Para iniciar a compra digite seu nome: ");
        String userr = scan.next();
        novoUser.setName(userr);
                
        System.out.println("Digite seu email: ");
        String userem = scan.next();
        novoUser.setEmailAddres(userem);
        novocust.incluir(novoUser);
        
        System.out.println();
        System.out.println("Qual livro deseja comprar? Digite o ID.");
        
        DAOBook db = new DAOBook();
        List<Book> bookss = db.listar("");    
        System.out.println("IDBook \t\t TÍTULO \t\t AUTOR");
        for(Book b:bookss){
           System.out.print(b.getIDBook()+"\t");
           System.out.print(b.getTitle()+"\t");
           System.out.println(b.getAuthor());
        }
        
        int opcao = scan.nextInt();
        boo.setIDBook(opcao);
        orderr.setBook(boo);
        orderr.setUser(novoUser);
        
        dorder.registrar(orderr);
      
    }
    
}//fim da classe

        // Book boo=new Book();
        /*b1.setTitle("Os sete");
        b1.setAuthor("Andre Vianco");
        DAOBook db = new DAOBook();
        db.incluir(b1);*/

