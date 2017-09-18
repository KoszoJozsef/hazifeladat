package koszo.jozsef.controller;

import java.util.List;




import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import koszo.jozsef.beans.interfaces.UserBeanLocal;
import koszo.jozsef.model.ApplicationUser;
import koszo.jozsef.model.Role;




@ViewScoped
@ManagedBean
public class UserMB {
	
	@Inject
	UserBeanLocal userbl;
	
	private int id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private Role role;
	
	public void updateUser(){
		ApplicationUser u = new ApplicationUser();
		u.setId(id);
		u.setUsername(username);
		u.setPassword(password);
		u.setFirstname(firstname);
		u.setLastname(lastname);
		u.setRole(role);
		
		userbl.updateUser(u);
	}
	
	public void getUser(int id){
		ApplicationUser u = userbl.getUser(id);
		this.id = u.getId();
		firstname = u.getFirstname();
		lastname = u.getLastname();
		role = u.getRole();

	}
	
	public List<ApplicationUser> getUsers(){
		return userbl.getUserList();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	
}
