/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.modelo.dominio;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Felipillo
 */
public class Alquiler {

    private Date fecha;
    private int dias;
    private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy HH;mm");
    private final int MS_DIA = 1000 * 60 * 60 * 24;
    private final double PRECIO_DIA = 30;
    private Cliente cliente;
    private Turismo turismo;

    public Alquiler(Cliente cliente, Turismo turismo) {

        this.cliente = cliente;
        this.turismo = turismo;
        fecha = new Date();
        dias = 0;
        

    }

    public Date getFecha() {
        return fecha;
    }

    public int getDias() {
        return dias;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Turismo getTurismo() {
        return turismo;
    }

    public void close() {
        Date ahora = new Date();
        dias = difDias(ahora, fecha);
        turismo.setDisponible(true);

    }

    private int difDias(Date fechaFin, Date fechaInicio) {
        long milisegundos = fechaFin.getTime() - fechaInicio.getTime();
        long diasAlq = milisegundos / MS_DIA;
        return (int) diasAlq + 1;

    }

    public double getPrecio() {
        return PRECIO_DIA * dias + turismo.getCilindrada() / 100;
    }

    public String toString() {
        return ("FECHA DE ALQUILER; " + FORMATO_FECHA.format(fecha) + " CLIENTE; " + cliente + " VEHICULO ALQUILADO; " + turismo);
    }

}
