package hn.unah.lenguajes.proyecto.demo.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table (name="empleado")
public class Empleado {
    
    @Id
    private String dni;

    private String nombre;

    private String apellido;

    private LocalDate fechaingreso;

    @OneToMany(mappedBy = "empleado")
   @JsonIgnore
    private List<HistoricoPagos> HistoricoPagos;
}
