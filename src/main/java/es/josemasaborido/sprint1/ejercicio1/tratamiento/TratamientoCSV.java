package es.josemasaborido.sprint1.ejercicio1.tratamiento;

import es.josemasaborido.sprint1.ejercicio1.models.ErrorFichero;
import es.josemasaborido.sprint1.ejercicio1.models.Usuario;
import es.josemasaborido.sprint1.ejercicio1.models.enums.TipoError;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

/**
 * Ejercicio 1 Sprint 1 de Fisrt Commit
 * <p>
 * Clase que hace tod@ el tatamiento del fichero facilitado
 *
 * @author josema
 * @version 1.0
 */
public class TratamientoCSV {

    //COLORES CONSOLA

    public static final String ANSI_ROJO = "\u001B[31m";
    public static final String ANSI_VERDE = "\u001B[32m";
    public static final String ANSI_AMARILLO = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    //ATRIBUTOS

    private int contadorLineas;
    private List<Usuario> usuarios;
    private List<ErrorFichero> errores;
    private String rutaArchivo;
    private static final String SEPARADOR = ",";

    //CONSTRUCTORES

    /**
     * Constructor con parametros.
     *
     * @param rutaArchivo ruta del archivo facilitado.
     */
    public TratamientoCSV(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        //Inicializamos la Lista de usuarios
        this.usuarios = new ArrayList<>();
        //Inicializamos la lista de errores
        this.errores = new ArrayList<>();
        //inicializamos el contador de lineas
        this.contadorLineas = 1;
    }

    //METODOS

