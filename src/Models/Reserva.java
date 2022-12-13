package Models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import static java.time.temporal.ChronoUnit.DAYS;

public class Reserva {
    //Attributes
    private int id;
    private Vivienda vivienda;
    private Propietario arrendador;
    private Usuario inquilino;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private static int contador = 5000;

    //Constructor, lo usaremos para realizar una reserva.
    public Reserva(Vivienda vivienda, Propietario arrendador, Usuario inquilino, LocalDate fechaInicio, LocalDate fechaFin) {
        this.vivienda = vivienda;
        this.arrendador = arrendador;
        this.inquilino = inquilino;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        id = contador;
        contador++;
    }

    public Reserva(Propietario arrendador, Usuario inquilino, LocalDate fechaInicio, LocalDate fechaFin) {
        this.arrendador = arrendador;
        this.inquilino = inquilino;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        id = contador;
        contador++;
    }

    //GET & SET
    public Vivienda getVivienda() {
        return vivienda;
    }

    public void setVivienda(Vivienda vivienda) {
        this.vivienda = vivienda;
    }

    public Propietario getArrendador() {
        return arrendador;
    }

    public void setArrendador(Propietario arrendador) {
        this.arrendador = arrendador;
    }

    public Usuario getInquilino() {
        return inquilino;
    }

    public void setInquilino(Usuario inquilino) {
        this.inquilino = inquilino;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getId() {
        return id;
    }

    //Other Methods
    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "=====Reserva con id "+id+"===" + "\n" +
                "Usuario: " + inquilino.getNombre() + "\n" +
                "Vivienda: " + vivienda.getDescripcion() + "\n" +
                "Noches: " + calculaDias() + "\n" +
                "Fecha de entrada: " + fechaInicio.format(formato) + "\n" +
                "Fecha de salida: " + fechaFin.format(formato) + "\n" +
                "Precio por noche: " + vivienda.getPrecio() + "; " +
                "Precio total: " + calculaPrecio() + "\n" +
                "============";
    }

    //Metodo para declarar una vivienda como no disponible durante un tiempo.
    public static Reserva noDisponible(Propietario arrendador, LocalDate fechaInicio, LocalDate fechaFin) {
        return new Reserva(arrendador, null, fechaInicio, fechaFin);
    }

    //Metodo para calcular el precio total de la reserva.
    public double calculaPrecio() {
        int diasAlquilada = calculaDias();
        return vivienda.getPrecio() * diasAlquilada * 100 / 100;
    }

    public int calculaDias(){
        return (int) DAYS.between(fechaInicio, fechaFin);
    }

    //ToString si no disponemos de inquilino porque esta no disponible durante alguna fecha
    public String pintaViviendaSinInquilino() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "===Reserva: "+id +" ===" + "\n" +
                "Vivienda: " + vivienda + "\n" +
                "Arrendador: " + arrendador.getNombre() + "\n" +
                "Inquilino: reservada por indisponibilidad" + "\n" +
                "Fecha de entrada: " + fechaInicio.format(formato) + "\n" +
                "Fecha de salida: " + fechaFin.format(formato) + "\n" +
                "============";
    }
}

