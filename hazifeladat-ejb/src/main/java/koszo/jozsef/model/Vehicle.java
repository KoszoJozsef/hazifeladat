package koszo.jozsef.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the vehicle database table.
 * 
 */
@Entity
@NamedQuery(name="Vehicle.findAll", query="SELECT v FROM Vehicle v")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int vehicleid;

	private String brand;

	private String comment;

	@Enumerated(EnumType.STRING)
	private List<Extras> extras;

	private String model;

	private String typedesignation;

	private String vin;

	//bi-directional many-to-one association to Applicationuser
	@ManyToOne
	@JoinColumn(name="user_fk")
	private Applicationuser applicationuser;

	public Vehicle() {
	}

	public int getVehicleid() {
		return this.vehicleid;
	}

	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<Extras> getExtras() {
		return this.extras;
	}

	public void setExtras(List<Extras> extras) {
		this.extras = extras;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getTypedesignation() {
		return this.typedesignation;
	}

	public void setTypedesignation(String typedesignation) {
		this.typedesignation = typedesignation;
	}

	public String getVin() {
		return this.vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public Applicationuser getApplicationuser() {
		return this.applicationuser;
	}

	public void setApplicationuser(Applicationuser applicationuser) {
		this.applicationuser = applicationuser;
	}

}