package ChangggeCells;

public class ARoll extends SpecialCard{

	public ARoll() {
		super.ID = 1;
		super.Name = "Second Chances";
		super.Describtion = "Recieve a new rolling immediately";
	}
	
	public void getNewRoll() {
		board.roll();
	}
}
