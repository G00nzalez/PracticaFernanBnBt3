import Models.*;
import Utils.Menus;
import Utils.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //Definicion de clases
        Usuario inquilino1 = null, inquilino2 = null;
        Propietario arrendador1 = null, arrendador2 = null;
        Administrador admin = new Administrador("admin", "admin");
        Reserva reserva1 = null, reserva2 = null, reserva3 = null, reserva4 = null;


        //PRUEBAS

        /*
        inquilino1 = new Usuario("jose", "jose");
        inquilino2 = new Usuario("ana", "ana");
        arrendador1 = new Propietario("pepe", "pepe");
        arrendador2 = new Propietario("toni", "toni");
        Vivienda v1 = new Vivienda("descripcion", "direccion", 10, 20.5);
        Vivienda v2 = new Vivienda("casa", "ciudad", 5, 210);
        arrendador1.registrarVivienda(v1);
        arrendador2.registrarVivienda(v2);
        */

        int opMenuLog, opRegistro;


        do {
            Usuario inquilinoLog = null;
            Propietario arrendadorLog = null;
            Administrador adminLog = null;

            Menus.pintaMenuLoging();
            opMenuLog = Integer.parseInt(s.nextLine());

            switch (opMenuLog) {
                case 1 -> { //Registrar un usuario nuevo
                    System.out.println("===REGISTRO===");
                    //Preguntamos el tipo de usuario que desea crear
                    do {
                        System.out.println("""
                                Introduzca el tipo de su cuenta:
                                1. Arrendador.
                                2. Inquilino.
                                3. Cancelar
                                """);
                        opRegistro = Integer.parseInt(s.nextLine());
                    } while (opRegistro != 1 && opRegistro != 2 && opRegistro != 3);

                    //Formulario de usuario
                    if (opRegistro != 3) {
                        System.out.print("Introduzca un nombre: ");
                        String nombreRegistro = s.nextLine();
                        System.out.print("Introduzca una contrase??a: ");
                        String passRegister = s.nextLine();
                        System.out.println("Su nombre es: " + nombreRegistro + " , y su contrase??a es: " + passRegister);
                        System.out.print("??Son correctos estos datos? Inserte S para aceptar, cualquier otra opci??n para denegar: ");
                        //Registro
                        if (s.nextLine().equalsIgnoreCase("S")) {
                            //Tipo de perfil de usuario
                            if (opRegistro == 1) { //Arrendador
                                if (arrendador1 == null)
                                    arrendador1 = new Propietario(nombreRegistro, passRegister);
                                else if (arrendador2 == null)
                                    arrendador2 = new Propietario(nombreRegistro, passRegister);

                                else System.out.println("Su registro no se ha podido completar por falta de espacio.");
                            } else { //Inquilino
                                if (inquilino1 == null) inquilino1 = new Usuario(nombreRegistro, passRegister);
                                else if (inquilino2 == null)
                                    inquilino2 = new Usuario(nombreRegistro, passRegister);
                                else System.out.println("Su registro no se ha podido completar por falta de espacio.");
                            }
                        } else { //Cancelar registro
                            System.out.println("Su registro ha sido cancelado");
                        }

                    } else System.out.println("Su registro ha sido cancelado");

                    System.out.println();
                    System.out.println();

                }//Cierra registro

                case 2 -> { //Logging de usuario
                    boolean registro = false, cancelar = false;

                    do {
                        System.out.println("===LOGGING===");
                        System.out.println("Si desea cancelar, no escriba nada en ning??n cuestionario");
                        System.out.print("Introduce tu nombre: ");
                        String nombreLog = s.nextLine();
                        System.out.print("Introduce tu contrase??a: ");
                        String passLog = s.nextLine();

                        //Comprobaciones de si el usuario es el administrador
                        if (nombreLog.equals(admin.getNombre()) && passLog.equals(admin.getPass())) {
                            adminLog = admin;
                            registro = true;
                            System.out.println("Log como admin");
                        }
                        //Comprobaci??n de si es propietario
                        else if (arrendador1 != null && nombreLog.equals(arrendador1.getNombre()) && passLog.equals(arrendador1.getPass())) {
                            arrendadorLog = arrendador1;
                            registro = true;
                            System.out.println("Log como arrendador");
                        } else if (arrendador2 != null && nombreLog.equals(arrendador2.getNombre()) && passLog.equals(arrendador2.getPass())) {
                            arrendadorLog = arrendador2;
                            registro = true;
                            System.out.println("Log como arrendador");
                        }
                        //Comprobaci??n de si es inquilino
                        else if (inquilino1 != null && nombreLog.equals(inquilino1.getNombre()) && passLog.equals(inquilino1.getPass())) {
                            inquilinoLog = inquilino1;
                            registro = true;
                            System.out.println("Log como inquilino");
                        } else if (inquilino2 != null && nombreLog.equals(inquilino2.getNombre()) && passLog.equals(inquilino2.getPass())) {
                            inquilinoLog = inquilino2;
                            registro = true;
                            System.out.println("Log como inquilino");
                        }
                        //Cancelar el registro
                        else if (nombreLog.equals("") && passLog.equals("")) {
                            System.out.println("Loggeo cancelado");
                            cancelar = true;
                        }

                        //Credenciales incorrectas
                        else System.out.println("Credenciales incorrectas");

                    } while (!registro && !cancelar);

                    //Cuando el usuario loggeado es un administrador
                    if (adminLog != null) {
                        int opMenuAdmin;
                        do {
                            //Pintamos el menu de administrador
                            System.out.println();
                            System.out.println();
                            Menus.pintaMenuAdmin(adminLog);
                            opMenuAdmin = Integer.parseInt(s.nextLine());

                            switch (opMenuAdmin) {
                                case 1 -> { //Ver todas las viviendas
                                    boolean existeVivienda1 = true, existeVivienda2 = true;
                                    System.out.println();
                                    System.out.println();
                                    System.out.println("=====VIVIENDAS=====");
                                    if (arrendador1 != null) {
                                        if (arrendador1.getVivienda() != null)
                                            System.out.println(arrendador1.getVivienda());
                                        else existeVivienda1 = false;
                                    }
                                    if (arrendador2 != null) {
                                        if (arrendador2.getVivienda() != null)
                                            System.out.println(arrendador2.getVivienda());
                                        else existeVivienda2 = false;
                                    }
                                    //Mensaje si a??n no hay viviendas registradas
                                    if (!existeVivienda1 && !existeVivienda2)
                                        System.out.println("A??n no se ha registrado ninguna vivienda.");
                                    System.out.println();
                                    Utils.pulsa();

                                }
                                case 2 -> { //Ver todas los usuarios
                                    //Pintamos usuarios inquilinos
                                    System.out.println();
                                    System.out.println();
                                    System.out.println("=====USUARIOS INQUILINOS=====");
                                    //Mensaje si a??n no hay inquilinos registrados
                                    if (inquilino1 == null && inquilino2 == null)
                                        System.out.println("No hay inquilinos registrados a??n");
                                    if (inquilino1 != null) System.out.println(inquilino1);
                                    if (inquilino2 != null) System.out.println(inquilino2);
                                    System.out.println("============================");
                                    System.out.println();

                                    //Pintamos usuarios arrendatarios
                                    System.out.println("=====USUARIOS ARRENDADORES=====");
                                    //Mensaje si a??n no hay arrendadores registrados
                                    if (arrendador1 == null && arrendador2 == null)
                                        System.out.println("No hay arrendadores registrados a??n");
                                    if (arrendador1 != null) System.out.println(arrendador1);
                                    if (arrendador2 != null) System.out.println(arrendador2);
                                    System.out.println("============================");

                                    Utils.pulsa();
                                }

                                case 3 -> { //Ver todas las reservas
                                    System.out.println("=====RESERVAS=====");
                                    if (inquilino1.getReserva1() != null) {
                                        System.out.println(inquilino1.getReserva1());
                                        System.out.println("==========");
                                    }
                                    System.out.println();
                                    if (inquilino1.getReserva2() != null) {
                                        System.out.println(inquilino1.getReserva2());
                                        System.out.println("==========");
                                    }
                                    System.out.println();
                                    if (inquilino2.getReserva1() != null) {
                                        System.out.println(inquilino2.getReserva1());
                                        System.out.println("==========");
                                        System.out.println();
                                    }
                                    if (inquilino2.getReserva2() != null) {
                                        System.out.println(inquilino2.getReserva2());
                                        System.out.println("==========");
                                    }
                                    //Mensaje si no hay ninguna reserva realizada a??n
                                    if (inquilino1.getReserva1() != null && inquilino1.getReserva2() != null && inquilino2.getReserva1() != null && inquilino2.getReserva2() != null)
                                        System.out.println("A??n no se ha realizado ninguna reserva.");
                                    System.out.println();
                                    Utils.pulsa();

                                }

                                case 4 -> { //Ver perfil de administrador
                                    System.out.println(admin);
                                    System.out.println();
                                    Utils.pulsa();
                                }

                                case 5 -> { //Modificar perfil de administrador
                                    System.out.println();
                                    System.out.println();
                                    System.out.println("===Modificar perfil de administrador===");
                                    System.out.print("Introduce el nuevo nombre: ");
                                    String nombreModificado = s.nextLine();
                                    System.out.print("Introduce la nueva contrase??a: ");
                                    String passModificada = s.nextLine();
                                    System.out.println("??Est?? de acuerdo con su modificaci??n?: s para aceptar, cualquiera para cancelar: ");
                                    String aceptarModificado = s.nextLine();
                                    if (aceptarModificado.equalsIgnoreCase("s"))
                                        admin.modificaAdministrador(nombreModificado, passModificada);
                                    else System.out.println("Se ha cancelado su modificaci??n");
                                    Utils.pulsa();
                                    System.out.println();
                                }

                                case 6 -> { //Cerrar sesi??n
                                    System.out.print("Cerrando sesi??n ");
                                    Utils.cerrarPrograma();

                                }

                                default -> {
                                    System.out.println("Opci??n no v??lida, inserte otra opci??n");
                                    System.out.println();
                                    System.out.println();
                                }

                            }

                        } while (opMenuAdmin != 6);

                    } //Cierra el if menu administrador

                    //Log de un usuario arrendador
                    if (arrendadorLog != null) {
                        int menuArrendador;
                        do {
                            Menus.pintaMenuPropietario(arrendadorLog);
                            menuArrendador = Integer.parseInt(s.nextLine());

                            switch (menuArrendador) {
                                case 1 -> { //Ver sus viviendas
                                    if (arrendadorLog.getVivienda() == null)
                                        System.out.println("No ha registrado ninguna vivienda");
                                    else System.out.println(arrendadorLog.getVivienda());
                                    Utils.pulsa();
                                    System.out.println();
                                }

                                case 2 -> { //Editar sus viviendas
                                    Menus.pintaMenuEditarViviendas();
                                    int opEditarViviendas = Integer.parseInt(s.nextLine());

                                    switch (opEditarViviendas) {

                                        case 1 -> { //A??adir vivienda nueva

                                            int numHuespedes;
                                            double precioNoche;

                                            //Si el usuario ya tiene su vivienda registrada.
                                            if (arrendadorLog.getVivienda() != null)
                                                System.out.println("Usted cumple con el m??ximo de viviendas registradas.");
                                                //Si el usuario aun no ha registrado su vivienda.
                                            else {
                                                System.out.print("Inserte una descripci??n: ");
                                                String descripcion = s.nextLine();
                                                System.out.print("Inserte una direcci??n: ");
                                                String direccion = s.nextLine();
                                                do {
                                                    System.out.print("Introduzca el n??mero de huespedes como m??ximo: ");
                                                    numHuespedes = Integer.parseInt(s.nextLine());
                                                    if (numHuespedes < 0) {
                                                        System.out.println("Debe introducir un n??mero mayor de 0 para los huespedes");
                                                        System.out.println();
                                                        System.out.println();
                                                    }
                                                } while (numHuespedes < 0);

                                                do {
                                                    System.out.print("Introduzca un precio por noche: ");
                                                    precioNoche = Double.parseDouble(s.nextLine());
                                                    if (precioNoche < 0) {
                                                        System.out.println("Debe ser mayor que 0 el precio por noche");
                                                        System.out.println();
                                                        System.out.println();
                                                    }
                                                } while (precioNoche < 0);

                                                System.out.println("==========");
                                                System.out.println("Sus datos son: ");
                                                System.out.println("Descripcion : " + descripcion);
                                                System.out.println("Direccion : " + direccion);
                                                System.out.println("N??mero maximo de huespedes : " + numHuespedes);
                                                System.out.println("Precio por noche : " + precioNoche);
                                                System.out.println("==========");

                                                System.out.println("??Son correctos? Pulse s para aceptar, cualquier otra tecla para cancelar");
                                                //Si no quiere guardar esa informaci??n
                                                if (!s.nextLine().equalsIgnoreCase("s")) {
                                                    System.out.println("Su operaci??n se ha cancelado.");
                                                    Utils.pulsa();
                                                } //Si sus datos son correctos, registramos la casa
                                                else {
                                                    arrendadorLog.registrarVivienda(new Vivienda(descripcion, direccion, numHuespedes, precioNoche));
                                                    System.out.println("Su vivienda ha sido registrada.");
                                                    Utils.pulsa();

                                                }
                                            }

                                        }

                                        case 2 -> { //Modificar vivienda nueva
                                            int numHuespedes;
                                            double precioNoche;

                                            System.out.println("=====MODIFICAR VIVIENDA=====");
                                            System.out.print("Inserte una descripci??n: ");
                                            String descripcion = s.nextLine();
                                            System.out.print("Inserte una direcci??n: ");
                                            String direccion = s.nextLine();
                                            do {
                                                System.out.print("Introduzca el n??mero de huespedes como m??ximo: ");
                                                numHuespedes = Integer.parseInt(s.nextLine());
                                                if (numHuespedes < 0) {
                                                    System.out.println("Debe introducir un n??mero mayor de 0 para los huespedes");
                                                    System.out.println();
                                                    System.out.println();
                                                }
                                            } while (numHuespedes < 0);

                                            do {
                                                System.out.print("Introduzca un precio por noche: ");
                                                precioNoche = Double.parseDouble(s.nextLine());
                                                if (precioNoche < 0) {
                                                    System.out.println("Debe ser mayor que 0 el precio por noche");
                                                    System.out.println();
                                                    System.out.println();
                                                }
                                            } while (precioNoche < 0);

                                            System.out.println("==========");
                                            System.out.println("Sus datos son: ");
                                            System.out.println("Descripcion : " + descripcion);
                                            System.out.println("Direccion : " + direccion);
                                            System.out.println("N??mero maximo de huespedes : " + numHuespedes);
                                            System.out.println("Precio por noche : " + precioNoche);
                                            System.out.println("==========");

                                            System.out.println("??Son correctos? Pulse s para aceptar, cualquier otra tecla para cancelar");
                                            //Si no quiere guardar esa informaci??n
                                            if (!s.nextLine().equalsIgnoreCase("s")) {
                                                System.out.println("Su operaci??n se ha cancelado.");
                                                Utils.pulsa();
                                            } //Si sus datos son correctos, registramos la casa
                                            else {
                                                arrendadorLog.registrarVivienda(new Vivienda(descripcion, direccion, numHuespedes, precioNoche));
                                                System.out.println("Su vivienda ha sido modificada.");
                                                Utils.pulsa();

                                            }
                                        }


                                        case 3 -> { //Cancelar operaci??n
                                            System.out.print("Cancelando ");
                                            Utils.cerrarPrograma();
                                            System.out.println();
                                        }
                                    }

                                }

                                case 3 -> { //Ver reservas en sus viviendas
                                    //Comprobaci??n que existe una vivienda registrada
                                    if (arrendador1.getVivienda() == null)
                                        System.out.println("No ha registrado ninguna vivienda");
                                    else {
                                        //Si existe la vivienda, mostramos sus posibles reservas.
                                        if (arrendadorLog.getVivienda().getReserva1() != null)
                                            if (arrendadorLog.getVivienda().getReserva1().getInquilino() != null)
                                                System.out.println(arrendadorLog.getVivienda().getReserva1());
                                            else
                                                System.out.println(arrendadorLog.getVivienda().getReserva1().pintaViviendaSinInquilino());
                                        if (arrendadorLog.getVivienda().getReserva2() != null)
                                            if (arrendadorLog.getVivienda().getReserva2().getInquilino() != null)
                                                System.out.println(arrendadorLog.getVivienda().getReserva2());
                                            else
                                                System.out.println(arrendadorLog.getVivienda().getReserva2().pintaViviendaSinInquilino());
                                        //Si no se han realizado reservas a??n, mostramos un mensaje de informaci??n
                                        if (arrendadorLog.getVivienda().getReserva1() == null && arrendadorLog.getVivienda().getReserva2() == null)
                                            System.out.println("No se han realizado reservas a??n en su vivienda.");
                                    }
                                    Utils.pulsa();

                                }

                                case 4 -> {//Establecer periodo de no disponibilidad
                                    boolean confirmarFechaInicio = true;
                                    boolean confirmarFechaFin = true;
                                    boolean cancelacion = false;
                                    int dia, mes, year;
                                    LocalDate fechaInicio = null, fechaFin = null;
                                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                                    //Pedir fecha inicio
                                    System.out.println("=====Establecer periodo de no disponibilidad=====");
                                    System.out.println("Introduzca el dia fecha de inicio: ");
                                    dia = Integer.parseInt(s.nextLine());
                                    System.out.println("Introduzca el mes fecha de inicio: ");
                                    mes = Integer.parseInt(s.nextLine());
                                    System.out.println("Introduzca el a??o fecha de inicio: ");
                                    year = Integer.parseInt(s.nextLine());
                                    System.out.println("La fecha de inicio es: " + dia + "/" + mes + "/" + year);
                                    System.out.println("??Est?? usted de acuerdo con esta fecha? Pulse s para confirmar, otra tecla para denegar");

                                    //Si pulsa s creamos la fecha de inicio de reserva
                                    if (s.nextLine().equalsIgnoreCase("s")) {
                                        System.out.println("Fecha confirmada");
                                        fechaInicio = LocalDate.parse(year + "-" + mes + "-" + dia);

                                    } //Cancelamos la operaci??n
                                    else {
                                        System.out.println("Fecha cancelada");
                                        confirmarFechaInicio = false;
                                    }
                                    //Si la fecha de inicio es correcta preguntamos por la fecha de fin
                                    if (confirmarFechaInicio) {
                                        System.out.println("=====Establecer periodo de no disponibilidad=====");
                                        System.out.println("Introduzca el dia fecha de fin: ");
                                        dia = Integer.parseInt(s.nextLine());
                                        System.out.println("Introduzca el mes fecha de fin: ");
                                        mes = Integer.parseInt(s.nextLine());
                                        System.out.println("Introduzca el a??o fecha de fin: ");
                                        year = Integer.parseInt(s.nextLine());
                                        System.out.println("La fecha de inicio es: " + dia + "/" + mes + "/" + year);
                                        System.out.println("??Est?? usted de acuerdo con esta fecha? Pulse s para confirmar, otra tecla para denegar");
                                        //Si pulsa s creamos la fecha de fin
                                        if (s.nextLine().equalsIgnoreCase("s")) {
                                            System.out.println("Fecha confirmada");
                                            fechaFin = LocalDate.parse(year + "-" + mes + "-" + dia);

                                        } //Si no pulsa s cancelamos la operaci??n
                                        else {
                                            System.out.println("Fecha cancelada");
                                            confirmarFechaFin = false;
                                        }

                                    }
                                    //Si alguna de las dos fechas no es correcta cancelamos la operaci??n
                                    if (!confirmarFechaInicio || !confirmarFechaFin) {
                                        cancelacion = true;
                                        System.out.print("Su operaci??n se est?? cancelando");
                                        Utils.cerrarPrograma();
                                    }

                                    //Si no se ha cancelado la creacion de la fecha, preguntamos por la vivienda a reservar
                                    if (!cancelacion) {
                                        //Empezamos a buscar la vivienda por ID
                                        System.out.print("Introduce la ID de su vivienda: ");
                                        int idVivienda = Integer.parseInt(s.nextLine());
                                        Vivienda viviendaCopia = null;
                                        //Busqueda de la vivienda por id
                                        if (arrendador1 != null) {
                                            if (arrendador1.getVivienda() != null)
                                                viviendaCopia = arrendador1.getVivienda();

                                        } else if (arrendador2 != null) {
                                            if (arrendador2.getVivienda() != null)
                                                viviendaCopia = arrendador2.getVivienda();

                                        }  //Si no se encuentra la vivienda
                                        else System.out.println("Vivienda no encontrada");

                                        //Si la vivienda ha sido encontrado
                                        if (viviendaCopia.getReserva1() == null)
                                            viviendaCopia.setReserva1(Reserva.noDisponible(arrendadorLog, fechaInicio, fechaFin));
                                        else if (viviendaCopia.getReserva2() == null)
                                            viviendaCopia.setReserva2(Reserva.noDisponible(arrendadorLog, fechaInicio, fechaFin));
                                        else System.out.println("No se ha podido realizar la operaci??n.");

                                    }

                                    Utils.pulsa();

                                }

                                case 5 -> { //Ver perfil
                                    System.out.println(arrendadorLog);
                                    System.out.println();
                                    Utils.pulsa();
                                }

                                case 6 -> { //Modificar perfil
                                    System.out.println();
                                    System.out.println();
                                    System.out.println("=====Modificar perfil=====");
                                    System.out.print("Introduce el nuevo nombre: ");
                                    String nombreModificado = s.nextLine();
                                    System.out.print("Introduce la nueva contrase??a: ");
                                    String passModificada = s.nextLine();
                                    System.out.println("??Est?? de acuerdo con su modificaci??n?: s para aceptar, cualquiera para cancelar: ");
                                    String aceptarModificado = s.nextLine();
                                    if (aceptarModificado.equalsIgnoreCase("s")) {
                                        arrendadorLog.setNombre(nombreModificado);
                                        arrendadorLog.setPass(passModificada);
                                        System.out.println("Sus cambios han sido guardados.");
                                    } else System.out.println("Se ha cancelado su modificaci??n");
                                    Utils.pulsa();

                                }

                                case 7 -> { //Cerrar sesi??n
                                    System.out.print("Cerrando sesi??n ");
                                    Utils.cerrarPrograma();
                                    System.out.println();
                                }

                                default -> {
                                    System.out.println("Opci??n no v??lida, inserte otra opci??n");
                                    Utils.pulsa();
                                }

                            }
                        } while (menuArrendador != 7);


                    }//Cierra if arrendador


                    //Log de un usuario inquilino
                    int menuInquilino = 0;
                    do {
                        if (inquilinoLog != null) {
                            Menus.pintaMenuInquilino(inquilinoLog);
                            menuInquilino = Integer.parseInt(s.nextLine());

                            switch (menuInquilino) {
                                case 1 -> { //B??squeda de alojamientos

                                    if (inquilinoLog.getReserva1() == null || inquilinoLog.getReserva2() == null) {

                                        String ciudad;
                                        LocalDate fechaInicio, fechaFin;
                                        int numHuespedes = 0;
                                        System.out.println("=====Busqueda de alojamientos=====");
                                        System.out.print("Introduzca una ciudad para buscar: ");
                                        ciudad = s.nextLine();
                                        System.out.print("Introduzca n??mero de hu??spedes: ");
                                        numHuespedes = Integer.parseInt(s.nextLine());
                                        //Pedir fecha
                                        System.out.println("Introduzca el dia fecha de inicio: ");
                                        int dia = Integer.parseInt(s.nextLine());
                                        System.out.println("Introduzca el mes fecha de inicio: ");
                                        int mes = Integer.parseInt(s.nextLine());
                                        System.out.println("Introduzca el a??o fecha de inicio: ");
                                        int year = Integer.parseInt(s.nextLine());
                                        fechaInicio = LocalDate.parse(year + "-" + mes + "-" + dia);
                                        System.out.println("Introduzca el dia fecha de fin: ");
                                        int diaFin = Integer.parseInt(s.nextLine());
                                        System.out.println("Introduzca el mes fecha de fin: ");
                                        int mesFin = Integer.parseInt(s.nextLine());
                                        System.out.println("Introduzca el a??o fecha de fin: ");
                                        int yearFin = Integer.parseInt(s.nextLine());
                                        fechaFin = LocalDate.parse(yearFin + "-" + mesFin + "-" + diaFin);

                                        if (arrendador1.getVivienda() != null && arrendador1.getVivienda().getDireccion().equals(ciudad) && arrendador1.getVivienda().getNumHuespedesMax() > numHuespedes) {
                                            System.out.println("Hemos encontrado esta vivienda: ");
                                            System.out.println(arrendador1.getVivienda());
                                        }
                                        if (arrendador2.getVivienda() != null && arrendador2.getVivienda().getDireccion().equals(ciudad) && arrendador2.getVivienda().getNumHuespedesMax() > numHuespedes) {
                                            System.out.println("Hemos encontrado esta vivienda: ");
                                            System.out.println(arrendador2.getVivienda());
                                        }

                                        System.out.println("??Desea realizar alguna reserva en alguna de estas viviendas? s para continuar, cualquier tecla para cancelar");
                                        if (!s.nextLine().toLowerCase().equals("s")) {
                                            System.out.println("Se ha cancelado su reserva.");
                                        } else {
                                            System.out.print("Introduzca la id de la vivienda deseada: ");
                                            int idViviendaDeseada = Integer.parseInt(s.nextLine());

                                            Reserva reserva = null;
                                            //Comprobamos la id con la vivienda 1
                                            if (idViviendaDeseada == arrendador1.getVivienda().getId()) {
                                                reserva = new Reserva(arrendador1.getVivienda(), arrendador1, inquilinoLog, fechaInicio, fechaFin);
                                                if (inquilinoLog.getReserva1() != null)
                                                    inquilinoLog.setReserva1(reserva);
                                                else inquilinoLog.setReserva2(reserva);
                                                System.out.println("Reserva realizada correctamente");
                                            } else
                                                //Comprobamos id con la vivienda 2
                                                if (idViviendaDeseada == arrendador2.getVivienda().getId()) {
                                                    reserva = new Reserva(arrendador2.getVivienda(), arrendador2, inquilinoLog, fechaInicio, fechaFin);
                                                    if (inquilinoLog.getReserva1() != null)
                                                        inquilinoLog.setReserva1(reserva);
                                                    else inquilinoLog.setReserva2(reserva);
                                                    System.out.println("Reserva realizada correctamente");
                                                } else System.out.println("Id no encontrada.");

                                            Utils.pulsa();
                                            System.out.println();

                                        }

                                        //Solo se pueden realizar 2 reservas por usuario.
                                    } else System.out.println("Usted ya tiene el m??ximo de reservas realizadas");
                                }

                                case 2 -> { //Ver reservas del usuario.
                                    System.out.println("===Reservas realizadas===");
                                    if (inquilinoLog.getReserva1() != null)
                                        System.out.println(inquilinoLog.getReserva1());
                                    if (inquilinoLog.getReserva2() != null)
                                        System.out.println(inquilinoLog.getReserva2());

                                    if (inquilinoLog.getReserva1() == null && inquilinoLog.getReserva2() == null)
                                        System.out.println("No ha realizado ninguna reserva a??n");

                                    Utils.pulsa();
                                    System.out.println();

                                }

                                case 3 -> { //Modificar mis reservas
                                    System.out.print("Introduce la id de la reserva: ");
                                    int idReservaBuscada = Integer.parseInt(s.nextLine());
                                    Reserva reservaCopia = null;


                                    //Comprobamos si la id es de la primera reserva
                                    if (inquilinoLog.getReserva1() != null) {
                                        if (inquilinoLog.getReserva1().getId() == idReservaBuscada) {
                                            reservaCopia = inquilinoLog.getReserva1();
                                        }

                                    } else if (inquilinoLog.getReserva2() != null) {
                                        //Comprobamos si es la segunda reserva
                                        if (inquilinoLog.getReserva2().getId() == idReservaBuscada) {
                                            reservaCopia = inquilinoLog.getReserva2();

                                        }

                                    }

                                    if (reservaCopia == null)
                                        System.out.println("ID no encontrada entre sus reservas.");
                                    else {
                                        System.out.println();
                                        System.out.println("""
                                                1. Eliminar reserva
                                                2. Modificar fecha reserva
                                                3. Cancelar""");
                                        switch (Integer.parseInt(s.nextLine())) {
                                            case 1 -> { //Eliminamos la reserva
                                                System.out.println("??Est?? usted seguro que desea eliminar esta reserva? s para confirmar, cualquier otra tecla para cancelar.");
                                                if (s.nextLine().toLowerCase().equals("s")) {

                                                } else {
                                                    System.out.print("Cancelando operaci??n");
                                                    Utils.cerrarPrograma();
                                                    System.out.println();
                                                }

                                            }
                                            case 2 -> { //Modificamos la fecha de la reserva
                                                boolean confirmarFechaInicio = true;
                                                boolean confirmarFechaFin = true;
                                                boolean cancelacion = false;
                                                int dia, mes, year;
                                                LocalDate fechaInicio = null, fechaFin = null;
                                                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                                                //Pedir fecha inicio
                                                System.out.println("=====Modificaci??n de la reserva con id: " + reservaCopia.getId() + "=====");
                                                System.out.println("Introduzca el dia fecha de inicio: ");
                                                dia = Integer.parseInt(s.nextLine());
                                                System.out.println("Introduzca el mes fecha de inicio: ");
                                                mes = Integer.parseInt(s.nextLine());
                                                System.out.println("Introduzca el a??o fecha de inicio: ");
                                                year = Integer.parseInt(s.nextLine());
                                                System.out.println("La fecha de inicio es: " + dia + "/" + mes + "/" + year);
                                                System.out.println("??Est?? usted de acuerdo con esta fecha? Pulse s para confirmar, otra tecla para denegar");

                                                //Si pulsa s creamos la fecha de inicio de reserva
                                                if (s.nextLine().equalsIgnoreCase("s")) {
                                                    System.out.println("Fecha confirmada");
                                                    fechaInicio = LocalDate.parse(year + "-" + mes + "-" + dia);

                                                } //Cancelamos la operaci??n
                                                else {
                                                    System.out.println("Fecha cancelada");
                                                    confirmarFechaInicio = false;
                                                }
                                                //Si la fecha de inicio es correcta preguntamos por la fecha de fin
                                                if (confirmarFechaInicio) {
                                                    System.out.println("=====Modificaci??n de la reserva con id: " + reservaCopia.getId() + "=====");
                                                    System.out.println("Introduzca el dia fecha de fin: ");
                                                    dia = Integer.parseInt(s.nextLine());
                                                    System.out.println("Introduzca el mes fecha de fin: ");
                                                    mes = Integer.parseInt(s.nextLine());
                                                    System.out.println("Introduzca el a??o fecha de fin: ");
                                                    year = Integer.parseInt(s.nextLine());
                                                    System.out.println("La fecha de inicio es: " + dia + "/" + mes + "/" + year);
                                                    System.out.println("??Est?? usted de acuerdo con esta fecha? Pulse s para confirmar, otra tecla para denegar");
                                                    //Si pulsa s creamos la fecha de fin
                                                    if (s.nextLine().equalsIgnoreCase("s")) {
                                                        System.out.println("Fecha confirmada");
                                                        fechaFin = LocalDate.parse(year + "-" + mes + "-" + dia);

                                                    } //Si no pulsa s cancelamos la operaci??n
                                                    else {
                                                        System.out.println("Fecha cancelada");
                                                        confirmarFechaFin = false;
                                                    }

                                                }
                                                //Si alguna de las dos fechas no es correcta cancelamos la operaci??n
                                                if (!confirmarFechaInicio || !confirmarFechaFin) {
                                                    cancelacion = true;
                                                    System.out.print("Su operaci??n se est?? cancelando");
                                                    Utils.cerrarPrograma();
                                                }

                                                reservaCopia.setFechaInicio(fechaInicio);
                                                reservaCopia.setFechaFin(fechaFin);
                                                Utils.pulsa();

                                            }
                                            case 3 -> { //Cancelar operaci??n
                                                System.out.print("Cancelando su operaci??n");
                                                Utils.cerrarPrograma();
                                                System.out.println();
                                            }

                                            default -> System.out.println("Opci??n incorrecta, introduzca una opci??n v??lida");
                                        }


                                    }


                                }

                                case 4 -> { //Mostrar perfil
                                    System.out.println(inquilinoLog);
                                    Utils.pulsa();
                                    System.out.println();
                                }

                                case 5 -> { //Modificar perfil
                                    System.out.println();
                                    System.out.println();
                                    System.out.println("===Modificar perfil de inquilino===");
                                    System.out.print("Introduce el nuevo nombre: ");
                                    String nombreModificado = s.nextLine();
                                    System.out.print("Introduce la nueva contrase??a: ");
                                    String passModificada = s.nextLine();
                                    System.out.println("??Est?? de acuerdo con su modificaci??n?: s para aceptar, cualquiera para cancelar: ");
                                    String aceptarModificado = s.nextLine();
                                    if (aceptarModificado.equalsIgnoreCase("s"))
                                        inquilinoLog.modificarUsuario(nombreModificado, passModificada);
                                    else System.out.println("Se ha cancelado su modificaci??n");
                                    Utils.pulsa();
                                    System.out.println();
                                }

                                case 6 -> { //Salir
                                    System.out.print("Cerrando sesi??n ");
                                    Utils.cerrarPrograma();
                                    System.out.println();

                                }

                                default -> {
                                    System.out.println("Opci??n no v??lida, inserte otra opci??n");
                                    System.out.println();
                                }
                            }


                        }
                    } while (menuInquilino != 6);


                } //Cierra el logging

                case 3 -> { //Cerrar programa
                    System.out.println();
                    System.out.println("Gracias por sus servicios");
                    System.out.print("Cerrando el programa");
                    Utils.cerrarPrograma();
                    System.out.println();
                    System.out.println();


                } //Cierra el case de fin programa

                default -> {
                    System.out.println("Opci??n incorrecta, vuelva a introducir una opci??n.");
                    System.out.println();
                    System.out.println();
                } //Cierra de default

            } //Cierra el switch
        } while (opMenuLog != 3);


    }
}
