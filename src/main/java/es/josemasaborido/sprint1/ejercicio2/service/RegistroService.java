package es.josemasaborido.sprint1.ejercicio2.service;

import es.josemasaborido.sprint1.ejercicio2.models.Usuario;
import es.josemasaborido.sprint1.ejercicio2.repositories.RegistroRepository;
import jdk.swing.interop.SwingInterOpUtils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Ejercicio  Sprint 1 de Fisrt Commit
 * <p>
 * Clase que define el registro
 *
 * @author josema
 * @version 1.0
 */
public class RegistroService implements RegistroRepository {

    //ATRIBUTOS

    private List<Usuario> almacenamiento = new ArrayList<>();

    //CONSTRUCTORES

    /**
     * Cosntructor con parametros
     * @param almacenamiento Array list donde se guardan los registros
     */
    public RegistroService(List<Usuario> almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    //METODOS

    /**
     * Metodo que registra un usuario en un ArrayList si no existe en él
     * @param email del usuario
     * @param password del usuario
     * @return true si lo ha registraao correctamente y false si ha habido algun error
     */
    @Override
    public boolean register(String email, String password) {
        String hashPwd;
        //Comprobamos que el correo esta bien formado y no exite en la base de datos
        if(this.emailBienFormado(email)) {
            if(!this.buscaEmailDuplicado(email)) {
                //Si el hasheo del password es null realiza el registro
                if (this.hashPassword(password) != null) {
                    //Hasheamos el password
                    hashPwd = this.hashPassword(password);
                    //Creamos el usuario
                    Usuario usuario = new Usuario(email, hashPwd);
                    //Lo almacenamos
                    this.almacenamiento.add(usuario);
                    System.out.println("Usuario: " + email + " | Password: " + password + " almacenado con exito.");
                    System.out.println("El hash es: " + hashPwd);
                } else {
                    System.err.println("Error al hashear el password.");
                }
            }
        }
        return false;
    }

    /**
     * Metodo que hashea el password pasado por parametro
     * @param password del usuario
     * @return el password hasheado en MD5 y si ha habido algun problema devulve null
     */
    public static String hashPassword(String password) {
        String hash = null;
        try {
            //Instanciamos messageDigest y definimos SHA-512 como protocolo de cifrado
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            hash = number.toString(16);
            //Si el hash obtenido tiene mens de 32 caracteres le añadimos 0 delante
            while (hash.length() < 32) {
                hash = "0" + hash;
            }

        } catch (NoSuchAlgorithmException e) {
            System.err.println("Hubo un error al seleccionar el cifrado: " + e.getMessage());
        }
        return hash;
    }

    /**
     * Metodo que comprueba que el correo esta formado correctamente
     * @param email del usuario
     * @return true si esta bien formado y false si esta mal formado
     */
    public boolean emailBienFormado(String email){
        //Expresion regular para email acepta letras numeros "_" "-" ".
        Pattern patEmail = Pattern.compile("^[a-zA-Z0-9_\\-\\.]+@([a-zA-Z0-9]+)(\\.)[a-zA-Z0-9]+$");
        Matcher matEmail = patEmail.matcher(email);
        if(matEmail.matches()){
            return true;
        }
        System.err.println("Email mal formado. Por favor instroduzca un email correcto");
        return false;
    }

    /**
     * Metodo que busca en el Array de almacenamiento si un email exite
     * @param email de usuario
     * @return true si existe y false si no existe
     */
    public boolean buscaEmailDuplicado(String email){
        for(Usuario usuario: this.almacenamiento){
            if(usuario.getEmail().equals(email)){
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
}
