package hn.unah.lenguajes.proyecto.demo.repositories;

import java.time.LocalDate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.unah.lenguajes.proyecto.demo.entities.Empleado;
import hn.unah.lenguajes.proyecto.demo.entities.HistoricoPagos;
import java.util.List;


@Repository
public interface HistoricoPagosRepository extends CrudRepository<HistoricoPagos, LocalDate>{
    
    public List<HistoricoPagos> findByEmpleado(Empleado Empleado);


}
