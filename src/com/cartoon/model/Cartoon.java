package com.cartoon.model;

public class Cartoon {

	private int idCartoons;
	private String Name;
	private String Description;
	private int PG;
	
	public int getIdCartoons() {
		return idCartoons;
	}
	public void setIdCartoons(int idCartoons) {
		this.idCartoons = idCartoons;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getPG() {
		return PG;
	}
	public void setPG(int pG) {
		PG = pG;
	}
	
	public Cartoon(int idCartoons, String name, String description, int pG) {
		this.idCartoons = idCartoons;
		this.Name = name;
		this.Description = description;
		this.PG = pG;
	}
	
	@Override
	public String toString() {
		return "Cartoon [id=" + idCartoons + ", name=" + Name + ", Description=" + Description + ", Parental Guidance=" + PG +"]";
	}

}
