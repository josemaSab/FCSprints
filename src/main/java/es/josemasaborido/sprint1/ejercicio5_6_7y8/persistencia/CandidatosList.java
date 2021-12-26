package es.josemasaborido.sprint1.ejercicio5_6_7y8.persistencia;

import es.josemasaborido.sprint1.ejercicio5_6_7y8.Main;
import es.josemasaborido.sprint1.ejercicio5_6_7y8.entities.Alumno;
import es.josemasaborido.sprint1.ejercicio5_6_7y8.entities.Pais;

import java.util.*;

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
 *## Ejercicio 8. Dada la colección anterior, realiza métodos de cálculo de todos los candidatos:
 *
 * - public void imprimeCiudadesTop() → Imprime el número de alumnos por ciudad, ordenadas por total:
 *     - Madrid => 48
 *     - Barcelona => 37
 *     - Valencia => 26
 *     - Málaga => 14
 *     - Sevilla => 10
 *     - Tarragona => 7
 *     - Buenos Aires => 6
 *     - Rosario => 5
 *     - Malaga => 5
 *     - Zaragoza => 5
 *     - Córdoba => 4
 * - public void imprimePaisesTop() → Imprime el número de alumnos por país, ordenadas por total
 * - public int totalRemotos() → Devuelve un entero con los candidatos que están dispuestos a trabajar en remoto
 * - public int totalPosibilidadTraslado() → Devuelve un entero con los candidatos que están dispuestos a trasladarse
 * - public int totalPresencialSinTraslado() → Devuelve un entero con los candidatos que quieren trabajo exclusivamente presencial y no están dispuestos a trasladarse
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

    //METODOS EJERCICIO 8

    /**
     * Metodo que imprime el listado de ciudades top con numero de candidatos ordenados de mayor a menor
     */
    public void imprimeCiudadesTop(){
        Map<String, Integer> ciudadesAlumnos = new HashMap<>();
        int valor;
        //Recorremos el listado de alumnos
        for(Alumno a:listaCandidatos){
            //Si existe la ciudad en el map sumamos 1 al valor
            if(ciudadesAlumnos.containsKey(a.getCiudad().getCiudad())){
                valor = ciudadesAlumnos.get(a.getCiudad().getCiudad());
                valor = valor +1;
                ciudadesAlumnos.put(a.getCiudad().getCiudad(), valor);
            }else{
                //Si la ciudad no existe en el map la crea y le asigna valor 1
                ciudadesAlumnos.put(a.getCiudad().getCiudad(), 1);
            }

        }
        System.out.println("IMPRIME ALUMNOS POR CIUDADES");
        System.out.println("-----------------------------\n");
        //Asignamos los valores un arrayList para ordenarlo
        List<Map.Entry<String, Integer>> lista =new ArrayList<>(ciudadesAlumnos.entrySet());
        //Ordenamos por el valor
        lista.sort(Map.Entry.comparingByValue());
        for(int i = lista.size()-1; i>=0; i--){
            System.out.println("* Ciudad: " + lista.get(i).getKey() + "=>" + lista.get(i).getValue() + " candidatos");
        }
    }
    /**
     * Metodo que imprime el listado de paises top con numero de candidatos ordenados de mayor a menor
     */
    public void imprimePaisesTop(){
        Map<String, Integer> paisesAlumnos = new HashMap<>();
        int valor;
        //Recorremos el listado de alumnos
        for(Alumno a:listaCandidatos){
            //Si existe la ciudad en el map sumamos 1 al valor
            if(paisesAlumnos.containsKey(a.getCiudad().getPais().getPais())){
                valor = paisesAlumnos.get(a.getCiudad().getPais().getPais());
                valor = valor +1;
                paisesAlumnos.put(a.getCiudad().getPais().getPais(), valor);
            }else{
                //Si la ciudad no existe en el map la crea y le asigna valor 1
                paisesAlumnos.put(a.getCiudad().getPais().getPais(), 1);
            }

        }
        System.out.println("\n\nIMPRIME ALUMNOS POR PAISES");
        System.out.println("-----------------------------\n");
        //Asignamos los valores un arrayList para ordenarlo
        List<Map.Entry<String, Integer>> lista =new ArrayList<>(paisesAlumnos.entrySet());
        //Ordenamos por el valor
        lista.sort(Map.Entry.comparingByValue());
        //Recorremos el ArrayList desde el final al principio
        for(int i = lista.size()-1; i>=0; i--){
            System.out.println("* Pais: " + lista.get(i).getKey() + "=>" + lista.get(i).getValue() + " candidatos");
        }

    }

    /**
     * Metodo que devulve el numero total de candidatos que tienen la presencialidad en remoto
     * @return numero total de remotos
     */
    public int totalRemotos(){
        int contador = 0;
        for(Alumno a:listaCandidatos){
            if(a.getPresencialidad().getPresencialidad().equals("Remoto")){
                contador++;
            }
        }
        return contador;
    }

    /**
     * Metodo que devulve el total de candidatos que tienen posibilidad de traslado
     * @return numero total de traslados
     */
    public int totalPosibilidadTraslado(){
        int contador = 0;
        for(Alumno a:listaCandidatos){
            if(a.getTraslado()==true){
                contador++;
            }
        }
        return contador;
    }
    /**
     * Metodo que devulve el total de candidatos que no tienen posibilidad de traslado
     * @return numero total de no traslados
     */
    public int totalNoPosibilidadTraslado(){
        int contador = 0;
        for(Alumno a:listaCandidatos){
            if(a.getTraslado()==false){
                contador++;
            }
        }
        return contador;

    }



    //GETTER Y SETTER


    public static List<Alumno> getListaCandidatos() {
        return listaCandidatos;
    }

    public static void setListaCandidatos(List<Alumno> listaCandidatos) {
        CandidatosList.listaCandidatos = listaCandidatos;
    }
}
