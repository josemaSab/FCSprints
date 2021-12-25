package es.josemasaborido.sprint1.ejercicio5_6_7y8.services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import es.josemasaborido.sprint1.ejercicio5_6_7y8.entities.Alumno;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Ejercicio 5 Sprint 1 de Fisrt Commit
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

        Chunk tituloPrincipal = new Chunk("CURRICULUM VITAE ", TITULO2);
        Chunk tituloSecundario = new Chunk(candidato.getNombreAlumno() + " " + candidato.getApellidos(), TITULO);


        try {
            documentoPDF.add(tituloPrincipal);
            documentoPDF.add(tituloSecundario);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        documentoPDF.close();


        return false;

    }

    //GETTER Y SETTER


    public String getRutaFichero() {
        return rutaFichero;
    }

    public void setRutaFichero(String rutaFichero) {
        this.rutaFichero = rutaFichero;
    }
}
