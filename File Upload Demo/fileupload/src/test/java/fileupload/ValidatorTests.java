package fileupload;


import fileupload.Service.FileValidationService;
import fileupload.Shared.Exceptions.InvalidAttachmentException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration

public class ValidatorTests {

    @Autowired
    private FileValidationService fileValidationService;

    @Test
    public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() throws InvalidAttachmentException {
        FileValidationService fileValidationService = new FileValidationService();
        fileValidationService.validate(null);
        Assert.assertEquals("", "");

    }
}
