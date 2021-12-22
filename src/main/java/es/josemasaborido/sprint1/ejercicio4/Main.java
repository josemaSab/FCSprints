package es.josemasaborido.sprint1.ejercicio4;

import com.sparkpost.Client;
import com.sparkpost.exception.SparkPostException;
import com.sparkpost.model.responses.Response;
import es.josemasaborido.sprint1.ejercicio4.sparkpost.SparkPost;


/**
 * Ejercicio 4 Sprint 1 de Fisrt Commit
 * Ejercicio 4. Crea una cuenta en SparkPost y mándate un mail de bienvenida al sistema
 * <p>
 * Clase Main. Entrada al programa
 *
 * @author josema
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws SparkPostException {

        //DEFINIMOS LA CONFIGURACION DEL CORREO

        String de = "holaquease@sparkpost.devsyn.net";
        String para = "j.saborido@josemasaborido.es";
        String asunto = "Prueba libreria SparkPost";
        String cuerpo = "Buenas noches,\n Esto es una prueba de correo electronico con la"
                + " libreria SparkPost desde IntelliJ en el proyecto First Commit de " +
                "OpenBootcamp";
        String html = "<b>Recibe un cordial saludo</b>";

        //Instanciamos un objeto Sparkpost
        SparkPost sparkPost = new SparkPost();
        //Enviamos el mensaje
        Response response = sparkPost.getCliente().sendMessage(de, para, asunto, cuerpo, html);
        //Mostramos el Response
        System.out.println(response);
    }


}

