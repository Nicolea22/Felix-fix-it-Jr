package principal.statemachine.gamestate;

import java.awt.Graphics2D;

import principal.Constant;
import principal.Game;
import principal.HUD;
import principal.Handler;
import principal.Images;
import principal.Level;
import principal.Score;
import principal.entities.Building;
import principal.entities.creatures.Cloud;
import principal.entities.creatures.Felix;
import principal.entities.creatures.Ralph;
import principal.graphics.DrawingSurface;
import principal.graphics.Sprite;
import principal.input.KeyBoard;
import principal.statemachine.GameState;
import principal.statemachine.GameStatus;

public class GameManager implements GameState {
	
	public static boolean showHitBox;
	
	private Handler handler;
	
	private Building b;
	
	private Felix felix;
	private Ralph ralph;

	private Sprite bush;
	
	private long timing;
	
	private static boolean chooseLevel;
	
	private Cloud cloud;
	private Cloud cloud1;
		
	private static GameManager gm = new GameManager();
	
	private GameManager() {
		handler = new Handler();
		
		b = Building.getBuilding();
		
		cloud = new Cloud(0, 300);
		cloud1 = new Cloud(150, 200);
		
		felix = new Felix(Constant.WIDTH/2 , Constant.HEIGHT -100);

		HUD.getHud().setFelix(felix);

		chooseLevel = false;
		
		ralph = new Ralph(300 ,240);
	
		bush = Game.animations.getBush();
		
	}
	
	
	public static GameManager getGameManager(){
		return gm;
	}
	
	
	@Override
	public void tick(long time) {	
		
		if (b.canChangeLevel()) {
			Win.setTiming(time);
			GameStatus.changeState(5);	
		}
		
		
		if (b.canChangeLevel()){
			nextLevel();
		}
		
		
		
		if (felix.getLife() == 0) {
			Score.getScore().saveScore();
			GameStatus.changeState(3);
			felix.resetAll(Constant.WIDTH/2 , Constant.HEIGHT -100);
		}
		
		
		handler.tick(time);
		

		
		if (KeyBoard.pause){
			GameStatus.changeState(2);	
		}
		
	}

	
	@Override
	public void draw(Graphics2D g, long time) {
		drawBushes(g);
		handler.draw(g, time);
	}

	
	private void drawBushes(Graphics2D g) {
		int bushPosX = 0;
		for (int i = 0; i < 33; i++) {
			g.drawImage(bush.getImage(), 0 + bushPosX, Constant.HEIGHT - 45, null);
			bushPosX += bush.getWidth();
		}
	}

	
	public static int getLevel(){
		return Level.getLevel().getActualLevel();
	}
	
	
	public void resetGameManager() {
		b.resetBuilding();
		if (!chooseLevel){
			Level.getLevel().resetGame();
		}
		
		ralph.reset(300 ,240);
		felix.resetAll(Constant.WIDTH/2 , Constant.HEIGHT - 100);
		HUD.getHud().setFelix(felix);
		DrawingSurface.resetSurface();
		Handler.removeAll();
	}
	
	
	public void nextLevel(){
		b.resetBuilding();
		ralph.reset(300 ,240);
		felix.resetAll(Constant.WIDTH/2 , Constant.HEIGHT -100);
		DrawingSurface.resetSurface();
		Level.getLevel().levelUp();
		ralph.setVelocity(Level.getLevel().getRalphVel());
		ralph.setBrickTime(Level.getLevel().getRalphTime());
		HUD.getHud().reset();
		Handler.removeAll();
	}
	
	
	public static void setChoose(boolean choose){
		chooseLevel = choose;
	}
	
}
