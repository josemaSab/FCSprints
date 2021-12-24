package es.josemasaborido.sprint1.ejercicio5.persistencia;

import es.josemasaborido.sprint1.ejercicio5.entities.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 5 Sprint 1 de Fisrt Commit
 *
 * Clase que se encarga de definir la persistencia en un ArrayList
 * Patron Singelton
 *
 * @author josema
 * @version 1.0
 */
public class PersisntenciaArrayList implements TipoAlmacenamiento<Usuario>{

    //ATRIBUTOS

    private static ArrayList<Usuario> bdUsuarios;
    private static PersisntenciaArrayList persisntenciaArrayList = null;

    //CONSTRUCTORES

    private PersisntenciaArrayList(){
        this.bdUsuarios = new ArrayList<>();
    }

    /**
     * Metodo de llamada al constructor para tomar la instancia del objeto
     * @return la instancia del objeto
     */

    public static PersisntenciaArrayList getInstancia(){
        //Si no existe una instancia del objeto la crea
        if(persisntenciaArrayList ==null){
            persisntenciaArrayList =new PersisntenciaArrayList();
        }
        //Si ya esta creada la instancia anteriormente te devuelve la instancia
        return persisntenciaArrayList;
    }

    //METODOS

    /**
     * Metodo que guarda el usuario en el ArrayList
     * @param usuario objeto usuario pasado
     * @return true si ha podido guardarlo y false si ha habido algun errro
     */
    @Override
    public boolean guardar(Usuario usuario) {
        if(bdUsuarios.add(usuario)){
            return true;
        }
        return false;
    }

    /**
     * Metodo que busca un usurio en el ArrayList
     * @param usuario buscado
     * @return usuario  si lo encuetra y null si no lo encuentra
     */
    @Override
    public Usuario obtener(Usuario usuario) {
        Usuario usuarioBD = null;
        //Comprobamos que el usuario existe en el arraylist
        if(bdUsuarios.contains(usuario)){
            //Recorremos el array para buscarlo
            for(Usuario u: bdUsuarios){
                //Se lo asignamos a la variable que finalmente retornaremos
                if(u == usuarioBD){
                    usuarioBD = u;
                }
            }
        }
        return usuarioBD;
    }

    /**
     * Metodo que obtiene todos los usuarios
     * @return List de usuarios
     */
    @Override
    public List<Usuario> obtenerTodos() {
        return bdUsuarios;
    }

    //GETTER Y SETTER


    public static ArrayList<Usuario> getBdUsuarios() {
        return bdUsuarios;
    }

    public static void setBdUsuarios(ArrayList<Usuario> bdUsuarios) {
        PersisntenciaArrayList.bdUsuarios = bdUsuarios;
    }

    public static PersisntenciaArrayList getPersisntenciaArrayList() {
        return persisntenciaArrayList;
    }

    public static void setPersisntenciaArrayList(PersisntenciaArrayList persisntenciaArrayList) {
        PersisntenciaArrayList.persisntenciaArrayList = persisntenciaArrayList;
    }
}
