package users.Service;

import org.springframework.security.core.userdetails.UserDetailsService;
import users.shared.UserDto;

public interface UsersService  extends UserDetailsService {

    UserDto CreateUser (UserDto user) ;
    UserDto getUserDetailsByEmail (String email) ;
    UserDto getUserByUserId(String userId) ;

}
