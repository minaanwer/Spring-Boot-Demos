package fileupload;

import fileupload.Service.FileValidationService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


    @SpringBootTest
    @ActiveProfiles("test")
    @RunWith(SpringJUnit4ClassRunner.class)
    public class MockitoDemoApplicationTests {

        @Autowired
        private FileValidationService fileValidationService;

        @Test
        public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
            //Mockito.when(fileValidationService.validate()).thenReturn("Mock Product Name");
           // Assert.assertEquals("Mock Product Name", testName);
        }
    }


