package hospital_model.cabinet;

import hospital_model.employee.MedicalMan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Implements dentist cabinet functionality.
 */
@Component("medicalCabinet")
public class DentistCabinet implements MedicalCabinet {

    private MedicalMan medicalMan;

    @Override
    public void doProcedure() {
        medicalMan.doProcedure();
        System.out.println("Dr. " + medicalMan.getProfession() + " has made operation with patient teeth.");
    }

    @Override
    public MedicalMan getMedicalMan() {
        return medicalMan;
    }


    @Override
    @Autowired(required = false)
    @Qualifier("Dentist")
    public void setMedicalMan(MedicalMan medic) {
        this.medicalMan = medic;
    }
}
