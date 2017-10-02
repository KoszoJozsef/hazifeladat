package koszo.jozsef.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.validation.constraints.Pattern;



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
	
	private String typeDesignation;
	
	@Pattern(regexp = "^[A-HJ-NPR-Z\\d]{8}[\\dX][A-HJ-NPR-Z\\d]{2}\\d{6}$", message = " Invalid VIN!")
	private String VIN;
	private String comment;
	
	private List<String> availableExtras;
	private List<String> selectedExtras;
	
	private List<String> availableBrands;
	private String selectedBrand;
	
	private List<String> availableModels;
	private String selectedModel;
	
	private Applicationuser applicationuser;
		
	
	@PostConstruct
	public void init(){
		
		availableExtras = new ArrayList<String>();
		
		availableExtras.add("Airbags");
		availableExtras.add("OverturningSystem");
		availableExtras.add("SeatHeating");
		
		availableBrands = new ArrayList<String>();
		
		availableBrands.add("Suzuki");
		availableBrands.add("Fiat");
		availableBrands.add("Skoda");
		
		selectedBrand = null;		
		
	}
	
	public void changeBrand(AjaxBehaviorEvent event) {
				
		availableModels = new ArrayList<String>();		

		if(selectedBrand.equalsIgnoreCase("Suzuki")) {
			availableModels.add("Alto");
			availableModels.add("Ignis");
			availableModels.add("Swift");
		}
		
		if(selectedBrand.equalsIgnoreCase("Fiat")) {
			availableModels.add("Bravo");
			availableModels.add("Croma");
			availableModels.add("Punto");
		}
		
		if(selectedBrand.equalsIgnoreCase("Skoda")) {
			availableModels.add("Fabia");
			availableModels.add("Forman");
			availableModels.add("Rapid");
		}
		
		selectedModel = null;
		
	}
	
	public void createVehicle(){
		Vehicle v = new Vehicle();
		v.setBrand(selectedBrand);
		v.setModel(selectedModel);
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
		
		if(applicationuser != null){
			v.setApplicationuser(applicationuser);
			vehiclebl.createVehicle(v);
		} else {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			FacesMessage facesMessage = new FacesMessage(" User with an id of " + userid + " was not found!");
			facesContext.addMessage("form:owner", facesMessage);
		}		
						
	}
	

	
	public void updateVehicle(){
		Vehicle v = new Vehicle();
		v.setVehicleid(vehicleid);
		v.setBrand(selectedBrand);
		v.setModel(selectedModel);
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
		
		if(applicationuser != null){
			v.setApplicationuser(applicationuser);
			vehiclebl.updateVehicle(v);
		} else {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			FacesMessage facesMessage = new FacesMessage(" User with an id of " + userid + " was not found!");
			facesContext.addMessage("form:owner", facesMessage);
		}
	}
	
	public void deleteVehicle(int id){
		vehiclebl.deleteVehicle(id);
	}
	
	public void getVehicle(int vehicleid){
		Vehicle v = vehiclebl.getVehicle(vehicleid);
		this.vehicleid = v.getVehicleid();
		selectedBrand = null;
		selectedModel = null;
		typeDesignation = null;
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

	public List<String> getAvailableBrands() {
		return availableBrands;
	}

	public void setAvailableBrands(List<String> availableBrands) {
		this.availableBrands = availableBrands;
	}

	public String getSelectedBrand() {
		return selectedBrand;
	}

	public void setSelectedBrand(String selectedBrand) {
		this.selectedBrand = selectedBrand;
	}

	public List<String> getAvailableModels() {
		return availableModels;
	}

	public void setAvailableModels(List<String> availableModels) {
		this.availableModels = availableModels;
	}

	public String getSelectedModel() {
		return selectedModel;
	}

	public void setSelectedModel(String selectedModel) {
		this.selectedModel = selectedModel;
	}
	
}
