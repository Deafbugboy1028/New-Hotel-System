package logic;

import java.io.File;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public abstract class Room implements Serializable {
	
	protected boolean occupied, breakfast;
	protected String roomNumber, name, type;
	protected double dailyRate;
	
	public Room () {
		occupied = false;
		breakfast = true;
		roomNumber = "0A";
		name = "Default";
		type = "Standard";
		dailyRate = 75.0;
	}
	
	public Room (boolean occupied, boolean breakfast, String roomNumber,
			String name, String type, double dailyRate, ImageIcon photo) {
		this.occupied = occupied;
		this.breakfast = breakfast;
		this.roomNumber = roomNumber;
		this.name = name;
		this.type = type;
		this.dailyRate = dailyRate;
	}

	public abstract JLabel getAsLabel ();
	public abstract JButton getAsButton ();
	
	public boolean isOccupied() {
		return occupied;
	}
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	public boolean isBreakfast() {
		return breakfast;
	}
	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getDailyRate() {
		return dailyRate;
	}
	public void setDailyRate(double dailyRate) {
		this.dailyRate = dailyRate;
	}
	
}
