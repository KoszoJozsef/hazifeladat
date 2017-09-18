package koszo.jozsef.model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Vehicle
 *
 */
@Entity
@NamedQuery(name="Vehicle.findById", query="SELECT v FROM Vehicle v")
public class Vehicle implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String brand;
	private String model;
	private String typeDesignation;
	private String VIN;
	private String comment;
//	private boolean seatHeating;
//	private boolean airbags;
//	private boolean overturningSystem;

	public Vehicle() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}   
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}   
	public String getTypeDesignation() {
		return this.typeDesignation;
	}

	public void setTypeDesignation(String typeDesignation) {
		this.typeDesignation = typeDesignation;
	}   
	public String getVIN() {
		return this.VIN;
	}

	public void setVIN(String VIN) {
		this.VIN = VIN;
	}   
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}   
//	public boolean isSeatHeating() {
//		return this.seatHeating;
//	}
//
//	public void setSeatHeating(boolean seatHeating) {
//		this.seatHeating = seatHeating;
//	}   
//	public boolean isAirbags() {
//		return this.airbags;
//	}
//
//	public void setAirbags(boolean airbags) {
//		this.airbags = airbags;
//	}   
//	public boolean isOverturningSystem() {
//		return this.overturningSystem;
//	}
//
//	public void setOverturningSystem(boolean overturningSystem) {
//		this.overturningSystem = overturningSystem;
//	}
   
}
