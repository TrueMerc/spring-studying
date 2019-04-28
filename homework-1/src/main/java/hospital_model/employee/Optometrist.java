package hospital_model.employee;

/**
 * Provides basic functionality for optometrists.
 */
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
