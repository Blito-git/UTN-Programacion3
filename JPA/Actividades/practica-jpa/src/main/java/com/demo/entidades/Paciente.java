package com.demo.entidades;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Paciente extends Base {

    private int edad;
    private String obraSocial;

    @OneToOne
    @JoinColumn(name = "historial_id")
    private HistorialClinico historialClinico;

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "paciente_medicamento",
        joinColumns = @JoinColumn(name = "paciente_id"),
        inverseJoinColumns = @JoinColumn(name = "medicamento_id")
    )
    private List<Medicamento> medicamentos = new ArrayList<>();

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public HistorialClinico getHistorialClinico() {
        return historialClinico;
    }

    public void setHistorialClinico(HistorialClinico historialClinico) {
        this.historialClinico = historialClinico;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }
}
