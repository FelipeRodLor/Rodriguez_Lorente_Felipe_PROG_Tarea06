/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.vista;

import mvc.modelo.dao.Alquileres;
import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.DireccionPostal;
import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import mvc.modelo.dominio.Turismo;
import mvc.modelo.AlquilerVehiculos;
import utilidades.Entrada;

/**
 *
 * @author Felipillo
 */
public class IUTextual {

    public static void main(String[] args) {
        int opcion;
        AlquilerVehiculos alquilerVehiculos = new AlquilerVehiculos();

        alquilerVehiculos.añadirDatosPrueba();

        do {
            do {
                opcion = comenzar();

                switch (opcion) {

                    case 1:
                        anadirCliente(alquilerVehiculos);
                        break;

                    case 2:

                        borrarCliente(alquilerVehiculos);
                        break;

                    case 3:

                        listarClientes(alquilerVehiculos);
                        break;

                    case 4:
                        anadirTurismo(alquilerVehiculos);
                        break;

                    case 5:
                        borrarTurismo(alquilerVehiculos);
                        break;

                    case 6:

                        listarTurismos(alquilerVehiculos);
                        break;

                    case 7:

                        abrirAlquiler(alquilerVehiculos);

                        break;

                    case 8:
                        cerrarAlquiler(alquilerVehiculos);

                        break;

                    case 9:

                        listarAlquileres(alquilerVehiculos);
                        break;

                }

            } while (opcion > 10 || opcion < 0);

        } while (opcion != 10);
        System.out.println("Has abandonado satisfactoriamente");
    }

    public static int comenzar() {
        int opcion;
        System.out.println("\nPulse el numero de la opcion que quiera realizar;");
        System.out.println("----------------");
        System.out.println("1-AÑADIR CLIENTE");
        System.out.println("2-BORRAR CLIENTE");
        System.out.println("3-LISTAR CLIENTES");
        System.out.println("4-AÑADIR TURUSMO");
        System.out.println("5-BORRAR TURISMO");
        System.out.println("6-LISTAR TURISMOS");
        System.out.println("7-ABRIR ALQUILER");
        System.out.println("8-CERRAR ALQUILER");
        System.out.println("9-LISTAR ALQUILER");
        System.out.println("10-SALIR");
        opcion = Entrada.entero();
        return opcion;
    }

    public static void listarAlquileres(AlquilerVehiculos alquilerVehiculos) {
        System.out.println("\nLISTADO DE ALQUILERES");
        System.out.println("---------------------");
        for (Alquiler listaAlquileres : alquilerVehiculos.obtenerAlquileres()) {
            if (listaAlquileres != null) {
                System.out.println(listaAlquileres);
            }
        }
    }

    public static void cerrarAlquiler(AlquilerVehiculos alquilerVehiculos) {
        Alquileres alquileres = null;
        
        System.out.println("\nCIERRE DE ALQUILER");
        System.out.println("--------------------");
        System.out.print("\nIntroduzca el dni del cliente; ");
        String dniCierre = Entrada.cadena();
        System.out.print("Introduzca la matricula del vehiculo; ");
        String matriculaCierre = Entrada.cadena();
        
        try {
            Cliente clienteAlquiler = alquilerVehiculos.buscarCliente(dniCierre);
            Turismo turismoAlquiler = alquilerVehiculos.buscarTurismo(matriculaCierre);
            alquilerVehiculos.closeAlquiler(clienteAlquiler, turismoAlquiler);
            System.out.println("Operacion realizada");
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("\nERROR:  %s%n%n", e.getMessage());
            
        }
    }

    public static void abrirAlquiler(AlquilerVehiculos alquilerVehiculos) {
        Alquiler nuevoAlquiler = null;
        
        System.out.println("\nAPERTURA DE ALQUILER");
        System.out.println("--------------------");
        System.out.print("\nIntroduzca el dni del cliente; ");
        String dniAlquiler = Entrada.cadena();
        System.out.print("Introduzca la matricula del vehiculo; ");
        String matriculaAlquiler = Entrada.cadena();
        
        try {
            Cliente clienteAlquiler = alquilerVehiculos.buscarCliente(dniAlquiler);
            Turismo turismoAlquiler = alquilerVehiculos.buscarTurismo(matriculaAlquiler);
            alquilerVehiculos.abrirAlquiler(clienteAlquiler, turismoAlquiler);
            
            System.out.println("\nOperacion realizada");
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("\nERROR: %s%n%n", e.getMessage());
        }
    }

