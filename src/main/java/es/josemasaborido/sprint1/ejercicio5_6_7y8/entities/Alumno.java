package es.josemasaborido.sprint1.ejercicio5_6_7y8.entities;

import es.josemasaborido.sprint1.ejercicio5_6_7y8.entities.enums.Presencialidad;
import es.josemasaborido.sprint1.ejercicio5_6_7y8.persistencia.GeneradorId;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 5 Sprint 1 de Fisrt Commit
 *
 * Clase Usuario
 *
 * @author josema
 * @version 1.0
 */
public class Alumno {

    //ATRIBUTOS
    private static Long idAlumno = 0L;//Será clave Primaria
    private String nombreAlumno;
    private String apellidos;
    private String emailAlumno;
    private String telefono;
    private Presencialidad presencialidad;
    private Boolean traslado;
    private String foto;
    private String curriculum;

    //Relaciones
    private List<Certificacion> certificaciones = new ArrayList<>();
    private Ciudad ciudad;
    private Usuario usuario;

    //CONSTRUCTORES

    /**
     * Constructor con parametros
     * @param nombreAlumno nombre del alumno
     * @param apellidos apellidos del alumno
     * @param emailAlumno email del alumno
     * @param telefono telefono del alumno
     * @param presencialidad tipo de presencialidad es un enum
     * @param traslado si esta dispuesto a traslado o no
     * @param foto ruta de la foto
     * @param curriculum ruta del curriculum
     */
    public Alumno(String nombreAlumno, String apellidos, String emailAlumno, String telefono,
                  Presencialidad presencialidad, Boolean traslado, String foto, String curriculum) {
        this.idAlumno = GeneradorId.generarId(idAlumno);
        this.nombreAlumno = nombreAlumno;
        this.apellidos = apellidos;
        this.emailAlumno = emailAlumno;
        this.telefono = telefono;
        this.presencialidad = presencialidad;
        this.traslado = traslado;
        this.foto = foto;
        this.curriculum = curriculum;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombreAlumno='" + nombreAlumno + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", emailAlumno='" + emailAlumno + '\'' +
                ", telefono='" + telefono + '\'' +
                ", presencialidad=" + presencialidad +
                ", traslado=" + traslado +
                ", foto='" + foto + '\'' +
                ", curriculum='" + curriculum + '\'' +
                ", certificaciones=" + certificaciones +
                ", ciudad=" + ciudad +
                '}';
    }

    //GETTER Y SETTER


    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmailAlumno() {
        return emailAlumno;
    }

    public void setEmailAlumno(String emailAlumno) {
        this.emailAlumno = emailAlumno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Presencialidad getPresencialidad() {
        return presencialidad;
    }

    public void setPresencialidad(Presencialidad presencialidad) {
        this.presencialidad = presencialidad;
    }

    public Boolean getTraslado() {
        return traslado;
    }

    public void setTraslado(Boolean traslado) {
        this.traslado = traslado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public List<Certificacion> getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(List<Certificacion> certificaciones) {
        this.certificaciones = certificaciones;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
