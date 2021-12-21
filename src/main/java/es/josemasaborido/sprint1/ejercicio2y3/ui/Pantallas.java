package es.josemasaborido.sprint1.ejercicio2y3.ui;
/**
 * Ejercicio  Sprint 1 de Fisrt Commit
 * <p>
 * Clase que las pantallas del programa
 *
 * @author josema
 * @version 1.0
 */
public class Pantallas {

    //METODOS
    public static void muestraMenu(){
        StringBuilder sb = new StringBuilder();
        sb.append("  ___ ___   _______   ______    ___ ___ \n");
        sb.append(" |   Y   | |   _   | |   _  \\  |   Y   |\n");
        sb.append(" |.      | |.  1___| |.  |   | |.  |   |\n");
        sb.append(" |. \\_/  | |.  __)_  |.  |   | |.  |   |\n");
        sb.append(" |:  |   | |:  1   | |:  |   | |:  1   |\n");
        sb.append(" |::.|:. | |::.. . | |::.|   | |::.. . |\n");
        sb.append(" `--- ---' `-------' `--- ---' `-------'\n");
        sb.append("\n");
        sb.append("------------------------------------------------------------------------------\n\n");
        System.out.println(sb.toString());
    }

    /**
     * Metodo que muestra por consola el titulo de la pantalla de registro
     */
    public static void muestraRegistro(){
        StringBuilder sb = new StringBuilder();
        sb.append("  _______   _______   _______   ___   _______   _______   _______   _______ \n");
        sb.append(" |   _   \\ |   _   | |   _   | |   | |   _   | |       | |   _   \\ |   _   |\n");
        sb.append(" |.  l   / |.  1___| |.  |___| |.  | |   1___| |.|   | | |.  l   / |.  |   |\n");
        sb.append(" |.  _   1 |.  __)_  |.  |   | |.  | |____   | `-|.  |-' |.  _   1 |.  |   |\n");
        sb.append(" |:  |   | |:  1   | |:  1   | |:  | |:  1   |   |:  |   |:  |   | |:  1   |\n");
        sb.append(" |::.|:. | |::.. . | |::.. . | |::.| |::.. . |   |::.|   |::.|:. | |::.. . |\n");
        sb.append(" `--- ---' `-------' `-------' `---' `-------'   `---'   `--- ---' `-------'\n");
        sb.append("\n");
        sb.append("------------------------------------------------------------------------------\n\n");
        System.out.println(sb.toString());
    }
    /**
     * Metodo que muestra por consola el titulo de la pantalla de login
     */
    public static void muestraLogin(){
        StringBuilder sb = new StringBuilder();
        sb.append("  ___       _______   _______   ___   ______  \n");
        sb.append(" |   |     |   _   | |   _   | |   | |   _  \\ \n");
        sb.append(" |.  |     |.  |   | |.  |___| |.  | |.  |   |\n");
        sb.append(" |.  |___  |.  |   | |.  |   | |.  | |.  |   |\n");
        sb.append(" |:  1   | |:  1   | |:  1   | |:  | |:  |   |\n");
        sb.append(" |::.. . | |::.. . | |::.. . | |::.| |::.|   |\n");
        sb.append(" `-------' `-------' `-------' `---' `--- ---'\n");
        sb.append("\n");
        sb.append("------------------------------------------------------------------------------\n\n");
        System.out.println(sb.toString());
    }

    public static void muestraOpciones(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n");
        sb.append("------------------------------------------------------------------------------\n\n");
        sb.append("OPCIONES\n");
        sb.append("--------\n\n");
        sb.append("1. Registrar usuario\n");
        sb.append("2. Log in\n");
        sb.append("0. Salir\n");
        System.out.println(sb.toString());
    }


}
