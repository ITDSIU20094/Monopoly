package ChangggeCells;

public class GiveMoney extends SpecialCard {

	public GiveMoney() {
		super.ID = 3;
		super.Name = "Organize a promotion party";
		super.Describtion = "You need to spend money for rending neighbor house!";
	}

	public void giveMoney(Player[] playerList,Player currentPlayer) {
		for(Player i:playerList) {
			if(i == currentPlayer) {
				currentPlayer.MoneyController(-150*(playerList.length-1));
				if(currentPlayer.getMoney < 0) {
					System.out.println("Loserrrrr!U are out");
				}
			} else {
				i.addMoney(150);
			} 
		}
	}
}
