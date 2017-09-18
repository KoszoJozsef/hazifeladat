package koszo.jozsef.beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import koszo.jozsef.model.Vehicle;


@Local
public interface VehicleBeanLocal {
	public Vehicle createVehicle(Vehicle vehicle);
	public Vehicle updateVehicle(Vehicle vehicle);
	public void deleteVehicle(int id);
	public Vehicle getVehicle(int id);
	public List<Vehicle> getVehicleList();
}
