package koszo.jozsef.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;




import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import koszo.jozsef.beans.interfaces.UserBeanLocal;
import koszo.jozsef.model.Applicationuser;
import koszo.jozsef.model.Role;




@SessionScoped
@ManagedBean
public class UserController {
	
	@Inject
	UserBeanLocal userbl;
	
	private int id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String lastlogin;
	private Role role;
	
	private Applicationuser loggedUser;
	
	private boolean isLogin = false;
	
	public void clear() {
	
		id = 0;
		username = null;
		password = null;
		firstname = null;
		lastname = null;
		lastlogin = null;
		role = null;
	}
	
	public void updateUser(){
		Applicationuser u = new Applicationuser();
		u.setUserid(id);
		u.setUsername(username);
		u.setPassword(password);
		u.setLastlogin(lastlogin);
		u.setFirstname(firstname);
		u.setLastname(lastname);
		u.setLastlogin(lastlogin);
		u.setRole(role);
		
		userbl.updateUser(u);
		
		clear();
		
	}
	
	public void updateLoggedUser() {
		loggedUser.setUserid(id);
		loggedUser.setUsername(username);
		loggedUser.setPassword(password);
		loggedUser.setLastlogin(lastlogin);
		loggedUser.setFirstname(firstname);
		loggedUser.setLastname(lastname);
		loggedUser.setRole(role);
		loggedUser.setLastlogin(lastlogin);
		
		userbl.updateUser(loggedUser);
		
		clear();
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
		lastlogin = u.getLastlogin();

	}
	
	public List<Applicationuser> getUsers(){		
		
		List<Applicationuser> tmp = userbl.getUserList();
		
		for(int i = 0; i < tmp.size(); i++){
			if(tmp.get(i).getRole().equals(Role.Admin)){
				tmp.remove(i);
			}
		}
		
		return tmp;

	}
	
	public void checkLogin() {
		if(!this.isLogin) {
			doRedirect("login.jsf");
		}
	}
	
	private void doRedirect(String url) {
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.getExternalContext().redirect(url);
			
		} catch (Exception e) {
			
		}
	}
	
	public void login() {
		
		List<Applicationuser> tmp = userbl.getUserList();
		
		FacesContext context = FacesContext.getCurrentInstance();
				
		for(int i = 0;i < tmp.size();){
			
			if(username.equals(tmp.get(i).getUsername()) && password.equals(tmp.get(i).getPassword())){	
				if(tmp.get(i).getRole().equals(Role.Admin)) {
										
					loggedUser = tmp.get(i);
					
					isLogin = true;
					
					Date dt = new Date();
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					
					loggedUser.setLastlogin(sdf.format(dt));
					
					userbl.updateUser(loggedUser);
										
					context.getExternalContext().getSessionMap().put("applicationuser", loggedUser);					
										
					doRedirect("adminvehiclelist.jsf");
					
				} else {
					
					loggedUser = tmp.get(i);
					
					isLogin = true;
					
					Date dt = new Date();
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					
					loggedUser.setLastlogin(sdf.format(dt));
					
					userbl.updateUser(loggedUser);
										
					context.getExternalContext().getSessionMap().put("applicationuser", loggedUser);
					
					doRedirect("uservehiclelist.jsf");
					
				}
						
			} else {			
				i++;			
			}
		}
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(" Invalid username or password!");
		facesContext.addMessage("login:username", facesMessage);
	}
	
	public void logout() {
		
		isLogin = false;
		
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();  
        
        doRedirect("login.jsf");
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

	public String getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}

	public Applicationuser getLogged() {
		return loggedUser;
	}

	public void setLogged(Applicationuser logged) {
		this.loggedUser = logged;
	}

	
	
}
