package Utils;

import Models.Administrador;
import Models.Propietario;
import Models.Usuario;

public class Menus {
    //Método para imprimir el menú de logging
    public static void pintaMenuLoging(){
        System.out.println(" _______  _______ .______      .__   __.      ___      .__   __. .______   .__   __. .______   \n" +
                "|   ____||   ____||   _  \\     |  \\ |  |     /   \\     |  \\ |  | |   _  \\  |  \\ |  | |   _  \\  \n" +
                "|  |__   |  |__   |  |_)  |    |   \\|  |    /  ^  \\    |   \\|  | |  |_)  | |   \\|  | |  |_)  | \n" +
                "|   __|  |   __|  |      /     |  . `  |   /  /_\\  \\   |  . `  | |   _  <  |  . `  | |   _  <  \n" +
                "|  |     |  |____ |  |\\  \\----.|  |\\   |  /  _____  \\  |  |\\   | |  |_)  | |  |\\   | |  |_)  | \n" +
                "|__|     |_______|| _| `._____||__| \\__| /__/     \\__\\ |__| \\__| |______/  |__| \\__| |______/  ");

        System.out.println("""
                
                ======================
                1. Registrar usuario.
                2. Logging
                3. Salir""");
        System.out.print("Introduzca una opción: ");

    }

    //Método para imprimir menú de administrador
    public static void pintaMenuAdmin(Administrador a){
        System.out.println("==============================");
        System.out.println("Bienvenido "+ a.getNombre()+", perfil administración.");
        System.out.println("""
                =====Menú principal=====
                1. Ver todas las viviendas en alquiler.
                2. Ver todos los usuarios del sistema.
                3. Ver todas las reservas de viviendas.
                4. Ver mi perfil.
                5. Modificar el perfil.
                6. Cerrar sesión.
                """);

    }

    //Método para imprimir menú de propietario
    public static void pintaMenuPropietario(Propietario p){
        System.out.println("==============================");
        System.out.println("Bienvenido "+ p.getNombre()+", gestione sus viviendas en alquiler.");
        System.out.println("""
                =====Menú principal=====
                1. Ver mis viviendas en alquiler.
                2. Editar mis viviendas.
                3. Ver las reservas en mis viviendas.
                4. Establecer un periodo de no disponible para una vivienda.
                5. Ver mi perfil
                6. Modificar mi perfil
                7. Cerrar sesión.
                """);

    }

    //Método para imprimir menú de inquilino
    public static void pintaMenuInquilino(Usuario u){
        System.out.println("==============================");
        System.out.println("Bienvenido "+ u.getNombre()+", busque un alojamiento para sus próximas vacaciones.");
        System.out.println("""
                =====Menú principal=====
                1. Busqueda de alojamientos
                2. Ver mis reservas
                3. Modificar una reserva
                4. Ver mi perfil
                5. Modificar mi perfil
                6. Cerrar sesión.
                """);

    }

    public static void pintaMenuEditarViviendas() {
        System.out.println("""
                =====Menú de modificación de viviendas=====
                1. Añadir una vivienda.
                2. Modificar su vivienda.
                3. Salir
                """);

    }
}
