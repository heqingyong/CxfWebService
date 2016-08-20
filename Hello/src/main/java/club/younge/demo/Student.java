package club.younge.demo;

public class Student {
	private String number;
	private String name;
	public String getNumber() {
		return number;
	}
	public void setNumberAndName(String number, String name){
		this.number = number;
		this.name = name;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return new StringBuilder()
		.append("I am a student, my number is ")
		.append(this.number).append(",my name is ")
		.append(this.name).toString();
	}
	
}
