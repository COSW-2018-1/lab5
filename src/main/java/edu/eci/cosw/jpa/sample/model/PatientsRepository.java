package edu.eci.cosw.jpa.sample.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientsRepository extends JpaRepository<Paciente, PacienteId> {
}
