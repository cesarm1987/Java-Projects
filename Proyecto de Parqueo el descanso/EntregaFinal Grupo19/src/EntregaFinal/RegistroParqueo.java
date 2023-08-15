package EntregaFinal;

import javax.swing.*;

public class RegistroParqueo {

    private String ubicacion;
    private int cantidadVehiculos;
    private String[] vehiculos;

    public RegistroParqueo() {
        ubicacion = "";
        cantidadVehiculos = 0;
        vehiculos = null;
    }

    public void solicitarDatos() {
        ubicacion = JOptionPane.showInputDialog(null, "Ingrese la ubicación del parqueo:");
        cantidadVehiculos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de vehículos a recibir en el parqueo:"));
    }

    public void solicitarDatosdelVehiculo() {
        vehiculos = new String[cantidadVehiculos];
        for (int i = 0; i < cantidadVehiculos; i++) {
            vehiculos[i] = JOptionPane.showInputDialog(null, "Ingrese el tipo de vehículo #" + (i + 1) + ":");
        }
    }



    public void mostrarDatos() {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Ubicación del parqueo: ").append(ubicacion).append("\n");
        mensaje.append("Cantidad de vehículos a recibir: ").append(cantidadVehiculos).append("\n");
        mensaje.append("Tipos de vehículos a recibir:\n");
        for (int i = 0; i < cantidadVehiculos; i++) {
            mensaje.append("- ").append(vehiculos[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Registro de Parque", JOptionPane.INFORMATION_MESSAGE);
    }
}
