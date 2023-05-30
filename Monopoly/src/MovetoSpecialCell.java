package ChangggeCells;

import java.util.Random;

import changeCells.Player;
import changeCells.SpecialCard;

public class MovetoSpecialCell extends SpecialCard {
	private Random rd = new Random(System.nanoTime());
	
	public MovetoSpecialCell() {
		super.ID = 5;
		super.Name = "Come Back Home";
		super.Describtion = "You will take a teleport to another Special Cell";
	}
	
	public void MovetoSpecialCells(Player player) {
		player.setPosition(getRanDomAddressSpecialCells());
	}
	
	private int getRanDomAddressSpecialCells() {
		int result = rd.nextInt(6);
		switch(result) {
			case 0:{
				return getStreetAddress();
			}
			case 1:{
				 return 30;
			}
			case 2:{
				return 20;
			}
			case 3:{
				return 0;
			} 
			case 4:{
				return getTaxAddress();
			}
			case 5:{
				return 2;
			}
			default : return -1;
		}
	}
	private int getStreetAddress() {
		int result = rd.nextInt(4);
		switch(result) {
		case 0 : return 7;
		case 1 : return 17;
		case 2 : return 22;
		case 3 : return 36;
		default: return -1;
	}
	}
	private int getTaxAddress() {
		int result = rd.nextInt(2);
		switch(result) {
		case 0 : return 4;
		case 1 : return 38;
		default: return -1;
		}
		}
}
