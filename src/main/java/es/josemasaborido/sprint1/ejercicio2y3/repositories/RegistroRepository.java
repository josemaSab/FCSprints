package es.josemasaborido.sprint1.ejercicio2y3.repositories;
/**
 * Ejercicio 2 Sprint 1 de Fisrt Commit
 * <p>
 * Interface que define el registro en la base de datos
 *
 * @author josema
 * @version 1.0
 */
public interface RegistroRepository {

    boolean register(String email, String password);
}
