package antonburshteyn.authentication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    String userName;
    String password;
    String name;
    String surname;
    String phoneNumber;
    //@Email
    String email;
}
