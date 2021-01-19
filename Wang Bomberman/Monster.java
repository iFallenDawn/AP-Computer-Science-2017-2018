//Jordan Wang
//
//

public class Monster
{
	private int speed, health;
	private boolean alive;
	public Monster()
	{
		speed = 5;
		health = 3;
		alive = true;
	}
	public int getHealth()
	{
		return health;
	}
	public void decrementHealth()
	{
		health--;
	}
}