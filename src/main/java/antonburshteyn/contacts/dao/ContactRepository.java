package antonburshteyn.contacts.dao;

import antonburshteyn.contacts.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public interface ContactRepository extends JpaRepository<Contact, Long> {

    Optional<Contact> findByEmail(String email);

    List<Contact> findByName(String name);

    List<Contact> findBySurname(String surname);

    boolean existsByName(String name);

    List<Contact> findByStatus (String status);
}
