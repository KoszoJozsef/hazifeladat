package koszo.jozsef.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import koszo.jozsef.beans.interfaces.UserBeanLocal;
import koszo.jozsef.beans.interfaces.VehicleBeanLocal;
import koszo.jozsef.model.Applicationuser;
import koszo.jozsef.model.Vehicle;



@ViewScoped
@ManagedBean
public class VehicleController {
	
	@Inject
	private VehicleBeanLocal vehiclebl;
	
	@Inject
	private UserBeanLocal userbl;
	
	private String userid;
	
	private int vehicleid;
	private String brand;
	private String model;
	private String typeDesignation;
	private String VIN;
	private String comment;
	
	private List<String> availableExtras;
	private List<String> selectedExtras;
	
	private Applicationuser applicationuser;
	
	@PostConstruct
	public void init(){
		
		availableExtras = new ArrayList<String>();
		
		availableExtras.add("Airbags");
		availableExtras.add("OverturningSystem");
		availableExtras.add("SeatHeating");
		
	}
	
	public void createVehicle(){
		Vehicle v = new Vehicle();
		v.setBrand(brand);
		v.setModel(model);
		v.setTypedesignation(typeDesignation);
		v.setVin(VIN);
		v.setComment(comment);
		
		StringBuilder sb = new StringBuilder();
		
		for(String records : selectedExtras){
			if (sb.length() != 0)
		        sb.append(',');
		    sb.append(records);
		}
		
		v.setSelectedextras(sb.toString());
		
		applicationuser = userbl.getUser(Integer.parseInt(userid));
		
		v.setApplicationuser(applicationuser);
		
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

		StringBuilder sb = new StringBuilder();
		
		for(String records : selectedExtras){
			if (sb.length() != 0)
		        sb.append(',');
		    sb.append(records);
		}
		
		v.setSelectedextras(sb.toString());
		
		applicationuser = userbl.getUser(Integer.parseInt(userid));
		
		v.setApplicationuser(applicationuser);
		
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
		selectedExtras = Arrays.asList(v.getSelectedextras().split(","));
		
		userid = String.valueOf(v.getApplicationuser().getUserid());
		
		applicationuser = userbl.getUser(Integer.parseInt(userid));
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


	public List<String> getSelectedExtras() {
		return selectedExtras;
	}

	public void setSelectedExtras(List<String> selectedExtras) {
		this.selectedExtras = selectedExtras;
	}

	public List<String> getAvailableExtras() {
		return availableExtras;
	}

	public void setAvailableExtras(List<String> availableExtras) {
		this.availableExtras = availableExtras;
	}

	public Applicationuser getApplicationuser() {
		return applicationuser;
	}

	public void setApplicationuser(Applicationuser applicationuser) {
		this.applicationuser = applicationuser;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}


	
}
