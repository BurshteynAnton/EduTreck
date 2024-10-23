package antonburshteyn.authentication.dao;

import antonburshteyn.authentication.model.UserAccount;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserAccountRepository extends JpaRepository<UserAccount, String> {

    Optional<UserAccount> findByUserName(String userName);

    boolean existsByUserName(String userName);
}
