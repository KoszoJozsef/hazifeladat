package koszo.jozsef.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import koszo.jozsef.beans.interfaces.VehicleBeanLocal;
import koszo.jozsef.model.Vehicle;



@ViewScoped
@ManagedBean
public class VehicleMB {
	
	@Inject
	private VehicleBeanLocal vehiclebl;
	
	private int id;
	private String brand;
	private String model;
	private String typeDesignation;
	private String VIN;
	private String comment;
//	private boolean seatHeating;
//	private boolean airbags;
//	private boolean overturningSystem;
	
	public void createVehicle(){
		Vehicle v = new Vehicle();
		v.setBrand(brand);
		v.setModel(model);
		v.setTypeDesignation(typeDesignation);
		v.setVIN(VIN);
		v.setComment(comment);
//		v.setSeatHeating(seatHeating);
//		v.setAirbags(airbags);
//		v.setOverturningSystem(overturningSystem);
		
		vehiclebl.createVehicle(v);
		
	}
	
	public void updateVehicle(){
		Vehicle v = new Vehicle();
		v.setId(id);
		v.setBrand(brand);
		v.setModel(model);
		v.setTypeDesignation(typeDesignation);
		v.setVIN(VIN);
		v.setComment(comment);
//		v.setSeatHeating(seatHeating);
//		v.setAirbags(airbags);
//		v.setOverturningSystem(overturningSystem);
		
		vehiclebl.updateVehicle(v);
	}
	
	public void deleteVehicle(int id){
		vehiclebl.deleteVehicle(id);
	}
	
	public void getVehicle(int id){
		Vehicle v = vehiclebl.getVehicle(id);
		this.id = v.getId();
		brand = v.getBrand();
		model = v.getModel();
		typeDesignation = v.getTypeDesignation();
		VIN = v.getVIN();
		comment = v.getComment();
//		seatHeating = v.getSeatHeating();
//		airbags = v.getAirbags();
//		overturningSystem = v.getOverturningSystem();
	}
	
	public List<Vehicle> getVehicles(){
		return vehiclebl.getVehicleList();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getTypeDesignation() {
		return typeDesignation;
	}

	public void setTypeDesignation(String typeDesignation) {
		this.typeDesignation = typeDesignation;
	}

	public String getVIN() {
		return VIN;
	}

	public void setVIN(String vIN) {
		VIN = vIN;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

//	public boolean isSeatHeating() {
//		return seatHeating;
//	}
//
//	public void setSeatHeating(boolean seatHeating) {
//		this.seatHeating = seatHeating;
//	}
//
//	public boolean isAirbags() {
//		return airbags;
//	}
//
//	public void setAirbags(boolean airbags) {
//		this.airbags = airbags;
//	}
//
//	public boolean isOverturningSystem() {
//		return overturningSystem;
//	}
//
//	public void setOverturningSystem(boolean overturningSystem) {
//		this.overturningSystem = overturningSystem;
//	}
	
}
