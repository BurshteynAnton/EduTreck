package antonburshteyn.authentication.service;

import antonburshteyn.authentication.dao.UserAccountRepository;
import antonburshteyn.authentication.dto.LoginDto;
import antonburshteyn.authentication.dto.RegisterDto;
import antonburshteyn.authentication.dto.UserDto;
import antonburshteyn.authentication.dto.exceptions.InvalidCredentialsException;
import antonburshteyn.authentication.dto.exceptions.UserExistException;
import antonburshteyn.authentication.dto.exceptions.UserNotFoundException;
import antonburshteyn.authentication.model.Role;
import antonburshteyn.authentication.model.UserAccount;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService, CommandLineRunner {


    final UserAccountRepository userAccountRepository;
    final ModelMapper modelMapper;
    final PasswordEncoder passwordEncoder;

//    @Override
//    public UserDto register(RegisterDto registerDto) {
//        if(userAccountRepository.existsById(registerDto.getUserName())) {
//            throw new UserExistException();
//        }
//        UserAccount userAccount = modelMapper.map(registerDto, UserAccount.class);
//        String password = passwordEncoder.encode(registerDto.getPassword());
//        userAccount.setPassword(password);
//        userAccountRepository.save(userAccount);
//        return modelMapper.map(userAccount, UserDto.class);
//    }
    @Override
    public UserDto register(RegisterDto registerDto) {
        if (userAccountRepository.existsByUserName(registerDto.getUserName())) {
            throw new UserExistException();
        }
        UserAccount userAccount = new UserAccount(registerDto.getUserName(),
                passwordEncoder.encode(registerDto.getPassword()),
                registerDto.getName(),
                registerDto.getSurname(),
                registerDto.getPhoneNumber(),
                registerDto.getEmail());
        userAccountRepository.save(userAccount);
        return modelMapper.map(userAccount, UserDto.class);
    }

    @Override
    public UserDto login(String userName, String password) {
        UserAccount userAccount = userAccountRepository.findByUserName(userName)
                .orElseThrow(UserNotFoundException::new);
        if (!passwordEncoder.matches(password, userAccount.getPassword())) {
            throw new InvalidCredentialsException();
        }else if (!userName.matches(userAccount.getUsername())){
            throw new UserExistException();
        }

        return modelMapper.map(userAccount, UserDto.class);
    }

    @Override
    public UserDto deleteUser(Long userId) {
        UserAccount userAccount = userAccountRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
        userAccountRepository.delete(userAccount);
        return modelMapper.map(userAccount, UserDto.class);
    }

    @Override
    public UserDto updateUser(String userId) {
//        Long id = Long.parseLong(userId);
//        UserAccount userAccount = userAccountRepository.findById(id)
//                .orElseThrow(UserNotFoundException::new);
//        userAccountRepository.delete(userAccount);
//        return modelMapper.map(userAccount, UserAccount.class);
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

    @Override
    public void run(String... args) throws Exception {
        if (!userAccountRepository.existsByUserName("user123")) {
            String password = passwordEncoder.encode("4321");
            UserAccount userAccount = new UserAccount("user123", password, "", "", "", "user123@example.com");
            userAccount.addRole(Role.MODERATOR.name());
            userAccount.addRole(Role.ADMINISTRATOR.name());
            userAccountRepository.save(userAccount);
        }

    }
}