    /**
     * Metodo que realiza el tramiento del fichero y comprueba que los campos son correctos,
     * si son conrrectos los almacena en el ArrayList y si no son correctos los almacena en
     * el ArrayList de errores .Nos muestra por consola todo lo que va pasando y al final
     * muestra por consola un resumen de los usuarios guardados , errores y lineas procesadas
     */
    public void tratamientoFichero() {
        //Creamos el buffer de lectura
        BufferedReader bufferLectura = null;
        String linea = null;
        try {
            //Abrimos el archivo en el buffer de lectura
            bufferLectura = new BufferedReader(new FileReader(this.rutaArchivo));
            //Leemos una linea
            linea = bufferLectura.readLine();
            //Mientras linea sea diferente a null hacer el tratamiento del fichero
            while (linea != null) {
                String[] campos = linea.split(SEPARADOR);
                //Si todos los campos son correctos
                if (comprobacionCampos(campos)) {
                    //Comprobamos que el email o el nombre de usuario no esta ya en la lista
                    //campos[0] corresponde al email
                    if (this.compruebaEmailDuplicados(campos[0])) {
                        //Creamos un error y lo agragamos al listado de errores
                        ErrorFichero errorEmail = new ErrorFichero(TipoError.EMAIL_DUPLICADO, this.contadorLineas);
                        this.errores.add(errorEmail);
                        System.out.println(this.contadorLineas + ": " + ANSI_ROJO + "[ERROR] EMAIL \t\t\t" + ANSI_RESET + linea);
                        //campos[2] corresponde al nombre de usuario
                    } else if (this.compruebaNomUsuariosDuplicados(campos[2])) {
                        //Creamos un error y lo agragamos al listado de errores
                        ErrorFichero errorNombreUsuario = new ErrorFichero(TipoError.NOMBRE_USUARIO_DUPLICADO,
                                this.contadorLineas);
                        this.errores.add(errorNombreUsuario);
                        System.out.println(this.contadorLineas + ": " + ANSI_ROJO + "[ERROR] NOMBRE USUARIO \t" + ANSI_RESET + linea );
                    } else {
                        //Creamos el usuario y lo añadimos al listado de usuarios
                        Usuario usuario = new Usuario(campos[0], campos[1], campos[2]);
                        this.usuarios.add(usuario);
                        System.out.println(this.contadorLineas + ": " + ANSI_VERDE + "[OK]\t\t\t\t\t\t" + ANSI_RESET + linea);
                    }

                } else {
                    //Creamos un error y lo agregamos a la lista de errores
                    ErrorFichero errorMalFormado = new ErrorFichero(TipoError.MAL_FORMADO, this.contadorLineas);
                    this.errores.add(errorMalFormado);
                    System.out.println(this.contadorLineas + ": " + ANSI_ROJO + "[ERROR] MAL FORMADO\t\t" + ANSI_RESET + linea);
                }
                //Leemos otra linea y aumentamos el contador
                linea = bufferLectura.readLine();
                this.contadorLineas++;

            }
            //MOSTRAMOS RESULTADOS FINALES
            this.mostrarLineasProcesadas();
            //Paramos para que no se superpongan cosas en la consola
            sleep(50);
            this.mostrarUsuarios();
            sleep(50);
            this.mostrarErrores();
        } catch (FileNotFoundException e) {
            System.err.println("El fichero no existe o la ruta es erronea: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ha habido algun problema al leer el fichero: " + e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //Cerramos el buffer de lectura.
            if (bufferLectura != null) {
                try {
                    //Cerramos el buffer
                    bufferLectura.close();
                } catch (IOException e) {
                    System.out.println("Hubo algun problema al cerrar el buffer: " + e.getMessage());
                }
            }
        }
    }

    /**
     * Metodo que comprueba que los campos facilitados en el array cumplen con las especificaciones
     * de cada campo.
     *
     * @param campos array con los campos de una linea del fichero.
     * @return true si cumplen con las especificaciones y false si no las cumple.
     */
    public boolean comprobacionCampos(String[] campos) {
        //Expresion regular para email acepta letras numeros "_" "-" ".
        Pattern email = Pattern.compile("^[a-zA-Z0-9_\\-\\.]+@([a-zA-Z0-9]+)(\\.)[a-zA-Z0-9]+$");
        //Expresion regular para los nombres completos. Acepta letras minusculas y mayusculas
        Pattern nombreCompleto = Pattern.compile("^[a-zA-Z]+(\s[a-zA-Z]+)+$");
        //Expresion regular para el nombre de usuario. permite letras numeros "_" "-" "."
        Pattern usuario = Pattern.compile("^[a-zA-Z0-9_\\.\\-@]+$");
        String[] arrayPasado = new String[3];
        //Si el array pasado por parametros tiene 3 elementos hago la comprobación de las
        //expresiones regulares y si tod@ es correcto devuleve true
        if (campos.length == 3) {
            arrayPasado = campos;
            Matcher matEmail = email.matcher(arrayPasado[0]);
            Matcher matNombreCompleto = nombreCompleto.matcher(arrayPasado[1]);
            Matcher matUsuario = usuario.matcher(arrayPasado[2]);
            //Comprobamos si todos los matches son correctos
            if (matEmail.matches() && matNombreCompleto.matches() && matUsuario.matches()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que comprueba si un email pasado por parametro existe ya en el ArrayList
     *
     * @param email email del usuario
     * @return true si ya existe y false si no existe
     */
    public boolean compruebaEmailDuplicados(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que comprueba si un nombre de usuario pasado por parametro existe ya en el ArrayList
     *
     * @param nombreUsuario nombre de usuario
     * @return true si existe y false si no existe
     */
    public boolean compruebaNomUsuariosDuplicados(String nombreUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que muestra por consola todos los usuarios almacenados en el ArrayList de usuarios
     */
    public void mostrarUsuarios() {
        System.out.println("-------- LISTA DE USUARIOS --------");
        //recorremos el array para mostrarlo por consola
        for (Usuario usuario : this.usuarios) {
            System.out.println(ANSI_AMARILLO + usuario.toString() + ANSI_RESET);
        }
    }

    /**
     * Metodo que muestra por consola todos los errores almacenados en el ArrayList de errores
     */
    public void mostrarErrores() {
        System.out.println("-------- LISTA DE ERRORES --------");
        //recorremos el array para mostrarlo por consola
        for (ErrorFichero error : errores) {
            System.err.println(error.toString());
        }
    }

    /**
     * Muestra el numero de lineas procesadas
     */
    public void mostrarLineasProcesadas() {
        System.out.println("-------- LINEAS PROCESADAS -------");
        System.out.println(ANSI_VERDE + "Total de lineas procesadas: " + (this.contadorLineas-1) + ANSI_RESET);
    }

    //GETTER Y SETTER

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public int getContadorLineas() {
        return contadorLineas;
    }

    public List<ErrorFichero> getErrores() {
        return errores;
    }

    public void setErrores(List<ErrorFichero> errores) {
        this.errores = errores;
    }
}
