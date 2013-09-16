package ca.bsolomon.gw2.wvw.objective;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import ca.bsolomon.gw2.api.wvw.dao.WvWMatch;
import ca.bsolomon.gw2.wvw.objective.dao.Status;

@ManagedBean(name="wvwObjectiveBean")
@SessionScoped
public class WvWObjectiveBean {

	@ManagedProperty(value="#{checkboxBean}")
	private CheckboxBean checkboxBean;
	
	public WvWObjectiveBean() {
		WvWMatch match = WvWObjectiveDataRetrieverJob.getSorMatch();
		
	}
	
	public List<Status> getRedWorldStatus() {
		return processData(WvWObjectiveDataRetrieverJob.getRedStatus());
	}
	
	public List<Status> getGreenWorldStatus() {
		return processData(WvWObjectiveDataRetrieverJob.getGreenStatus());
	}
	
	public List<Status> getBlueWorldStatus() {
		return processData(WvWObjectiveDataRetrieverJob.getBlueStatus());
	}
	
	public List<Status> getEbWorldStatus() {
		return processData(WvWObjectiveDataRetrieverJob.getEbStatus());
	}

	private List<Status> processData(List<Status> ebStatus) {
		List<Status> statuses = new ArrayList<>();
		
		List<String> selectedObjectives = checkboxBean.getSelectedObjectives();
		
		if (ebStatus != null) {
			for (Status s:ebStatus) {
				if (selectedObjectives.contains(s.getObjective())) {
					statuses.add(s);
				}
			}
		}
		
		return statuses;
	}
	
	public void setCheckboxBean(CheckboxBean checkboxBean) {
		this.checkboxBean = checkboxBean;
	}
}
