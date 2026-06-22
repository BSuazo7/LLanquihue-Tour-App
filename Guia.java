package model;

import util.ValidacionException;

/**
 * Representa a un guía turístico de la agencia.
 * Hereda de Empleado y agrega su especialidad (ej: rutas gastronómicas,
 * paseos lacustres, excursiones culturales).
 */
public class Guia extends Empleado {

    private String especialidad;

    public Guia(String nombre, String apellido, String rut, String telefono, Direccion direccion,
                double sueldo, String especialidad) throws ValidacionException {
        super(nombre, apellido, rut, telefono, direccion, "Guía Turístico", sueldo);
        setEspecialidad(especialidad);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) throws ValidacionException {
        if (especialidad == null || especialidad.trim().isEmpty()) {
            throw new ValidacionException("La especialidad del guía no puede estar vacía.");
        }
        this.especialidad = especialidad.trim();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nEspecialidad: " + especialidad;
    }
}

