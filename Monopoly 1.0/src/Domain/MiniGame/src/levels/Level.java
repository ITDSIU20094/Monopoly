package Domain.MiniGame.src.levels;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Domain.MiniGame.src.entities.Crabby;
import Domain.MiniGame.src.main.Game;
import Domain.MiniGame.src.objects.Spike;
import Domain.MiniGame.src.utilz.HelpMethods;

import static Domain.MiniGame.src.utilz.HelpMethods.GetLevelData;
import static Domain.MiniGame.src.utilz.HelpMethods.GetCrabs;
import static Domain.MiniGame.src.utilz.HelpMethods.GetPlayerSpawn;

public class Level {

	private BufferedImage img;
	private int[][] lvlData;
	private ArrayList<Crabby> crabs;

	private ArrayList<Spike> spikes;

	private int lvlTilesWide;
	private int maxTilesOffset;
	private int maxLvlOffsetX;
	private Point playerSpawn;

	public Level(BufferedImage img) {
		this.img = img;
		createLevelData();
		createEnemies();
		createSpikes();
		calcLvlOffsets();
		calcPlayerSpawn();
	}

	private void createSpikes() {
		spikes = HelpMethods.GetSpikes(img);
	}





	private void calcPlayerSpawn() {
		playerSpawn = GetPlayerSpawn(img);
	}

	private void calcLvlOffsets() {
		lvlTilesWide = img.getWidth();
		maxTilesOffset = lvlTilesWide - Game.TILES_IN_WIDTH;
		maxLvlOffsetX = Game.TILES_SIZE * maxTilesOffset;
	}

	private void createEnemies() {
		crabs = GetCrabs(img);
	}

	private void createLevelData() {
		lvlData = GetLevelData(img);
	}

	public int getSpriteIndex(int x, int y) {
		return lvlData[y][x];
	}

	public int[][] getLevelData() {
		return lvlData;
	}

	public int getLvlOffset() {
		return maxLvlOffsetX;
	}

	public ArrayList<Crabby> getCrabs() {
		return crabs;
	}

	public Point getPlayerSpawn() {
		return playerSpawn;
	}



	public ArrayList<Spike> getSpikes() {
		return spikes;
	}

}
