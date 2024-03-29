package ca.bsolomon.gw2.wvw.objective;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.GJChronology;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;
import org.primefaces.model.Visibility;

@ManagedBean(name="dashboardBean")
@SessionScoped
public class DashboardBean implements Serializable {

	Chronology gregorianJuian = GJChronology.getInstance(DateTimeZone.UTC);
	
	private static final long serialVersionUID = 1L;
	private DashboardModel model;  
	
	private boolean serv1Collapsed = false;
	private boolean serv2Collapsed = false;
	private boolean serv3Collapsed = false;
	private boolean ebCollapsed = false;
	
	private DateTime lastChange = new DateTime(gregorianJuian);
	
    public DashboardBean() {  
        model = new DefaultDashboardModel();  
        DashboardColumn column1 = new DefaultDashboardColumn();  
        DashboardColumn column2 = new DefaultDashboardColumn();  
        DashboardColumn column3 = new DefaultDashboardColumn();  
        DashboardColumn column4 = new DefaultDashboardColumn();
          
        column1.addWidget("serv1Panel");
        column2.addWidget("serv2Panel");
        column3.addWidget("serv3Panel");
        column4.addWidget("ebPanel");  
        
        model.addColumn(column1);
        model.addColumn(column2); 
        model.addColumn(column3); 
        model.addColumn(column4); 
    }
    
    public DashboardModel getModel() {  
        return model;  
    }

	public boolean isServ1Collapsed() {
		return serv1Collapsed;
	}
	
	public void handleServ1Toggle(ToggleEvent event) {
    	serv1Collapsed = (event.getVisibility() == Visibility.HIDDEN);
    }
    
	public boolean isServ2Collapsed() {
		return serv2Collapsed;
	}
	
	public void handleServ2Toggle(ToggleEvent event) {
    	serv2Collapsed = (event.getVisibility() == Visibility.HIDDEN);
    }
	
	public boolean isServ3Collapsed() {
		return serv3Collapsed;
	}
	
	public void handleServ3Toggle(ToggleEvent event) {
    	serv3Collapsed = (event.getVisibility() == Visibility.HIDDEN);
    }

	public boolean isEbCollapsed() {
		return ebCollapsed;
	}
	
	public void handleEBToggle(ToggleEvent event) {
    	ebCollapsed = (event.getVisibility() == Visibility.HIDDEN);
    }
}
