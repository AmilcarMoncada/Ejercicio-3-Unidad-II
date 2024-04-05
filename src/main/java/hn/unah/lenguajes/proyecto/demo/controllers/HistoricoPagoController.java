package hn.unah.lenguajes.proyecto.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.proyecto.demo.entities.HistoricoPagos;
import hn.unah.lenguajes.proyecto.demo.services.implementations.HistoricoPagoImplementation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api")
public class HistoricoPagoController {
   
    @Autowired
    private HistoricoPagoImplementation HistoricoPagoImplementation;

    @GetMapping("/pagos/pagosespecificos")
    public List<HistoricoPagos> ListaDePagosEspecificos(@RequestParam String dni,
                                                        @RequestParam LocalDate FechaInicio,
                                                        @RequestParam LocalDate FechaFin) {
        return this.HistoricoPagoImplementation.ListaDePagosEspecificos(dni, FechaInicio, FechaFin);
    }
    

    @PostMapping("/pagos/nuevopago")
    public String CrearPagoaEmpleado(@RequestParam String dni,
                                     @RequestParam int HorasTrabajadas,
                                     @RequestParam Double PrecioPorHora) {
        return this.HistoricoPagoImplementation.CrearPagoaEmpleado(dni, HorasTrabajadas, PrecioPorHora);
    }
    

}
