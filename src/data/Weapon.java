package data;

import java.io.IOException;
import java.util.ArrayList;

public class Weapon {
	public String name, type, trigger, attack, element, base, multishot, firerate, crit, critdmg, status, reload, magsize,
		avgshot, burstdps, sustdps, avgprocpersec, reserveammo, pt, dispo, shottype, mr, intro;
	public final String[] specs;
	
	// there are 23 specs
	public Weapon(String[] specs) {
		this.specs = specs;
	}

	/* 
	 * weapons appear as:
	 * name, type, trigger, attack, element, base, multishot, firerate, crit, critdmg, status, reload, magsize,
	 * avgshot, burstdps, sustdps, avgprocpersec, reserveammo, pt, dispo, shottype, mr, intro
	 */
	public static ArrayList<Weapon> getWeaponsFromComparisonList(String URL) {
		ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
		try {
			String doc = Crawl.grab(URL);
			String[] weapons = doc.split("<tr>");
			for(String weapon : weapons) {
				weapon = weapon.split("</tr>")[0];
				if(weapon.contains("<td style=\"\">")) {
					String[] specs = weapon.replace("</td>", "")
							.replace("\n", "")
							.split("<td style=\"\">");
					//for(String s : specs) System.out.println(s);
					
					// TODO: fill Weapon objects each time, add them to array, and tie in Primary/Secondary/Melee classes to use this
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return weaponList;
	}
}
