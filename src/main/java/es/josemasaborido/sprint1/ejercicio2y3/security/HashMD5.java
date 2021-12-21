package es.josemasaborido.sprint1.ejercicio2y3.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Ejercicio 2 Sprint 1 de Fisrt Commit
 * <p>
 * Clase que define el encriptado de password con protocolo MD5
 *
 * @author josema
 * @version 1.0
 */
public class HashMD5 implements PasswordHasheable {

    /**
     * Metodo que hashea el password pasado por parametro
     *
     * @param password del usuario
     * @return el password hasheado en MD5 y si ha habido algun problema devulve null
     */
    @Override
    public String hashPassword(String password) {
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
     * Metodo que verifica que un password sin hashear es igual al hasheado
     *
     * @param hash     password hasheado
     * @param password sin hashear
     * @return true si coinciden y false si no coinciden
     */
    @Override
    public boolean verificarPassword(String hash, String password) {
        if (hash.equals(hashPassword(password))) {
            return true;
        }
        return false;
    }
}
