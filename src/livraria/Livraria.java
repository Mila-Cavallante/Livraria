//-----PROGRAMA PRINCIPAL-----//

package livraria;

import DAO.Conexao;
import java.util.Scanner;
/**
 *
 * @author camil
 */
public class Livraria {

    public static void main(String[] args) {
        Conexao conect = new Conexao();
        
        conect.conectar();
        System.out.println(conect.getConexao());
    }
    
}
