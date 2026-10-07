package com.demo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Medico extends Base {

    private String especialidad;

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas = new ArrayList<>();

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
