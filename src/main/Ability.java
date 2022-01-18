package main;

public class Ability {
	public final String name;
	public final String cost;
	public final String strength;
	public final String duration;
	public final String range;
	
	public Ability(String name, String cost, String strength, String duration, String range) {
		this.name = name;
		this.cost = cost;
		this.strength = strength;
		this.duration = duration;
		this.range = range;
	}
	
	public String toString() {
		/*String str = "", r = "";
		
		for(double s : strength)
			str += s + " \\ ";
		for(double ran : range)
			r += ran + " \\ ";*/
		
		return "\t" + name
				+ "\n\t\tCost:\t" + cost
				+ "\n\t\tStrength:\t" + strength//str
				+ "\n\t\tDuration:\t" + duration
				+ "\n\t\tRange:\t" + range; 
	}
}
