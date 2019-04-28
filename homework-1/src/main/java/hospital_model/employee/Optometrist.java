package hospital_model.employee;

import org.springframework.stereotype.Component;

/**
 * Provides basic functionality for optometrists.
 */
@Component("medicalMan")
public class Optometrist implements MedicalMan {

    private static final String PROFESSION = "Optometrist";

    @Override
    public String getProfession() {
        return PROFESSION;
    }

    @Override
    public void setProfession() {

    }

    @Override
    public void doProcedure() {
        System.out.println("Doing procedure with eyes");
    }
}
