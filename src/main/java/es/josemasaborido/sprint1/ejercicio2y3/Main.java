package es.josemasaborido.sprint1.ejercicio2y3;

import es.josemasaborido.sprint1.ejercicio2y3.menu.Menu;
import es.josemasaborido.sprint1.ejercicio2y3.models.Usuario;
import es.josemasaborido.sprint1.ejercicio2y3.security.HashArgon2;
import es.josemasaborido.sprint1.ejercicio2y3.service.LoginService;
import es.josemasaborido.sprint1.ejercicio2y3.service.RegistroService;

import java.util.ArrayList;
import java.util.List;

/**
 * ## Ejercicio 2. Crea los dos métodos siguientes para acceder al sistema:
 * <p>
 * a) **Registrar usuario.** Se debe almacenar, en un ArrayList de Users, el correo electrónico y la contraseña hasheada.
 * <p>
 * **Signatura:** public boolean register(String email, String password)
 * <p>
 * Devuelve true si se ha podido almacenar, false si el correo ya existía.
 * b) **Login usuario.** Se debe comprobar con el ArrayList previo si el usuario existe y en caso de que exista, hashear la contraseña recibida y comprobar que son iguales.
 * <p>
 * **Signatura:** public int login(String email, String password)
 * <p>
 * Devuelve -1 si el email no existe
 * Devuelve -2 si la contraseña es incorrecta
 * Devuelve 1 si el usuario existe y la contraseña es correcta
 * <p>
 * Clase Main. Entrada al programa
 *
 * @author josema
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        //Creamos el ArrayLista para el almacenamiento de los Usuarios
        List<Usuario> almacenamiento = new ArrayList<>();
        /*    ENCRIPTACION CON MD5
        //Instanciamos el servicio de registro
        RegistroService registroService = new RegistroService(almacenamiento, new HashMD5());
        //Instanciamos el servicio de login
        LoginService loginService=new LoginService(almacenamiento, new HashMD5());
         */
        //Instanciamos el servicio de registro
        RegistroService registroService = new RegistroService(almacenamiento, new HashArgon2());
        //Instanciamos el servicio de login
        LoginService loginService = new LoginService(almacenamiento, new HashArgon2());
        //Instanciamos el menu que arrancará la lógica de la aplicacion
        Menu menu = new Menu(registroService, loginService);

    }
}


