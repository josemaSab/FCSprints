package es.josemasaborido.sprint1.ejercicio5_6_7y8.security;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;


/**
 * Ejercicio 2 Sprint 1 de Fisrt Commit
 * <p>
 * Clase que define el encriptado de password con protocolo ARGON2
 *
 * @author josema
 * @version 1.0
 */
public class HashArgon2 implements PasswordHasheable {

    //ATRIBUTOS

    Argon2 argon2;

    //CONTRCUTORES

    /**
     * Constructor vacio que crea la instancia de Argon2
     */
    public HashArgon2() {
        //Argon2 por defecto 16bytes de salt y longitud de hash de 32bits
        this.argon2 = Argon2Factory.create();
    }


    //METODOS

    /**
     * Metodo que hashea el password pasado por parametro
     *
     * @param password del usuario
     * @return el password hasheado en ARGON2 y si ha habido algun problema devulve null
     */
    @Override
    public String hashPassword(String password) {
        String hash = null;
        //Pasamos el password a un Array de caracteres
        char[] passCharArray = password.toCharArray();
        try {
            //Hashea el password
            hash = this.argon2.hash(10, 65536, 1, passCharArray);

        } catch (Exception e) {
            System.out.println("Algo no salió bien al hashear el password: " + e.getMessage());
        } finally {
            this.argon2.wipeArray(passCharArray);
        }

        return hash;
    }

    /**
     * Metodo que comprueba si un hash coincide con un String sin hashear
     *
     * @param hash     password hasheado
     * @param password sin hashear
     * @return true si coinciden y false si no coinciden
     */
    @Override
    public boolean verificarPassword(String hash, String password) {
        //Pasamos el password a un Array de caracteres
        char[] passCharArray = password.toCharArray();
        //Comprobamos que coincide el hash coincide con la contraseña
        if (this.argon2.verify(hash, passCharArray)) {
            return true;
        }
        return false;
    }

    //GETTER Y SETTER


    public Argon2 getArgon2() {
        return argon2;
    }

    public void setArgon2(Argon2 argon2) {
        this.argon2 = argon2;
    }
}
