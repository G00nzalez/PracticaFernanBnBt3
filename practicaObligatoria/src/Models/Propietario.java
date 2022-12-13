package Models;

public class Propietario {

    //Attributes
    private int id;
    private static int contador = 1000;
    private String nombre;
    private String pass;
    private String tipo;
    private Vivienda vivienda;

    //Constructor
    public Propietario(String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
        vivienda = null;
        tipo = "arrendador";
        id = contador;
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

    public Vivienda getVivienda() {
        return vivienda;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    //Other Methods
    @Override
    public String toString() {
        return "===ARRENDADOR===" + '\n' +
                "Nombre: " + nombre + '\n' +
                "Contraseña: " + pass + '\n' +
                "Vivienda: " + (vivienda == null? "sin viviendas registradas": "\n"+vivienda) + '\n' +
                "==============" + "\n";
    }

    public void registrarVivienda(Vivienda vivienda){
        this.vivienda = vivienda;
    }
}
