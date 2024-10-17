package antonburshteyn.authentication.service;

import antonburshteyn.authentication.dto.RegisterDto;
import antonburshteyn.authentication.dto.UserDto;

public interface AuthService {
    UserDto register (RegisterDto registerDto);

    UserDto login (String userName, String password);

    UserDto deleteUser (Long userId);

    UserDto updateUser(String userId);

    RegisterDto changePassword(String password);

    UserDto getUserById(String userId);

    Boolean addRole(String user, String role);

    Boolean deleteRole(String user, String role);
}
