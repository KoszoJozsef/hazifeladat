package koszo.jozsef.beans;

import java.util.List;






import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import koszo.jozsef.beans.interfaces.UserBeanLocal;
import koszo.jozsef.model.Applicationuser;

/**
 * Session Bean implementation class UserBean
 */
@Stateless
public class UserDAO implements UserBeanLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public UserDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Applicationuser updateUser(Applicationuser user) {
		em.merge(user);
		return user;
	}

	@Override
	public Applicationuser getUser(int id) {
		Applicationuser user = em.find(Applicationuser.class, id);
		return user;
	}

	@Override
	public List<Applicationuser> getUserList() {
		return em.createNamedQuery("Applicationuser.findAll", Applicationuser.class).getResultList();
	}


}
