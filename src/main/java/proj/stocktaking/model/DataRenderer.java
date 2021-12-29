package proj.stocktaking.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import proj.stocktaking.data.ActionHistory;
import proj.stocktaking.data.DatabaseConnector;
import proj.stocktaking.data.DeviceStorage;
import proj.stocktaking.instances.Device;
import proj.stocktaking.instances.HistoryItem;
import proj.stocktaking.instances.StorageItem;

@ManagedBean (name = "renderer")
@SessionScoped
public class DataRenderer implements Serializable
{
	private ActionHistory history;
	private DeviceStorage storage;
	
	private List<HistoryItem> historyList;
	private List<Device> deviceList;
	
	public DataRenderer()
	{
		try 
		{
			DatabaseConnector.getConnection();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		history = new ActionHistory();
		storage = new DeviceStorage();

		historyList = history.getHistory();
		deviceList = storage.getDeviceList();
	}
	
	public List<HistoryItem> getHistoryList()
	{
		return historyList;
	}
	
	public List<Device> getDeviceList()
	{
		return deviceList;
	}
	
}
