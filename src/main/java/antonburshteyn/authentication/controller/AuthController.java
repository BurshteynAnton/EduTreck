package antonburshteyn.authentication.controller;

import antonburshteyn.authentication.dto.LoginDto;
import antonburshteyn.authentication.dto.RegisterDto;
import antonburshteyn.authentication.dto.UserDto;
import antonburshteyn.authentication.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
        return authService.login(loginDto.getUsername(), loginDto.getPassword());
    }

    @DeleteMapping("/user/{userId}")
    public UserDto deleteUser(@PathVariable Long userId) {
        return authService.deleteUser(userId);
    }

    @PutMapping("/user/{userId}")
    public UserDto updateUser(@PathVariable String userId) {
        return authService.updateUser(userId);
    }

    @GetMapping("/password")
    public RegisterDto changePassword(String password) {
        return authService.changePassword(password);
    }

    @GetMapping("/user/{userId}")
    public UserDto getUserById(@PathVariable String userId) {
        return authService.getUserById(userId);
    }

    @PutMapping("/user/{user}/role/{role}")
    public Boolean addRole(@PathVariable String user,@PathVariable String role) {
        return authService.addRole(user, role);
    }

    @DeleteMapping("/user/{user}/role/{role}")
    public Boolean deleteRole(String user, String role) {
        return authService.deleteRole(user, role);
    }
}
