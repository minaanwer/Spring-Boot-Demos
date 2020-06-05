package users.shared;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FeignErrorDecoder implements ErrorDecoder {

    @Autowired
   private Environment environment;

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()){
            case 400 :

                break;
            case 404: {
             if(methodKey.contains("getAlbums")) {
                 return new ResponseStatusException(HttpStatus.valueOf(response.status()), environment.getProperty("albums.Exceptions.albums-notFound"));
             }
                return new ResponseStatusException(HttpStatus.valueOf(response.status()), environment.getProperty("albums.Exceptions.albums-notFound") );
            }
            default:
                return new Exception(response.reason());
        }
        return null;

    }
}
