/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.modelo.dominio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Felipillo
 */
public class Cliente {

    private String nombre;
    private String dni;
    private int identificador;
    private DireccionPostal direccionPostal;
    private static int ultimoIdenificador;

    public Cliente(String nombre, String dni, DireccionPostal direccionPostal) {

        setNombre(nombre);
        setDni(dni);
        setDireccionPostal(direccionPostal);
        setIdentificador();

    }

    private void setNombre(String nombre) {
        if (nombre.length() > 0) {
            this.nombre = nombre;
        } else {
            throw new ExcepcionAlquilerVehiculos("El nombre introducido no es correcto");
        }
    }

    private void setDni(String dni) {
        if (compruebaDni(dni)) {
            this.dni = dni;
        } else {
            throw new ExcepcionAlquilerVehiculos("El DNI introducido no es correcto");
        }
    }

    private void setIdentificador() {

        ultimoIdenificador++;
        identificador = ultimoIdenificador;

    }

    private boolean compruebaDni(String dni) {
        Pattern patron = Pattern.compile("([0-9]){8}([a-zA-Z]){1}");
        Matcher emparejador;
        emparejador = patron.matcher(dni);

        return emparejador.matches();

    }

    public void setDireccionPostal(DireccionPostal direccionPostal) {
        this.direccionPostal = new DireccionPostal(direccionPostal);
    }

    private Cliente(Cliente cliente) {
        this.nombre = cliente.nombre;
        this.direccionPostal = cliente.direccionPostal;
        this.dni = cliente.dni;

    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;

    }

    public DireccionPostal getDireccionPostal() {
        DireccionPostal nuevaDireccionPostal = new DireccionPostal(direccionPostal);
        return nuevaDireccionPostal;
    }

    public int getIdentificador() {
        return identificador;

    }

    public String toString() {

        return (" DNI; " + dni + " NOMBRE; " + nombre + direccionPostal.toString() + " ID; " + identificador);
    }

}
