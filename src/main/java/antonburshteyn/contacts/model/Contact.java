package antonburshteyn.contacts.model;

import antonburshteyn.contacts.dto.AddCommentToContactDto;
import antonburshteyn.contacts.dto.ReminderDto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "Contacts")
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String surname;
    @Column(nullable = false)
    String phoneNumber;
    @Column(nullable = false, unique = true)
    String email;
    String place;
    String course;
    String source;
    String status;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    @Singular
    List<Comment> comments;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    @Singular
    List<Reminder> reminders;

}
