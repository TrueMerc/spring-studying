package hospital_model;

import hospital_model.cabinet.MedicalCabinet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class for patient.
 */
public class Patient
{
    public static void main( String[] args )
    {
        useXmlConfiguration();
        useJavaConfigConfiguration();
        useAutowiredConfiguration();
    }

    private static void useXmlConfiguration() {
        ApplicationContext context = new ClassPathXmlApplicationContext( "config.xml");
        MedicalCabinet cabinet = context.getBean("medicalCabinet", MedicalCabinet.class);
        cabinet.doProcedure();
    }

    private static void useJavaConfigConfiguration() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        MedicalCabinet cabinet = context.getBean( "medicalCabinet", MedicalCabinet.class);
        cabinet.doProcedure();
    }

    private static void useAutowiredConfiguration() {

    }
}
