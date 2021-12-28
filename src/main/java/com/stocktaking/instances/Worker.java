package com.stocktaking.instances;

public class Worker 
{
	private String name;
	private String surname;
	private String deviceId = null;
	
	public Worker(String name, String surname)
	{
		this.name = name;
		this.surname = surname;
	}

	public String getName() 
	{
		return name;
	}

	public String getSurname() 
	{
		return surname;
	}

	public String getDeviceId() 
	{
		return deviceId;
	}

	public void setDeviceId(String deviceId) 
	{
		this.deviceId = deviceId;
	}
}
