package hospital_model.employee;

/**
 * Provides basic functionality for therapists.
 */
public class Therapist implements MedicalMan {
    @Override
    public void doProcedure() {
        System.out.println("Doing general examination.");
    }

    @Override
    public String getProfession() {
        return "Therapist";
    }
}
