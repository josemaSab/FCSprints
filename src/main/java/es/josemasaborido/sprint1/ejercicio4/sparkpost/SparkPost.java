package es.josemasaborido.sprint1.ejercicio4.sparkpost;

import com.sparkpost.Client;
/**
 * Ejercicio 4 Sprint 1 de Fisrt Commit
 *
 * Clase que define el objeto SparkPost instancia el cliente con la API KEY
 *
 * @author josema
 * @version 1.0
 */
public class SparkPost {

    //ATRIBUTOS

    private final String API_KEY="b275f49495d342f18f146161093b52ec93fbfb47";
    Client cliente;

    //CONSTRUCTORES

    /**
     * Constructor sin parametros
     */
    public SparkPost() {
        this.cliente = new Client(API_KEY);
    }

    //GETTER Y SETTER


    public String getAPI_KEY() {
        return API_KEY;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }
}
