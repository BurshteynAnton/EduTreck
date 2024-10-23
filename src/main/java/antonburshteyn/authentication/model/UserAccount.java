package antonburshteyn.authentication.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
//@NoArgsConstructor
@EqualsAndHashCode(of = "userName")
@Entity
@Table(name = "UserAccount")
public class UserAccount implements Serializable {

     @Id
     private String userName;
     @Setter
     private String password;
     @Setter
     private String name;
     @Setter
     private String surname;
     @Setter
     private String phoneNumber;
     @Setter
     private String email;

     @ElementCollection(fetch = FetchType.EAGER)
     @Enumerated(EnumType.STRING)
     private Set<Role> roles = new HashSet<>();

     public UserAccount() {
          roles = new HashSet<>();
          roles.add(Role.USER);
     }

     public UserAccount(String userName, String password, String name, String surname,
                        String phoneNumber, String email) {
          this.userName = userName;
          this.password = password;
          this.name = name;
          this.surname = surname;
          this.phoneNumber = phoneNumber;
          this.email = email;
     }


     public String getUsername() {
          return userName;
     }

     public boolean addRole(String role) {
          return roles.add(Role.valueOf(role.toUpperCase()));
     }

     public boolean removeRole(String role) {
          return roles.remove(Role.valueOf(role.toUpperCase()));
     }
}
//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//          return roles.stream()
//                  .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
//                  .collect(Collectors.toList());
//     }

//     @Override
//     public String getPassword() {
//          return password;
//     }
//