    public static void listarTurismos(AlquilerVehiculos alquilerVehiculos) {
        System.out.println("\nLISTADO DE TURISMOS");
        System.out.println("---------------------");
        for (Turismo listaTurismos : alquilerVehiculos.obtenerTurismo()) {
            if (listaTurismos != null) {
                System.out.println(listaTurismos);
            }
        }
    }

    public static void borrarTurismo(AlquilerVehiculos alquilerVehiculos) {
        System.out.println("\nBORRAR TURISMO");
        System.out.println("----------------");
        System.out.print("Intruduzca la matricula del turismo a eliminar; ");
        String matriculaBorrar = Entrada.cadena();
        try {
            alquilerVehiculos.borrarTurismo(matriculaBorrar);
            System.out.println("Operacion realizada");
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("\nERROR: %s%n%n", e.getMessage());
        }
    }

    public static void anadirTurismo(AlquilerVehiculos alquilerVehiculos) {
        Turismo nuevoTurismo = null;
        
        System.out.println("\nDATOS DEL TURISMO");
        System.out.println("-------------------");
        System.out.print("Matricula; ");
        String matricula = Entrada.cadena();
        System.out.print("Marca; ");
        String marca = Entrada.cadena();
        System.out.print("Modelo; ");
        String modelo = Entrada.cadena();
        System.out.print("Cilindrada; ");
        int cilindrada = Entrada.entero();
        
        try {
            nuevoTurismo = new Turismo(matricula, marca, modelo, cilindrada);
            
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("\nERROR: %s%n%n", e.getMessage());
            
        }
        
        if (nuevoTurismo != null) {
            try {
                alquilerVehiculos.añadirTurismo(nuevoTurismo);
                System.out.println("\nOperacion realizada");
            } catch (ExcepcionAlquilerVehiculos i) {
                System.out.printf("\nERROR: %s%n%n", i.getMessage());
            }
        }
    }

    public static void listarClientes(AlquilerVehiculos alquilerVehiculos) {
        System.out.println("\nLISTADO DE CLIENTES");
        System.out.println("---------------------");
        for (Cliente listaCliente : alquilerVehiculos.obtenerClientes()) {
            if (listaCliente != null) {
                System.out.println(listaCliente);
            }
        }
    }

    public static void borrarCliente(AlquilerVehiculos alquilerVehiculos) {
        System.out.println("\nBORRAR CLIENTE");
        System.out.println("----------------");
        System.out.print("Intruduzca el dni del cliente a eliminar; ");
        String dniBorrar = Entrada.cadena();
        try {
            
            alquilerVehiculos.borrarCliente(dniBorrar);
            System.out.println("\nOperacion realizada");
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("\nERROR: %s%n%n", e.getMessage());
            
        }
    }

    public static void anadirCliente(AlquilerVehiculos alquilerVehiculos) {
        Cliente nuevoCliente = null;
        
        System.out.println("\nDATOS DEL CLIENTE");
        System.out.println("-------------------");
        System.out.print("Nombre; ");
        String nombre = Entrada.cadena();
        System.out.print("Dni; ");
        String dni = Entrada.cadena();
        System.out.print("Calle; ");
        String calle = Entrada.cadena();
        System.out.print("Localidad; ");
        String localidad = Entrada.cadena();
        System.out.print("Codigo Postal; ");
        String codigoPostal = Entrada.cadena();
        
        try {
            DireccionPostal nuevaDireccionPostal = new DireccionPostal(calle, localidad, codigoPostal);
            nuevoCliente = new Cliente(nombre, dni, nuevaDireccionPostal);
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("\nERROR: %s%n%n", e.getMessage());
            
        }
        if (nuevoCliente != null) {
            try {
                alquilerVehiculos.añadirCliente(nuevoCliente);
                System.out.println("\nOperacion realizada");
            } catch (ExcepcionAlquilerVehiculos e) {
                System.out.printf("\nERROR: %s%n%n", e.getMessage());
            }
        }
    }

}


