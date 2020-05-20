package users.Service;

import users.shared.UserDto;

import java.util.UUID;

public class UsersServiceImp implements  UsersService {


    @Override
    public UserDto CreateUser(UserDto user) {
        UserDto mappedUser = new UserDto() ;
        mappedUser.setUserId(UUID.randomUUID().toString());
        return  mappedUser;
    }
}
