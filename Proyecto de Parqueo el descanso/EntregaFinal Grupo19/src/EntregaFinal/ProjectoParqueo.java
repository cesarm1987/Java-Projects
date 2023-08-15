package EntregaFinal;

import javax.swing.*;

public class ProjectoParqueo {

    public static void main(String[] args) {
        // TODO code application logic here
        int opcion;
        int op = 0;
        int filas = 5; // Número de espacios
        int columnas = 365; // Número de días en un año
        double tarifaSemana = 100; // Tarifa por persona por noche en días de semana
        double tarifaFinDeSemana = 150; // Tarifa por persona por noche en fin de semana
        double iva = 0.16; // Tasa de IVA

        String mensaje = "Gracias por preferirnos";
        RegistroParqueo RP = new RegistroParqueo();
        RegistrodelVehiculo RV = new RegistrodelVehiculo();
        ReservaciondeEspacios RE = new ReservaciondeEspacios(filas, columnas, tarifaSemana, tarifaFinDeSemana, iva);;

        while (op != 4) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al Parqueo el Descanso: \n1.Registro de la capacidad del Parqueo. "
                    + "\n2.Registro del Vehiculo." + "\n3.Reservacion de Espacio." + "\n4.Salir."));

            if (opcion == 1) {
                RP.solicitarDatos();

            } else if (opcion == 2) {
                RV.solicitarDatos();
                RV.mostrarDatos();
            } else if (opcion == 3) {
                RE.realizarReservaciones();

            }

        }
    }
}
