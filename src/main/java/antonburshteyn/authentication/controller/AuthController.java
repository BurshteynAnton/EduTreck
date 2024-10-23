package antonburshteyn.authentication.controller;

import antonburshteyn.authentication.dto.*;
import antonburshteyn.authentication.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    final AuthService authService;

    @PostMapping("/register")
    public UserDto register(@RequestBody RegisterDto registerDto) {
        return authService.register(registerDto);
    }

    @PostMapping("/login")
    public UserDto login(@RequestBody LoginDto loginDto) {
        return authService.login(loginDto.getUserName(), loginDto.getPassword());
    }

    @DeleteMapping("/user/{userName}")
    public UserDto deleteUser(@PathVariable String userName) {
        return authService.deleteUser(userName);
    }

    @PutMapping("/user/{userName}")
    public UserDto updateUser(@PathVariable String userName,@RequestBody UserEditDto userEditDto) {
        return authService.updateUser(userName, userEditDto);
    }

    @PutMapping("/password/{userName}")
    public void changePassword(Principal principal, @RequestBody ChangePasswordDto changePasswordDto) {
        authService.changePassword(principal.getName(), changePasswordDto.getOldPassword(), changePasswordDto.getNewPassword());
    }

    @GetMapping("/user/{userName}")
    public UserDto getUserById(@PathVariable String userName) {
        return authService.getUserById(userName);
    }

    @PutMapping("/user/{userName}/role/{role}")
    public Boolean addRole(@PathVariable String userName,@PathVariable String role) {
        return authService.addRole(userName, role);
    }

    @DeleteMapping("/user/{userName}/role/{role}")
    public Boolean deleteRole(@PathVariable String userName,@PathVariable String role) {
        return authService.deleteRole(userName, role);
    }
}
