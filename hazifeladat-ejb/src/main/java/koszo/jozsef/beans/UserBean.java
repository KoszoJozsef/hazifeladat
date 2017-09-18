package koszo.jozsef.beans;

import java.util.List;




import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import koszo.jozsef.beans.interfaces.UserBeanLocal;
import koszo.jozsef.model.ApplicationUser;

/**
 * Session Bean implementation class UserBean
 */
@Stateless
public class UserBean implements UserBeanLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public UserBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public ApplicationUser updateUser(ApplicationUser user) {
		em.merge(user);
		return user;
	}

	@Override
	public ApplicationUser getUser(int id) {
		ApplicationUser user = em.find(ApplicationUser.class, id);
		return user;
	}

	@Override
	public List<ApplicationUser> getUserList() {
		return em.createNamedQuery("ApplicationUser.findById", ApplicationUser.class).getResultList();

	}

}
