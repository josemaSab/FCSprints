package es.josemasaborido.sprint1.ejercicio5.persistencia;

import java.util.List;

/**
 * Ejercicio 5 Sprint 1 de Fisrt Commit
 *
 * Interface que declara  los metodos que se pueden realizar en el tipo de almacenamiento
 * con programación generica
 *
 * @author josema
 * @version 1.0
 */
public interface TipoAlmacenamiento <T>{

    boolean guardar(T objeto);
    //El metodo obtener tendrá que devolver null si  no encuentra el objeto en persistencia
    T obtener(T objeto);

    List<T> obtenerTodos();
}
