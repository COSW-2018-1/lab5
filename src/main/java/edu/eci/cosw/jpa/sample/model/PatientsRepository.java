package edu.eci.cosw.jpa.sample.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PatientsRepository extends JpaRepository<Paciente, PacienteId> {

    @Query("FROM Paciente p WHERE size(p.consultas)>= :top")
    List<Paciente> topPacientes(@Param(value = "top") int top1);
}
