package hibe_example;

public class Student {

	private String name, usn, address;
	private int id,totmarks;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTotmarks() {
		return totmarks;
	}
	public void setTotmarks(int totMarks) {
		this.totmarks = totMarks;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", usn=" + usn + ", address=" + address + ", totMarks=" + totmarks + "]";
	}
	
}
