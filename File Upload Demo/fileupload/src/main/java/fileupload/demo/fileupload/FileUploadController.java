package fileupload.demo.fileupload;

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
    private static String UPLOADED_FOLDER = "c://temp//";
    @GetMapping("/status/check")
    public String GetStatus(){
        return "I'm Ok !";
    }

    @PostMapping("/uploadnormal")
    @ResponseBody
    public String uploadFileNormal(@RequestBody MultipartFile fileKey ) {

        try {

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
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Succuss";
    }


    @PostMapping("/uploadLst")
    @ResponseBody
    public String uploadMultiFiles(@RequestBody MultipartFile[] files ) {

        try {

            for (MultipartFile item:files ) {
                System.out.println("file" + item.getOriginalFilename());
                byte[] bytes = item.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + item.getOriginalFilename());
                Files.write(path, bytes);
            }

            System.out.println("completed successfully ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Succuss";
    }





}
