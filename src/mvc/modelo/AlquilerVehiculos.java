/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.modelo;

import mvc.modelo.dominio.vehiculo.DatosTecnicosVehiculo;
import mvc.modelo.dao.Alquileres;
import mvc.modelo.dao.Clientes;
import mvc.modelo.dao.Turismos;
import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.vehiculo.Vehiculo;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.DireccionPostal;

/**
 *
 * @author Felipillo
 */
public class AlquilerVehiculos {

    private Clientes clientes;
    private Alquileres alquileres;
    private Turismos turismos;

    public AlquilerVehiculos() {
        clientes = new Clientes();
        alquileres = new Alquileres();
        turismos = new Turismos();
    }

    public Alquiler[] obtenerAlquileres() {
        return alquileres.getAlquiler();
    }

    public Vehiculo[] obtenerVehiculos() {
        return turismos.getVehiculo();
    }

    public Cliente[] obtenerClientes() {
        return clientes.getClientes();
    }

    public Cliente buscarCliente(String dni) {
        return clientes.buscar(dni);
    }

    public void añadirCliente(Cliente cliente) {
        clientes.añadir(cliente);
    }

    public void borrarCliente(String dni) {
        clientes.borrar(dni);
    }

    public void añadirVehiculo(Vehiculo vehiculo) {
        turismos.añadir(vehiculo);
    }

    public void borrarVehiculo(String matricula) {
        turismos.borrar(matricula);
    }

    public Vehiculo buscarVehiculo(String matricula) {
        return turismos.buscar(matricula);
    }

    public void abrirAlquiler(Cliente cliente, Vehiculo vehiculo) {
        alquileres.abrir(cliente, vehiculo);
    }

    public void cerrarAlquiler(Cliente cliente, Vehiculo vehiculo) {
        alquileres.cerrar(cliente, vehiculo);
    }

    public void añadirDatosPrueba() {

        DireccionPostal direccionPostal1 = new DireccionPostal("aaa", "aaaa", "04009");
        DireccionPostal direccionPostal2 = new DireccionPostal("bbb", "bbbb", "04008");
        Cliente cliente1 = new Cliente("aa", "11111111A", direccionPostal1);
        Cliente cliente2 = new Cliente("bb", "22222222B", direccionPostal2);
        añadirCliente(cliente1);
        añadirCliente(cliente2);
        DatosTecnicosVehiculo datosTecnicosVehiculo1 = new DatosTecnicosVehiculo(2000,4, 1000);
        DatosTecnicosVehiculo datosTecnicosVehiculo2 = new DatosTecnicosVehiculo(1000, 4, 1000);
        Vehiculo vehiculo1 = new Vehiculo("1111BBB", "Seat", "Ibiza", datosTecnicosVehiculo1);
        Vehiculo vehiculo2 = new Vehiculo("2222BBB", "Opel", "Corsa", datosTecnicosVehiculo2);
        añadirVehiculo(vehiculo1);
        añadirVehiculo(vehiculo2);
        abrirAlquiler(cliente1, buscarVehiculo("2222BBB"));
        vehiculo2.setDisponible(false);
    }
}
