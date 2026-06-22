package model;

import util.ValidacionException;

/**
 * Representa a un proveedor de servicios externos de la agencia
 * (por ejemplo, transporte, alojamiento o alimentación).
 * Hereda de Empleado y agrega el tipo de servicio que ofrece.
 */
public class Proveedor extends Empleado {

    private String tipoServicio;

    public Proveedor(String nombre, String apellido, String rut, String telefono, Direccion direccion,
                      double sueldo, String tipoServicio) throws ValidacionException {
        super(nombre, apellido, rut, telefono, direccion, "Proveedor", sueldo);
        setTipoServicio(tipoServicio);
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) throws ValidacionException {
        if (tipoServicio == null || tipoServicio.trim().isEmpty()) {
            throw new ValidacionException("El tipo de servicio no puede estar vacío.");
        }
        this.tipoServicio = tipoServicio.trim();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTipo de servicio: " + tipoServicio;
    }
}

