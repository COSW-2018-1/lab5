package edu.eci.cosw.samples.services;

import edu.eci.cosw.jpa.sample.model.Paciente;
import edu.eci.cosw.jpa.sample.model.PacienteId;
import edu.eci.cosw.jpa.sample.model.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // SE QUITO DEL STUB
public class PatientServicesImpl implements PatientServices {


    @Autowired
    PatientsRepository pR;

    /**
     * Obj: consultar un paciente dado su ID y tipo ID
     *
     * @param id
     * @param tipoid
     * @return la instancia del paciente
     * @throws ServicesException si hay un error interno o si
     *                           no existe un paciente con dicho identificador.
     */
    @Override
    public Paciente getPatient(int id, String tipoid) throws ServicesException {
        Paciente paciente = pR.findOne(new PacienteId(id, tipoid));
        return paciente;
    }

    /**
     * Obj: retorna los pacientes que tengan más registradas más de N consultas.
     *
     * @param n - el valor N a ser usado como parámetro en la consulta
     * @return el listao de pacientes que tengan más registradas más de N consultas.
     * @throws ServicesException si se presenta un error interno en la consulta.
     */
    @Override
    public List<Paciente> topPatients(int n) throws ServicesException {
        return pR.topPacientes(n);
    }
}
