package se.atg.service.harrykart.java.rest.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Loop {
	@JacksonXmlProperty(isAttribute=true)
	private int number;
	
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Lane> lane=new ArrayList<>();

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public List<Lane> getLane() {
		return lane;
	}
	public void setLane(List<Lane> lane) {
		this.lane = lane;
	}
	
}
