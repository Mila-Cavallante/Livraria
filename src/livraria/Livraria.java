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
        conect.conectar(); //conexao com o banco de dados
        //System.out.println(conect.getConexao());
        Customer novoUser = new Customer();
        DAOCustomer novocust = new DAOCustomer();
        Scanner scan = new Scanner(System.in);
        DAOOrder dorder = new DAOOrder();
        Order orderr = new Order();
        Book boo=new Book();
        DAOBook db = new DAOBook();
        
        //Iniciando processo de venda
        System.out.println("Para iniciar a compra digite seu nome: ");
        String userr = scan.next();
        novoUser.setName(userr); //define o Name em Customer
                
        System.out.println("Digite seu email: ");
        String userem = scan.next();
        novoUser.setEmailAddres(userem); //define o emailAddres em Customer
        novocust.incluir(novoUser); //chama o método incluir da DAOCustomer
        
        System.out.println();
        System.out.println("Qual livro deseja comprar? Digite o ID.");
             
        List<Book> bookss = db.listar(""); //classe para listar o Book retornando do método listar da DAOBook   
        System.out.println("IDBook \t\t TÍTULO \t\t AUTOR");
        for(Book b:bookss){ //retornando os valores
           System.out.print(b.getIDBook()+"\t");
           System.out.print(b.getTitle()+"\t");
           System.out.println(b.getAuthor());
        }
        
        int opcao = scan.nextInt(); //alocar o valor da opção de IDBook escolhido 
        boo.setIDBook(opcao); //set na variavel 
        orderr.setBook(boo);//set do IDBook na Order
        orderr.setUser(novoUser);//set do user na Order
        
        dorder.registrar(orderr);//valores retornados de User para o método registrar em DAOOrder
      
    }
    
}//fim da classe

        // Book boo=new Book();
        /*b1.setTitle("Os sete");
        b1.setAuthor("Andre Vianco");
        DAOBook db = new DAOBook();
        db.incluir(b1);*/

