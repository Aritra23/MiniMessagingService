package model;



/**
 * @author Aritra
 * People.java: Class implementing the People Model. This class implements
 * basic getter/setter functionality.
 */
public class People  {
	
	private int people_id; // ID of the user
	private String handle; // Username
	private String name; // Name of the user.

	/**
	* Default constructor function.
	*/
	public People() {
	}

	/**
	* Constructor function.
	* @param people_id ID of the user
	* @param handle Username
	* @param name Name of the user
	*/
	public People(int people_id, String handle, String name) {
		this.people_id = people_id;
		this.handle = handle;
		this.name = name;
	}

 /**
 * Function that returns the ID of the user.
 * @return User ID
 */
	public int getId() {
		return people_id;
	}

	/**
  * Function that sets the ID of the user.
  * @param id User ID
  */
	public void setId(int id) {
		this.people_id = id;
	}

	/**
  * Function that returns the username.
  * @return Username
  */
	public String getHandle() {
		return handle;
	}

	/**
  * Function that sets the username.
  * @param handle Username
  */
	public void setHandle(String handle) {
		this.handle = handle;
	}

	/**
  * Function that returns the name of the user.
  * @return Name of the user
  */
	public String getName() {
		return name;
	}

	/**
  * Function that sets the name of the user.
  * @param name Name of the user
  */
	public void setName(String name) {
		this.name = name;
	}

}
