package es.josemasaborido.sprint1.ejercicio2y3.service;

import es.josemasaborido.sprint1.ejercicio2y3.models.Usuario;
import es.josemasaborido.sprint1.ejercicio2y3.security.PasswordHasheable;
import es.josemasaborido.sprint1.ejercicio2y3.ui.Colores;

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


    //ATRIBUTOS

    private List<Usuario> almacenamiento = new ArrayList<>();
    private PasswordHasheable encode;

    //CONSTRUCTORES

    /**
     * Constructor con todos los parametros
     *
     * @param almacenamiento Array listo donde estan todos los usurios
     * @param encode         tipo de encriptacion seleccionada para encreitar contraseña
     */
    public LoginService(List<Usuario> almacenamiento, PasswordHasheable encode) {
        this.almacenamiento = almacenamiento;
        this.encode = encode;
    }


    //METODOS

    /**
     * Metodo que realiza el login en el sistema
     *
     * @param email    del usuario
     * @param password del usuario
     * @return -1 si el email no existe, -2 si la contraseña es incorrecta y 1 si
     * el usuario existe y la contraseña es correcta
     */
    public int login(String email, String password) {
        int resultado = -1;
        if (this.existeEmail(email) != null) {
            //Se comprueba si el password hasheado coincide con el password sin hashear pasado
            //por parametro
            if (this.encode.verificarPassword(this.obtenerHashPwd(email), password)) {
                return 1;
            }
            return -2;
        }
        return resultado;
    }

    /**
     * Metodo que comprueba que el email existe en el almacenamiento
     *
     * @param email del usuario
     * @return el usuario buscado por email y si no existe devulve null
     */
    public Usuario existeEmail(String email) {
        for (Usuario usuario : this.almacenamiento) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    /**
     * Metodo que devuelve el pasword hasheado en el almacenamiento
     *
     * @param email del usuario
     * @return string con el password Hasheado que esta en el almacenamiento
     */
    public String obtenerHashPwd(String email) {
        Usuario usuario = this.existeEmail(email);
        return usuario.getPassword();
    }

    public void muestraMensajes(int estadoLogin) {
        switch (estadoLogin) {
            case -1:
                System.out.println(Colores.ANSI_AMARILLO + "[STATUS " + Colores.ANSI_ROJO + "ERROR: " + estadoLogin + Colores.ANSI_AMARILLO + "] EL EMAIL NO EXISTE." + Colores.ANSI_RESET);
                break;
            case -2:
                System.out.println(Colores.ANSI_AMARILLO + "[STATUS " + Colores.ANSI_ROJO + "ERROR: " + estadoLogin + Colores.ANSI_AMARILLO + "] LA CONTRASEÑA ES INCORRECTA." + Colores.ANSI_RESET);
                break;
            case 1:
                System.out.println(Colores.ANSI_AMARILLO + "[STATUS " + Colores.ANSI_VERDE + "OK: " + estadoLogin + Colores.ANSI_AMARILLO + "] EL USUARIO EXISTE Y LA CONTRASEÑA ES CORRECTA." + Colores.ANSI_RESET);
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

    public PasswordHasheable getEncode() {
        return encode;
    }

    public void setEncode(PasswordHasheable encode) {
        this.encode = encode;
    }
}
