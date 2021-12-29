package proj.stocktaking.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import proj.stocktaking.instances.Actions;
import proj.stocktaking.instances.Device;
import proj.stocktaking.instances.HistoryItem;
import proj.stocktaking.instances.Worker;

final public class DatabaseConnector 
{
	static private Connection conn;
	static private Statement st;
	static private ResultSet rs;
	
	private DatabaseConnector(){}
	
	public static Connection getConnection() throws Exception
	{
		try 
		{
			String url = "jdbc:mysql://localhost:3306/stocktaking";
			String username = "root";
			String password = "";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			st = conn.createStatement();
			
			System.out.println("Connected");
			return conn;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	static public List<Worker> getWorkers()
	{
		String query = "select * from workers";
		try 
		{
			rs = st.executeQuery(query);
			
			List<Worker> workers = new ArrayList<Worker>();
			
			while(rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				
				Worker w = new Worker(name, surname, id);
				workers.add(w);
			}
			
			return workers;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static List<Device> getDevices()
	{
		String query = "select * from device";
		try 
		{
			rs = st.executeQuery(query);
			
			List<Device> devices = new ArrayList<Device>();
			
			while(rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int issueAmount = rs.getInt("issueAmount");
				int inStock = rs.getInt("inStock");
				
				Device d = new Device(name, id, issueAmount, inStock);
				devices.add(d);
				
			}
			
			return devices;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static List<HistoryItem> getHistory(List<Device> devices, List<Worker> workers)
	{
		String query = "select * from history";
		try 
		{
			rs = st.executeQuery(query);
			
			List<HistoryItem> history = new ArrayList<HistoryItem>();
			
			while(rs.next())
			{
				int deviceId = rs.getInt("device");
				int workerId = rs.getInt("worker");
				Date date = rs.getDate("date");
				String activity = rs.getString("activity");
				int amount = rs.getInt("amount");
				
				String deviceName = getDeviceNameById(deviceId, devices);
				String workerName = getWorkerNameById(workerId, workers);
				
				
				HistoryItem hi = new HistoryItem(deviceName, workerName, Actions.valueOf(activity),  date);
				history.add(hi);
				
			}
			
			return history;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static List<HistoryItem> getHistory()
	{
		List<Device> devices = DatabaseConnector.getDevices();
		List<Worker> workers = DatabaseConnector.getWorkers();
		
		String query = "select * from history";
		try 
		{
			rs = st.executeQuery(query);
			
			List<HistoryItem> history = new ArrayList<HistoryItem>();
			
			while(rs.next())
			{
				int deviceId = rs.getInt("device");
				int workerId = rs.getInt("worker");
				Date date = rs.getDate("date");
				String activity = rs.getString("activity");
				int amount = rs.getInt("amount");
				
				String deviceName = getDeviceNameById(deviceId, devices);
				String workerName = getWorkerNameById(workerId, workers);
				
				
				HistoryItem hi = new HistoryItem(deviceName, workerName, Actions.valueOf(activity),  date);
				history.add(hi);
				
			}
			
			return history;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static String getWorkerNameById(int id, List<Worker> workers)
	{
		String workerName = null;
		
		for(int i = 0; i < workers.size(); i++)
		{
			if(workers.get(i).getId() == id)
			{
				workerName = workers.get(i).getName() + " " + workers.get(i).getSurname();
				break;
			}
		}
		
		return workerName;
	}
	
	private static String getDeviceNameById(int id, List<Device> devices)
	{
		String deviceName = null;
		
		for(int i = 0; i < devices.size(); i++)
		{
			if(devices.get(i).getId() == id)
			{
				deviceName = devices.get(i).getName();
				break;
			}
		}
		
		return deviceName;
	}
}
