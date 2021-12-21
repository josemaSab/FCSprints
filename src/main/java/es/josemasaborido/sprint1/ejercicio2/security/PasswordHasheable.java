package es.josemasaborido.sprint1.ejercicio2.security;

/**
 * Ejercicio  Sprint 1 de Fisrt Commit
 * <p>
 * Interface que implemente las funciones de hashing
 *
 * @author josema
 * @version 1.0
 */
public interface PasswordHasheable {

    String hashPassword(String password);

    boolean verificarPassword(String hash, String password);
}
