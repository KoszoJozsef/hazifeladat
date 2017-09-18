package koszo.jozsef.beans;

import java.util.List;





import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import koszo.jozsef.beans.interfaces.VehicleBeanLocal;
import koszo.jozsef.model.Vehicle;

/**
 * Session Bean implementation class VehicleBean
 */
@Stateless
public class VehicleBean implements VehicleBeanLocal {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public VehicleBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Vehicle createVehicle(Vehicle vehicle) {
		em.persist(vehicle);
		return vehicle;
	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		em.merge(vehicle);
		return vehicle;
	}

	@Override
	public void deleteVehicle(int id) {
		em.remove(getVehicle(id));
		
	}

	@Override
	public Vehicle getVehicle(int id) {
		Vehicle vehicle = em.find(Vehicle.class, id);
		return vehicle;
	}

	@Override
	public List<Vehicle> getVehicleList() {
		return em.createNamedQuery("Vehicle.findById", Vehicle.class).getResultList();
	}

}
