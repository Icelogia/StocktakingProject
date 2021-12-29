package proj.stocktaking.data;

import java.util.ArrayList;
import java.util.List;

import proj.stocktaking.instances.Device;
import proj.stocktaking.instances.StorageItem;


public class DeviceStorage 
{
	private List<Device> storage;
	
	public DeviceStorage() 
	{
		storage = new ArrayList<Device>();
		downloadData();
	}
	
	
	public void refresh()
	{
		downloadData();
	}
	
	private void downloadData()
	{
		//Connection to database
		this.storage = DatabaseConnector.getDevices();
	}


	public List<Device> getDeviceList() 
	{
		return storage;
	}
}
