package proj.stocktaking.model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import proj.stocktaking.data.ActionHistory;
import proj.stocktaking.data.DatabaseConnector;
import proj.stocktaking.data.DeviceStorage;
import proj.stocktaking.instances.Device;
import proj.stocktaking.instances.HistoryItem;

@ManagedBean (name = "renderer")
public class DataRenderer
{
	private static final long serialVersionUID = 1L;
	private ActionHistory history;
	private DeviceStorage storage;
	
	private List<HistoryItem> historyList;
	private List<Device> deviceList;
	
	
	private static String workerName = "Default";
	private static String deviceName = "Default";
	private static int amount = 0;
	
	public DataRenderer()
	{
		System.out.print("Renderer Created");
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
	
	public void updateDevice()
	{
		
	}
	
	public void updateHisotry()
	{
		System.out.println(workerName);
		System.out.println(deviceName);
		System.out.println(amount);
		
	}
	///////////////////////////////////Getters & Setters///////////////////////////////////////////////

	public String getWorkerName() 
	{
		return workerName;
	}

	public void setWorkerName(String workerName) 
	{
		System.out.println(workerName);
		System.out.println("1");
		DataRenderer.workerName = workerName;
	}
	
	public void processValueChange(ValueChangeEvent event)
	{
		System.out.println("1");
		DataRenderer.workerName = event.getNewValue().toString();
	}

	public String getDeviceName() 
	{
		return deviceName;
	}

	public void setDeviceName(String deviceName) 
	{
		System.out.println(deviceName);
		System.out.println("1");
		DataRenderer.deviceName = deviceName;
	}

	public int getAmount() 
	{
		return amount;
	}

	public void setAmount(String amount) 
	{
		this.amount = Integer.valueOf(amount);
	}
	
}
