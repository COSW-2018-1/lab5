package edu.eci.cosw.samples;


import edu.eci.cosw.jpa.sample.model.Consulta;
import edu.eci.cosw.jpa.sample.model.Paciente;
import edu.eci.cosw.jpa.sample.model.PacienteId;
import edu.eci.cosw.jpa.sample.model.PatientsRepository;
import edu.eci.cosw.samples.services.PatientServices;
import edu.eci.cosw.samples.services.ServicesException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import javax.validation.constraints.AssertTrue;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringDataRestApiApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class SpringDataRestApiApplicationTests {

    @Autowired
    PatientServices services;

    @Autowired
    PatientsRepository pR;

    @Test
    public void getPatientSIexiste() throws ServicesException {
        int ccID = 2095112;
        String typeID = "cc";
        String nombre = "sergio";
        Date date = new Date();

        Paciente paciente = new Paciente(new PacienteId(ccID,typeID),nombre,date);

        pR.save(paciente);

        Paciente pacienteVS = services.getPatient(ccID,typeID);

        assertEquals(ccID,pacienteVS.getId());
        assertEquals(nombre,pacienteVS.getNombre());

    }

    @Test
    public void getPatientNOexiste() throws ServicesException {
        int ccID = 2095112;
        String typeID = "cc";
        String nombre = "sergio";
        Date date = new Date();

        Paciente paciente = new Paciente(new PacienteId(ccID,typeID),nombre,date);

        pR.save(paciente);


        try{
            Paciente pacienteVS = services.getPatient(123456001,typeID);

        }catch (ServicesException ex){
            assertTrue(false);

        }

    }

    @Test
    public void testTopPatientsNoExistenConNoMas() throws ServicesException {
        int ccID = 2095112;
        String typeID = "cc";
        String nombre = "sergio";
        Date date = new Date();
        String resumen = "resumen consulta 1";
        Set<Consulta> consultas = new HashSet<>(0);
        consultas.add(new Consulta(date,resumen));

        Paciente paciente = new Paciente(new PacienteId(ccID,typeID),nombre,date, consultas);

        pR.save(paciente);

        assertEquals(0, services.topPatients(2).size());

        /*
         datos 1

        int ccID = 2095112;
        String typeID = "cc";
        String nombre = "sergio";
        Date date = new Date();

        Paciente paciente = new Paciente(new PacienteId(ccID,typeID),nombre,date);

        // datos 1
        int ccID1 = 20951121;
        String typeID1 = "cc";
        String nombre1 = "sergio1";

        Paciente paciente1 = new Paciente(new PacienteId(ccID,typeID),nombre,date);

        // datos 2
        int ccID2 = 20951122;
        String typeID2 = "cc";
        String nombre2 = "sergio2";

        Paciente paciente2 = new Paciente(new PacienteId(ccID,typeID),nombre,date);


        // datos 3
        int ccID3 = 2095112;
        String typeID3 = "cc3";
        String nombre3 = "sergi3";

        Paciente paciente3 = new Paciente(new PacienteId(ccID,typeID),nombre,date);



        // datos 4
        int ccID4 = 20951124;
        String typeID4 = "cc";
        String nombre4 = "sergio4";

        Paciente paciente4 = new Paciente(new PacienteId(ccID,typeID),nombre,date);




        // gaurdar
        pR.save(paciente);
        pR.save(paciente1);
        pR.save(paciente2);
        pR.save(paciente3);
        pR.save(paciente4);

        */

    }

    @Test
    public void testTopPatientsOKdosPacientes() throws ServicesException {
        // SIN CONSULTAS
        int ccID = 2095112;
        String typeID = "cc";
        String nombre = "sergio";
        Date date = new Date();


        Paciente paciente = new Paciente(new PacienteId(ccID,typeID),nombre,date);

        pR.save(paciente);

        // CON UNA CONSULTA
        int ccID1 = 20951121;
        String nombre1 = "sergio1";
        String resumen1 = "resumen consulta 2";
        Set<Consulta> consultas1 = new HashSet<>(0);
        consultas1.add(new Consulta(date,resumen1));

        Paciente paciente1 = new Paciente(new PacienteId(ccID1,typeID),nombre1,date, consultas1);

        pR.save(paciente1);


        // CON DOS CONSULTAS
        int ccID3 = 20951122;
        String nombre3 = "sergio2";
        String resumen3 = "resumen consulta 3";
        Set<Consulta> consultas3 = new HashSet<>(0);
        consultas3.add(new Consulta(date,resumen3+"Y OTRO1"));
        consultas3.add(new Consulta(date,resumen3+"Y OTRO2"));

        Paciente paciente3 = new Paciente(new PacienteId(ccID3,typeID),nombre3,date, consultas3);

        pR.save(paciente3);


        //assertEquals(2, services.topPatients(1).size());

        List<Paciente> pacientes = services.topPatients(2);

        assertEquals(pacientes.get(0).getId().equals(ccID) || pacientes.get(0).getId().equals(ccID1) , pacientes.get(1).getId().equals(ccID) || pacientes.get(1).getId().equals(ccID1)  );


    }


	@Test
	public void contextLoads() {
	}
        
    @Test
    public void patientLoadTest(){

    }

}
