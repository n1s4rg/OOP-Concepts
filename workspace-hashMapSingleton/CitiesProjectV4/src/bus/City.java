package bus;

public class City implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;// Integer code (is a reference type) -- not int code (is a value type)
	
	//if code is : private  Long code = null
	private String name;
	private Double area;	
	          //private Integer population;--TO DO
	public City() {
		super();
	}
	public City(String code, String name, Double area) {
		super();
		this.code = code;
		this.name = name;
		this.area = area;
		//this.pop  = null;
	}
	
	public City(String code, String name, Double area, Integer pop) {
		super();
		this.code = code;
		this.name = name;
		this.area = area;
		//this.pop = pop;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getArea() {
		return area;
	}
	public void setArea(Double area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "City [code=" + code + ", name=" + name + ", area=" + area + "]";
	}
	
		

}
