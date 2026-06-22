package model;

import util.ValidacionException;

/**
 * Clase base que representa a una persona vinculada a la agencia
 * (puede ser cliente, guía, operador o proveedor).
 * Aplica composición: toda Persona tiene una Direccion.
 */
public class Persona {

    private String nombre;
    private String apellido;
    private String rut;
    private String telefono;
    private Direccion direccion; // Composición: Persona tiene una Direccion

    public Persona(String nombre, String apellido, String rut, String telefono, Direccion direccion)
            throws ValidacionException {
        setNombre(nombre);
        setApellido(apellido);
        setRut(rut);
        setTelefono(telefono);
        setDireccion(direccion);
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws ValidacionException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ValidacionException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) throws ValidacionException {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new ValidacionException("El apellido no puede estar vacío.");
        }
        this.apellido = apellido.trim();
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) throws ValidacionException {
        if (rut == null || !rut.matches("\\d{1,2}\\.\\d{3}\\.\\d{3}-[\\dkK]")) {
            throw new ValidacionException("RUT inválido: " + rut + " (formato esperado 12.345.678-9)");
        }
        this.rut = rut;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) throws ValidacionException {
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new ValidacionException("El teléfono no puede estar vacío.");
        }
        this.telefono = telefono.trim();
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) throws ValidacionException {
        if (direccion == null) {
            throw new ValidacionException("La dirección no puede ser nula.");
        }
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " " + apellido +
                "\nRUT: " + rut +
                "\nTeléfono: " + telefono +
                "\nDirección: " + direccion.toString();
    }
}

