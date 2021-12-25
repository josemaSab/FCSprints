package es.josemasaborido.sprint1.ejercicio5_6_7y8.services;

import es.josemasaborido.sprint1.ejercicio5_6_7y8.entities.Usuario;
import es.josemasaborido.sprint1.ejercicio5_6_7y8.security.PasswordHasheable;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 5 Sprint 1 de Fisrt Commit
 *
 * Servicio de tratamiento de usuario. Se implementa los metodos para manejar usuarios
 *
 * @author josema
 * @version 1.0
 */
public class UsuarioService {

    //ATRIBUTOS
    List<Usuario> listaUsuarios= new ArrayList<>();
    //private TipoAlmacenamiento tipoAlmacenamiento;
    private PasswordHasheable passwordHasheable;

    //CONSTRUCTORES

    /**
     * Constructor con parametros
     * @param passwordHasheable isntancia del tipo de Encripatcion de password
     */
    public UsuarioService(List<Usuario> listaUsuarios, PasswordHasheable passwordHasheable) {
        this.listaUsuarios = listaUsuarios;
        this.passwordHasheable = passwordHasheable;
    }

    //METODOS

    /**
     * Metodo que realiza el registro del usuario en persistencia
     * @param usuario objeto usuario a registrar
     * @return true si  ha podido registrar al usuario con exito y false si ha habido algun error
     * @throws Exception Excepción que salta cuando no se ha podido registrar al usuario
     */
    public boolean registrar(Usuario usuario) throws Exception {
        try{
            Usuario usuarioBD = this.obtener(usuario.getNombreUsuario());
            //Comrpuebo que el usuario no exita en la base de datos
            if( usuarioBD == null){
                //Hasheo de password de usuario
                String paswordHasheada = passwordHasheable.hashPassword(usuario.getPassword());
                usuario.setPassword(paswordHasheada);
                //Guarda el usuario
                if(this.listaUsuarios.add(usuario)){
                    System.out.println("Usuario guardado con éxito");
                    return true;
                }
                //Si no puede guardar el usuario lanza una excepcion
                throw new Exception();
            }
            //Si existe lo muestra en consola y devuelve fakse
            System.out.println("El usuario ya existe. Prueba con otro nombre de usuario");
            return false;

        }catch(Exception e){
            //Lazan la excepcion y devuelve false
            System.out.println("No se pudo guardar el usuario.");
            return false;
        }
    }

    /**
     * Metodo login de usuario. Comprueba que el usuario pasado por parametro tiene los datos correctos para
     * acceder al sistema
     * @param usuario objeto usuario
     * @return true si el login se hizo con exito y false si hubo algun error
     * @throws Exception Excepcion que salta si no se pudo obtener el usuario de la base de datos
     */
    public boolean login(Usuario usuario) {
        try{
            Usuario usuarioBD = this.obtener(usuario.getNombreUsuario());
            //Si el usuario existe en la base de datos comprueba el nombre de usuario y la contraseña
            if(usuarioBD != null){
                if(usuarioBD.getNombreUsuario().equals(usuario.getNombreUsuario())){
                    if(usuarioBD.getPassword().equals(usuario.getPassword())){
                        System.out.println("Login correcto.");
                        return true;
                    }
                    System.out.println("La constraseña no es correcta. Verifícala de nuevo.");
                    return false;
                }
            }
            System.out.println("El nombre de usuario no es correcto o no existe en la base de datos.");
            return false;

        }catch (Exception e){
            System.out.println("Hubo algun error al intentar logearse.");
            return false;
        }
    }

    /**
     * Metodo que obtiene un usuario de un Array
     * @param nombreUsuario usuanombre de usuario a buscar
     * @return usuario buscado o null si no lo encuentra
     */
    public Usuario obtener(String nombreUsuario) {
        Usuario usuarioBD = null;
        //Comprobamos que el usuario existe en el arraylist
       //Recorremos el array para buscarlo
        for(Usuario u: this.listaUsuarios){
                //Se lo asignamos a la variable que finalmente retornaremos
            if(u.getNombreUsuario().equals(nombreUsuario)){
                usuarioBD = u;
            }
        }

        return usuarioBD;
    }


    //GETTE Y SETTER
/*
    public TipoAlmacenamiento getTipoAlmacenamiento() {
        return tipoAlmacenamiento;
    }

    public void setTipoAlmacenamiento(TipoAlmacenamiento tipoAlmacenamiento) {
        this.tipoAlmacenamiento = tipoAlmacenamiento;
    }
*/
    public PasswordHasheable getPasswordHasheable() {
        return passwordHasheable;
    }

    public void setPasswordHasheable(PasswordHasheable passwordHasheable) {
        this.passwordHasheable = passwordHasheable;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}
