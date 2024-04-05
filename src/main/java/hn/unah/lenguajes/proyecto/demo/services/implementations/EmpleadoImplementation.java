package hn.unah.lenguajes.proyecto.demo.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.proyecto.demo.entities.Empleado;
import hn.unah.lenguajes.proyecto.demo.repositories.EmpleadoRepository;
import hn.unah.lenguajes.proyecto.demo.services.EmpleadoService;

@Service
public class EmpleadoImplementation implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public Empleado CrearEmpleado(Empleado empleado) {
      return this.empleadoRepository.save(empleado);
    }

    @Override
    public String EliminarEmpleado(String dni) {
        this.empleadoRepository.deleteById(dni);
        return "Empleado eliminado correctamente";
    }

    @Override
    public Empleado BuscarEmpleado(String dni) {
    return this.empleadoRepository.findById(dni).get();
    }

    @Override
    public List<Empleado> ObtenerEmpleados() {
       return (List<Empleado>) this.empleadoRepository.findAll();
    }
    
}
