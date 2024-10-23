package antonburshteyn.contacts.dao;

import antonburshteyn.contacts.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
