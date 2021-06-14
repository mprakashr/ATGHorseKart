package se.atg.service.harrykart.java.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;

public class FinalRanking {
	
	private int position;
	private String horse;
	@JsonIgnore
	private double totaltimetaken;
	
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getHorse() {
		return horse;
	}
	public void setHorse(String horse) {
		this.horse = horse;
	}
	public double getTotaltimetaken() {
		return totaltimetaken;
	}
	public void setTotaltimetaken(double totaltimetaken) {
		this.totaltimetaken = totaltimetaken;
	}
	
}
