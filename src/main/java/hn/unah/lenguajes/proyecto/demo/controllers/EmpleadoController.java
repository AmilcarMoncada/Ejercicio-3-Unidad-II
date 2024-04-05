package hn.unah.lenguajes.proyecto.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.proyecto.demo.entities.Empleado;
import hn.unah.lenguajes.proyecto.demo.services.implementations.EmpleadoImplementation;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
    
@Autowired
private EmpleadoImplementation empleadoImplementation;

@PostMapping("/empleado/crear")
public Empleado CrearEmpleado(@RequestBody Empleado empleado) {
    return this.empleadoImplementation.CrearEmpleado(empleado);
}

@DeleteMapping("/empleado/eliminar/{dni}")
public String EliminarEmpleado(@PathVariable String dni){
return this.empleadoImplementation.EliminarEmpleado(dni);
}

@GetMapping("/empleado/buscar")
public Empleado BuscarEmpleado(@RequestParam String dni) {
    return this.empleadoImplementation.BuscarEmpleado(dni);
}

@GetMapping("/empleado/obtener")
public List<Empleado> ObtenerEmpleados() {
    return this.empleadoImplementation.ObtenerEmpleados();
}

}

