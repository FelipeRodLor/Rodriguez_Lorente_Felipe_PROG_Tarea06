/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controlador;

import mvc.modelo.AlquilerVehiculos;
import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.Turismo;
import mvc.vista.IUTextual;

/**
 *
 * @author Felipon
 */
public class ControladorAlquilerVehiculos {

    IUTextual vista;
    AlquilerVehiculos modelo;

    public ControladorAlquilerVehiculos(AlquilerVehiculos modelo, IUTextual vista) {
        this.vista = vista;
        this.modelo = modelo;
        vista.setControlador(this);
    }

    public void comenzar() {
        modelo.añadirDatosPrueba();
        vista.comenzar();
    }

    public void anadirTurismo(Turismo turismo) {
        modelo.añadirTurismo(turismo);
    }

    public void borrarTurismo(String matricula) {
        modelo.borrarTurismo(matricula);
    }

    public Turismo buscarTurismo(String matricula) {

        return modelo.buscarTurismo(matricula);
    }

    public Turismo[] obtenerTurismos() {
        return modelo.obtenerTurismos();
    }

    public void anadirCliente(Cliente cliente) {
        modelo.añadirCliente(cliente);
    }

    public void borrarCliente(String dni) {
        modelo.borrarCliente(dni);
    }

    public Cliente buscarCliente(String dni) {
        return modelo.buscarCliente(dni);
    }

    public Cliente[] obtenerClientes() {
        return modelo.obtenerClientes();
    }

    public void abrirAlquiler(Cliente cliente, Turismo turismo) {
        modelo.abrirAlquiler(cliente, turismo);
    }

    public void cerrarAlquiler(Cliente cliente, Turismo turismo) {
        modelo.cerrarAlquiler(cliente, turismo);
    }

    public Alquiler[] obtenerAlquileres() {
        return modelo.obtenerAlquileres();
    }

}
