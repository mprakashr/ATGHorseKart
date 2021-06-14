package se.atg.service.harrykart.java.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.atg.service.harrykart.java.rest.dto.FinalRanking;
import se.atg.service.harrykart.java.rest.dto.HarryKart;
import se.atg.service.harrykart.java.service.HarryKartService;

@RestController
@RequestMapping("/java/api")
public class HarryKartController {
	
	@Autowired
	HarryKartService kartService;
	
	
    @PostMapping(path = "/play", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, List<FinalRanking>> playHarryKart(@RequestBody HarryKart raceinfo) {
    	
    	Map<String, List<FinalRanking>> rankingDetails=new HashMap<>(); 			 
    	rankingDetails.put("ranking", kartService.findRaceRanking(raceinfo));
    	return rankingDetails;
    	
    }
    

}
