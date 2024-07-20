package papa_hant.first.server.routes.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import papa_hant.first.server.routes.user.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByPhone(String phone);
}
