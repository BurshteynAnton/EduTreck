package antonburshteyn.authentication.service;

import antonburshteyn.authentication.dto.ChangePasswordDto;
import antonburshteyn.authentication.dto.RegisterDto;
import antonburshteyn.authentication.dto.UserDto;
import antonburshteyn.authentication.dto.UserEditDto;

public interface AuthService {
    UserDto register (RegisterDto registerDto);

    UserDto login (String userName, String password);

    UserDto deleteUser (String userName);

    UserDto updateUser(String userName, UserEditDto userEditDto);

    void changePassword(String userName,  String oldPassword, String newPassword);

    UserDto getUserById(String userName);

    Boolean addRole(String userName, String role);

    Boolean deleteRole(String userName, String role);
}
