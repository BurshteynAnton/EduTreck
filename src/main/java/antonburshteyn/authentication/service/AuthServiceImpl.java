package antonburshteyn.authentication.service;

import antonburshteyn.authentication.dao.UserAccountRepository;
import antonburshteyn.authentication.dto.RegisterDto;
import antonburshteyn.authentication.dto.UserDto;
import antonburshteyn.authentication.dto.exceptions.UserExistException;
import antonburshteyn.authentication.model.UserAccount;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{


    final UserAccountRepository userAccountRepository;
    final ModelMapper modelMapper;
    final PasswordEncoder passwordEncoder;

    @Override
    public UserDto register(RegisterDto registerDto) {
        if(userAccountRepository.existsById(registerDto.getEmail())) {
            throw new UserExistException();
        }
        UserAccount userAccount = modelMapper.map(registerDto, UserAccount.class);
        String password = passwordEncoder.encode(registerDto.getPassword());
        userAccount.setPassword(password);
        userAccountRepository.save(userAccount);
        return modelMapper.map(userAccount, UserDto.class);
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
