package Models;

public class Vivienda {

    //Attributes
    private int id;
    private static int contador = 3000;
    private String descripcion;
    private String direccion;
    private int numHuespedesMax;
    private double precio;
    private Reserva reserva1;
    private Reserva reserva2;

    //Constructor
    public Vivienda(String descripcion, String direccion, int numHuespedesMax, double precio) {
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.numHuespedesMax = numHuespedesMax;
        this.precio = precio;
        id = contador;
        contador++;
        reserva1 = null;
        reserva2 = null;
    }

    //Get & Set

    public Reserva getReserva1() {
        return reserva1;
    }

    public void setReserva1(Reserva reserva1) {
        this.reserva1 = reserva1;
    }

    public Reserva getReserva2() {
        return reserva2;
    }

    public void setReserva2(Reserva reserva2) {
        this.reserva2 = reserva2;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getNumHuespedesMax() {
        return numHuespedesMax;
    }

    public double getPrecio() {
        return precio;
    }

    //Other Methods

    @Override
    public String toString() {
        return  "=====Alojamiento con ID: " +id + "====="+"\n" +
                "Vivienda: " + descripcion + '\n' +
                "Dirección :" + direccion + '\n' +
                "Número de huéspedes máximo: " + numHuespedesMax + '\n' +
                "Precio por noche: " + precio + '\n' + '\n';
    }
}
