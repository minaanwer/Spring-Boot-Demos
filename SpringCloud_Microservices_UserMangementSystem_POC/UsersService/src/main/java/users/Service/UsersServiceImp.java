package users.Service;

import feign.FeignException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import users.data.AlbumsServiceClient;
import users.data.UsersRepository;
import users.data.userEntity;
import users.shared.UserDto;
import users.ui.models.AlbumResponseModel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UsersServiceImp implements  UsersService {


    Logger logger = LoggerFactory.getLogger(this.getClass());


/*
    @Autowired
    public UsersServiceImp(UsersRepository userrepo , BCryptPasswordEncoder passwordEnc){
        this.usersRepository = userrepo;
        this.bCryptPasswordEncoder = passwordEnc ;
    }
    */


    @Autowired

    private AlbumsServiceClient albumsServiceClient;

    @Autowired
    UsersRepository usersRepository ;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;



    @Override
    public UserDto CreateUser(UserDto userDetails) {
        userEntity dbUser = new userEntity();
        userDetails.setUserId(UUID.randomUUID().toString());
//"bCryptPasswordEncoder.encode(userDetails.getPassword())"
        userDetails.setEncryptedPassword( bCryptPasswordEncoder.encode(userDetails.getPassword()));
        //userDetails.setEncryptedPassword( "ss" );

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT) ;
        dbUser = modelMapper.map(userDetails,userEntity.class) ;

        usersRepository.save(dbUser);
        return  userDetails;
    }



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        userEntity userEntity =  usersRepository.findByEmail(s);
        if (userEntity == null  ) throw  new UsernameNotFoundException(s) ;
        return new User(userEntity.getEmail(),userEntity.getEncryptedPassword(),true,true , true,true , new ArrayList<>()) ;
    }

    @Override
    public UserDto getUserDetailsByEmail(String email) {
        userEntity userEntity =  usersRepository.findByEmail(email);
        if (userEntity == null  ) throw  new UsernameNotFoundException(email) ;
        return  new ModelMapper().map(userEntity,UserDto.class);
    }

    @Override
    public UserDto getUserByUserId(String userId) {

        userEntity userEntity  = usersRepository.findByuserId(userId);
        if(userEntity == null)
            throw  new UsernameNotFoundException("user not found  ya Monna") ;

        UserDto userDto = new ModelMapper().map(userEntity,UserDto.class);
        //use RestTemplate
        /*
        String albumsUrl = String.format("http://ALBUMS-WS/users/%s/albums",userId)  ;
        ResponseEntity<List<AlbumResponseModel>> albumsListResponse =
                restTemplate.exchange(albumsUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<AlbumResponseModel>>() {
                });
        List<AlbumResponseModel> albumsList =  albumsListResponse.getBody();

        userDto.setAlbums(albumsList);
         */
        List<AlbumResponseModel> albums =null;
           logger.debug("before service run");
            albums =   albumsServiceClient.getAlbums(userId);
            logger.debug("after service run");


        userDto.setAlbums(albums);
        return userDto;
    }

}
