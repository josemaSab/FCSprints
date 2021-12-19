package es.josemasaborido.sprint1.ejercicio1;


import es.josemasaborido.sprint1.ejercicio1.tratamiento.TratamientoCSV;

/**
 * ## Ejercicio 1. Dado un fichero CSV de la siguiente forma:
 *
 * correo@dominio.com,Nombre Completo,usuario
 * correo@dominio.com,Nombre Completo,usuario
 * correo@dominio.com,Nombre Completo,usuario
 *
 * Debes hacer un programa en Java que procese el fichero y cree un ArrayList con todos los usuarios
 * (para ver que funciona correctamente, imprime por pantalla el resultado).
 *
 * Debes tener en cuenta:
 *
 * 1. No debe haber correos duplicados. Se debe mostrar un error por **stderr** indicando la línea y el correo que está
 * duplicado.
 * 2. Si hay una línea mal formada, se debe mostrar también por **stderr**, indicando el número de línea que está mal
 * formada.
 * 3. Se debe indicar el número de líneas procesadas correctamente por **stdout** y el número de errores.
 *
 * ------------------------------------------
 *
 * Clase main. Entrada al programa
 *
 * @author josema
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        String ruta = "/media/josema/DATOS/Usuarios/Josema_000/IdeaProjects/FCSprints/src/main/java/es/josemasaborido/sprint1/ejercicio1/usuarios.csv";
        TratamientoCSV csv = new TratamientoCSV(ruta);
        csv.tratamientoFichero();
    }
}
