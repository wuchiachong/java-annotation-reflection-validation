import java.io.Serializable;

public class UserModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4469704917708123018L;

	private long id = 0;
	
	private String firstName = "";
	
	@Required
	private String lastName = "";
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
