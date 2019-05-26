package hospital_model.configuration;

import hospital_model.cabinet.MedicalCabinet;
import hospital_model.cabinet.OptometristCabinet;
import hospital_model.employee.MedicalMan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Provides basic application dependencies injections
 * and inversion of controls configuration.
 */
@Configuration
@ComponentScan("hospital_model")
public class JavaConfigConfiguration {

    @Bean(name = "medicalCabinet")
    public MedicalCabinet getMedicalCabinet(@Qualifier("optometrist") MedicalMan medicalMan) {
        MedicalCabinet cabinet = new OptometristCabinet();
        cabinet.setMedicalMan(medicalMan);
        return cabinet;
    }
}
