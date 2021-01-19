//ArrayList remove() exercise

import java.util.ArrayList;

public class RemoveAll
{
	public static void main(String args[])
	{
		ArrayList<String> ray;
		ray = new ArrayList<String>();

		ray.add("all");
		ray.add("all");
		ray.add("fun");
		ray.add("dog");
		ray.add("bat");
		ray.add("cat");
		ray.add("all");
		ray.add("dog");
		ray.add("all");
		ray.add("all");
		System.out.println(ray);
		System.out.println(ray.size());

		//add in a loop to remove all occurrences of all


		/* (5) For loop ascending using remove all
		for(int i = 0; i < ray.size(); i++)
		{
			ray.remove("all");
		}
		System.out.println(ray);
		*/
		System.out.println(ray.size());
	}
}