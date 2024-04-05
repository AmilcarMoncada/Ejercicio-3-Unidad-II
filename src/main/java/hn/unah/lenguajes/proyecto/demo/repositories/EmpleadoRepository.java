package hn.unah.lenguajes.proyecto.demo.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import hn.unah.lenguajes.proyecto.demo.entities.Empleado;


@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, String>{

    
}
