package koszo.jozsef.model;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ApplicationUser
 *
 */
@Entity
@NamedQuery(name="ApplicationUser.findById", query = "SELECT u FROM ApplicationUser u")
public class ApplicationUser implements Serializable {

	   

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String password;
	private String lastname;
	private String firstname;
	private Date lastLogin;
	private Role role;
	private static final long serialVersionUID = 1L;

	public ApplicationUser() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}   
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}   
	public Date getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}   
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
   
}
