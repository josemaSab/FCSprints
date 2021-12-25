package es.josemasaborido.sprint1.ejercicio5_6_7y8.persistencia;
/**
 * Ejercicio 5 Sprint 1 de Fisrt Commit
 *
 * Clase que genera una id nueva para cada nuevo registro de las entities en la base de datos
 *
 * @author josema
 * @version 1.0
 */
public class GeneradorId {

    //METODOS
    /**
     * Metodo que realiza el incremento en el id de las entities en cada nuevo registro
     * @param id id a incrementar
     * @return id incrementado en 1
     */
    public static Long generarId(Long id){
        return id++;
    }
}
