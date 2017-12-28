/**
 * 
 */
package dao;
import java.util.List;
import model.Followers;
/**
 * @author Aritra
 *
 */
public interface FollowersDAO {
	
	List<Followers> listAllFollowers();
	List<Followers> listAllFollowing();

}
