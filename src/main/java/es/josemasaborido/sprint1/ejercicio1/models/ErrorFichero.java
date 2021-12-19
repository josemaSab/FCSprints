package es.josemasaborido.sprint1.ejercicio1.models;

import es.josemasaborido.sprint1.ejercicio1.models.enums.TipoError;

/**
 * Ejercicio 1 Sprint 1 de Fisrt Commit
 * <p>
 * Clase que define un error
 *
 * @author josema
 * @version 1.0
 */
public class ErrorFichero {

    //ATRIBUTOS
    private TipoError tipoError;
    private int lineaError;

    // CONSTRUCTORES

    /**
     * Constructor con todos los parametros
     *
     * @param tipoError  tipo de error
     * @param lineaError linea del documento donde se da el error
     */
    public ErrorFichero(TipoError tipoError, int lineaError) {
        this.tipoError = tipoError;
        this.lineaError = lineaError;
    }

    //METODOS

    @Override
    public String toString() {
        return this.tipoError.getDescripcionError() + lineaError;
    }


    //GETTER Y SETTER


    public TipoError getTipoError() {
        return tipoError;
    }

    public void setTipoError(TipoError tipoError) {
        this.tipoError = tipoError;
    }

    public Integer getLineaError() {
        return lineaError;
    }

    public void setLineaError(int lineaError) {
        this.lineaError = lineaError;
    }
}
