package hospital_model.cabinet;

import hospital_model.employee.MedicalMan;

/**
 * Implements optometrist cabinet functionality.
 */
public class OptometristCabinet extends CommonMedicalCabinet {
    @Override
    protected String getProcedureDescription() {
        return "operation with patient eyes";
    }
}
