package com.stocktaking.instances;

public class Device 
{
	private String name;
	private String id;
	private int amount;
	
	public Device(String name, String id, int amount)
	{
		this.name = name;
		this.id = id;
		this.amount = amount;
	}

	public String getName() 
	{
		return name;
	}

	public String getId() 
	{
		return id;
	}

	public int getAmount() 
	{
		return amount;
	}
	
	public void increaseBy(int value)
	{
		this.amount += value;
	}
}
