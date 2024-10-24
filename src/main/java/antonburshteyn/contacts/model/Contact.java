package antonburshteyn.contacts.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Column(nullable = false)
    boolean archived;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    @Singular
    Map<String, Comment> comments = new HashMap<>();

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    @Singular
    Map<String, Reminder> reminders;

    public boolean isArchived() {
        return archived;
    }

    public void archive() {
        this.archived = true;
    }
    public void unarchive() {
        this.archived = false;
    }
}
