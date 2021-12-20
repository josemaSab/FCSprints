package es.josemasaborido.sprint1.ejercicio2.models;
/**
 * Ejercicio 2 Sprint 1 de Fisrt Commit
 * <p>
 * Clase que define un obejto usuario
 *
 * @author josema
 * @version 1.0
 */
public class Usuario {

    // ATRIBUTOS

    private String email;
    private String password;

    //CONSTRUCTORES

    /**
     * Cosntructor con todos los atributos
     * @param email del usuario
     * @param password del usuario
     */
    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
    }

    //METODOS

    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    //GETTER Y SETTER

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
