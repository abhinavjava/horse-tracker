package com.horse.track.horsetrack.model;

import java.util.Objects;

public class Horse {

	private Integer number ;
	
	private String name;
	
	private String result;
	

	public Horse(Integer number, String name, String result) {
		super();
		this.number = number;
		this.name = name;
		this.result = result;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Horse other = (Horse) obj;
		return Objects.equals(number, other.number);
				
	}

	@Override
	public String toString() {
		return "Horse [number=" + number + ", name=" + name + ", result=" + result + "]";
	}
	
}
