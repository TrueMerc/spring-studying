package hospital_model;

import hospital_model.cabinet.MedicalCabinet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class for patient.
 */
public class Patient
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext( "config.xml");
        MedicalCabinet cabinet = context.getBean("medicalCabinet", MedicalCabinet.class);
        cabinet.doProcedure();
    }
}
