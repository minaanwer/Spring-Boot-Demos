package fileupload.Service;

import fileupload.Shared.Exceptions.InvalidAttachmentException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileValidationService {

    @Autowired
    Environment environment;

    public void validate(MultipartFile[] files) throws InvalidAttachmentException {

        String Error = "";
        String count = environment.getProperty("uploadedFiles.count");

        if( count!=null && Integer.parseInt(count)>files.length)
            Error+="files count :"+ files.length + "Exceeds max Files Count : "+ count ;

        for (MultipartFile file : files) {
            Error += validate(file);
        }
        if(!Error.equals(""))
        throw new InvalidAttachmentException(Error);

    }

    private String validate (MultipartFile file){
        String Error = "";
        String fileMaxSize = environment.getProperty("uploadedFiles.file.maxSize");
        String fileMinSize = environment.getProperty("uploadedFiles.file.minSize");
        String fileExtension = environment.getProperty("uploadedFiles.file.extensions");

        if(fileMaxSize!=null && file.getSize() > Long.parseLong(fileMaxSize)){
            Error+= "file  : "+ file.getOriginalFilename() + " size Exceeded max size ";
        }

        if(fileMinSize!=null &&    file.getSize() < Long.parseLong(fileMinSize)){
            Error+= "file  : "+ file.getOriginalFilename() + " size less than min size ";
        }
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        if(fileExtension!=null && extension != fileExtension ){
            Error+= "file  : "+ file.getOriginalFilename() + " size less than min size ";
        }
      return Error;
    }
}
