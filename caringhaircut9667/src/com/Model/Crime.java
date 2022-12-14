package com.Model;



public class Crime {
	
	
	private int CrimeId;
	private String date;
	private String Place;
	private String Description;
	private String Victims; 
	private String Suspects;
	private String DetailDescription;
	
	private String Status;
	
	public Crime() {
		super();
	}
	public Crime(int CrimeId,String date, String place, String description,String Victims, String suspects,String DetailDescription, String status) {
		super();
		this.CrimeId = CrimeId;
		this.date = date;
		this.Place = place;
		this.Description = description;
		this.Victims = Victims;
		this.Suspects = suspects;
		this.DetailDescription = DetailDescription;
		this.Status = status;
	}
	
	public String getVictims() {
		return Victims;
	}
	public void setVictims(String victims) {
		Victims = victims;
	}
	public String getDetailDescription() {
		return DetailDescription;
	}
	public void setDetailDescription(String detailDescription) {
		DetailDescription = detailDescription;
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
		return "Crime [CrimeId=" + CrimeId + ", date=" + date + ", Place=" + Place + ", Description=" + Description
				+ ", Victims=" + Victims + ", Suspects=" + Suspects + ", DetailDescription=" + DetailDescription
				+ ", Status=" + Status + "]";
	}
	
	
	
	
}
