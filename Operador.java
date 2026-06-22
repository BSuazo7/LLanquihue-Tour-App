package model;

import util.ValidacionException;

/**
 * Representa a un operador local que colabora con la agencia.
 * Hereda de Empleado y agrega la zona donde presta sus servicios.
 */
public class Operador extends Empleado {

    private String zonaCobertura;

    public Operador(String nombre, String apellido, String rut, String telefono, Direccion direccion,
                     double sueldo, String zonaCobertura) throws ValidacionException {
        super(nombre, apellido, rut, telefono, direccion, "Operador", sueldo);
        setZonaCobertura(zonaCobertura);
    }

    public String getZonaCobertura() {
        return zonaCobertura;
    }

    public void setZonaCobertura(String zonaCobertura) throws ValidacionException {
        if (zonaCobertura == null || zonaCobertura.trim().isEmpty()) {
            throw new ValidacionException("La zona de cobertura no puede estar vacía.");
        }
        this.zonaCobertura = zonaCobertura.trim();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nZona de cobertura: " + zonaCobertura;
    }
}

