package aplicacionbancaria;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private final List<Cliente> clientes;
    private int numeroCliente;

    public Banco() {
        clientes = new ArrayList<>();
        numeroCliente = 1;
    }

    public Cliente registrarCliente() {
        // Obtener la información del cliente utilizando cuadros de diálogo
        String identificacion = JOptionPane.showInputDialog(null, "Ingrese la identificación:");
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre:");
        String apellidos = JOptionPane.showInputDialog(null, "Ingrese los apellidos:");
        String direccion = JOptionPane.showInputDialog(null, "Ingrese la dirección:");
        String telefono = JOptionPane.showInputDialog(null, "Ingrese el teléfono:");
        String correoElectronico = JOptionPane.showInputDialog(null, "Ingrese el correo electrónico:");
        String fechaNacimiento = JOptionPane.showInputDialog(null, "Ingrese la fecha de nacimiento (dd/mm/yyyy):");

        Cliente cliente = new Cliente(numeroCliente, identificacion, nombre, apellidos, direccion, telefono, correoElectronico, fechaNacimiento);
        clientes.add(cliente); // Agregar el cliente a la lista de clientes
        numeroCliente++;

        return cliente;
    }

    public Cuenta crearCuenta(Cliente cliente) {
        // Obtener el número de cuenta y el saldo inicial utilizando cuadros de diálogo
        String numeroCuenta = JOptionPane.showInputDialog(null, "Ingrese el número de cuenta:");
        double saldoInicial = obtenerMonto("Ingrese el saldo inicial (CRC):");

        // Crear una nueva cuenta para el cliente y agregarla a la lista de cuentas del cliente
        Cuenta cuenta = new Cuenta(numeroCuenta, saldoInicial, cliente);
        cliente.agregarCuenta(cuenta);
        return cuenta;
    }

    private double obtenerMonto(String mensaje) {
        String montoStr = JOptionPane.showInputDialog(null, mensaje); // Mostrar el cuadro de diálogo para ingresar el monto
        try {
            return Double.parseDouble(montoStr); // Convertir el monto ingresado a un número decimal
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    // Método para mostrar el menú
    public void mostrarMenu() {
        // Código para mostrar el menú y gestionar las opciones
        // ...
    }

    // Otros métodos y funciones de utilidad...
}
