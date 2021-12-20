package es.josemasaborido.sprint1.ejercicio2.menu;

import es.josemasaborido.sprint1.ejercicio2.models.Usuario;
import es.josemasaborido.sprint1.ejercicio2.service.RegistroService;
import es.josemasaborido.sprint1.ejercicio2.ui.Pantallas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.sleep;

/**
 * Ejercicio 2 Sprint 1 de Fisrt Commit
 * <p>
 * Clase que gestiona el menu de la aplicacion
 *
 * @author josema
 * @version 1.0
 */
public class Menu {

    //ATRIBUTOS
    private int opcionElegida;
    private RegistroService registroService;

    //CONSTRUCTORES

    public Menu(RegistroService registroService) {
        this.registroService = registroService;
        opcionElegida = -1;
        Pantallas.muestraMenu();
        Pantallas.muestraOpciones();
        this.opciones();
    }
    //METODOS

    /**
     * Metodo que va mostrando por pantalla el menu de opciones hasta que la opcion elegida
     * es 0 para salir de la aplicacion
     */
    public void opciones() {
        while(this.opcionElegida!=0){
            this.eligeOpcion();
        }
    }

    /**
     * Metodo en el que elegimos una opción del menu y segun lo elegido nos envia a una pantalla u a otra
     */
    public void eligeOpcion() {
        Scanner sc = new Scanner(System.in);
        //Se repite la hasta que se elija una opcion correcta
        do{
            //Paramos 50 milis para que si hay un error se muestre antes de volver  a solicitar
            //que elijamos una opcion
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ELIGE UNA OPCION: ");
            try {
                this.opcionElegida = Integer.parseInt(sc.nextLine());
                if(this.opcionElegida > 2){
                    System.err.println("La opción elegida no es correcta.");
                }
                switch(this.opcionElegida){
                    //OPCION SALIR
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        Pantallas.muestraRegistro();
                        this.opcionRegistro();
                        break;
                    case 2:
                        Pantallas.muestraLogin();
                        Pantallas.muestraMenu();
                        break;
                }
            }catch(NumberFormatException e){
                System.err.println("El valor introducido no es correcto.");
            }
        }while(this.opcionElegida>=0 && this.opcionElegida<=2);

    }

    public void opcionRegistro(){
        String email;
        String password;
        boolean esRegistrado;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el email del usuario:");
        email = sc.nextLine();
        System.out.println("Introduce el password del usuario:");
        sc = new Scanner(System.in);
        password = sc.nextLine();
        esRegistrado = this.registroService.register(email, password);
        if(!esRegistrado){
            Pantallas.muestraOpciones();
            this.eligeOpcion();
        }

    }

    //GETTER Y SETTER


    public int getOpcionElegida() {
        return opcionElegida;
    }

    public void setOpcionElegida(int opcionElegida) {
        this.opcionElegida = opcionElegida;
    }

    public RegistroService getRegistroService() {
        return registroService;
    }

    public void setRegistroService(RegistroService registroService) {
        this.registroService = registroService;
    }

}
