package hospital_model;

import hospital_model.cabinet.MedicalCabinet;
import hospital_model.configuration.AutowiredConfiguration;
import hospital_model.configuration.JavaConfigConfiguration;
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
        System.out.println();
        useJavaConfigConfiguration();
        System.out.println();
        useAutowiredConfiguration();
    }

    private static void useXmlConfiguration() {
        ApplicationContext context = new ClassPathXmlApplicationContext( "config.xml");
        MedicalCabinet cabinet = context.getBean("medicalCabinet", MedicalCabinet.class);
        cabinet.doProcedure();
    }

    private static void useJavaConfigConfiguration() {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfigConfiguration.class);
        MedicalCabinet cabinet = context.getBean( "medicalCabinet", MedicalCabinet.class);
        cabinet.doProcedure();
    }

    private static void useAutowiredConfiguration() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AutowiredConfiguration.class);
        MedicalCabinet cabinet = context.getBean( "medicalCabinet", MedicalCabinet.class);
        cabinet.doProcedure();
    }
}
