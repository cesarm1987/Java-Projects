package aplicacionbancaria;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Cuenta {
    private String numeroCuenta;
    private double saldo;
    private Cliente cliente;
    private List<Transaccion> transacciones;

    public Cuenta(String numeroCuenta, double saldoInicial, Cliente cliente) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
        this.cliente = cliente;
        this.transacciones = new ArrayList<>();
    }

    public void realizarDeposito(double monto) {
        saldo += monto;
        Transaccion transaccion = new Transaccion(transacciones.size() + 1, "Depósito", numeroCuenta, saldo, monto);
        transacciones.add(transaccion); // Agregar la transacción a la lista de transacciones de la cuenta
        JOptionPane.showMessageDialog(null, "Depósito realizado correctamente.");
    }

    public void realizarRetiro(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            Transaccion transaccion = new Transaccion(transacciones.size() + 1, "Retiro", numeroCuenta, saldo, monto);
            transacciones.add(transaccion); // Agregar la transacción a la lista de transacciones de la cuenta
            JOptionPane.showMessageDialog(null, "Retiro realizado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar el retiro.");
        }
    }

    public void generarEstadoDeCuenta() {
        StringBuilder estadoCuenta = new StringBuilder();
        estadoCuenta.append("Número de cuenta: ").append(numeroCuenta).append("\n");
        estadoCuenta.append("Saldo: ₡").append(formatearMonto(saldo)).append("\n");
        estadoCuenta.append(cliente.toString()); // Obtener la información del cliente como una cadena de texto
        estadoCuenta.append("Transacciones:\n");
        estadoCuenta.append("-------------------------------------------------\n");
        estadoCuenta.append("| No. | Tipo     | Monto     | Saldo Actual         |\n");
        estadoCuenta.append("-------------------------------------------------\n");

        for (Transaccion transaccion : transacciones) {
            estadoCuenta.append(String.format("| %-3d | %-8s | ₡%-8s | ₡%-20s |\n",
                    transaccion.getNumeroTransaccion(), transaccion.getTipoTransaccion(),
                    formatearMonto(transaccion.getMonto()), formatearMonto(transaccion.getSaldoActual())));
        }
        estadoCuenta.append("-------------------------------------------------\n");

        JOptionPane.showMessageDialog(null, estadoCuenta.toString()); // Mostrar el estado de cuenta utilizando un cuadro de diálogo
    }

    private String formatearMonto(double monto) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
        return decimalFormat.format(monto);
    }

    private static class Transaccion {
        private int numeroTransaccion;
        private String tipoTransaccion;
        private String numeroCuenta;
        private double saldoActual;
        private double monto;

        public Transaccion(int numeroTransaccion, String tipoTransaccion, String numeroCuenta, double saldoActual, double monto) {
            this.numeroTransaccion = numeroTransaccion;
            this.tipoTransaccion = tipoTransaccion;
            this.numeroCuenta = numeroCuenta;
            this.saldoActual = saldoActual;
            this.monto = monto;
        }

        public int getNumeroTransaccion() {
            return numeroTransaccion;
        }

        public String getTipoTransaccion() {
            return tipoTransaccion;
        }

        public double getMonto() {
            return monto;
        }

        public double getSaldoActual() {
            return saldoActual;
        }
    }
}
