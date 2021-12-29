package proj.stocktaking.instances;

public class Device 
{
	private String name;
	private int id;
	private int issueAmount;
	private int inStock;
	
	public Device(String name, int id, int issueAmount, int inStock)
	{
		this.name = name;
		this.id = id;
		this.issueAmount = issueAmount;
		this.inStock = inStock;
	}

	public String getName() 
	{
		return name;
	}

	public int getId() 
	{
		return id;
	}

	public int getIssueAmount() 
	{
		return issueAmount;
	}
	
	public void increaseIssueAmountBy(int value)
	{
		this.issueAmount += value;
		this.inStock -= value;
	}
	
	public int getInStock() 
	{
		return inStock;
	}
}
