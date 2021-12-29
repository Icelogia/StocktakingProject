package proj.stocktaking.model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import proj.stocktaking.data.ActionHistory;
import proj.stocktaking.data.DatabaseConnector;
import proj.stocktaking.data.DeviceStorage;
import proj.stocktaking.instances.Actions;
import proj.stocktaking.instances.Device;
import proj.stocktaking.instances.HistoryItem;
import proj.stocktaking.instances.Worker;

@ManagedBean (name = "renderer")
public class DataRenderer
{
	private static final long serialVersionUID = 1L;
	private ActionHistory history;
	private DeviceStorage storage;
	
	private static List<HistoryItem> historyList;
	private static List<Device> deviceList;
	
	
	private static String workerName = "";
	private static String deviceName = "";
	private static int amount = 0;
	
	private static boolean isCreated = false;


	public DataRenderer()
	{
		if(!DataRenderer.isCreated)
		{
			System.out.println("Renderer Created");
			try 
			{
				DatabaseConnector.getConnection();
				DataRenderer.isCreated = true;
				
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			updateDevices();
			updateHisotry();
		}
		
	}
	
	
	public List<HistoryItem> getHistoryList()
	{
		return historyList;
	}
	
	public List<Device> getDeviceList()
	{
		return deviceList;
	}
	
	public void updateDevices()
	{
		storage = new DeviceStorage();
		deviceList = storage.getDeviceList();
	}
	
	public void updateHisotry()
	{
		history = new ActionHistory();
		historyList = history.getHistory();
	}
	
	public void issueSubmit()
	{
		Worker worker = findWorker(workerName);
		Device device = findDevice(deviceName);
		device.increaseIssueAmountBy(amount);
		
		DatabaseConnector.addHistoryItem(device, worker, Actions.Issue, amount);
		DatabaseConnector.updateDevice(device);
		
		updateDevices();
		updateHisotry();
	}
	
	public void returnSubmit()
	{
		Worker worker = findWorker(workerName);
		Device device = findDevice(deviceName);
		device.increaseIssueAmountBy(-amount);
		
		DatabaseConnector.addHistoryItem(device, worker, Actions.Return, amount);
		DatabaseConnector.updateDevice(device);
		
		updateDevices();
		updateHisotry();
	}
	
	public void addSubmit()
	{
		Device device = findDevice(deviceName);
		device.increaseInStockAmountBy(amount);
		
		DatabaseConnector.addHistoryItem(device, null, Actions.Return, amount);
		DatabaseConnector.updateDevice(device);
		
		updateDevices();
		updateHisotry();
	}
	
	public void deleteSubmit()
	{
		Device device = findDevice(deviceName);
		device.increaseInStockAmountBy(-amount);
		
		DatabaseConnector.addHistoryItem(device, null, Actions.Return, amount);
		DatabaseConnector.updateDevice(device);
		
		updateDevices();
		updateHisotry();
	}
	
	private Device findDevice(String name)
	{
		for(int i = 0; i < DataRenderer.deviceList.size(); i++)
		{
			String deviceName = DataRenderer.deviceList.get(i).getName();
			System.out.println(deviceName);
			
			if(deviceName.equals(name))
			{
				return DataRenderer.deviceList.get(i);
			}
		}
		
		return null;
	}
	
	private Worker findWorker(String name)
	{
		List<Worker> workerList = DatabaseConnector.getWorkers();
		
		
		for(int i = 0; i < workerList.size(); i++)
		{
			String w = workerList.get(i).getName() + " " + workerList.get(i).getSurname();
			if(w.equals(name))
			{
				return workerList.get(i);
			}
		}
		
		return null;
	}
	///////////////////////////////////Getters & Setters///////////////////////////////////////////////

	public  String getWorkerName() 
	{
		return workerName;
	}
	
	public  void setWorkerName(String workerName)
	{
		DataRenderer.workerName = workerName;
	}
	
	public void processWorkerNameChange(ValueChangeEvent event)
	{
		DataRenderer.workerName = event.getNewValue().toString();
	}

	public String getDeviceName() 
	{
		return deviceName;
	}
	
	public  void setDeviceName(String deviceName)
	{
		System.out.println(deviceName);
		DataRenderer.deviceName = deviceName;
	}

	public void processDeviceNameChange(ValueChangeEvent event)
	{
		DataRenderer.deviceName = event.getNewValue().toString();
	}

	public  int getAmount() {
		return amount;
	}


	public  void setAmount(int amount) 
	{
		DataRenderer.amount = amount;
	}

	public void processAmountChange(ValueChangeEvent event)
	{
		System.out.println(amount);
		DataRenderer.amount = Integer.valueOf(event.getNewValue().toString());
	}
	
}
