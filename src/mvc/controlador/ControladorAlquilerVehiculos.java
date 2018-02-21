/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */
package mvc.controlador;

import mvc.modelo.AlquilerVehiculos;
import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Cliente;
import mvc.dominio.vehiculo.Vehiculo;
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

    public void anadirVehiculo(Vehiculo vehiculo) {
        modelo.añadirVehiculo(vehiculo);
    }

    public void borrarVehiculo(String matricula) {
        modelo.borrarVehiculo(matricula);
    }

    public Vehiculo buscarVehiculo(String matricula) {
        return modelo.buscarVehiculo(matricula);
    }

    public Vehiculo[] obtenerVehiculos() {
        return modelo.obtenerVehiculos();
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

    public void abrirAlquiler(Cliente cliente, Vehiculo turismo) {
        modelo.abrirAlquiler(cliente, turismo);
    }

    public void cerrarAlquiler(Cliente cliente, Vehiculo turismo) {
        modelo.cerrarAlquiler(cliente, turismo);
    }

    public Alquiler[] obtenerAlquileres() {
        return modelo.obtenerAlquileres();
    }
}
