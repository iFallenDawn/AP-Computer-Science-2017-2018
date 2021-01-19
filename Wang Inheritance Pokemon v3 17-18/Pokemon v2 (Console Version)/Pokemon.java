//Jordan Wang

public class Pokemon
{
	private String attack;
	private int health;
	public Pokemon()
	{
		attack = "";
		health = 0;
	}
	public Pokemon(String attack, int health)
	{
		this.attack = attack;
		this.health = health;
	}
	public int getHealth()
	{
		return health;
	}
	public String getAttack()
	{
		return attack;
	}
	public void calculateHealth(int damage)
	{
		health -=  damage;
	}
	public String toString()
	{
		String result = "";
		result+= "Health: " + health + "/20\n";
		return result;
	}
}