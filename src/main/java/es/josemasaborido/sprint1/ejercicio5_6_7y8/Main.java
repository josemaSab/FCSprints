package es.josemasaborido.sprint1.ejercicio5_6_7y8;

import es.josemasaborido.sprint1.ejercicio5_6_7y8.entities.*;
import es.josemasaborido.sprint1.ejercicio5_6_7y8.entities.enums.Presencialidad;
import es.josemasaborido.sprint1.ejercicio5_6_7y8.security.HashArgon2;
import es.josemasaborido.sprint1.ejercicio5_6_7y8.services.GeneradorPDFService;
import es.josemasaborido.sprint1.ejercicio5_6_7y8.services.UsuarioService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 5 Sprint 1 de Fisrt Commit
 * Crea todas las clases del Modelo de Datos (es necesaria validación previa del modelo) con sus atributos.
 *
 * - Además, añade a la clase Usuario el método registrar y login.
 * - Relaciona las clases entre sí.
 *
 * Entrada al programa
 *
 * @author josema
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        //CREACION DE CIUDADES

        Ciudad gijon = new Ciudad("Gijón");
        Ciudad cadiz = new Ciudad("Cádiz");
        Ciudad malaga = new Ciudad("Malaga");
        Ciudad lisboa = new Ciudad("Lisboa");
        Ciudad portimao = new Ciudad("Portimao");
        Ciudad paris = new Ciudad("Paris");
        //Creamos un array list para meter las ciudades de españa
        List<Ciudad> ciudadesSpain = new ArrayList<>();
        //Creamos un array list para meter las ciudades de españa
        List<Ciudad> ciudadesPortugal = new ArrayList<>();
        //Creamos un array list para meter las ciudades de españa
        List<Ciudad> ciudadesFrancia = new ArrayList<>();
        //ciudades de españa
        ciudadesSpain.add(gijon);
        ciudadesSpain.add(cadiz);
        ciudadesSpain.add(malaga);
        //ciudades de francia
        ciudadesFrancia.add(paris);
        //ciudades de portugal
        ciudadesPortugal.add(lisboa);
        ciudadesPortugal.add(portimao);

        //CREACION DE PAISES

        Pais spain = new Pais("España");
        Pais francia = new Pais("Francia");
        Pais portugal = new Pais("Portugal");
        //añadimos las ciudades de los paises
        spain.setCiudades(ciudadesSpain);
        francia.setCiudades(ciudadesFrancia);
        portugal.setCiudades(ciudadesPortugal);

        //CREACION DE CERTIFICACIONES

        List<Certificacion> listaCertificaciones = new ArrayList<>();

        Certificacion htmlCss = new Certificacion("HTML+CSS");
        Certificacion javascript = new Certificacion("JAVASCRIPT");
        Certificacion java = new Certificacion("JAVA");
        Certificacion react = new Certificacion("REACT");
        Certificacion spring = new Certificacion("SPRING");
        Certificacion  hibernate = new Certificacion("HIBERNATE");

        //CREACION DE ALUMNOS

        Alumno alumno1 = new Alumno("Josema", "Saborido", "j@j.com", "678558855",
                Presencialidad.REOMOTO, false, "foto1", "curriculumAlumno1");
        alumno1.getCertificaciones().add(htmlCss);
        alumno1.getCertificaciones().add(javascript);
        alumno1.getCertificaciones().add(java);
        alumno1.getCertificaciones().add(spring);
        alumno1.setCiudad(cadiz);

        Alumno alumno2 = new Alumno("Pepe", "Martinez", "pepe@j.com", "688557788",
                Presencialidad.HIBRIDO, true, "foto2", "curriculumAlumno2");
        alumno2.getCertificaciones().add(htmlCss);
        alumno2.getCertificaciones().add(javascript);
        alumno2.setCiudad(portimao);

        Alumno alumno3 = new Alumno("Ana", "Oroñez", "hola@ana.com", "677552444",
                Presencialidad.PRESENCIAL, false, "foto3", "curriculumAlumno3");
        alumno1.getCertificaciones().add(htmlCss);
        alumno1.getCertificaciones().add(javascript);
        alumno1.getCertificaciones().add(react);
        alumno1.setCiudad(gijon);

        Alumno alumno4 = new Alumno("Antonio", "Diaz", "antd@gmail.com.com", "607666555",
                Presencialidad.REOMOTO, false, "foto4", "curriculumAlumno4");
        alumno1.getCertificaciones().add(htmlCss);
        alumno1.getCertificaciones().add(javascript);
        alumno1.getCertificaciones().add(java);
        alumno1.getCertificaciones().add(spring);
        alumno1.setCiudad(malaga);

        Alumno alumno5 = new Alumno("Ludovic", "Pante", "lpante@hotmail.com", "688777454",
                Presencialidad.PRESENCIAL, true, "foto5", "curriculumAlumno5");
        alumno1.getCertificaciones().add(java);
        alumno1.getCertificaciones().add(spring);
        alumno1.setCiudad(cadiz);

        Alumno alumno6 = new Alumno("Joao", "Zeno", "joao@gmail.com.com", "674555222",
                Presencialidad.REOMOTO, false, "foto6", "curriculumAlumno6");
        alumno1.getCertificaciones().add(htmlCss);
        alumno1.getCertificaciones().add(javascript);
        alumno1.getCertificaciones().add(java);
        alumno1.getCertificaciones().add(spring);
        alumno1.setCiudad(cadiz);

        //CREACION DE USUARIOS

        Usuario admin1 = new Usuario("admin1", "123456", "admin1@openbootcamp.com");
        //Asignamos alumnos
        admin1.getAlumnos().add(alumno1);
        admin1.getAlumnos().add(alumno2);
        admin1.getAlumnos().add(alumno3);
        admin1.getAlumnos().add(alumno6);

        Usuario admin2 = new Usuario("admin2", "1234", "admin2@openbootcamp.com");
        //Asignamos alumnos
        admin2.getAlumnos().add(alumno4);
        admin2.getAlumnos().add(alumno5);

        //CREACION DE BASE DE DATOS

        List<Usuario> listaUsuarios = new ArrayList<>();

        //REGISTRAR USUARIOS

        UsuarioService usuarioService = new UsuarioService(listaUsuarios, new HashArgon2());

        try {
            usuarioService.registrar(admin1);
            usuarioService.registrar(admin2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(Usuario u:listaUsuarios){
            System.out.println(u.getNombreUsuario());
            System.out.println(u.getPassword());
        }
        //LOGIN USUARIOS

        usuarioService.login(admin1);

        //GENERAR PDF
        String rutaPDF1 = "/media/josema/DATOS/Usuarios/Josema_000/IdeaProjects/FCSprints/src/main/java/es/josemasaborido/sprint1/ejercicio5_6_7y8/curriculum/"
                + alumno1.getNombreAlumno() + ".pdf";
        System.out.println(rutaPDF1);
        GeneradorPDFService generadorPDFService = new GeneradorPDFService(rutaPDF1);
        generadorPDFService.crearPDFCandidato(new File(rutaPDF1),alumno1);

    }



}