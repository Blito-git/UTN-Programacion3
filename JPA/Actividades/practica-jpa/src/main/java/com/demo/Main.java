package com.demo;

import com.demo.entidades.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("practicaJPA");
        EntityManager em = emf.createEntityManager();

        // ===== Persistir datos de prueba =====
        em.getTransaction().begin();

        Medico medico1 = new Medico();
        medico1.setNombre("Carlos");
        medico1.setApellido("Fernandez");
        medico1.setEspecialidad("Clínica Médica");

        Medico medico2 = new Medico();
        medico2.setNombre("Laura");
        medico2.setApellido("Gimenez");
        medico2.setEspecialidad("Pediatría");

        em.persist(medico1);
        em.persist(medico2);

        HistorialClinico historial1 = new HistorialClinico();
        historial1.setDescripcion("Paciente con antecedentes de hipertensión controlada.");

        HistorialClinico historial2 = new HistorialClinico();
        historial2.setDescripcion("Sin antecedentes relevantes.");

        em.persist(historial1);
        em.persist(historial2);

        Paciente paciente1 = new Paciente();
        paciente1.setNombre("Juan");
        paciente1.setApellido("Perez");
        paciente1.setEdad(45);
        paciente1.setObraSocial("OSDE");
        paciente1.setHistorialClinico(historial1);

        Paciente paciente2 = new Paciente();
        paciente2.setNombre("Maria");
        paciente2.setApellido("Lopez");
        paciente2.setEdad(28);
        paciente2.setObraSocial("Swiss Medical");
        paciente2.setHistorialClinico(historial2);

        Paciente paciente3 = new Paciente();
        paciente3.setNombre("Pedro");
        paciente3.setApellido("Rodriguez");
        paciente3.setEdad(60);
        paciente3.setObraSocial("OSDE");

        em.persist(paciente1);
        em.persist(paciente2);
        em.persist(paciente3);

        Medicamento medicamento1 = new Medicamento();
        medicamento1.setNombre("Ibuprofeno");
        medicamento1.setDosis("400mg");

        Medicamento medicamento2 = new Medicamento();
        medicamento2.setNombre("Losartan");
        medicamento2.setDosis("50mg");

        Medicamento medicamento3 = new Medicamento();
        medicamento3.setNombre("Amoxicilina");
        medicamento3.setDosis("500mg");

        em.persist(medicamento1);
        em.persist(medicamento2);
        em.persist(medicamento3);

        paciente1.getMedicamentos().add(medicamento2);
        paciente3.getMedicamentos().add(medicamento2);
        paciente2.getMedicamentos().add(medicamento1);
        paciente2.getMedicamentos().add(medicamento3);

        Consulta consulta1 = new Consulta();
        consulta1.setFecha(LocalDate.of(2024, 2, 10));
        consulta1.setDiagnostico("Hipertensión arterial");
        consulta1.setPaciente(paciente1);
        consulta1.setMedico(medico1);

        Consulta consulta2 = new Consulta();
        consulta2.setFecha(LocalDate.of(2024, 3, 5));
        consulta2.setDiagnostico("Control de rutina");
        consulta2.setPaciente(paciente2);
        consulta2.setMedico(medico2);

        Consulta consulta3 = new Consulta();
        consulta3.setFecha(LocalDate.of(2024, 4, 15));
        consulta3.setDiagnostico("Infección respiratoria");
        consulta3.setPaciente(paciente2);
        consulta3.setMedico(medico1);

        Consulta consulta4 = new Consulta();
        consulta4.setFecha(LocalDate.of(2024, 5, 20));
        consulta4.setDiagnostico("Chequeo cardiológico");
        consulta4.setPaciente(paciente3);
        consulta4.setMedico(medico1);

        em.persist(consulta1);
        em.persist(consulta2);
        em.persist(consulta3);
        em.persist(consulta4);

        em.getTransaction().commit();

        // ===== 1. Listar todos los pacientes mayores de 30 años =====
        System.out.println("\n--- 1. Pacientes mayores de 30 años ---");
        List<Paciente> pacientesMayores30 = em.createQuery(
                "SELECT p FROM Paciente p WHERE p.edad > 30", Paciente.class)
                .getResultList();
        for (Paciente p : pacientesMayores30) {
            System.out.println(p.getNombre() + " " + p.getApellido() + " - " + p.getEdad() + " años");
        }

        // ===== 2. Obtener todas las consultas realizadas por un médico específico =====
        System.out.println("\n--- 2. Consultas del médico " + medico1.getNombre() + " ---");
        List<Consulta> consultasMedico = em.createQuery(
                "SELECT c FROM Consulta c WHERE c.medico = :medico", Consulta.class)
                .setParameter("medico", medico1)
                .getResultList();
        for (Consulta c : consultasMedico) {
            System.out.println(c.getFecha() + " - " + c.getDiagnostico() + " (paciente: " + c.getPaciente().getNombre() + ")");
        }

        // ===== 3. Mostrar todos los medicamentos asociados a un paciente =====
        System.out.println("\n--- 3. Medicamentos de " + paciente2.getNombre() + " ---");
        List<Medicamento> medicamentosPaciente = em.createQuery(
                "SELECT m FROM Paciente p JOIN p.medicamentos m WHERE p = :paciente", Medicamento.class)
                .setParameter("paciente", paciente2)
                .getResultList();
        for (Medicamento m : medicamentosPaciente) {
            System.out.println(m.getNombre() + " - " + m.getDosis());
        }

        // ===== 4. Listar las consultas con su diagnóstico y el nombre del paciente =====
        System.out.println("\n--- 4. Consultas con diagnóstico y paciente ---");
        List<Object[]> consultasConPaciente = em.createQuery(
                "SELECT c.diagnostico, c.paciente.nombre FROM Consulta c", Object[].class)
                .getResultList();
        for (Object[] fila : consultasConPaciente) {
            System.out.println("Diagnóstico: " + fila[0] + " - Paciente: " + fila[1]);
        }

        // ===== 5. Calcular el promedio de edad de los pacientes =====
        System.out.println("\n--- 5. Promedio de edad de los pacientes ---");
        Double promedioEdad = em.createQuery(
                "SELECT AVG(p.edad) FROM Paciente p", Double.class)
                .getSingleResult();
        System.out.println("Promedio: " + promedioEdad);

        // ===== 6. Listar todos los pacientes que tienen una obra social específica =====
        System.out.println("\n--- 6. Pacientes con obra social OSDE ---");
        List<Paciente> pacientesObraSocial = em.createQuery(
                "SELECT p FROM Paciente p WHERE p.obraSocial = :obraSocial", Paciente.class)
                .setParameter("obraSocial", "OSDE")
                .getResultList();
        for (Paciente p : pacientesObraSocial) {
            System.out.println(p.getNombre() + " " + p.getApellido());
        }

        // ===== 7. Mostrar los médicos y la cantidad de consultas que atendieron =====
        System.out.println("\n--- 7. Médicos y cantidad de consultas ---");
        List<Object[]> medicosConsultas = em.createQuery(
                "SELECT m.nombre, COUNT(c) FROM Medico m LEFT JOIN m.consultas c GROUP BY m.nombre", Object[].class)
                .getResultList();
        for (Object[] fila : medicosConsultas) {
            System.out.println(fila[0] + " - " + fila[1] + " consultas");
        }

        // ===== 8. Obtener todos los pacientes junto con la descripción de su historia clínica =====
        System.out.println("\n--- 8. Pacientes con descripción de su historia clínica ---");
        List<Object[]> pacientesHistorial = em.createQuery(
                "SELECT p.nombre, h.descripcion FROM Paciente p LEFT JOIN p.historialClinico h", Object[].class)
                .getResultList();
        for (Object[] fila : pacientesHistorial) {
            System.out.println(fila[0] + " - " + fila[1]);
        }

        em.close();
        emf.close();
    }
}
