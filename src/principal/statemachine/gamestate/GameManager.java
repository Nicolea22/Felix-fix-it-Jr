package principal.statemachine.gamestate;

import java.awt.Graphics2D;
import principal.Constant;
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
import principal.util.Random;
import principal.util.ResourceLoader;


public class GameManager implements GameState {
	
	
	public static boolean showHitBox;
	public static Images animations;
	
	private Handler handler;
	
	private Building b;
	
	private Felix felix;
	private Ralph ralph;

	private Score score;
	
	private Sprite bush;
	
	private Cloud cloud;
	private Cloud cloud1;
		
	public GameManager() {
		
		animations = new Images();
		
		
		handler = new Handler();
		
		b = Building.getBuilding();
		
		cloud = new Cloud(0, 300);
		cloud1 = new Cloud(150, 200);
		
		felix = new Felix(Constant.WIDTH/2 , Constant.HEIGHT - 600);
		ralph = new Ralph(300 ,227);
	
		bush = new Sprite(ResourceLoader.getLoader().loadImage("images/bush.png"));
		
	}
	
	
	
	
	@Override
	public void tick(long time) {	
		
		handler.tick(time);
		
		if (KeyBoard.pause){
			GameStatus.changeState(2);	
		}
		
		
		if (KeyBoard.hitBox) {
			showHitBox = !showHitBox;
		}

	}

	
		
	

	@Override
	public void draw(Graphics2D g, long time) {
		drawBushes(g);
		handler.draw(g, time);
	}

	
	private void drawBushes(Graphics2D g) {
		int bushPosX = 0;
		for (int i = 0; i < 33; i++){
			g.drawImage(bush.getImage(), 0 + bushPosX, Constant.HEIGHT - 55, null);
			bushPosX += bush.getWidth();
		}
	}

}
