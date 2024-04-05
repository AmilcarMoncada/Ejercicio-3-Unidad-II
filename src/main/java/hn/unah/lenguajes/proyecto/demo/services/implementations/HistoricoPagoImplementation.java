package hn.unah.lenguajes.proyecto.demo.services.implementations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.proyecto.demo.entities.Empleado;
import hn.unah.lenguajes.proyecto.demo.entities.HistoricoPagos;
import hn.unah.lenguajes.proyecto.demo.repositories.EmpleadoRepository;
import hn.unah.lenguajes.proyecto.demo.repositories.HistoricoPagosRepository;
import hn.unah.lenguajes.proyecto.demo.services.HistoricoPagosService;

@Service
public class HistoricoPagoImplementation implements HistoricoPagosService{


    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired 
    private HistoricoPagosRepository historicoPagosRepository;

    @Override
    public List<HistoricoPagos> ListaDePagosEspecificos(String dni, LocalDate FechaInicio, LocalDate FechaFin) {
    Empleado empleadoespecifico =this.empleadoRepository.findById(dni).get();
    List<HistoricoPagos> listahistorica = this.historicoPagosRepository.findByEmpleado(empleadoespecifico);
    List<HistoricoPagos> listaespecifica = new ArrayList<HistoricoPagos>();
        for (int i=0;i<listahistorica.size();i++){
            LocalDate FechaCorrespondiente = listahistorica.get(i).getFechaPago();
            if (FechaCorrespondiente.isAfter(FechaInicio) && FechaCorrespondiente.isBefore(FechaFin)){
                listaespecifica.add(listahistorica.get(i));
            }
        }
        return listaespecifica;
     }
    

    @Override
    public String CrearPagoaEmpleado(String dni, int HorasTrabajadas, Double PrecioPorHora) {
    if (null!= this.empleadoRepository.findById(dni)){
    if(HorasTrabajadas>0 && PrecioPorHora>0){
    Empleado empleadocorrespondiente = this.empleadoRepository.findById(dni).get();
    HistoricoPagos nuevopago= new HistoricoPagos();
    nuevopago.setEmpleado(empleadocorrespondiente);
    nuevopago.setHorasTrabajadas(HorasTrabajadas);
    nuevopago.setPrecioPorHora(PrecioPorHora);
    nuevopago.setTotalSueldo(HorasTrabajadas*PrecioPorHora);
    nuevopago.setFechaPago(LocalDate.now());
    this.historicoPagosRepository.save(nuevopago);
    return "Pago Agregado Correctamente";
    }
    }
    return "Ingrese valores reales";
}
   

}
