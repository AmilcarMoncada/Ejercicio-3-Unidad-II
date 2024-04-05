package hn.unah.lenguajes.proyecto.demo.services;

import java.time.LocalDate;
import java.util.List;

import hn.unah.lenguajes.proyecto.demo.entities.HistoricoPagos;

public interface HistoricoPagosService {
    
    public List<HistoricoPagos> ListaDePagosEspecificos(String dni, LocalDate FechaInicio, LocalDate FechaFin);
    
    public String CrearPagoaEmpleado (String dni, int HorasTrabajadas, Double PrecioPorHora);
}
