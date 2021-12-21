package es.josemasaborido.sprint1.ejercicio2y3.service;

import es.josemasaborido.sprint1.ejercicio2y3.models.Usuario;
import es.josemasaborido.sprint1.ejercicio2y3.repositories.RegistroRepository;
import es.josemasaborido.sprint1.ejercicio2y3.security.PasswordHasheable;
import es.josemasaborido.sprint1.ejercicio2y3.ui.Colores;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Ejercicio 2 Sprint 1 de Fisrt Commit
 * <p>
 * Clase que define el registro
 *
 * @author josema
 * @version 1.0
 */
public class RegistroService implements RegistroRepository {

    //ATRIBUTOS

    private List<Usuario> almacenamiento = new ArrayList<>();
    private PasswordHasheable encode;

    //CONSTRUCTORES

    /**
     * Constructor con todos los parametros
     *
     * @param almacenamiento Array listo donde estan todos los usurios
     * @param encode         tipo de encriptacion seleccionada para encreitar contraseña
     */

    public RegistroService(List<Usuario> almacenamiento, PasswordHasheable encode) {
        this.almacenamiento = almacenamiento;
        this.encode = encode;
    }


    //METODOS

    /**
     * Metodo que registra un usuario en un ArrayList si no existe en él
     *
     * @param email    del usuario
     * @param password del usuario
     * @return true si lo ha registraao correctamente y false si ha habido algun error
     */
    @Override
    public boolean register(String email, String password) {
        String hashPwd;
        //Comprobamos que el correo esta bien formado y no exite en la base de datos
        if (this.emailBienFormado(email)) {
            if (!this.buscaEmailDuplicado(email)) {
                //Si el hasheo del password es null realiza el registro
                if (encode.hashPassword(password) != null) {
                    //Hasheamos el password
                    hashPwd = encode.hashPassword(password);
                    //Creamos el usuario
                    Usuario usuario = new Usuario(email, hashPwd);
                    //Lo almacenamos
                    this.almacenamiento.add(usuario);
                    System.out.println("Usuario: " + email + " | Password: " + password + " almacenado con exito.");
                    System.out.println("El hash es: " + hashPwd);
                    System.out.println(Colores.ANSI_AMARILLO + "ENCRIPTACION: " + Colores.ANSI_VERDE + encode.getClass().getSimpleName() + Colores.ANSI_RESET);
                } else {
                    System.err.println("Error al hashear el password.");
                }
            }
        }
        return false;
    }

    /**
     * Metodo que comprueba que el correo esta formado correctamente
     *
     * @param email del usuario
     * @return true si esta bien formado y false si esta mal formado
     */
    public boolean emailBienFormado(String email) {
        //Expresion regular para email acepta letras numeros "_" "-" ".
        Pattern patEmail = Pattern.compile("^[a-zA-Z0-9_\\-\\.]+@([a-zA-Z0-9]+)(\\.)[a-zA-Z0-9]+$");
        Matcher matEmail = patEmail.matcher(email);
        if (matEmail.matches()) {
            return true;
        }
        System.err.println("Email mal formado. Por favor instroduzca un email correcto");
        return false;
    }

    /**
     * Metodo que busca en el Array de almacenamiento si un email exite
     *
     * @param email de usuario
     * @return true si existe y false si no existe
     */
    public boolean buscaEmailDuplicado(String email) {
        for (Usuario usuario : this.almacenamiento) {
            if (usuario.getEmail().equals(email)) {
                System.err.println("El email ya existe en la base de datos");
                return true;
            }
        }
        return false;
    }

    //GETTER Y SETTER

    public List<Usuario> getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(List<Usuario> almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public PasswordHasheable getEncode() {
        return encode;
    }

    public void setEncode(PasswordHasheable encode) {
        this.encode = encode;
    }
}
