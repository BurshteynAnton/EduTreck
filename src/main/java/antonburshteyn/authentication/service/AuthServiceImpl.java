package antonburshteyn.authentication.service;

import antonburshteyn.authentication.dao.UserAccountRepository;
import antonburshteyn.authentication.dto.RegisterDto;
import antonburshteyn.authentication.dto.UserDto;
import antonburshteyn.authentication.dto.UserEditDto;
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
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService, CommandLineRunner {

    final UserAccountRepository userAccountRepository;
    final ModelMapper modelMapper;
    final PasswordEncoder passwordEncoder;

    @Transactional
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
        }

        return modelMapper.map(userAccount, UserDto.class);
    }

    @Transactional
    @Override
    public UserDto deleteUser(String userName) {
        UserAccount userAccount = userAccountRepository.findByUserName(userName)
                .orElseThrow(UserNotFoundException::new);
        userAccountRepository.delete(userAccount);
        return modelMapper.map(userAccount, UserDto.class);
    }

    @Transactional
    @Override
    public UserDto updateUser(String userName, UserEditDto userEditDto) {
        UserAccount userAccount = userAccountRepository.findByUserName(userName)
                .orElseThrow(UserNotFoundException::new);

        if (userEditDto.getName() != null && !userEditDto.getName().equals(userAccount.getName())) {
            userAccount.setName(userEditDto.getName());
        }
        if (userEditDto.getSurname() != null && !userEditDto.getSurname().equals(userAccount.getSurname())) {
            userAccount.setSurname(userEditDto.getSurname());
        }
        if (userEditDto.getPhoneNumber() != null && !userEditDto.getPhoneNumber().equals(userAccount.getPhoneNumber())) {
            userAccount.setPhoneNumber(userEditDto.getPhoneNumber());
        }
        if (userEditDto.getEmail() != null && !userEditDto.getEmail().equals(userAccount.getEmail())) {
            userAccount.setEmail(userEditDto.getEmail());
        }

        userAccountRepository.save(userAccount);
        return modelMapper.map(userAccount, UserDto.class);
    }

    @Transactional
    @Override
    public void changePassword(String userName, String oldPassword, String newPassword) {
        UserAccount userAccount = userAccountRepository.findByUserName(userName)
                .orElseThrow(UserNotFoundException::new);
        if (!passwordEncoder.matches(oldPassword, userAccount.getPassword())) {
            throw new InvalidCredentialsException();
        }
        String encodedNewPassword = passwordEncoder.encode(newPassword);
        userAccount.setPassword(encodedNewPassword);
        userAccountRepository.save(userAccount);
    }

    @Override
    public UserDto getUserById(String userName) {
        UserAccount userAccount = userAccountRepository.findByUserName(userName)
                .orElseThrow(UserNotFoundException::new);
        return modelMapper.map(userAccount, UserDto.class);
    }

    @Transactional
    @Override
    public Boolean addRole(String userName, String role) {
        UserAccount userAccount = userAccountRepository.findByUserName(userName)
                .orElseThrow(UserNotFoundException::new);
        boolean roleAdded = userAccount.addRole(role);
        if (roleAdded) {
            userAccountRepository.save(userAccount);
        }
        return roleAdded;
    }

    @Transactional
    @Override
    public Boolean deleteRole(String userName, String role) {
        UserAccount userAccount = userAccountRepository.findByUserName(userName)
                .orElseThrow(UserNotFoundException::new);
        boolean removedRole = userAccount.removeRole(role);
        if (removedRole) {
            userAccountRepository.save(userAccount);
        }
        return removedRole;
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
