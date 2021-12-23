package es.josemasaborido.sprint1.ejercicio5.entities;

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
public class Usuario {

    //ATRIBUTOS
    private Long idUsuario;
    private String nombreUsuario;
    private String password;
    private String email;

    //Relaciones
    private List<Alumno> alumnos = new ArrayList<>();

    //CONSTRUCTORES

    /**
     * Constructor con todos lo atributos
     * @param idUsuario id del usuario
     * @param nombreUsuario nombre del usuario
     * @param password password del usuario
     * @param email email del usuario
     */
    public Usuario(Long idUsuario, String nombreUsuario, String password, String email) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.email = email;
    }

    //GETTER Y SETTER


    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
