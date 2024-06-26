package RollingRolling.RollingMindBackend.repository.user;

import RollingRolling.RollingMindBackend.domain.participant.ParticipantStatus;
import RollingRolling.RollingMindBackend.domain.user.Login;
import RollingRolling.RollingMindBackend.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, String>{
    List<User> findAllByIdIn(List<Integer> id);

    Optional<User> findByUserId(String userId);

    Optional<User> findByEmail(String email);
    @Query("SELECT u.name, u.nickname, u.id FROM User u WHERE u.nickname= :nickname")
    List<String> findByNameAndNicknameAndId(@Param("nickname") String nickname);
}
