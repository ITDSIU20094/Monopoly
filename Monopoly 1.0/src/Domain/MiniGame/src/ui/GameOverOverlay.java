package Domain.MiniGame.src.ui;

import java.awt.*;
import java.awt.event.KeyEvent;

import Domain.MiniGame.src.gamestates.Gamestate;
import Domain.MiniGame.src.gamestates.Playing;
import Domain.MiniGame.src.main.Game;

public class GameOverOverlay {

	private Playing playing;

	public GameOverOverlay(Playing playing) {
		this.playing = playing;
	}

	public void draw(Graphics g) {
		g.setColor(new Color(0, 0, 0, 200));
		g.fillRect(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);

		g.setColor(Color.white);
		g.setFont(new Font("TimesRoman", Font.PLAIN,60));
		g.drawString("Game Over", Game.GAME_WIDTH / 2-180, Game.GAME_HEIGHT/2-120);

		g.setFont(new Font("TimesRoman", Font.PLAIN,100));
		g.drawString("YOU ARE KILLED", Game.GAME_WIDTH / 2-420, Game.GAME_HEIGHT/2);

		g.setFont(new Font("TimesRoman", Font.PLAIN,50));
		g.drawString("Press esc to return Monopoly game!", Game.GAME_WIDTH / 2-400, Game.GAME_HEIGHT/2+100);

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			playing.resetAll();
			Gamestate.state = Gamestate.MENU;
		}
	}
}
