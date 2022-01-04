package bus;

public class City {
	
	private String code;
	private String name;
	private Double area;// area is of a class data type from the package java.lang
	private Integer pop;
	
	public Integer getpop() {
		return pop;
	}
	public void setPop(Integer pop) {
		this.pop = pop;
	}
	public City(String code, String name, Double area, Integer pop) {
		super();
		this.code = code;
		this.name = name;
		this.area = area;
		this.pop = pop;
	}
	public City() {
		super();
	}
	public City(String code, String name, Double area) {
		super();
		this.code = code;
		this.name = name;
		this.area = area;
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
		return "City [code=" + code + ", name=" + name + ", area=" + area + ", pop=" + pop + "]";
	}
	
	
	public Integer getPop()
	{
		return 0;
	}

}
