package hospital_model.employee;

/**
 * Provides basic interface to all
 * medical men employees in a hospital.
 */
public interface MedicalMan {

    /**
     * Executes medical procedure which is specific for each profession.
     */
    void doProcedure();

    /**
     * Returns medical man profession name.
     * @return medical man profession name.
     */
    String getProfession();

}
