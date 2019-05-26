package hospital_model.configuration;

import hospital_model.cabinet.DentistCabinet;
import hospital_model.cabinet.MedicalCabinet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("hospital_model")
public class AutowiredConfiguration {

    @Bean(name = "medicalCabinet")
    public MedicalCabinet getMedicalCabinet() {
        return new DentistCabinet();
    }
}
