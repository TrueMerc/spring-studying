package hospital_model.employee;

/**
 * Provides basic functionality for dentists.
 */
public class Dentist implements MedicalMan {
    @Override
    public void doProcedure() {
        System.out.println("Doing procedure with teeth");
    }

    @Override
    public String getProfession() {
        return "Dentist";
    }

    @Override
    public void setProfession() {

    }
}
