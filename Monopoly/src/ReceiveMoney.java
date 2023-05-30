package ChangggeCells;
import java.util.Random;

public class ReceiveMoney extends SpecialCard{
	private Random rd = new Random(System.nanoTime());
	
	public ReceiveMoney() {
		super.ID = 4;
		super.Name = "Win the lottery";
		super.Describtion = "You receive a suprise gift from the bank";
	}
	
	public void bonusMoney(Player currentPlayer) {
		currentPlayer.MoneyController(getRandomMoney());
	}
	
	private int getRandomMoney() {
		int result = 1+rd.nextInt(10);
		if(result < 6) {
			return 50;
		} else if(result < 10 ) {
			return 100;
		} else {
			return 200;
		}
	}
}
