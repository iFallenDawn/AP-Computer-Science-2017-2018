//Jordan Wang

public class Starter extends Pokemon
{
	private String name, attack, type;
	private int health;
	public Starter()
	{
		name = "";
		attack = "";
		type = "";
		health = 0;
	}
	public Starter(String attack, int health, String name, String type)
	{
		super(attack, health);
		this.type = type;
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String toString()
	{
		return "Pokemon: " + name + "\nType: " + type + "\n" + super.toString();
	}
}