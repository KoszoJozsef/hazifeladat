package koszo.jozsef.beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import koszo.jozsef.model.Applicationuser;


@Local
public interface UserBeanLocal {
	public Applicationuser updateUser(Applicationuser user);
	public Applicationuser getUser(int id);
	public List<Applicationuser> getUserList();
	
}
