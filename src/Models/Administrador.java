package Models;

public class Administrador {
    //Attribute
    private int id;
    private static int contador = 0;
    private String nombre;
    private String pass;
    private String tipo;

    //Constructor
    public Administrador(String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
        id = contador;
        tipo = "admin";
        contador++;
    }


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

    public String getTipo() {
        return tipo;
    }

    //Other Methods
    public void modificaAdministrador(String nombre, String pass){
        this.nombre = nombre;
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "===ADMINISTRADOR===" + '\n' +
                "Nombre: " + nombre + '\n' +
                "Contraseña: " + pass + '\n' +
                "==============" + "\n";
    }
}
