package es.josemasaborido.sprint1.ejercicio5_6_7y8.services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import es.josemasaborido.sprint1.ejercicio5_6_7y8.entities.Alumno;
import es.josemasaborido.sprint1.ejercicio5_6_7y8.entities.Certificacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Ejercicio 6 Sprint 1 de Fisrt Commit
 * ## Ejercicio 6. Genera un PDF del CV del Candidato.
 *
 * - Dados los datos del candidato y sus etiquetas, genera un PDF a modo de CV.
 * - Ampliación: puedes añadir una imagen de ejemplo.
 *
 * Servicio que se encarga de generar pdf del candidato
 *
 * @author josema
 * @version 1.0
 */
public class GeneradorPDFService {

    //ATRIBUTOS

    private String rutaFichero;

    /* Colores */

    private static final BaseColor VERDEOP = new BaseColor(50, 213, 164);
    private static final BaseColor NEGROOP = new BaseColor(18, 22, 37);
    private static final BaseColor BLANCOOP = new BaseColor(248, 248, 249);
    private static final BaseColor GRISOP = new BaseColor(165, 168, 179);

    /* Fuentes */
    private static final Font TITULO = FontFactory.getFont(FontFactory.COURIER, 26, Font.BOLD, VERDEOP);
    private static final Font TITULO2 = FontFactory.getFont(FontFactory.COURIER, 26, Font.BOLD, NEGROOP);
    private static final Font SUBTITULO = FontFactory.getFont(FontFactory.COURIER, 20, Font.UNDERLINE, NEGROOP);
    private static final Font ATRIBUTO = FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, NEGROOP);
    private static final Font VALORATRIBUTO = FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, GRISOP);

    //Salto de LInea
    private static final Chunk SALTOLINEA= Chunk.NEWLINE;

    //CONSTRUCTORES

    /**
     * Constructor con parametros
     * @param rutaFichero ruta del fichero pdf
     */
    public GeneradorPDFService(String rutaFichero) {
        this.rutaFichero = rutaFichero;
    }
    //METODOS

    public boolean crearPDFCandidato(File ficheroPDF, Alumno candidato) {
        Document documentoPDF = new Document();
        try {
            PdfWriter.getInstance(documentoPDF, new FileOutputStream(ficheroPDF));

        } catch (DocumentException e) {
            System.out.println("Se ha producido un error al generar un documento): " + e.getMessage());;
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el fichero para general rl PDF: " + e.getMessage());
        }
        documentoPDF.open();

        //Añadimos los medatados al PDf
        documentoPDF.addTitle("Curriculum de candidato: " + candidato.getNombreAlumno() +" " + candidato.getApellidos());
        documentoPDF.addAuthor("Josema Saborido");

        //TITULO
        //Creo un parrafo
        Paragraph parrafoTitulo = new Paragraph();
        //Metemos los elementos del titulo
        Chunk tituloPrincipal = new Chunk("CURRICULUM VITAE ", TITULO2);
        Chunk tituloSecundario = new Chunk(candidato.getNombreAlumno() + " " + candidato.getApellidos(), TITULO);
        //Los agregamos al parrafo
        parrafoTitulo.add(tituloPrincipal);
        parrafoTitulo.add(tituloSecundario);
        Image imagen = null;
        //IMAGEN
        try {
            imagen = Image.getInstance(candidato.getFoto());
            imagen.scaleAbsolute(100, 150);
            imagen.setAbsolutePosition(400f,520f);

        } catch (BadElementException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //DATOS PERSONALES
        Paragraph datosPersonales = new Paragraph();
        Chunk titDatosPersonales = new Chunk("DATOS PERSONALES", SUBTITULO);
        Chunk nombre = new Chunk("Nombre: ", ATRIBUTO);
        Chunk valorNombre = new Chunk(candidato.getNombreAlumno(), VALORATRIBUTO);
        Chunk apellidos = new Chunk("Apellidos: ", ATRIBUTO);
        Chunk valorApellidos = new Chunk(candidato.getApellidos(), VALORATRIBUTO);
        Chunk email = new Chunk("Email: ", ATRIBUTO);
        Chunk valorEmail = new Chunk(candidato.getEmailAlumno(), VALORATRIBUTO);
        Chunk telefono = new Chunk("Teléfono: ", ATRIBUTO);
        Chunk valorTelefono = new Chunk(candidato.getTelefono(), VALORATRIBUTO);
        Chunk presencialidad = new Chunk("Presencialidad: ", ATRIBUTO);
        Chunk valorPresencialidad = new Chunk(candidato.getPresencialidad().getPresencialidad(), VALORATRIBUTO);
        Chunk traslado = new Chunk("Traslado: ", ATRIBUTO);
        Chunk valorTraslado = new Chunk(siNo(candidato), VALORATRIBUTO);


        datosPersonales.add(titDatosPersonales);
        datosPersonales.add(SALTOLINEA);
        datosPersonales.add(SALTOLINEA);
        datosPersonales.add(nombre);
        datosPersonales.add(valorNombre);
        datosPersonales.add(SALTOLINEA);
        datosPersonales.add(SALTOLINEA);
        datosPersonales.add(apellidos);
        datosPersonales.add(valorApellidos);
        datosPersonales.add(SALTOLINEA);
        datosPersonales.add(SALTOLINEA);
        datosPersonales.add(email);
        datosPersonales.add(valorEmail);
        datosPersonales.add(SALTOLINEA);
        datosPersonales.add(SALTOLINEA);
        datosPersonales.add(telefono);
        datosPersonales.add(valorTelefono);
        datosPersonales.add(SALTOLINEA);
        datosPersonales.add(SALTOLINEA);
        datosPersonales.add(presencialidad);
        datosPersonales.add(valorPresencialidad);
        datosPersonales.add(SALTOLINEA);
        datosPersonales.add(SALTOLINEA);
        datosPersonales.add(traslado);
        datosPersonales.add(valorTraslado);

        //CERTIFICACIONES

        Paragraph certificaciones = new Paragraph();
        Chunk titCertificaciones = new Chunk("CERTIFICACIONES", SUBTITULO);
        certificaciones.add(titCertificaciones);
        certificaciones.add(SALTOLINEA);
        certificaciones.add(SALTOLINEA);
        for(Certificacion c: candidato.getCertificaciones()){
            Chunk certificaccion = new Chunk(c.getCertificacion());
            certificaciones.add(certificaccion);
            certificaciones.add(SALTOLINEA);
            certificaciones.add(SALTOLINEA);
        }

        //MAQUETACION DEL DOCUMENTO FINAL
        try {
            documentoPDF.add(parrafoTitulo);
            documentoPDF.add(SALTOLINEA);
            documentoPDF.add(imagen);
            documentoPDF.add(SALTOLINEA);
            documentoPDF.add(SALTOLINEA);
            documentoPDF.add(SALTOLINEA);
            documentoPDF.add(SALTOLINEA);
            documentoPDF.add(datosPersonales);
            documentoPDF.add(SALTOLINEA);
            documentoPDF.add(SALTOLINEA);
            documentoPDF.add(SALTOLINEA);
            documentoPDF.add(SALTOLINEA);
            documentoPDF.add(certificaciones);

        } catch (DocumentException e) {
            e.printStackTrace();
        }


        documentoPDF.close();


        return false;

    }

    public String siNo(Alumno candidato){
        if(candidato.getTraslado()){
            return "SI";
        }else{
            return "NO";
        }

    }

    //GETTER Y SETTER


    public String getRutaFichero() {
        return rutaFichero;
    }

    public void setRutaFichero(String rutaFichero) {
        this.rutaFichero = rutaFichero;
    }
}
