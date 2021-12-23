package es.josemasaborido.sprint1.ejercicio5.entities;
/**
 * Ejercicio  Sprint 1 de Fisrt Commit
 *
 * Enum Presencialidad
 *
 * @author josema
 * @version 1.0
 */
public enum Presencialidad {
    REOMOTO("Remoto"),
    HIBRIDO("Híbrido"),
    PRESENCIAL("Presencial");

    private String descripcion;

    private Presencialidad(String descripcion){
        this.descripcion = descripcion;
    }

    public String getPresencialidad(){
        return this.descripcion;
    }
}
