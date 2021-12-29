package proj.stocktaking.instances;

public class Worker 
{
	private String name;
	private String surname;
	private int id = 0;
	
	public Worker(String name, String surname, int id)
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

	public int getId() 
	{
		return id;
	}
}
