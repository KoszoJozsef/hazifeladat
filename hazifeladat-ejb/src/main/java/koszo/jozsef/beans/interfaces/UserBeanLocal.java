package koszo.jozsef.beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import koszo.jozsef.model.ApplicationUser;


@Local
public interface UserBeanLocal {
	public ApplicationUser updateUser(ApplicationUser user);
	public ApplicationUser getUser(int id);
	public List<ApplicationUser> getUserList();

}
