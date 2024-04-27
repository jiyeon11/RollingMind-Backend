package RollingRolling.RollingMindBackend.repository.friendslist;

import RollingRolling.RollingMindBackend.domain.friendslist.FriendsList;
import RollingRolling.RollingMindBackend.domain.friendslist.FriendsListSituation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FriendsListRepository extends JpaRepository<FriendsList, Long> {
    @Query("SELECT f.fromUser FROM FriendsList f WHERE f.toUser = :memberNum AND f.situation = :situation")
    List<Integer> findFromUserByToUserAndSituation(@Param("memberNum")int memberNum, @Param("situation")FriendsListSituation situation);
}
