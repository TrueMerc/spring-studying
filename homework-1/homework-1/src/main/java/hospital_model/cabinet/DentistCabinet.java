package hospital_model.cabinet;

import hospital_model.employee.MedicalMan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Implements dentist cabinet functionality.
 */
@Component("medicalCabinet")
public class DentistCabinet extends CommonMedicalCabinet {

    @Override
    @Autowired(required = false)
    @Qualifier("dentist")
    public void setMedicalMan(MedicalMan medic) {
        super.setMedicalMan(medic);
    }

    @Override
    protected String getProcedureDescription() {
        return "procedure with patient teeth";
    }
}
