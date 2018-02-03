/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea05;

import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Turismo;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.DireccionPostal;
import utilidades.Entrada;

/**
 *
 * @author Felipillo
 */
public class Principal {

    public static void main(String[] args) {
        int opcion;
        AlquilerVehiculos alquilerVehiculos = new AlquilerVehiculos();
        
        DireccionPostal direccionPostal1 = new DireccionPostal ("aaa", "aaaa", "04009");
        DireccionPostal direccionPostal2 = new DireccionPostal ("bbb", "bbbb", "04008");
        Cliente cliente1 = new Cliente("aa", "11111111A", direccionPostal1);
        Cliente cliente2 = new Cliente("bb", "22222222B", direccionPostal2);
        alquilerVehiculos.addCliente(cliente1);
        alquilerVehiculos.addCliente(cliente2);
        Turismo vehiculo1 = new Turismo("1111BBB", "Seat", "Ibiza", 1900);
        Turismo vehiculo2 = new Turismo("2222BBB", "Opel", "Corsa", 1600);
        alquilerVehiculos.addTurismo(vehiculo1);
        alquilerVehiculos.addTurismo(vehiculo2);
        System.out.println(vehiculo1.toString());
        do {
            do {
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

                switch (opcion) {

                    case 1:
                        Cliente nuevoCliente = null;
                        DireccionPostal nuevaDireccionPostal = null;
                        
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
                            nuevaDireccionPostal = new DireccionPostal(calle, localidad, codigoPostal);
                            nuevoCliente = new Cliente(nombre, dni, nuevaDireccionPostal);
                        } catch (ExcepcionAlquilerVehiculos e) {
                            System.out.printf("\nERROR: %s%n%n", e.getMessage());

                        }
                        if (nuevoCliente != null) {
                            try {
                                alquilerVehiculos.addCliente(nuevoCliente);
                                System.out.println("\nOperacion realizada");
                            } catch (ExcepcionAlquilerVehiculos e) {
                                System.out.printf("\nERROR: %s%n%n", e.getMessage());
                            }
                        }
                        break;

                    case 2:

                        System.out.println("\nBORRAR CLIENTE");
                        System.out.println("----------------");
                        System.out.print("Intruduzca el dni del cliente a eliminar; ");
                        String dniBorrar = Entrada.cadena();
                        try {
                            alquilerVehiculos.delCliente(dniBorrar);
                            System.out.println("\nOperacion realizada");
                        } catch (ExcepcionAlquilerVehiculos e) {
                            System.out.printf("\nERROR: %s%n%n", e.getMessage());

                        }
                        break;

                    case 3:

                        System.out.println("\nLISTADO DE CLIENTES");
                        System.out.println("---------------------");
                        for (Cliente listaCliente : alquilerVehiculos.getClientes()) {
                            if (listaCliente != null) {
                                System.out.println(listaCliente);
                            }
                        }
                        break;

                    case 4:
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
                                alquilerVehiculos.addTurismo(nuevoTurismo);
                                System.out.println("\nOperacion realizada");
                            } catch (ExcepcionAlquilerVehiculos i) {
                                System.out.printf("\nERROR: %s%n%n", i.getMessage());
                            }
                        }
                        break;

                    case 5:
                        System.out.println("\nBORRAR TURISMO");
                        System.out.println("----------------");
                        System.out.print("Intruduzca la matricula del turismo a eliminar; ");
                        String matriculaBorrar = Entrada.cadena();
                        try {
                            alquilerVehiculos.delTurismo(matriculaBorrar);
                            System.out.println("Operacion realizada");
                        } catch (ExcepcionAlquilerVehiculos e) {
                            System.out.printf("\nERROR: %s%n%n", e.getMessage());
                        }
                        break;

                    case 6:

                        System.out.println("\nLISTADO DE TURISMOS");
                        System.out.println("---------------------");
                        for (Turismo listaTurismos : alquilerVehiculos.getTurismos()) {
                            if (listaTurismos != null) {
                                System.out.println(listaTurismos);
                            }
                        }
                        break;

                    case 7:
                        Alquiler nuevoAlquiler = null;

                        System.out.println("\nAPERTURA DE ALQUILER");
                        System.out.println("--------------------");
                        System.out.print("\nIntroduzca el dni del cliente; ");
                        String dniAlquiler = Entrada.cadena();
                        Cliente clienteAlquiler = alquilerVehiculos.getCliente(dniAlquiler);
                        System.out.print("Introduzca la matricula del vehiculo; ");
                        String matriculaAlquiler = Entrada.cadena();
                        Turismo turismoAlquiler = alquilerVehiculos.getTurismo(matriculaAlquiler);
                        if (clienteAlquiler == null) {
                            System.out.println("\nERROR: El cliente introducido no existe en el sistema");
                        } else {
                            if (turismoAlquiler == null) {
                                System.out.println("\nERROR: El vehiculo introducido no existe en el sistema");
                            } else {

                                try {
                                    alquilerVehiculos.openAlquiler(clienteAlquiler, turismoAlquiler);
                                    System.out.println("\nOperacion realizada");
                                } catch (ExcepcionAlquilerVehiculos i) {
                                    System.out.printf("\nERROR: %s%n%n", i.getMessage());
                                }

                            }

                        }

                        break;

                    case 8:

                        System.out.println("\nCIERRE DE ALQUILER");
                        System.out.println("--------------------");
                        System.out.print("\nIntroduzca el dni del cliente; ");
                        String dniCierre = Entrada.cadena();
                        Cliente clienteCierre = alquilerVehiculos.getCliente(dniCierre);
                        System.out.print("Introduzca la matricula del vehiculo; ");
                        String matriculaCierre = Entrada.cadena();
                        Turismo turismoCierre = alquilerVehiculos.getTurismo(matriculaCierre);
                        if (clienteCierre == null) {
                            System.out.println("\nERROR: El cliente introducido no existe en el sistema");
                        } else {
                            if (turismoCierre == null) {
                                System.out.println("\nERROR:El vehiculo introducido no existe en el sistema");
                            } else {
                                try {
                                    alquilerVehiculos.closeAlquiler(clienteCierre, turismoCierre);
                                    System.out.println("Operacion realizada");
                                } catch (ExcepcionAlquilerVehiculos e) {
                                    System.out.printf("\nERROR:  %s%n%n", e.getMessage());

                                }

                            }
                        }
                        break;

                    case 9:

                        System.out.println("\nLISTADO DE ALQUILERES");
                        System.out.println("---------------------");
                        for (Alquiler listaAlquileres : alquilerVehiculos.getAlquileres()) {
                            if (listaAlquileres != null) {
                                System.out.println(listaAlquileres);
                            }
                        }
                        break;

                }

            } while (opcion > 10 || opcion < 0);

            
        } while (opcion
                != 10);
        System.out.println(
                "Has abandonado satisfactoriamente");
    }

}
