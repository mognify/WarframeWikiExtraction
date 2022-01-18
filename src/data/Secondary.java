package data;

import java.util.ArrayList;

public class Secondary {
	static ArrayList<Weapon> weapons;
	
	public static void populate() {
		final String URL = "https://warframe.fandom.com/wiki/Weapon_Comparison#Secondary_";
		weapons = Weapon.getWeaponsFromComparisonList(URL);
	}
}
