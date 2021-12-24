package es.josemasaborido.sprint1.ejercicio5.entities;

import es.josemasaborido.sprint1.ejercicio5.persistencia.GeneradorId;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 5 Sprint 1 de Fisrt Commit
 *
 * Clase Certificacion
 *
 * @author josema
 * @version 1.0
 */
public class Certificacion {

    //ATRIBUTOS

    private static Long idCertificacion = 0L;
    private String certificacion;

    //Relaciones

    private List<Alumno> alumnos = new ArrayList<>();

    //CONSTRUCTORES

    /**
     * Constructor con parametros
     * @param certificacion nombre la certificacion
     */
    public Certificacion(String certificacion) {
        this.idCertificacion = GeneradorId.generarId(idCertificacion);
        this.certificacion = certificacion;
    }

    //GETTER Y SETTER

    public Long getIdCertificacion() {
        return idCertificacion;
    }

    public void setIdCertificacion(Long idCertificacion) {
        this.idCertificacion = idCertificacion;
    }

    public String getCertificacion() {
        return certificacion;
    }

    public void setCertificacion(String certificacion) {
        this.certificacion = certificacion;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
