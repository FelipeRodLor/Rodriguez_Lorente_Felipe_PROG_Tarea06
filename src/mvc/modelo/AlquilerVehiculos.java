/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.modelo;

import mvc.modelo.dao.Alquileres;
import mvc.modelo.dao.Clientes;
import mvc.modelo.dao.Turismos;
import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Turismo;
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

    public Turismo[] obtenerTurismo() {
        return turismos.getTurismo();
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

    public void añadirTurismo(Turismo turismo) {
        turismos.añadir(turismo);

    }

    public void borrarTurismo(String matricula) {
        turismos.borrar(matricula);
    }

    public Turismo buscarTurismo(String matricula) {
        return turismos.buscar(matricula);
    }

    public void abrirAlquiler(Cliente cliente, Turismo turismo) {
        alquileres.abrir(cliente, turismo);
    }

    public void closeAlquiler(Cliente cliente, Turismo turismo) {
        alquileres.cerrar(cliente, turismo);
    }

    public void añadirDatosPrueba() {

        DireccionPostal direccionPostal1 = new DireccionPostal("aaa", "aaaa", "04009");
        DireccionPostal direccionPostal2 = new DireccionPostal("bbb", "bbbb", "04008");
        Cliente cliente1 = new Cliente("aa", "11111111A", direccionPostal1);
        Cliente cliente2 = new Cliente("bb", "22222222B", direccionPostal2);
        añadirCliente(cliente1);
        añadirCliente(cliente2);
        Turismo vehiculo1 = new Turismo("1111BBB", "Seat", "Ibiza", 1900);
        Turismo vehiculo2 = new Turismo("2222BBB", "Opel", "Corsa", 1600);
        añadirTurismo(vehiculo1);
        añadirTurismo(vehiculo2);

        abrirAlquiler(cliente1, buscarTurismo("2222BBB"));
        vehiculo2.setDisponible(false);
    }
}