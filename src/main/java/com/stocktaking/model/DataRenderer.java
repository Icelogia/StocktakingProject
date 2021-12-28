package com.stocktaking.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.stocktaking.data.ActionHistory;
import com.stocktaking.data.DeviceStorage;
import com.stocktaking.instances.HistoryItem;
import com.stocktaking.instances.StorageItem;

@ManagedBean (name = "renderer")
@SessionScoped
public class DataRenderer implements Serializable
{
	private ActionHistory history;
	private DeviceStorage storage;
	
	private List<HistoryItem> historyList;
	private List<StorageItem> deviceList;
	private List<String> devicesNames;
	
	public DataRenderer()
	{
		history = new ActionHistory();
		storage = new DeviceStorage();
		devicesNames = new ArrayList<String>();
		devicesNames.add("Raj");
		devicesNames.add("Lol");
		devicesNames.add("XED");
		
		historyList = history.getHistory();
		deviceList = storage.getDeviceList();
	}
	
	public List<HistoryItem> getHistoryList()
	{
		return historyList;
	}
	
	public List<StorageItem> getDeviceList()
	{
		return deviceList;
	}
	
	public List<String> getDevicesNames()
	{
		return devicesNames;
	}
}
