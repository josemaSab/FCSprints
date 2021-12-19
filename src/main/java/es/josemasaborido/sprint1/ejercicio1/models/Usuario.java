package es.josemasaborido.sprint1.ejercicio1.models;

/**
 * Ejercicio 1 Sprint 1 de Fisrt Commit
 * <p>
 * Clase que define un on obejto usuario
 *
 * @author josema
 * @version 1.0
 */
public class Usuario {

    //ATRIBUTOS

    private String email;
    private String nombreCompleto;
    private String nombreUsuario;

    //CONSTRUCTORES

    /**
     * Cosntructor con todos los parametros
     *
     * @param email          email del usuario
     * @param nombreCompleto nombre completo del usuario
     * @param nombreUsuario  nombre de usuario
     */
    public Usuario(String email, String nombreCompleto, String nombreUsuario) {
        this.email = email;
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
    }

    //METODOS

    /**
     * Metodo toString que muestra todos los atributos
     *
     * @return los atributos en forma de cadena de caracteres
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                '}';
    }


    //GETTER Y SETTER


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

}
