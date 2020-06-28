package fileupload.Shared.Extensions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {

    Environment environment ;

    public FileHandler(Environment env) {
        environment =env ;
    }

    public void Save(MultipartFile[] files){
        String  UPLOADED_FOLDER= environment.getProperty("uploadedFiles.folder");
        try {
            for (MultipartFile item:files ) {
                System.out.println("file" + item.getOriginalFilename());
                byte[] bytes = item.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + item.getOriginalFilename());
                Files.write(path, bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
