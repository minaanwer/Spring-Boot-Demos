package fileupload;

import fileupload.Service.FileValidationService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class FileValidationServiceConfiguration {
    @Bean
    @Primary
    public FileValidationService productService() {
        return Mockito.mock(FileValidationService.class);
    }
}