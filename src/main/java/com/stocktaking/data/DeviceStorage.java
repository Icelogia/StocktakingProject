package com.stocktaking.data;

import java.util.ArrayList;
import java.util.List;

import com.stocktaking.instances.StorageItem;


public class DeviceStorage 
{
	private List<StorageItem> storage;
	
	public DeviceStorage() 
	{
		storage = new ArrayList<StorageItem>();
		downloadData();
	}
	
	
	public void refresh()
	{
		downloadData();
	}
	
	private void downloadData()
	{
		//Connection to database
		StorageItem device = new StorageItem("device", 5, 5);
		storage.add(device);
		storage.add(device);
		storage.add(device);
		storage.add(device);
		storage.add(device);
	}


	public List<StorageItem> getDeviceList() 
	{
		return storage;
	}
}
