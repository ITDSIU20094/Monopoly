package ChangggeCells;

import java.util.Random;

public class Deck {
	private Random rd = new Random(System.nanoTime());
	
	public SpecialCard drawCard() {
		int result = rd.nextInt(6);
		switch(result) {
			case 0:{
				return new SpecialCard();
			}
			case 1:{
				return new ARoll();
			}
			case 2:{
				return new PrisonTicket();
			}
			case 3:{
				return new GiveMoney();
			}
			case 4:{
				return new ReceiveMoney();
			}
			case 5:{
				return new MovetoSpecialCell();
			}
			
		}
		return null;
		
	}
}
