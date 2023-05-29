package ChangggeCells;

public class PrisonTicket extends SpecialCard{

	public PrisonTicket() {
		super.ID = 2;
		super.Name = "Make a Crime";
		super.Describtion = "Catched by the police. Nice try!";
	}

	public void getPrisonticket() {
		board.goToPrison();
	}
}
