package com.example.reservationCheckIn.client.entities;

public class ReservationUpdate {

	private int id;
	private boolean checkedIn;
	private int bags_no;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isCheckedIn() {
		return checkedIn;
	}
	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	public int getBags_no() {
		return bags_no;
	}
	public void setBags_no(int bags_no) {
		this.bags_no = bags_no;
	} 
	
	public ReservationUpdate() {
		
	}
}
