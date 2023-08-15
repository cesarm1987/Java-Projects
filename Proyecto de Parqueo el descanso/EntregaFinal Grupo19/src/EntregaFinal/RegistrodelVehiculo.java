package EntregaFinal;

import javax.swing.JOptionPane;

public class RegistrodelVehiculo {

    private String numeroPlaca;
    private String formaPago;

    public RegistrodelVehiculo() {
    }

    // Método para solicitar los datos del vehículo
    public void solicitarDatos() {
        numeroPlaca = JOptionPane.showInputDialog(null, "Ingrese el número de placa del vehículo:");
        formaPago = JOptionPane.showInputDialog(null, "Ingrese la forma de pago del vehículo:");
    }

    // Método para mostrar los datos del vehículo
    public void mostrarDatos() {
        JOptionPane.showMessageDialog(null, "Número de placa: " + numeroPlaca + "\nForma de pago: " + formaPago);
    }

    // Getter para el número de placa
    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    // Setter para el número de placa
    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    // Getter para la forma de pago
    public String getFormaPago() {
        return formaPago;
    }

    // Setter para la forma de pago
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }
}
