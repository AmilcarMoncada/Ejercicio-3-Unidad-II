package hn.unah.lenguajes.proyecto.demo.services;

import java.util.List;

import hn.unah.lenguajes.proyecto.demo.entities.Empleado;

public interface EmpleadoService {
    public Empleado CrearEmpleado(Empleado empleado);

    public String EliminarEmpleado(String dni);

    public Empleado BuscarEmpleado(String dni);

    public List<Empleado> ObtenerEmpleados();

}
