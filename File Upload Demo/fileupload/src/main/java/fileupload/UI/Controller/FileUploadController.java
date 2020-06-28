package fileupload.UI.Controller;

import fileupload.Service.FileValidationService;
import fileupload.Shared.Exceptions.InvalidAttachmentException;
import fileupload.Shared.Extensions.FileHandler;
import fileupload.UI.Models.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/v1/file")
@CrossOrigin("*")
public class FileUploadController {

    @Autowired
    FileValidationService fileValidationService;
    @Autowired
    Environment environment;

    @GetMapping("/status/check")
    public String GetStatus(){
        return "I'm Ok !";
    }

    @PostMapping("/uploadnormal")
    @ResponseBody
    public String uploadFileNormal(@RequestBody MultipartFile fileKey ) {

        try {
            String  UPLOADED_FOLDER= environment.getProperty("uploadedFiles.folder");
            byte[] bytes = fileKey.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + fileKey.getOriginalFilename());
            Files.write(path, bytes);
            System.out.println("completed successfully ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Succuss";
    }


    @PostMapping("/upload")
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("Info") String Info) {
        System.out.println("Json is" + Info);
        //  if (file.isEmpty()) {
        //      return "No file attached";
        //   }
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String  UPLOADED_FOLDER= environment.getProperty("uploadedFiles.folder");
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception ex)
        {
            return "ex" + ex.getMessage();
        }
        return  "success" ;
    }


    @PostMapping("/uploadLst")
    @ResponseBody
    public ResponseEntity<ResponseModel<?>> uploadMultiFiles(@RequestBody MultipartFile[] files ) throws Exception {

        FileHandler fileHandler = new FileHandler(environment);
        fileValidationService.validate(files);
        fileHandler.Save(files);
        return ResponseEntity.ok().body(new ResponseModel("000","all files Uploaded successfully " , null ));
    }

}
