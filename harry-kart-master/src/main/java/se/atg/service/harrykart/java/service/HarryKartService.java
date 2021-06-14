package se.atg.service.harrykart.java.service;

import java.util.List;

import se.atg.service.harrykart.java.rest.dto.FinalRanking;
import se.atg.service.harrykart.java.rest.dto.HarryKart;

public interface HarryKartService {

	public  List<FinalRanking> findRaceRanking(HarryKart raceinfo);
}
