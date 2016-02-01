package principal.statemachine.gamestate;

import java.awt.Graphics2D;

import principal.Constant;
import principal.HUD;
import principal.Handler;
import principal.Images;
import principal.Score;
import principal.entities.Building;
import principal.entities.creatures.Bird;
import principal.entities.creatures.Cloud;
import principal.entities.creatures.Felix;
import principal.entities.creatures.Ralph;
import principal.graphics.Sprite;
import principal.input.KeyBoard;
import principal.statemachine.GameState;
import principal.statemachine.GameStatus;
import principal.statemachine.sectorstates.SecondSector;
import principal.statemachine.sectorstates.ThirdSector;
import principal.util.DrawDebug;
import principal.util.Random;
import principal.util.ResourceLoader;
import principal.util.Timer;

public class GameManager implements GameState {
	
	public static Images animations;
	
	private Handler handler;
	
	private Felix felix;
	private Ralph ralph;
	
//	private Building building;
//	private DrawDebug drawDebug;
	
	private Score score;
	
	private Sprite bush;
	
	private Cloud cloud;
	private Cloud cloud1;
		
	private int birdCounter;
	private final int MAX_BIRDS = 2;
	
	public GameManager() {
		animations = new Images();
		
		handler = new Handler();
	
		cloud = new Cloud(0, 300, handler);
		cloud1 = new Cloud(150, 200, handler);
		
		felix = new Felix(Constant.WIDTH/2 , Constant.HEIGHT - 90, handler);
		ralph = new Ralph(300 ,227, handler);
	
		bush = new Sprite(ResourceLoader.getLoader().loadImage("images/bush.png"));
		
		birdCounter = 0;
	}
	
	
	@Override
	public void tick() {	
		handler.tick();
		generateBirds();
				
		if (KeyBoard.pause){
			GameStatus.changeState(2);	
		}
		
	}

	
	private void generateBirds() {
	}

	@Override
	public void draw(Graphics2D g) {
		drawBushes(g);
		handler.draw(g);
	}

	
	private void drawBushes(Graphics2D g) {
		int bushPosX = 0;
		for (int i = 0; i < 33; i++){
			g.drawImage(bush.getImage(), 0 + bushPosX, Constant.HEIGHT - 55, null);
			bushPosX += bush.getWidth();
		}
	}
	
}
