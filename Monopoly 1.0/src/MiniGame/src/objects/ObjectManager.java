package MiniGame.src.objects;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import MiniGame.src.entities.Player;
import MiniGame.src.gamestates.Playing;
import MiniGame.src.levels.Level;
import MiniGame.src.utilz.LoadSave;
import static MiniGame.src.utilz.Constants.ObjectConstants.*;

public class ObjectManager {
	private Playing playing;
	private BufferedImage[][] potionImgs, containerImgs;
	private BufferedImage spikeImg;
	private ArrayList<Spike> spikes;
	public ObjectManager(Playing playing) {
		this.playing = playing;
		loadImgs();
	}

	public void checkSpikesTouched(Player p) {
		for (Spike s : spikes)
			if (s.getHitbox().intersects(p.getHitbox()))
				p.kill();
	}
	public void loadObjects(Level newLevel) {
		spikes = newLevel.getSpikes();
	}

	private void loadImgs() {
		BufferedImage potionSprite = LoadSave.GetSpriteAtlas(LoadSave.POTION_ATLAS);
		potionImgs = new BufferedImage[2][7];

		for (int j = 0; j < potionImgs.length; j++)
			for (int i = 0; i < potionImgs[j].length; i++)
				potionImgs[j][i] = potionSprite.getSubimage(12 * i, 16 * j, 12, 16);

		BufferedImage containerSprite = LoadSave.GetSpriteAtlas(LoadSave.CONTAINER_ATLAS);
		containerImgs = new BufferedImage[2][8];

		for (int j = 0; j < containerImgs.length; j++)
			for (int i = 0; i < containerImgs[j].length; i++)
				containerImgs[j][i] = containerSprite.getSubimage(40 * i, 30 * j, 40, 30);

		spikeImg = LoadSave.GetSpriteAtlas(LoadSave.TRAP_ATLAS);
	}

	public void update() {

	}

	public void draw(Graphics g, int xLvlOffset) {

		drawTraps(g, xLvlOffset);
	}

	private void drawTraps(Graphics g, int xLvlOffset) {
		for (Spike s : spikes)
			g.drawImage(spikeImg, (int) (s.getHitbox().x - xLvlOffset), (int) (s.getHitbox().y - s.getyDrawOffset()), SPIKE_WIDTH, SPIKE_HEIGHT, null);

	}
	public void resetAllObjects() {
		loadObjects(playing.getLevelManager().getCurrentLevel());}

}
