package es.josemasaborido.sprint1.ejercicio5.entities;

import es.josemasaborido.sprint1.ejercicio5.persistencia.GeneradorId;

/**
 * Ejercicio 4 Sprint 1 de Fisrt Commit
 * Ejercicio 4. Crea una cuenta en SparkPost y mándate un mail de bienvenida al sistema
 * <p>
 * Clase Ciudad
 *
 * @author josema
 * @version 1.0
 */
public class Ciudad {

    //ATRIBUTOS
    private  static Long idCiudad = 0L;
    private String ciudad;

    //Relaciones

    private Pais pais;

    //CONSTRUCTORES

    /**
     * Constructor con todos los parametros

     * @param ciudad nombre de la ciudad
     */
    public Ciudad(String ciudad) {
        this.idCiudad = GeneradorId.generarId(idCiudad);
        this.ciudad = ciudad;
    }

    //GETTER Y SETTER


    public Long getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
