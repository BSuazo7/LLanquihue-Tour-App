package model;

import util.ValidacionException;

/**
 * Representa a un empleado o colaborador vinculado a la agencia.
 * Es la superclase de Guia, Operador y Proveedor.
 */
public class Empleado extends Persona {

    private String cargo;
    private double sueldo;

    public Empleado(String nombre, String apellido, String rut, String telefono,
                     Direccion direccion, String cargo, double sueldo) throws ValidacionException {
        super(nombre, apellido, rut, telefono, direccion);
        setCargo(cargo);
        setSueldo(sueldo);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) throws ValidacionException {
        if (cargo == null || cargo.trim().isEmpty()) {
            throw new ValidacionException("El cargo no puede estar vacío.");
        }
        this.cargo = cargo.trim();
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) throws ValidacionException {
        if (sueldo < 0) {
            throw new ValidacionException("El sueldo no puede ser negativo: " + sueldo);
        }
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCargo: " + cargo +
                "\nSueldo: $" + sueldo;
    }
}

