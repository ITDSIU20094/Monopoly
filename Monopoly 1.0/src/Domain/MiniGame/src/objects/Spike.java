package Domain.MiniGame.src.objects;

import Domain.MiniGame.src.main.Game;

public class Spike extends GameObject{

	public Spike(int x, int y, int objType) {
		super(x, y, objType);
		
		initHitbox(32, 16);
		xDrawOffset = 0;
		yDrawOffset = (int)(Game.SCALE * 16);
		hitbox.y += yDrawOffset;
		
	}

}
