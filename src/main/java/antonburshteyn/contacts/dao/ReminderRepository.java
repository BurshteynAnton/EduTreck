package antonburshteyn.contacts.dao;

import antonburshteyn.contacts.model.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface ReminderRepository extends JpaRepository<Reminder, Long> {
}
