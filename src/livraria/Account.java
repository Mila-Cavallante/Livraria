
package livraria;

/**
 *
 * @author camil
 */
public class Account {
    private String emailAddress;
    private long id;
    private String password; 
    private long idTemp;
    private String passwordTemp; 
    
    
    //métodos de operação
    public boolean verifyPassword(){
       return password.equals(passwordTemp);
    }
    
        
    public boolean validateLogin(){
        return id==idTemp;
    }
    
    public boolean validateLogin(long ID, String password){
        idTemp=ID;
        passwordTemp=password;
        return (validateLogin() && verifyPassword());
    }
     
    
    //---métodos acessores
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
