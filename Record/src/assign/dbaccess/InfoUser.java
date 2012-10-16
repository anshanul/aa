package assign.dbaccess;

public class InfoUser {
	String firstName;
	String lastName;
	String sex;
	String phoneNo;
	String houseNo;
	String city;
	String state;
	
	
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) 
	{
		this.houseNo = houseNo;
	}

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getSex() {
		return sex;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public InfoUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InfoUser(String firstName, String lastName, String sex,
			String phoneNo, String houseNo, String city, String state) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.phoneNo = phoneNo;
		this.houseNo = houseNo;
		this.city = city;
		this.state = state;
	}


	

}
