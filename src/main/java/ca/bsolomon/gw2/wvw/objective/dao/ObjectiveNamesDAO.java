package ca.bsolomon.gw2.wvw.objective.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectiveNamesDAO {

	@JsonProperty("obj_id")
	private int objectiveId;
	@JsonProperty("obj_name")
	private String objectiveName;
	
	public int getObjectiveId() {
		return objectiveId;
	}
	public void setObjectiveId(int objectiveId) {
		this.objectiveId = objectiveId;
	}
	public String getObjectiveName() {
		return objectiveName;
	}
	public void setObjectiveName(String objectiveName) {
		this.objectiveName = objectiveName;
	}
}
