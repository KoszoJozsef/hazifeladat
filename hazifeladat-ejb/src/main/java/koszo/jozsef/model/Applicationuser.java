package koszo.jozsef.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the applicationuser database table.
 * 
 */
@Entity
@NamedQuery(name="Applicationuser.findAll", query="SELECT a FROM Applicationuser a")
public class Applicationuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int userid;

	private String firstname;

	private String lastlogin;

	private String lastname;

	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;

	private String username;

	//bi-directional many-to-one association to Vehicle
	@OneToMany(mappedBy="applicationuser", fetch = FetchType.EAGER)
	private List<Vehicle> vehicles;

	public Applicationuser() {
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastlogin() {
		return this.lastlogin;
	}

	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Vehicle> getVehicles() {
		return this.vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Vehicle addVehicle(Vehicle vehicle) {
		getVehicles().add(vehicle);
		vehicle.setApplicationuser(this);

		return vehicle;
	}

	public Vehicle removeVehicle(Vehicle vehicle) {
		getVehicles().remove(vehicle);
		vehicle.setApplicationuser(null);

		return vehicle;
	}

	@Override
	public String toString() {
		return "Applicationuser [userid=" + userid + ", firstname=" + firstname
				+ ", lastlogin=" + lastlogin + ", lastname=" + lastname
				+ ", password=" + password + ", role=" + role + ", username="
				+ username + ", vehicles=" + vehicles + "]";
	}

}