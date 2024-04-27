package RollingRolling.RollingMindBackend.service.friendslist;

import RollingRolling.RollingMindBackend.domain.friendslist.FriendsListSituation;
import RollingRolling.RollingMindBackend.domain.user.User;
import RollingRolling.RollingMindBackend.repository.friendslist.FriendsListRepository;
import RollingRolling.RollingMindBackend.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FriendsListService {
    private final FriendsListRepository friendsListRepository;
    private final UserRepository userRepository;

    public List<User> findFriendsList(int memberNum){  //친구 목록 조회
        List<Integer> friendsIdList = friendsListRepository.findFromUserByToUserAndSituation(memberNum, FriendsListSituation.FRIEND);  //situation이 FRIEND인 fromUser 가져옴

        return userRepository.findAllByMemberNumIn(friendsIdList);
    }
}