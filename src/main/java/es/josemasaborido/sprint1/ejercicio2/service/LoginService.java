package es.josemasaborido.sprint1.ejercicio2.service;

import es.josemasaborido.sprint1.ejercicio2.models.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio  Sprint 1 de Fisrt Commit
 * <p>
 * Clase que define el servicio de Login
 *
 * @author josema
 * @version 1.0
 */
public class LoginService {

    //COLORES CONSOLA

    public static final String ANSI_ROJO = "\u001B[31m";
    public static final String ANSI_VERDE = "\u001B[32m";
    public static final String ANSI_AMARILLO = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    //ATRIBUTOS

    private List<Usuario> almacenamiento = new ArrayList<>();

    //CONSTRUCTORES

    /**
     * Constructor con parametros
     * @param almacenamiento ArrayList con los usuarios guardados
     */
    public LoginService(List<Usuario> almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    //METODOS

    /**
     * Metodo que realiza el login en el sistema
     * @param email del usuario
     * @param password del usuario
     * @return -1 si el email no existe, -2 si la contraseña es incorrecta y 1 si
     * el usuario existe y la contraseña es correcta
     */
    public int login(String email, String password){
        int resultado = -1;
        String hashpwd = RegistroService.hashPassword(password);
        if(this.existeEmail(email) != null){
            if(this.obtenerHashPwd(email).equals(hashpwd)){
                return 1;
            }
            return -2;
        }
        return resultado;
    }

    /**
     * Metodo que comprueba que el email existe en el almacenamiento
     * @param email del usuario
     * @return el usuario buscado por email y si no existe devulve null
     */
    public Usuario existeEmail(String email){
        for(Usuario usuario: this.almacenamiento){
            if (usuario.getEmail().equals(email)){
                return usuario;
            }
        }
        return null;
    }

    /**
     * Metodo que devuelve el pasword hasheado en el almacenamiento
     * @param email del usuario
     * @return string con el password Hasheado que esta en el almacenamiento
     */
    public String obtenerHashPwd(String email){
        Usuario usuario = this.existeEmail(email);
        return usuario.getPassword();
    }

    public void muestraMensajes(int estadoLogin){
        switch(estadoLogin){
            case -1:
                System.out.println(ANSI_AMARILLO + "[STATUS " + ANSI_ROJO + "ERROR: " + estadoLogin + ANSI_AMARILLO + "] EL EMAIL NO EXISTE." + ANSI_RESET);
                break;
            case -2:
                System.out.println(ANSI_AMARILLO + "[STATUS " + ANSI_ROJO + "ERROR: " + estadoLogin + ANSI_AMARILLO + "] LA CONTRASEÑA ES INCORRECTA." + ANSI_RESET);
                break;
            case 1:
                System.out.println(ANSI_AMARILLO + "[STATUS " + ANSI_VERDE + "OK: " + estadoLogin + ANSI_AMARILLO + "] EL USUARIO EXISTE Y LA CONTRASEÑA ES CORRECTA." + ANSI_RESET);
                break;
        }
    }

    //GETTER Y SETTER


    public List<Usuario> getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(List<Usuario> almacenamiento) {
        this.almacenamiento = almacenamiento;
    }
}
