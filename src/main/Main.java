package main;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;

import data.Crawl;
import data.Primary;

public class Main {

	public static void main(String[] args) {
		Primary.populate();
		
		/*String[] warframeNames = getWarframeNames();
		for(String s : warframeNames) {
			getWarframeAbilities(s);*/
			/*try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
	}

	private static ArrayList<Ability> getWarframeAbilities(String s) {
		ArrayList<Ability> abilities = new ArrayList<Ability>();
		System.out.println(s);
		
		try {
			String doc = Crawl.grab("https://warframe.fandom.com/wiki/" + s);
			String[] warframeAbilities = doc.split("ability-box");
			//String[] temp = new String[warframeAbilities.length-1];
			
			for(int i = 0; i < warframeAbilities.length; i++) {
				String name = warframeAbilities[i].split("title=\"")[1].split("\"")[0];
				if(name.equals("Edit") || name.contains("WARFRAME Wiki")) continue;
				//System.out.println(name);
				//temp[i-1] = name;
				
				String cost = warframeAbilities[i]
						.split("/wiki/Warframe_Attributes#Energy")[1]
						.split("</span")[1]
						.split("bold;\">")[1]
						.replace("&nbsp;", "")
						.replace("<br>", "\n\t\t\t\t")
						.replace("</br>", "")
						.replace("</p>", "")
						.replace("<p>", "")
						.replace("<sup>", "^")
						.replace("</sup>", "");
				
				String strength = warframeAbilities[i]
						.split("/wiki/Ability_Strength")[1]
						.split("</span")[1]
						.split("12px;\">")[1]
						.replace("&nbsp;", "")
						.replace("<br>", "\n\t\t\t\t")
						.replace("</br>", "")
						.replace("</p>", "")
						.replace("<p>", "")
						.replace("<sup>", "^")
						.replace("</sup>", "");
				/*if(strength.contains("<span")) {
					String[] stemp = strength.split("<span");
					for(String st : stemp)
						strength += "\n\t\t\t\t" + st;
				}*/
				
				String duration = warframeAbilities[i]
						.split("/wiki/Ability_Duration")[1]
						.split("</span")[1]
						.split("12px;\">")[1]
						.replace("&nbsp;", "")
						.replace("<br>", "\n\t\t\t\t")
						.replace("</br>", "")
						.replace("</p>", "")
						.replace("<p>", "")
						.replace("<sup>", "^")
						.replace("</sup>", "");
				
				String range = warframeAbilities[i]
						.split("/wiki/Ability_Range")[1]
						.split("</span")[1]
						.split("12px;\">")[1]
						.replace("&nbsp;", "")
						.replace("<br>", "\n\t\t\t\t")
						.replace("</br>", "")
						.replace("</p>", "")
						.replace("<p>", "")
						.replace("<sup>", "^")
						.replace("</sup>", "");

				Ability a = new Ability(name, cost, strength, duration, range);
				System.out.println(a + "\n");
				abilities.add(a);
			}
		} catch (IOException e) {
			abilities.add(new Ability("Err", "0", "0", "0", "0"));
		}
		
		return abilities;
	}

	private static String[] getWarframeNames() {
		try {
			String doc = Jsoup.connect("https://warframe.fandom.com/wiki/Warframes").get().toString();
			String[] warframeNames = doc.split("WarframeNavBoxText");
			String[] temp = new String[warframeNames.length-1];
			
			for(int i = 1; i < warframeNames.length; i++) {
				String name = warframeNames[i].split("title=\"")[1].split("\"")[0];
				//System.out.println(name);
				temp[i-1] = name;
			}
			
			return temp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
