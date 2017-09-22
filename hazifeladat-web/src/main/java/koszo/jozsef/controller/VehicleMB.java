package koszo.jozsef.controller;

import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import koszo.jozsef.beans.interfaces.VehicleBeanLocal;
import koszo.jozsef.model.Extras;
import koszo.jozsef.model.Vehicle;



@ViewScoped
@ManagedBean
public class VehicleMB {
	
	@Inject
	private VehicleBeanLocal vehiclebl;
	
	private int vehicleid;
	private String brand;
	private String model;
	private String typeDesignation;
	private String VIN;
	private String comment;
	private List<Extras> extras;
	
	public void createVehicle(){
		Vehicle v = new Vehicle();
		v.setBrand(brand);
		v.setModel(model);
		v.setTypedesignation(typeDesignation);
		v.setVin(VIN);
		v.setComment(comment);
		v.setExtras(extras);
		
		vehiclebl.createVehicle(v);
		
	}
	
	public void updateVehicle(){
		Vehicle v = new Vehicle();
		v.setVehicleid(vehicleid);
		v.setBrand(brand);
		v.setModel(model);
		v.setTypedesignation(typeDesignation);
		v.setVin(VIN);
		v.setComment(comment);
		v.setExtras(extras);
		
		vehiclebl.updateVehicle(v);
	}
	
	public void deleteVehicle(int id){
		vehiclebl.deleteVehicle(id);
	}
	
	public void getVehicle(int vehicleid){
		Vehicle v = vehiclebl.getVehicle(vehicleid);
		this.vehicleid = v.getVehicleid();
		brand = v.getBrand();
		model = v.getModel();
		typeDesignation = v.getTypedesignation();
		VIN = v.getVin();
		comment = v.getComment();
		extras = v.getExtras();
	}
	
	public List<Vehicle> getVehicles(){
		return vehiclebl.getVehicleList();
	}

	public int getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
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

	public List<Extras> getExtras() {
		return extras;
	}

	public void setExtras(List<Extras> extras) {
		this.extras = extras;
	}


	
}
