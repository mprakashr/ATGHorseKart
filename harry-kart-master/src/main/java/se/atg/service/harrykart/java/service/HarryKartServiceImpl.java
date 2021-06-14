package se.atg.service.harrykart.java.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import se.atg.service.harrykart.java.rest.dto.FinalRanking;
import se.atg.service.harrykart.java.rest.dto.HarryKart;
import se.atg.service.harrykart.java.rest.dto.Lane;
import se.atg.service.harrykart.java.rest.dto.Loop;

@Service
public class HarryKartServiceImpl implements HarryKartService {

	final int distance=1000;
	
	@Override
	public List<FinalRanking> findRaceRanking(HarryKart raceinfo) {

		Map<Double, FinalRanking> horseRanking=new TreeMap<>();
    	
    	raceinfo.getParticipantList().forEach(p-> {
    		double timetakenforhorse=calculateTimeBySpeed(distance, p.getBaseSpeed());
    		int totalPowerUpPoint = 0;
    		
    		for(Loop loop:raceinfo.getPowerUps()) {
    			
    			for(Lane lane:loop.getLane())
    			{   				
    			if(lane.getLaneNumber()==p.getLane()) {
    				totalPowerUpPoint+=lane.getPowerUpPoint();
    				timetakenforhorse+=calculateTimeBySpeed(distance, p.getBaseSpeed()+totalPowerUpPoint);
    				break;
    			}					
    			}
    			
    		}  	
    		
    		FinalRanking timetakenbyHorse=new FinalRanking();
    		timetakenbyHorse.setHorse(p.getName());
    		timetakenbyHorse.setTotaltimetaken(timetakenforhorse);
    		horseRanking.put(timetakenforhorse, timetakenbyHorse);
    		
    	});
    	
    	//Other way to do for sorting and limiting---timeCalculatedList will be in place of horseRanking which collects the objects
    	
    	//final List<FinalRanking> rankingList=timeCalculatedList.stream().sorted((o1, o2) -> Double.compare(o1.getTotaltimetaken(), o2.getTotaltimetaken())).limit(3).collect(Collectors.toList());
    	
    	final List<FinalRanking> rankingList=horseRanking.values().stream().limit(3).collect(Collectors.toList());
		
		  IntStream.range(0, rankingList.size()).forEach(index ->
		  rankingList.get(index).setPosition(index+1));
		  
		  return rankingList;
		  }
	
	  public double calculateTimeBySpeed(int distance,int speed) {
			double timetaken = 0;
			if(speed>0) {
			timetaken=distance/speed;
			}
			return timetaken;	
		}

	
}
