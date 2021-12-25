package es.josemasaborido.sprint1.ejercicio5_6_7y8.persistencia;

import es.josemasaborido.sprint1.ejercicio5_6_7y8.entities.Alumno;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 7 Sprint 1 de Fisrt Commit
 * ## Ejercicio 7. Implementa una colección especial (a través de una clase), llamada CandidatosList que permita:
 *
 * - Añadir un Candidato
 * - Borrar un Candidato
 * - Filtrar candidatos:
 *     - public ArrayList<Candidato> filtrar(String ciudad)
 *     - public ArrayList<Candidato> filtrar(String presencialidad)
 *     - public ArrayList<Candidato> filtrar(boolean tipoTraslado)
 *     - public ArrayList<Candidato> filtrar(String ciudad, String presencialidad, boolean tipoTraslado)
 *     - public Candidato buscarEmail(String email)
 *     - public Candidato buscarTelefono(String telefono)
 *
 * @author josema
 * @version 1.0
 */
public class CandidatosList {

    //ATRIBUTOS
    public static List<Alumno> listaCandidatos = new ArrayList<>();

    //CONSTRUCTORES

    /**
     * Consutructor sin parametros
     */
    public CandidatosList() {
    }

    //METODOS

    /**
     * Metodo que añade un candidato al array de candidatos
     * @param candidato candidato Alumno
     * @return true si ha podido añadirlo y false si ha habido algun error al añadirlo
     */
    public boolean addCandidato(Alumno candidato){
        if(listaCandidatos.add(candidato)){
            System.out.println("Candidato añadido con exito." + candidato.toString());
            return true;
        }
        System.out.println("Hubo algun problema al añadir un candidato");
        return false;
    }

    /**
     * Metodo que elimina un candidato
     * @param candidato pasado por parametro
     * @return true si lo ha elimindao correctamente y false si ha habido algun error al elimiarlo.
     */
    public boolean borrarCandidato(Alumno candidato){
        //Comprobamos si existe en el array list
        if(listaCandidatos.contains(candidato)){
            //Si existe lo borramos
            listaCandidatos.remove(candidato);
            System.out.println("El candidato se ha eliminado correctamente.");
        }
        System.out.println("Hubo algún problema al eliminar el candidato");
        return false;
    }

    /**
     * Metodo que devulve un array con los usuario que son de la de ciudad pasada por parametro
     * @param nombreCiudad nombre de la ciudad pasada por parametro
     * @return array con los alumnos la ciudad pasada por parametro
     */
    public List<Alumno> filtrar(String nombreCiudad){
        List<Alumno> alumnosCiudad = new ArrayList<>();
        for(Alumno a:listaCandidatos){
            //Si el candidato tiene la ciudad lo añade al arrayList
            if(a.getCiudad().getCiudad().equals(nombreCiudad)){
                alumnosCiudad.add(a);
            }
        }
        return alumnosCiudad;
    }

    /**
     * Metofo que devulve un array de alumnos que tienen el tipo de presencialidad pasada por parametro
     * @param presencialidad tipo de presencialidad
     * @return array con los alumnos que tienen ese tipo de presencialidad
     */
    public List<Alumno> filtrarPresencialidad(String presencialidad){
        List<Alumno> alumnosPresencialidad = new ArrayList<>();
        for(Alumno a:listaCandidatos){
            //Si el candidato tiene la ciudad lo añade al arrayList
            if(a.getPresencialidad().getPresencialidad().contains(presencialidad)){
                alumnosPresencialidad.add(a);
            }
        }
        return alumnosPresencialidad;

    }

    /**
     * Metodo que devulve un array con los usuario que tienen el tipo de traslado pasado por parametro
     * @param tipoTraslado parametro booleano de si tiene activado el traslado
     * @return array con los alumnos con el tipo de traslado
     */
    public List<Alumno> filtrar(Boolean tipoTraslado){
        List<Alumno> alumnosTraslado = new ArrayList<>();
        for(Alumno a:listaCandidatos){
            //Si el candidato tiene la ciudad lo añade al arrayList
            if(a.getTraslado()==tipoTraslado){
                alumnosTraslado.add(a);
            }
        }
        return alumnosTraslado;
    }

    /**
     * Metodo que busca los alumnos que tienen una ciudad concreta un tipo de presencialidad y un tipo de traslado pasado
     * por parametros
     * @param ciudad pasada por parametro
     * @param presencialidad pasasada por parametro
     * @param tipoTraslado pasado por parametro
     * @return listado de alumno que cumple todas las reglas
     */
    public List<Alumno> filtrar(String ciudad, String presencialidad, boolean tipoTraslado){
        List<Alumno> alumnos = new ArrayList<>();
        for(Alumno a:listaCandidatos){
            if(a.getTraslado()==tipoTraslado && a.getPresencialidad().getPresencialidad().equals(presencialidad)&&a.getCiudad().getCiudad().equals(ciudad)){
                alumnos.add(a);
            }
        }
        return alumnos;
    }

    /**
     * Metodoq que busca un candiidato por email pasado por parametro
     * @param email pasado por parametro
     * @return candidato encontrado o null si no encuentra al candidato
     */
    public Alumno buscarEmail(String email){
        Alumno alumnoEncontrado = null;
        for(Alumno u:listaCandidatos){
            if(u.getEmailAlumno().equals(email)){
                alumnoEncontrado = u;
            }
        }
        return alumnoEncontrado;
    }

    /**
     * Metodo que busca un candidato por telefono pasado por parametro
     * @param telefono pasado por parametro
     * @return candidato encontrado o null si no encuentra nu¡inguno
     */
    public Alumno buscarTelefono(String telefono){
        Alumno alumnoEncontrado = null;
        for(Alumno u:listaCandidatos){
            if(u.getTelefono().equals(telefono)){
                alumnoEncontrado = u;
            }
        }
        return alumnoEncontrado;
    }

    //GETTER Y SETTER


    public static List<Alumno> getListaCandidatos() {
        return listaCandidatos;
    }

    public static void setListaCandidatos(List<Alumno> listaCandidatos) {
        CandidatosList.listaCandidatos = listaCandidatos;
    }
}
