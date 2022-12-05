package Gladiator;

import Gladiator.*;

public class Main {

	public static void main(String[] args) {
		Player gladiator = new Player("gladiator");
		Player soldier = new Player("soldier");
		
		soldier.buyArmor();
		soldier.showDetails();
		
		gladiator.upgradeWeapon();
		gladiator.upgradeWeapon();
		gladiator.upgradeWeapon();
		
		soldier.Attack("gladiator");
		
		gladiator.showDetails();
		
		gladiator.Attack("soldier");
		soldier.showDetails();
	}

}
