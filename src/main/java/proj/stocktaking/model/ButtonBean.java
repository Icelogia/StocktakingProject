package proj.stocktaking.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean (name = "buttonBeans")
@SessionScoped
public class ButtonBean 
{
	final private String addPage = "DeviceChange.xhtml";
	final private String removePage = "DeleteDeviceChange.xhtml";
	final private String issuePage = "Issue.xhtml";
	final private String returnPage = "ReturnIssue.xhtml";
	final private String historyPage = "History.xhtml";
	final private String devicesPage = "Devices.xhtml";
	final private String redirectText = "?faces-redirect=true";
	
	public String getAddPage() 
	{
		return addPage + redirectText;
	}
	
	public String getRemovePage() 
	{
		return removePage + redirectText;
	}
	public String getIssuePage() 
	{
		return issuePage + redirectText;
	}
	
	public String getReturnPage() 
	{
		return returnPage + redirectText;
	}
	
	public String getHistoryPage() 
	{
		return historyPage + redirectText;
	}
	
	public String getDevicesPage() 
	{
		return devicesPage + redirectText;
	}
}
