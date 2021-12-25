package es.josemasaborido.sprint1.ejercicio5_6_7y8.entities;

import es.josemasaborido.sprint1.ejercicio5_6_7y8.persistencia.GeneradorId;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 4 Sprint 1 de Fisrt Commit
 *
 * Clase Pais
 *
 * @author josema
 * @version 1.0
 */
public class Pais{

    //ATRIBUTOS

    private static Long idPais = 0L;
    private String pais;
    private List<Ciudad> ciudades = new ArrayList<>();

    //CONSTRUCTORES

    /**
     * Constructor con atributos
     * @param pais nombre del pais
     */
    public Pais(String pais) {
        this.idPais = GeneradorId.generarId(idPais);
        this.pais = pais;
    }

    //GETTER Y SETTER

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }
}
