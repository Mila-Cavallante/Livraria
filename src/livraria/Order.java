
package livraria;

/**
 *
 * @author camil
 */
public class Order {
    private Book book;
    //ShippingInfo shippingInfo;
   // BillingInfo;
    private User user;
    private int ID;
    private String dataHora;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
}
