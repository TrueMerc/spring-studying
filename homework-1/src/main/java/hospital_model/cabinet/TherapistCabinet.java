package hospital_model.cabinet;

import hospital_model.employee.MedicalMan;

/**
 * Provides functionality for therapist cabinet.
 */
public class TherapistCabinet extends CommonMedicalCabinet {
    @Override
    protected String getProcedureDescription() {
        return "preliminary examination of patient";
    }
}
