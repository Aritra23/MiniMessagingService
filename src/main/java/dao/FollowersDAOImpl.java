/**
 * 
 */
package dao;

/**
 * @author Aritra
 *
 */
import dao.PeopleDAO;
import dao.FollowersDAO;
import model.People;
import model.Followers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Qualifier;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FollowersDAOImpl implements FollowersDAO{
	
	private DataSource myDataSource;  // DataSource instance
	private NamedParameterJdbcTemplate myJDBCTemplate; // Database instance

	/**
	* Constructor Function to initialize beans
	* @author Aritra
	* @param myDataSource Parameter to initialize the datasource.
	*/
	@Autowired
	public FollowersDAOImpl(DataSource myDataSource) {
		this.myDataSource = myDataSource;
		this.myJDBCTemplate = new NamedParameterJdbcTemplate(myDataSource);
	}

	
	/**
	* RowMapper that maps data from the Follower SQL table into Followers objects.
	* @author Aritra
	*/
	
	
	/**
	* Function that lists all the users that the current user is following.
	* @author Aritra
	* @return List of all users being followed by the current user.
	*/
	
	public List<Followers> listAllFollowers() {
		int follower_id = getId();
		Map<String,Object> parameters = new HashMap<String,Object>();
		parameters.put("follower_id",follower_id);
		String sqlquery = "SELECT person_id, follower_person_id FROM followers WHERE follower_person_id = :follower_id ORDER BY person_id";
		List<Followers> result = myJDBCTemplate.query(sqlquery,parameters,new FollowersRowMapper());
		return result;
	}

	/**
	* Function that lists all the users that are following the current user.
	* @author Aritra
	* @return List of all users following the current user.
	*/
	
	public List<Followers> listAllFollowing() {
		int user_id = getId();
		Map<String,Object> parameters = new HashMap<String,Object>();
		parameters.put("user_id",user_id);
		String sqlquery = "SELECT person_id, follower_person_id FROM followers WHERE person_id = :user_id ORDER BY follower_person_id";
		List<Followers> result = myJDBCTemplate.query(sqlquery,parameters,new FollowersRowMapper());
		return result;
	}
	
	/**
	* Function that returns the ID of the current user.
	* @author Aritra
	* @return ID of current user.
	*/
	public int getId() {
		String aux;

		//Below block returns the username of the current user as a string
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails)
			aux = ((UserDetails)principal).getUsername();
		else
			aux = principal.toString();
		
		Map<String,Object> parameters = new HashMap<String,Object>();
		parameters.put("handle",aux);
		String sqlquery = "SELECT id FROM people WHERE handle = :handle";
		int Id = myJDBCTemplate.queryForObject(sqlquery,parameters,Integer.class);
		return Id;
			
   }

}
class FollowersRowMapper implements RowMapper<Followers>
{ 
	public Followers mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Followers f = new Followers();
		f.setUserId(rs.getInt("person_id"));
		f.setFollowerUserId(rs.getInt("follower_person_id"));
		return f;
	}
}

