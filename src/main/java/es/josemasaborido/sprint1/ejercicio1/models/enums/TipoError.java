package es.josemasaborido.sprint1.ejercicio1.models.enums;

/**
 * Ejercicio 1 Sprint 1 de Fisrt Commit
 * <p>
 * Enum que define el tipo de error
 *
 * @author josema
 * @version 1.0
 */
public enum TipoError {
    EMAIL_DUPLICADO("Error, email duplicado en linea: "),
    NOMBRE_USUARIO_DUPLICADO("Error, nombrede usuario duplicado en linea: "),
    MAL_FORMADO("Error, linea del fichero mal formada. Numero de linea: ");

    private String descripcionError;

    private TipoError(String descripcionError) {
        this.descripcionError = descripcionError;
    }

    public String getDescripcionError() {
        return this.descripcionError;
    }
}
