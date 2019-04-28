package hospital_model;

import hospital_model.cabinet.MedicalCabinet;
import hospital_model.cabinet.OptometristCabinet;
import hospital_model.employee.MedicalMan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Provides basic application dependencies injections
 * and inversion of controls configuration.
 */
@Configuration
@ComponentScan("hospital_model")
public class ApplicationConfiguration {

//    @Bean(name = "medicalMan")
//    public MedicalMan medicalMan() {
//        return new Optometrist();
//    }


    @Bean(name = "medicalCabinet")
    public MedicalCabinet medicalCabinet(MedicalMan medicalMan) {
        MedicalCabinet cabinet = new OptometristCabinet();
        cabinet.setMedicalMan(medicalMan);
        return cabinet;
    }
}
