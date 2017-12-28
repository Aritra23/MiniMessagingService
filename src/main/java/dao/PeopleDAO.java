/**
 * 
 */
package dao;
import java.util.List;
import model.People;
import model.Followers;
/**
 * @author Aritra
 *
 */
public interface PeopleDAO {
	int follow(int follower_id);
	int unfollow(int follower_id);
	List<People> listAllUsers();
	List<Followers> listUsersWithMostPopularFollower();
	int getId();
	boolean isFollower(int follower_id);

}
