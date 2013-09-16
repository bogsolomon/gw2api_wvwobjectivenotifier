package ca.bsolomon.gw2.wvw.objective;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Ajax;
import org.primefaces.component.datatable.DataTable;

import ca.bsolomon.gw2.api.wvw.dao.Maps;
import ca.bsolomon.gw2.api.wvw.dao.Objective;
import ca.bsolomon.gw2.wvw.objective.util.ObjectiveNames;

@ManagedBean(name="ajaxPollBean")
@SessionScoped
public class AjaxPollBean {
	
	@ManagedProperty(value="#{checkboxBean}")
	private CheckboxBean checkboxBean;
	
	private ConcurrentMap<Integer, String> objectiveOwners = new ConcurrentHashMap<>();
	
	public void updateEventServer(DataTable serv1Table, DataTable serv2Table, DataTable serv3Table, DataTable ebTable) {
		List<Maps> maps = WvWObjectiveDataRetrieverJob.getWvwMaps();
    	
    	for (Maps map:maps) {
    		if (map.getType().equals("RedHome")) {
    			processMapData(map, serv1Table);
    		} else if (map.getType().equals("GreenHome")) {
    			processMapData(map, serv2Table);
    		} else if (map.getType().equals("BlueHome")) {
    			processMapData(map, serv3Table);
    		}  else {
    			processMapData(map, ebTable);
    		}
    	}
	}
	
	private void processMapData(Maps map, DataTable serv1Table) {
		List<String> selectedObjectives = checkboxBean.getSelectedObjectives();
		
		for (Objective objective:map.getObjectives()) {
			String name = ObjectiveNames.objectiveNames.get(objective.getId());
			
			if (selectedObjectives.contains(name)) {
				if (objectiveOwners.get(objective.getId()) == null || !objectiveOwners.get(objective.getId()).equals(objective.getOwner())) {
					Ajax.update(serv1Table.getClientId());
				}
				
				objectiveOwners.put(objective.getId(), objective.getOwner());
			}
		}
	}

	public void setCheckboxBean(CheckboxBean checkboxBean) {
		this.checkboxBean = checkboxBean;
	}
}