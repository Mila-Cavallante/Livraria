
package livraria;

/**
 *
 * @author camil
 */
public abstract class BaseName { //com abstract a classe é somente herdada, não vira objeto (instanciada).
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
