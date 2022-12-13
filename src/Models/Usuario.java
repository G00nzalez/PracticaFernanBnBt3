package Models;

public class Usuario {

    //Attributes
    private int id;
    private static int contador = 2000;
    private String nombre;
    private String pass;
    private Reserva reserva1;
    private Reserva reserva2;
    private String tipo;

    //GET & SET

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPass() {
        return pass;
    }

    public Reserva getReserva1() {
        return reserva1;
    }

    public Reserva getReserva2() {
        return reserva2;
    }

    public String getTipo() {
        return tipo;
    }

    public void setReserva1(Reserva reserva1) {
        this.reserva1 = reserva1;
    }

    public void setReserva2(Reserva reserva2) {
        this.reserva2 = reserva2;
    }
    //CONSTRUCTOR

    public Usuario(String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
        reserva1 = null;
        reserva2 = null;
        id = contador;
        contador++;
        tipo = "inquilino";
    }


    //OTHER METHODS
    public void modificarUsuario(String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "===INQUILINO===" + '\n' +
                "Nombre: " + nombre + '\n' +
                "Contraseña: " + pass + '\n' +
                "==============" + "\n";
    }
}
