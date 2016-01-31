package principal.statemachine.gamestate;

import java.awt.Graphics2D;

import principal.Constant;
import principal.HUD;
import principal.Handler;
import principal.Images;
import principal.Score;
import principal.entities.Building;
import principal.entities.creatures.Cloud;
import principal.entities.creatures.Felix;
import principal.entities.creatures.Ralph;
import principal.graphics.Sprite;
import principal.statemachine.GameState;
import principal.util.DrawDebug;
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
	
	
	public GameManager() {
		animations = new Images();
		
		handler = new Handler();
	
		cloud = new Cloud(0, 300, handler);
		cloud1 = new Cloud(150, 200, handler);
		
		felix = new Felix(Constant.WIDTH/2 , Constant.HEIGHT - 90, handler);
		ralph = new Ralph(300 ,227, handler);
	
		bush = new Sprite(ResourceLoader.getLoader().loadImage("images/bush.png"));
		
		}
	
	
	@Override
	public void tick() {	
		handler.tick();
	}

	
	@Override
	public void draw(Graphics2D g) {
		drawBushes(g);
		handler.draw(g);
	}

	
//	public boolean changeSector(){
//		return Building.getBuilding().ischangeSector();
//	}
	
	
	private void drawBushes(Graphics2D g) {
		int bushPosX = 0;
		for (int i = 0; i < 33; i++){
			g.drawImage(bush.getImage(), 0 + bushPosX, Constant.HEIGHT - 55, null);
			bushPosX += bush.getWidth();
		}
	}
	
}
