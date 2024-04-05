package hn.unah.lenguajes.proyecto.demo.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table (name="historicopagos")
public class HistoricoPagos {
    
    @Id
    @Column(name="fechapago")
    private LocalDate FechaPago;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="dni" , referencedColumnName = "dni")
    private Empleado empleado;

    @Column(name="horastrabajadas")
    private int HorasTrabajadas;

    @Column(name="precioporhora")
    private Double PrecioPorHora;

    @Column(name="totalsueldo")
    private Double TotalSueldo;
}
