package EntregaFinal;

import javax.swing.*;

public class ReservaciondeEspacios {

    private boolean[][] disponibilidad;
    private double tarifaSemana;
    private double tarifaFinDeSemana;
    private double iva;

public ReservaciondeEspacios(int filas, int columnas, double tarifaSemana, double tarifaFinDeSemana, double iva) {
        this.disponibilidad = new boolean[filas][columnas];
        this.tarifaSemana = tarifaSemana;
        this.tarifaFinDeSemana = tarifaFinDeSemana;
        this.iva = iva;

        // Inicializar la matriz con todos los espacios disponibles
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                disponibilidad[i][j] = true;
            }
        }
    }

    public void realizarReservaciones() {
        while (true) {
            int espacio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de espacio:"));
            int dias = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de días de la reserva:"));
            String diaSemana = JOptionPane.showInputDialog("Ingrese el día de la semana de inicio (Lunes/Domingo):");

            // Verificar disponibilidad
            boolean disponible = true;
            for (int j = 0; j < disponibilidad[0].length && disponible; j++) {
                for (int k = 0; k < dias; k++) {
                    if (j + k >= disponibilidad[0].length || !disponibilidad[espacio - 1][j + k]) {
                        disponible = false;
                        break;
                    }
                }
            }

            if (disponible) {
                // Calcular tarifa y monto total
                double tarifa;
                if (diaSemana.equalsIgnoreCase("Domingo") || diaSemana.equalsIgnoreCase("Sábado")) {
                    tarifa = tarifaFinDeSemana;
                } else {
                    tarifa = tarifaSemana;
                }

                double montoTotal = tarifa * dias;
                double montoConIVA = montoTotal * (1 + iva);

                // Marcar los días como no disponibles
                for (int k = 0; k < dias; k++) {
                    int j = 0;
                    disponibilidad[espacio - 1][j + k] = false;
                }

                JOptionPane.showMessageDialog(null, "Reserva exitosa del espacio " + espacio + " por " + dias + " días."
                        + "\nTarifa por noche: $" + tarifa
                        + "\nMonto total a pagar (sin IVA): $" + montoTotal
                        + "\nMonto total a pagar (con IVA): $" + montoConIVA);
            } else {
                JOptionPane.showMessageDialog(null, "El espacio no está disponible para el período solicitado.");
            }

            int continuar = JOptionPane.showConfirmDialog(null, "¿Desea hacer otra reserva?", "Continuar", JOptionPane.YES_NO_OPTION);
            if (continuar != JOptionPane.YES_OPTION) {
                break;
            }
        }
    
  }
}