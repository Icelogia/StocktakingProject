package com.stocktaking.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.stocktaking.instances.Actions;
import com.stocktaking.instances.HistoryItem;

public class ActionHistory 
{
	private List<HistoryItem> history;
	
	
	public ActionHistory() 
	{
		history = new ArrayList<HistoryItem>();
		downloadData();
	}
	
	
	public void refresh()
	{
		downloadData();
	}
	
	private void downloadData()
	{
		//Connection to database
		HistoryItem historyItem = new HistoryItem("device", "Michal Wysocki", Actions.Add, new Date());
		history.add(historyItem);
		history.add(historyItem);
		history.add(historyItem);
		history.add(historyItem);
		history.add(historyItem);
	}


	public List<HistoryItem> getHistory() 
	{
		return history;
	}
}
