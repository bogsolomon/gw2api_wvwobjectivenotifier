package ca.bsolomon.gw2.wvw.objective;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Ajax;
import org.primefaces.component.datatable.DataTable;

import ca.bsolomon.gw2.api.wvw.dao.WvWMatch;
import ca.bsolomon.gw2.wvw.objective.dao.ServerID;
import ca.bsolomon.gw2.wvw.objective.util.ObjectiveNames;

@ManagedBean(name="checkboxBean")
@SessionScoped
public class CheckboxBean {

	private List<String> selectedObjectives = new ArrayList<>();
	  
    private Map<String,String> objectives;  

    private int eastSize = 300;
    private boolean eastCollapsed;
    
    private String serv1Name;
    private String serv2Name;
    private String serv3Name;
    
    public CheckboxBean() {  
    	objectives = new LinkedHashMap<String, String>();
    	
    	ObjectiveNames.parseNames();
    	for (String name:ObjectiveNames.objectiveNames.values()) {
    		objectives.put(name, name);
    	}
    	
    	WvWMatch match = WvWObjectiveDataRetrieverJob.getSorMatch();
    	
    	if (match != null) {
    		serv1Name = ServerID.getByID(match.getRedWorldId()).getName();
    		serv2Name = ServerID.getByID(match.getGreenWorldId()).getName();
    		serv3Name = ServerID.getByID(match.getBlueWorldId()).getName();
    	}
    }
    
    public void handleCheckbox(DataTable serv1Table, DataTable serv2Table, DataTable serv3Table, DataTable ebTable) {  
		Ajax.update(serv1Table.getClientId());
		Ajax.update(serv2Table.getClientId());
		Ajax.update(serv3Table.getClientId());
		Ajax.update(ebTable.getClientId());
	}

	public List<String> getSelectedObjectives() {
		return selectedObjectives;
	}

	public void setSelectedObjectives(List<String> selectedObjectives) {
		this.selectedObjectives = selectedObjectives;
	}

	public Map<String, String> getObjectives() {
		return objectives;
	}

	public void setObjectives(Map<String, String> objectives) {
		this.objectives = objectives;
	}

	public int getEastSize() {
		return eastSize;
	}

	public void setEastSize(int eastSize) {
		this.eastSize = eastSize;
	}

	public boolean isEastCollapsed() {
		return eastCollapsed;
	}

	public void setEastCollapsed(boolean eastCollapsed) {
		this.eastCollapsed = eastCollapsed;
	}

	public String getServ1Name() {
		return serv1Name;
	}

	public String getServ2Name() {
		return serv2Name;
	}

	public String getServ3Name() {
		return serv3Name;
	}
}
