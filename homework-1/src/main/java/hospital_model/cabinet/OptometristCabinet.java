package hospital_model.cabinet;

import hospital_model.employee.MedicalMan;

/**
 * Implements optometrist cabinet functionality.
 */
public class OptometristCabinet implements MedicalCabinet {

    private MedicalMan medicalMan;

    @Override
    public void doProcedure() {
        medicalMan.doProcedure();
        System.out.println("Dr. " + medicalMan.getProfession() + " has made operation with patient eyes.");
    }

    @Override
    public MedicalMan getMedicalMan() {
        return medicalMan;
    }

    @Override
    public void setMedicalMan(MedicalMan medic) {
        this.medicalMan = medic;
    }
}
