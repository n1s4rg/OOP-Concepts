package bus;

public class Student 
{
	// 1: data members
	private String firstName;
	private String lastName;
	private String email;
	private double gpa;
	
	// 2: function member
	// 2.1: Public overloaded constructors
	public Student() 
	{
		this.firstName = "Undefined";
		this.lastName = "Undefined";
		this.email = "Undefined";
		this.gpa = 0.00;
	}
	
	// 2.2: constructors with parameters
	public Student(String fn, String ln, String email, double gpa) 
	{
		this.firstName = "Undefined";	// setFirstName(fn);
		this.lastName = "Undefined";	// setLastName(ln);
		this.email = "Undefined";		// setEmail(email);
		this.gpa = 0.00;				// setGpa(gpa);
	}
	
	//2.3: public getter/setters
	public void setFirstName(String fn)
	{
		this.firstName = fn;
	}
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public void setLastName(String ln)
	{
		this.lastName = ln;
	}
	public String getLastName()
	{
		return this.lastName;
	}
	
	public String GetObjectState() 
	{
		String state;
		state = this.firstName + "," + this.lastName + "," + this.email + "," + this.gpa;
		return state;
	}
}
