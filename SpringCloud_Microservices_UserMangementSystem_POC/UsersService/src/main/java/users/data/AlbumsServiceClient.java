package users.data;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import users.ui.models.AlbumResponseModel;

import java.util.List;

@FeignClient(name = "albums-ws")
public interface AlbumsServiceClient {

    @GetMapping(path = "/users/{id}/albums")
    public List<AlbumResponseModel> getAlbums(@PathVariable String id );
}
