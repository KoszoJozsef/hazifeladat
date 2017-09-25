package koszo.jozsef.controller;

import java.util.Date;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import koszo.jozsef.beans.interfaces.UserBeanLocal;
import koszo.jozsef.model.Applicationuser;
import koszo.jozsef.model.Role;




@ViewScoped
@ManagedBean
public class UserController {
	
	@Inject
	UserBeanLocal userbl;
	
	private int id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private Date lastlogin;
	private Role role;
	
	private Applicationuser loggedUser;
	
	
	public void updateUser(){
		Applicationuser u = new Applicationuser();
		u.setUserid(id);
		u.setUsername(username);
		u.setPassword(password);
		u.setLastlogin(lastlogin);
		u.setFirstname(firstname);
		u.setLastname(lastname);
		u.setRole(role);
		
		userbl.updateUser(u);
	}
	
	public void getUser(int id){
		Applicationuser u = userbl.getUser(id);
		this.id = u.getUserid();
		username = u.getUsername();
		password = u.getPassword();
		lastlogin = u.getLastlogin();
		firstname = u.getFirstname();
		lastname = u.getLastname();
		role = u.getRole();

	}
	
	public List<Applicationuser> getUsers(){
		return userbl.getUserList();
	}
	
	public String login() {
		
		List<Applicationuser> tmp = userbl.getUserList();
		
		for(int i = 0;i < tmp.size();){
			
			if(username.equals(tmp.get(i).getUsername()) && password.equals(tmp.get(i).getPassword())){	
				if(getUsers().get(i).getRole().equals(Role.Admin)) {
					
					loggedUser = tmp.get(i);
										
					return "adminvehiclelist";					
				} else {
										
					loggedUser = tmp.get(i);
															
					return "uservehiclelist";
				}
						
			} else {			
				i++;			
			}
		}
		
		return "error";
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

	public Date getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}

	public Applicationuser getLogged() {
		return loggedUser;
	}

	public void setLogged(Applicationuser logged) {
		this.loggedUser = logged;
	}

	
	
}
