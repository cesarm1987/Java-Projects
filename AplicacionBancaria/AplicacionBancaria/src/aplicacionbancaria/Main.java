package aplicacionbancaria;

/**
 *
 * @author Cesar Morera 
 * Curso de Programación orientadas a objectos
 */
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Cliente cliente = banco.registrarCliente(); // Registrar un nuevo cliente
        Cuenta cuenta = banco.crearCuenta(cliente); // Crear una nueva cuenta para el cliente

        boolean seguirOperando = true;
        while (seguirOperando) {
            int opcion = mostrarMenu(); // Mostrar el menú de opciones
            switch (opcion) {
                case 1 -> {
                    double montoDeposito = obtenerMonto("Ingrese el monto a depositar (CRC):"); // Obtener el monto del depósito
                    cuenta.realizarDeposito(montoDeposito); // Realizar el depósito en la cuenta
                }
                case 2 -> {
                    double montoRetiro = obtenerMonto("Ingrese el monto a retirar (CRC):"); // Obtener el monto del retiro
                    cuenta.realizarRetiro(montoRetiro); // Realizar el retiro de la cuenta
                }
                case 3 -> cuenta.generarEstadoDeCuenta(); // Generar el estado de cuenta
                case 4 -> seguirOperando = false; // Salir del programa
                default -> JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente."); // Opción inválida
            }
        }
    }

    private static int mostrarMenu() {
        String mensaje = "Seleccione una opción:\n" +
                "1. Realizar depósito\n" +
                "2. Realizar retiro\n" +
                "3. Generar estado de cuenta\n" +
                "4. Salir";
        String opcionStr = JOptionPane.showInputDialog(null, mensaje); // Mostrar el cuadro de diálogo para elegir la opción
        try {
            return Integer.parseInt(opcionStr); // Convertir la opción ingresada a un entero
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static double obtenerMonto(String mensaje) {
        String montoStr = JOptionPane.showInputDialog(null, mensaje); // Mostrar el cuadro de diálogo para ingresar el monto
        try {
            return Double.parseDouble(montoStr); // Convertir el monto ingresado a un número decimal
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
