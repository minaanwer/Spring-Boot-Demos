package users.Service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import users.data.UsersRepository;
import users.data.userEntity;
import users.shared.UserDto;

import java.util.ArrayList;
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

}
