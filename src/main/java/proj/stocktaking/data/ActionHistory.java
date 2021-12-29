package proj.stocktaking.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import proj.stocktaking.instances.Actions;
import proj.stocktaking.instances.HistoryItem;

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
		history = DatabaseConnector.getHistory();
	}


	public List<HistoryItem> getHistory() 
	{
		return history;
	}
}
