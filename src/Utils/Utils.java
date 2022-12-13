package Utils;

import java.util.Scanner;

public class Utils {

    //Método para hacer la animación de cerrado
    public static void cerrarPrograma() {
        for (int i = 0; i < 4; i++) {
            System.out.print(".");
            try {
                Thread.sleep(800);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }

        }
    }


    public static void pulsa(){
        Scanner s = new Scanner(System.in);

        System.out.println("Pulse para continuar ");
        s.next();
        System.out.println();
        System.out.println();
        System.out.println();
    }


}
