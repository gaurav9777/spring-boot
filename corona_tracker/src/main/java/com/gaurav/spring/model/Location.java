package com.gaurav.spring.model;

public class Location {

	private String location;
	private long total_cases;
	private long total_deaths;
	private long people_vaccinated;
	private long population;
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getTotal_cases() {
		return total_cases;
	}
	public void setTotal_cases(long total_cases) {
		this.total_cases = total_cases;
	}
	public long getTotal_deaths() {
		return total_deaths;
	}
	public void setTotal_deaths(long total_deaths) {
		this.total_deaths = total_deaths;
	}
	public long getPeople_vaccinated() {
		return people_vaccinated;
	}
	public void setPeople_vaccinated(long people_vaccinated) {
		this.people_vaccinated = people_vaccinated;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	@Override
	public String toString() {
		return "Location [location=" + location + ", total_cases=" + total_cases + ", total_deaths=" + total_deaths
				+ ", people_vaccinated=" + people_vaccinated + ", population=" + population + "]";
	}
	
	
}
