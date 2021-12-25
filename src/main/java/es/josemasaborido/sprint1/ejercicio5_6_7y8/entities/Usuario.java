package es.josemasaborido.sprint1.ejercicio5_6_7y8.entities;

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
public class Usuario {

    //ATRIBUTOS
    private static Long idUsuario = 0L;
    private String nombreUsuario;
    private String password;
    private String email;

    //Relaciones
    private List<Alumno> alumnos = new ArrayList<>();

    //CONSTRUCTORES

    /**
     * Constructor con todos lo atributos
     * @param nombreUsuario nombre del usuario
     * @param password password del usuario
     * @param email email del usuario
     */
    public Usuario(String nombreUsuario, String password, String email) {
        this.idUsuario = GeneradorId.generarId(idUsuario);
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
