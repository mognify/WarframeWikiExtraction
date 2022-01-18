package data;

import java.util.ArrayList;

public class Melee {
	static ArrayList<Weapon> weapons;
	
	public static void populate() {
		final String URL = "https://warframe.fandom.com/wiki/Weapon_Comparison#Melee_";
		weapons = Weapon.getWeaponsFromComparisonList(URL);
	}
}
