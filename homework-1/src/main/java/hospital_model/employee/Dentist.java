package hospital_model.employee;

import org.springframework.stereotype.Component;

/**
 * Provides basic functionality for dentists.
 */
@Component("dentist")
public class Dentist implements MedicalMan {

    @Override
    public void doProcedure() {
        System.out.println("Doing procedure with teeth.");
    }

    @Override
    public String getProfession() {
        return "Dentist";
    }
}
