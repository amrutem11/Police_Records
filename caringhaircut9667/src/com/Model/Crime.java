package com.Model;



public class Crime {
	
	
	private int CrimeId;
	private String date;
	private String Place;
	private String Description;
	private String Suspects;
	private String Status;
	
	public Crime() {
		super();
	}
	public Crime(int CrimeId,String date, String place, String description, String suspects, String status) {
		super();
		this.CrimeId = CrimeId;
		this.date = date;
		Place = place;
		Description = description;
		Suspects = suspects;
		Status = status;
	}
	
	public int getCrimeId() {
		return CrimeId;
	}
	public void setCrimeId(int crimeId) {
		CrimeId = crimeId;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date2) {
		this.date = date2;
	}
	public String getPlace() {
		return Place;
	}
	public void setPlace(String place) {
		Place = place;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getSuspects() {
		return Suspects;
	}
	public void setSuspects(String suspects) {
		Suspects = suspects;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "Crime [date=" + date + ", Place=" + Place + ", Description=" + Description + ", Suspects=" + Suspects
				+ ", Status=" + Status + "]";
	}
	
	
	
}
