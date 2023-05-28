package com.horse.track.horsetrack.service;

public interface Tracker{

	void controlOperation(String input);
	
	void trackerOperation(String input);
	
	boolean betTheHorse(Integer horseNumber, String input);
	
	void viewInventory();
	
	void viewHorses();
	
	void reloadInventory();
}
