package Gladiator;

import java.util.HashMap;
import java.util.Map;

public class Player {
	private int Hp , weaponDamage;
	private String name;
	private boolean armor;
	private static Map<String,Integer> playerHealth = new HashMap<>();
	private static Map<String,Boolean> playerArmor = new HashMap<>();
	
	public Player (String name) {
		this.name = name;
		this.Hp = 100;
		this.weaponDamage = 20;
		this.armor = false;
		playerHealth.put(this.name , this.Hp);
		playerArmor.put(this.name, this.armor);
	}
	
	public void Attack(String name) {
		if (playerArmor.get(name)) {
			int newHp = playerHealth.get(name) - this.weaponDamage/2;
			if (newHp>0) {
				playerHealth.replace(name,newHp);				
			}
			else {
				playerHealth.remove(name);
				System.out.println(name+" is dead !");
			}
		}
		else {
			int newHp = playerHealth.get(name) - this.weaponDamage;
			if (newHp>0) {
				playerHealth.replace(name,newHp);				
			}
			else {
				playerHealth.remove(name);
				System.out.println(name+" is dead !");
			}
			playerHealth.replace(name,newHp);
		}
		System.out.println(this.name+" attacked "+name);
	}
	
	public void showDetails() {
		System.out.println(this.name +" Hp = "+playerHealth.get(this.name)+" Armor = "+playerArmor.get(this.name)+" weapon damage = "+this.weaponDamage);
	}
	
	public void buyArmor() {
		if (playerArmor.get(this.name)) {
			System.out.println("You have already armor");
		}
		else {
			playerArmor.replace(name,true);
			this.armor = true;
			System.out.println("The armor bought");
		}
	}
	
	public void upgradeWeapon() {
		this.weaponDamage *=2;
		System.out.println("Your weapon enchanted");
	}
}