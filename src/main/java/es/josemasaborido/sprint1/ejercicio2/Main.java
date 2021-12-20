package es.josemasaborido.sprint1.ejercicio2;

import es.josemasaborido.sprint1.ejercicio2.menu.Menu;
import es.josemasaborido.sprint1.ejercicio2.models.Usuario;
import es.josemasaborido.sprint1.ejercicio2.service.RegistroService;

import java.util.ArrayList;
import java.util.List;

/**
 * ## Ejercicio 2. Crea los dos métodos siguientes para acceder al sistema:
 *
 * a) **Registrar usuario.** Se debe almacenar, en un ArrayList de Users, el correo electrónico y la contraseña hasheada.
 *
 * **Signatura:** public boolean register(String email, String password)
 *
 * Devuelve true si se ha podido almacenar, false si el correo ya existía.
 * b) **Login usuario.** Se debe comprobar con el ArrayList previo si el usuario existe y en caso de que exista, hashear la contraseña recibida y comprobar que son iguales.
 *
 * **Signatura:** public int login(String email, String password)
 *
 * Devuelve -1 si el email no existe
 * Devuelve -2 si la contraseña es incorrecta
 * Devuelve 1 si el usuario existe y la contraseña es correcta
 *
 * Clase Main. Entrada al programa
 *
 * @author josema
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        List<Usuario> almacenamiento = new ArrayList<>();
        RegistroService registroService = new RegistroService(almacenamiento);
        Menu menu = new Menu(registroService);

    }
}


