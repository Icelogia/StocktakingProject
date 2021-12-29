package proj.stocktaking.instances;

public class StorageItem 
{
	public String deviceName;
	public int issueAmount;
	public int inStock;
	
	public StorageItem(String deviceName, int issueAmount, int inStock)
	{
		this.deviceName = deviceName;
		this.issueAmount = issueAmount;
		this.inStock = inStock;
	}
	
	public String getDeviceName()
	{
		return this.deviceName;
	}
	
	public String getIssueAmount()
	{
		return String.valueOf(this.issueAmount);
	}
	
	public String getInStock()
	{
		return String.valueOf(this.inStock);
	}
}
