package se.atg.service.harrykart.java.rest.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "harryKart")
public class HarryKart {

	@JacksonXmlProperty
	private int numberOfLoops;
	
	@JacksonXmlElementWrapper(localName = "startList")
	private List<Participant> participantList=new ArrayList<>();
	
	@JacksonXmlElementWrapper
	private List<Loop> powerUps=new ArrayList<>();//loops
	
	
	public int getNumberOfLoops() {
		return numberOfLoops;
	}
	public void setNumberOfLoops(int numberOfLoops) {
		this.numberOfLoops = numberOfLoops;
	}
	
	public List<Participant> getParticipantList() {
		return participantList;
	}
	public void setParticipantList(List<Participant> participantList) {
		this.participantList = participantList;
	}
	public List<Loop> getPowerUps() {
		return powerUps;
	}
	public void setPowerUps(List<Loop> powerUps) {
		this.powerUps = powerUps;
	}
	
	
	
	
	
}
