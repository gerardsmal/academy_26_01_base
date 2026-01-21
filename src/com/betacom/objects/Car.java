package com.betacom.objects;

public abstract class Car {
	private String model;
	private String color;
	private Integer masSpeed;
	
	
	public abstract void frena();
	public abstract void accelera();
	
	
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getMasSpeed() {
		return masSpeed;
	}
	public void setMasSpeed(Integer masSpeed) {
		this.masSpeed = masSpeed;
	}

}
