package antonburshteyn.authentication.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "UserAccount")
public class UserAccount implements UserDetails {
     @SequenceGenerator(
             name = "user_sequence",
             sequenceName = "user_sequence",
             allocationSize = 1
     )
     @Id
     @GeneratedValue(
             strategy = GenerationType.SEQUENCE,
             generator = "user_sequence"
     )
     private Long id;
     private String userName;
     private String password;
     private String name;
     private String surname;
     private String phoneNumber;
     private String email;

     @ElementCollection(fetch = FetchType.EAGER)
     @Enumerated(EnumType.STRING)
     private Set<Role> roles = new HashSet<>();

     public UserAccount(String userName, String password, String name, String surname,
                        String phoneNumber, String email) {
          this.userName = userName;
          this.password = password;
          this.name = name;
          this.surname = surname;
          this.phoneNumber = phoneNumber;
          this.email = email;
          this.roles.add(Role.USER);
     }

     @Override
     public Collection<? extends GrantedAuthority> getAuthorities() {
          return roles.stream()
                  .map(role -> new SimpleGrantedAuthority(role.name()))
                  .collect(Collectors.toList());
     }

     @Override
     public String getPassword() {
          return password;
     }

     @Override
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
