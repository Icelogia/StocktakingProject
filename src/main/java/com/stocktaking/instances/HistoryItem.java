package com.stocktaking.instances;

import java.util.Date;

public class HistoryItem 
{
	public String deviceName;
	public String workerName;
	public Actions action;
	public Date dateOfAction;
	
	public HistoryItem(String deviceName, String workerName, Actions action, Date dateOfAction)
	{
		this.deviceName = deviceName;
		this.workerName = workerName;
		this.action = action;
		this.dateOfAction = dateOfAction;
	}
	
	public String getDeviceName()
	{
		return this.deviceName;
	}
	
	public String getWorkerName()
	{
		return this.workerName;
	}
	
	public String getAction()
	{
		return this.action.toString();
	}
	
	public String getDateOfAction()
	{
		return this.dateOfAction.toString();
	}
}
