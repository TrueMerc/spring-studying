package hospital_model.cabinet;

import hospital_model.employee.MedicalMan;

/**
 * Provides functionality for common (non specialized) medical cabinet.
 */
public class CommonMedicalCabinet implements MedicalCabinet {

    private MedicalMan medicalMan;

    @Override
    public void doProcedure() {
        medicalMan.doProcedure();
        System.out.println("Dr. " + medicalMan.getProfession() + " has made preliminary examination of patient.");
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
