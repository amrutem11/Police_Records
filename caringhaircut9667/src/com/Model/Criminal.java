package com.Model;

public class Criminal {
	private String name;
	private int age;
	private String gender;
	private String address;
	private String identifyingMark;
	private String areaOfArrest;
	private String AttatchedCrime;
	
	public Criminal () {
		super();
	}
	
	public Criminal(String name, int age, String gender, String address, String identifyingMark, String areaOfArrest,
			String attatchedCrime) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.identifyingMark = identifyingMark;
		this.areaOfArrest = areaOfArrest;
		AttatchedCrime = attatchedCrime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdentifyingMark() {
		return identifyingMark;
	}

	public void setIdentifyingMark(String identifyingMark) {
		this.identifyingMark = identifyingMark;
	}

	public String getAreaOfArrest() {
		return areaOfArrest;
	}

	public void setAreaOfArrest(String areaOfArrest) {
		this.areaOfArrest = areaOfArrest;
	}

	public String getAttatchedCrime() {
		return AttatchedCrime;
	}

	public void setAttatchedCrime(String attatchedCrime) {
		AttatchedCrime = attatchedCrime;
	}

	@Override
	public String toString() {
		return "Criminal [name=" + name + ", age=" + age + ", gender=" + gender + ", address=" + address
				+ ", identifyingMark=" + identifyingMark + ", areaOfArrest=" + areaOfArrest + ", AttatchedCrime="
				+ AttatchedCrime + "]";
	}
	
	
	
	
}
