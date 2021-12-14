
package livraria;

/**
 *
 * @author camil
 */
public class User extends BaseName{
    private int IDUser;
    private String emailAddres;

    public String getEmailAddres() {
        return emailAddres;
    }

    public void setEmailAddres(String emailAddres) {
        this.emailAddres = emailAddres;
    }

    public int getIDUser() {
        return IDUser;
    }

    public void setIDUser(int IDUser) {
        this.IDUser = IDUser;
    }
}
