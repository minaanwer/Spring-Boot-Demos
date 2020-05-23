package users.Service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import users.data.UsersRepository;
import users.data.userEntity;
import users.shared.UserDto;

import java.util.UUID;

@Service
public class UsersServiceImp implements  UsersService {



  /*
    @Autowired
    public UsersServiceImp(UsersRepository userrepo , BCryptPasswordEncoder passwordEnc){
        this.usersRepository = userrepo;
        this.bCryptPasswordEncoder = passwordEnc ;
    }
    */

    @Autowired
    UsersRepository usersRepository ;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;



    @Override
    public UserDto CreateUser(UserDto userDetails) {
        userEntity dbUser = new userEntity();
        userDetails.setUserId(UUID.randomUUID().toString());
//"bCryptPasswordEncoder.encode(userDetails.getPassword())"
        userDetails.setEncryptedPassword( bCryptPasswordEncoder.encode(userDetails.getPassword()));
        userDetails.setEncryptedPassword( "ss" );

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT) ;
        dbUser = modelMapper.map(userDetails,userEntity.class) ;

         usersRepository.save(dbUser);
        return  userDetails;
    }
}
