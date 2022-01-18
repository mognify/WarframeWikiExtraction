package data;

import java.util.ArrayList;

public class Primary {
	static ArrayList<Weapon> weapons;
	
	public static void populate() {
		final String URL = "https://warframe.fandom.com/wiki/Weapon_Comparison#Primary_";
		weapons = Weapon.getWeaponsFromComparisonList(URL);
	}
}
