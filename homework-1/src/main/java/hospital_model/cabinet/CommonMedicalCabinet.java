package hospital_model.cabinet;

import hospital_model.employee.MedicalMan;

/**
 * Provides common implementation of 'MedicalCabinet' interface.
 */
public class CommonMedicalCabinet implements MedicalCabinet {

    protected MedicalMan medicalMan;

    @Override
    public void doProcedure() {
        medicalMan.doProcedure();
        System.out.println(medicalMan.getProfession() + " has made " + getProcedureDescription() + ".");
    }

    @Override
    public MedicalMan getMedicalMan() {
        return medicalMan;
    }

    @Override
    public void setMedicalMan(MedicalMan medic) {
        this.medicalMan = medic;
    }

    protected String getProcedureDescription() {
        return "nothing";
    }
}
