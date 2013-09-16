package ca.bsolomon.gw2.wvw.objective.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bsolomon.gw2.wvw.objective.dao.ObjectiveNamesDAO;

public class ObjectiveNames {

	private static ObjectMapper objectMapper = new ObjectMapper();
	
	private static String objectiveString = "[{\"obj_id\" : 1 , \"obj_name\" : \"Overlook\" ,\"obj_value\" : 25},"
	 +"{\"obj_id\" : 2 , \"obj_name\" : \"Valley\" ,\"obj_value\" : 25},"
	 +"{\"obj_id\" : 3 , \"obj_name\" : \"Lowlands\" ,\"obj_value\" : 25},"
	 +"{\"obj_id\" : 4 , \"obj_name\" : \"Golanta Clearing\" ,\"obj_value\" : 5},"
	 +"{\"obj_id\" : 5 , \"obj_name\" : \"Pangloss Rise\" ,\"obj_value\" : 5},"
	 +"{\"obj_id\" : 6 , \"obj_name\" : \"Speldan Clearcut\" ,\"obj_value\" : 5},"
	 +"{\"obj_id\" : 7 , \"obj_name\" : \"Danelon Passage\" ,\"obj_value\" : 5},"
	 +"{\"obj_id\" : 8 , \"obj_name\" : \"Umberglade Woods\" ,\"obj_value\" : 5},"
	 +"{\"obj_id\" : 9 , \"obj_name\" : \"Stonemist Castle\" ,\"obj_value\" : 35},"
	 +"{\"obj_id\" : 10 , \"obj_name\" : \"Rogue’s Quarry\" ,\"obj_value\" : 5},"
	 +"{\"obj_id\" : 11 , \"obj_name\" : \"Aldon’s Ledge\" ,\"obj_value\" : 10},"
	 +"{\"obj_id\" : 12 , \"obj_name\" : \"Wildcreek Run\" ,\"obj_value\" : 10},"
	 +"{\"obj_id\" : 13 , \"obj_name\" : \"Jerrifer’s Slough\" ,\"obj_value\" : 10},"
	 +"{\"obj_id\" : 14 , \"obj_name\" : \"Klovan Gully\" ,\"obj_value\" : 10},"
	 +"{\"obj_id\" : 15 , \"obj_name\" : \"Langor Gulch\" ,\"obj_value\" : 10},"
	 +"{\"obj_id\" : 16 , \"obj_name\" : \"Quentin Lake\" ,\"obj_value\" : 10},"
	 +"{\"obj_id\" : 17 , \"obj_name\" : \"Mendon’s Gap\" ,\"obj_value\" : 10},"
	 +"{\"obj_id\" : 18 , \"obj_name\" : \"Anzalias Pass\" ,\"obj_value\" : 10},"
	 +"{\"obj_id\" : 19 , \"obj_name\" : \"Ogrewatch Cut\" ,\"obj_value\" : 10},"
	 +"{\"obj_id\" : 20 , \"obj_name\" : \"Veloka Slope\" ,\"obj_value\" : 10},"
	 +"{\"obj_id\" : 21 , \"obj_name\" : \"Durios Gulch\" ,\"obj_value\" : 10},"
	 +"{\"obj_id\" : 22 , \"obj_name\" : \"Bravost Escarpment\" ,\"obj_value\" : 10},"
	 +"{\"obj_id\" : 23 , \"obj_name\" : \"Garrison\" ,\"obj_value\" : 25},"
	 +"{\"obj_id\" : 24 , \"obj_name\" : \"Champion’s demense\" ,\"obj_value\" : 5},"
	 +"{\"obj_id\" : 25 , \"obj_name\" : \"Redbriar\" ,\"obj_value\" : 10},"
	 +"{\"obj_id\" : 26 , \"obj_name\" : \"Greenlake\" ,\"obj_value\" : 10},"
	 +"{\"obj_id\" : 27 , \"obj_name\" : \"Ascension Bay\" ,\"obj_value\" : 25},"
	 +"{\"obj_id\" : 28 , \"obj_name\" : \"Dawn’s Eyrie\" ,\"obj_value\" : 10},"
	 +"{\"obj_id\" : 29 , \"obj_name\" : \"The Spiritholme\" ,\"obj_value\" : 5},"
	 +"{\"obj_id\" : 30 , \"obj_name\" : \"Woodhaven\" ,\"obj_value\" : 10},"
	 +"{\"obj_id\" : 31 , \"obj_name\" : \"Askalion Hills\" ,\"obj_value\" : 25},"
	 +"{\"obj_id\" : 32 , \"obj_name\" : \"Etheron Hills\" ,\"obj_value\" : 25},"
	 +"{\"obj_id\" : 33 , \"obj_name\" : \"Dreaming Bay\" ,\"obj_value\" : 25},"
	 +"{\"obj_id\" : 34 , \"obj_name\" : \"Victors’s Lodge\" ,\"obj_value\" : 5},"
	 +"{\"obj_id\" : 35 , \"obj_name\" : \"Greenbriar\" ,\"obj_value\" : 10},"
	 +"{\"obj_id\" : 36 , \"obj_name\" : \"Bluelake\" ,\"obj_value\" : 10},"
	 +"{\"obj_id\" : 37 , \"obj_name\" : \"Garrison\" ,\"obj_value\" : 25},"
	 +"{\"obj_id\" : 38 , \"obj_name\" : \"Longview\" ,\"obj_value\" : 10},"
	 +"{\"obj_id\" : 39 , \"obj_name\" : \"The Godsword\" ,\"obj_value\" : 5},"
	 +"{\"obj_id\" : 40 , \"obj_name\" : \"Cliffside\" ,\"obj_value\" : 10},"
	 +"{\"obj_id\" : 41 , \"obj_name\" : \"Shadaran Hills\" ,\"obj_value\" : 25},"
	 +"{\"obj_id\" : 42 , \"obj_name\" : \"Redlake\" ,\"obj_value\" : 10},"
	 +"{\"obj_id\" : 43 , \"obj_name\" : \"Hero’s Lodge\" ,\"obj_value\" : 5},"
	 +"{\"obj_id\" : 44 , \"obj_name\" : \"Dreadfall Bay\" ,\"obj_value\" : 25},"
	 +"{\"obj_id\" : 45 , \"obj_name\" : \"Bluebriar\" ,\"obj_value\" : 10},"
	 +"{\"obj_id\" : 46 , \"obj_name\" : \"Garrison\" ,\"obj_value\" : 25},"
	 +"{\"obj_id\" : 47 , \"obj_name\" : \"Sunnyhill\" ,\"obj_value\" : 10},"
	 +"{\"obj_id\" : 48 , \"obj_name\" : \"Faithleap\" ,\"obj_value\" : 5},"
	 +"{\"obj_id\" : 49 , \"obj_name\" : \"Bluevale Refuge\" ,\"obj_value\" : 5},"
	 +"{\"obj_id\" : 50 , \"obj_name\" : \"Bluewater Lowlands\" ,\"obj_value\" : 5},"
	 +"{\"obj_id\" : 51 , \"obj_name\" : \"Astralholme\" ,\"obj_value\" : 5},"
	 +"{\"obj_id\" : 52 , \"obj_name\" : \"Arah’s Hope\" ,\"obj_value\" : 5},"
	 +"{\"obj_id\" : 53 , \"obj_name\" : \"Greenvale Refuge\" ,\"obj_value\" : 5},"
	 +"{\"obj_id\" : 54 , \"obj_name\" : \"Foghaven\" ,\"obj_value\" : 5},"
	 +"{\"obj_id\" : 55 , \"obj_name\" : \"Redwater Lowlands\" ,\"obj_value\" : 5},"
	 +"{\"obj_id\" : 56 , \"obj_name\" : \"The Titanpaw\" ,\"obj_value\" : 5},"
	 +"{\"obj_id\" : 57 , \"obj_name\" : \"Cragtop\" ,\"obj_value\" : 10},"
	 +"{\"obj_id\" : 58 , \"obj_name\" : \"Godslore\" ,\"obj_value\" : 5},"
	 +"{\"obj_id\" : 59 , \"obj_name\" : \"Redvale Refuge\" ,\"obj_value\" : 5},"
	 +"{\"obj_id\" : 60 , \"obj_name\" : \"Stargrove\" ,\"obj_value\" : 5},"
	 +"{\"obj_id\" : 61 , \"obj_name\" : \"Greenwater Lowlands\" ,\"obj_value\" : 5}]";
	
	public static Map<Integer, String> objectiveNames = null;
	
	public static void parseNames() {
		if (objectiveNames == null) {
			objectiveNames = new HashMap<>();
			
			try {
				List<ObjectiveNamesDAO> result = objectMapper.readValue(objectiveString, 
						objectMapper.getTypeFactory().constructCollectionType(List.class, ObjectiveNamesDAO.class));
				
				for (ObjectiveNamesDAO obj:result) {
					objectiveNames.put(obj.getObjectiveId(), obj.getObjectiveName());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
