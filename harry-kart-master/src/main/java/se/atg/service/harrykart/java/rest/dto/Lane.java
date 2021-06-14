package se.atg.service.harrykart.java.rest.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class Lane {
	
	@JacksonXmlProperty(localName = "number",isAttribute = true)
	private int laneNumber;
	@JacksonXmlText
	private int powerUpPoint;
	
	public int getLaneNumber() {
		return laneNumber;
	}
	public void setLaneNumber(int laneNumber) {
		this.laneNumber = laneNumber;
	}
	public int getPowerUpPoint() {
		return powerUpPoint;
	}
	public void setPowerUpPoint(int powerUpPoint) {
		this.powerUpPoint = powerUpPoint;
	}
	

	
}
