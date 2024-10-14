package antonburshteyn.authentication.service;

import antonburshteyn.authentication.dto.RegisterDto;
import antonburshteyn.authentication.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    @Override
    public Boolean register(RegisterDto registerDto) {
        return null;
    }

    @Override
    public UserDto login(String login) {
        return null;
    }

    @Override
    public UserDto deleteUser(String userId) {
        return null;
    }

    @Override
    public UserDto updateUser(String userId) {
        return null;
    }

    @Override
    public RegisterDto changePassword(String password) {
        return null;
    }

    @Override
    public UserDto getUserById(String userId) {
        return null;
    }

    @Override
    public Boolean addRole(String user, String role) {
        return null;
    }

    @Override
    public Boolean deleteRole(String user, String role) {
        return null;
    }
}
