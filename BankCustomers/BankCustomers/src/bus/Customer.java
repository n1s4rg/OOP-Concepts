package bus;

import java.io.Serializable;
import java.util.Random;

public class Customer implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long identificationNum;
	private String firstName;
	private String lastName;
	private long pinNum;

	Random rand = new Random(); 
	int upperbound = 100001;
	long randNum = 0;
	 
	public Customer() {
		super();
		
		this.identificationNum = Long.valueOf(rand.nextInt(upperbound)+1);
		this.firstName = "";
		this.lastName = "";
		this.pinNum = 0;
		
	}
	
	public Customer(String firstName, String lastName, long pinNum) {
		super();
		
		this.identificationNum = Long.valueOf(rand.nextInt(upperbound)+1);
		this.firstName = firstName;
		this.lastName = lastName;
		this.pinNum = pinNum;
		
	}
	
	public void setIdentificationNum(long identificationNum) {
		this.identificationNum = identificationNum;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPinNum() {
		return pinNum;
	}

	public void setPinNum(long pinNum) {
		this.pinNum = pinNum;
	}

	public long getIdentificationNum() {
		return identificationNum;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Identification Number :"+this.identificationNum + "Full Name: "+this.firstName+" "+this.lastName;
	}
}
