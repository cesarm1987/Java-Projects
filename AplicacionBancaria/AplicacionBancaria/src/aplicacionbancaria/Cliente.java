package aplicacionbancaria;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int numeroCliente;
    private String identificacion;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private String fechaNacimiento;
    private List<Cuenta> cuentas;

    public Cliente(int numeroCliente, String identificacion, String nombre, String apellidos, String direccion, String telefono, String correoElectronico, String fechaNacimiento) {
        this.numeroCliente = numeroCliente;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.cuentas = new ArrayList<>();
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    // Otros métodos y funciones de utilidad...
}
