package ca.bsolomon.gw2.wvw.objective;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import ca.bsolomon.gw2.api.wvw.GW2WvWAPI;
import ca.bsolomon.gw2.api.wvw.dao.Maps;
import ca.bsolomon.gw2.api.wvw.dao.Objective;
import ca.bsolomon.gw2.api.wvw.dao.WvWMatch;
import ca.bsolomon.gw2.wvw.objective.dao.ServerID;
import ca.bsolomon.gw2.wvw.objective.dao.Status;
import ca.bsolomon.gw2.wvw.objective.util.ObjectiveNames;

@DisallowConcurrentExecution
public class WvWObjectiveDataRetrieverJob  implements Job{

	private GW2WvWAPI wvwAPI = new GW2WvWAPI();
	private static int SoRID = 1013;
	private static List<Maps> wvwMaps;
	private static WvWMatch sorMatch;
	
	private static Map<Integer, String> objectiveOwners = new HashMap<>();
	private String sorColor;
	
	private static List<Status> redStatus;
	private static List<Status> greenStatus;
	private static List<Status> blueStatus;
	private static List<Status> ebStatus;
	
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		List<WvWMatch> matches = wvwAPI.getMatches();
		
		sorMatch = findMatch(matches, SoRID);
		
		if (sorMatch.getBlueWorldId() == ServerID.SoR.getUid()) {
			sorColor = "Blue";
		} else if (sorMatch.getRedWorldId() == ServerID.SoR.getUid()) {
			sorColor = "Red";
		} else {
			sorColor = "Green";
		}
		
		wvwMaps = wvwAPI.getMatcheObjectives(sorMatch.getMatchId());
		
		redStatus = getRedWorldStatus();
		greenStatus = getGreenWorldStatus();
		blueStatus = getBlueWorldStatus();
		ebStatus = getEbWorldStatus();
	}

	private WvWMatch findMatch(List<WvWMatch> matches, int soRID) {
		for (WvWMatch match:matches) {
			if (match.getBlueWorldId() == soRID || match.getGreenWorldId() == soRID || match.getRedWorldId() == soRID) {
				return match;
			}
		}
		
		return null;
	}

	public static List<Maps> getWvwMaps() {
		return wvwMaps;
	}

	public static WvWMatch getSorMatch() {
		return sorMatch;
	}

	public List<Status> getRedWorldStatus() {
		List<Maps> maps = WvWObjectiveDataRetrieverJob.getWvwMaps();
    	
    	for (Maps map:maps) {
    		if (map.getType().equals("RedHome")) {
    			return processMapData(map);
    		}
    	}
    	
    	return null;
	}
	
	public List<Status> getGreenWorldStatus() {
		List<Maps> maps = WvWObjectiveDataRetrieverJob.getWvwMaps();
    	
    	for (Maps map:maps) {
    		if (map.getType().equals("GreenHome")) {
    			return processMapData(map);
    		}
    	}
    	
    	return null;
	}
	
	public List<Status> getBlueWorldStatus() {
		List<Maps> maps = WvWObjectiveDataRetrieverJob.getWvwMaps();
    	
    	for (Maps map:maps) {
    		if (map.getType().equals("BlueHome")) {
    			return processMapData(map);
    		}
    	}
    	
    	return null;
	}
	
	public List<Status> getEbWorldStatus() {
		List<Maps> maps = WvWObjectiveDataRetrieverJob.getWvwMaps();
    	
    	for (Maps map:maps) {
    		if (map.getType().equals("Center")) {
    			return processMapData(map);
    		}
    	}
    	
    	return null;
	}

	private List<Status> processMapData(Maps map) {
		List<Status> statuses = new ArrayList<>();
		
		for (Objective objective:map.getObjectives()) {
			ObjectiveNames.parseNames();
			String name = ObjectiveNames.objectiveNames.get(objective.getId());
			
			boolean playSound = false;
			
			if (objectiveOwners.get(objective.getId()) == null || !objectiveOwners.get(objective.getId()).equals(objective.getOwner())) {
				if (objective.getOwner().equals(sorColor)) {
					playSound = true;
				}
			}
			
			objectiveOwners.put(objective.getId(), objective.getOwner());
			
			Status status = new Status(objective.getOwner().toLowerCase(), playSound, name);
			statuses.add(status);
		}
		
		return statuses;
	}

	public static List<Status> getRedStatus() {
		return redStatus;
	}

	public static List<Status> getGreenStatus() {
		return greenStatus;
	}

	public static List<Status> getBlueStatus() {
		return blueStatus;
	}

	public static List<Status> getEbStatus() {
		return ebStatus;
	}
}
