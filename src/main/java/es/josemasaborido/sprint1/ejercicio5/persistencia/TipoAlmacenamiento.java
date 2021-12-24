package es.josemasaborido.sprint1.ejercicio5.persistencia;

import java.util.List;

/**
 * Ejercicio 5 Sprint 1 de Fisrt Commit
 *
 * Interface que declara  los metodos que se pueden realizar en el tipo de almacenamiento
 *
 * @author josema
 * @version 1.0
 */
public interface TipoAlmacenamiento {

    boolean guardar();

    Object obtener(Object obj);

    List<Object> obtenerTodos();
}
