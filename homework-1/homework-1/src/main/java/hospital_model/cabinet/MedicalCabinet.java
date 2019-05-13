package hospital_model.cabinet;

import hospital_model.employee.MedicalMan;

/**
 * Provides basic interface to all
 * medical cabinets in a hospital.
 */
public interface MedicalCabinet {
    void doProcedure();

    MedicalMan getMedicalMan();

    void setMedicalMan(final MedicalMan medic);
}
