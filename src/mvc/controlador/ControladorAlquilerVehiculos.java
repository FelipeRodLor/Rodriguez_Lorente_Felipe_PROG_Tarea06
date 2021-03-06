/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */
package mvc.controlador;

import mvc.modelo.ModeloAlquilerVehiculos;
import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.vehiculo.Vehiculo;
import mvc.vista.IUTextual;

/**
 *
 * @author Felipon
 */
public class ControladorAlquilerVehiculos implements IControladorAlquilerVehiculos {

    IUTextual vista;
    ModeloAlquilerVehiculos modelo;

    public ControladorAlquilerVehiculos(ModeloAlquilerVehiculos modelo, IUTextual vista) {
        this.vista = vista;
        this.modelo = modelo;
        vista.setControlador(this);
    }

    @Override
    public void comenzar() {
        modelo.añadirDatosPrueba();
        vista.comenzar();
    }

    @Override
    public void anadirVehiculo(Vehiculo vehiculo) {
        modelo.añadirVehiculo(vehiculo);
    }

    @Override
    public void borrarVehiculo(String matricula) {
        modelo.borrarVehiculo(matricula);
    }

    @Override
    public Vehiculo buscarVehiculo(String matricula) {
        return modelo.buscarVehiculo(matricula);
    }

    @Override
    public Vehiculo[] obtenerVehiculos() {
        return modelo.obtenerVehiculos();
    }

    @Override
    public void anadirCliente(Cliente cliente) {
        modelo.añadirCliente(cliente);
    }

    @Override
    public void borrarCliente(String dni) {
        modelo.borrarCliente(dni);
    }

    @Override
    public Cliente buscarCliente(String dni) {
        return modelo.buscarCliente(dni);
    }

    @Override
    public Cliente[] obtenerClientes() {
        return modelo.obtenerClientes();
    }

    @Override
    public void abrirAlquiler(Cliente cliente, Vehiculo turismo) {
        modelo.abrirAlquiler(cliente, turismo);
    }

    @Override
    public void cerrarAlquiler(Cliente cliente, Vehiculo turismo) {
        modelo.cerrarAlquiler(cliente, turismo);
    }

    @Override
    public Alquiler[] obtenerAlquileres() {
        return modelo.obtenerAlquileres();
    }
}
