package edu.eci.cosw.samples;


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
    public void testTopPatients() throws ServicesException {
        // datos 1
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


    }

        
	@Test
	public void contextLoads() {
	}
        
    @Test
    public void patientLoadTest(){

    }

}
