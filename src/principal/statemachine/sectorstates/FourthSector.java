package principal.statemachine.sectorstates;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import principal.HUD;
import principal.Score;
import principal.entities.Building;
import principal.entities.windows.DoubleDoor;
import principal.entities.windows.TwoPanels;
import principal.entities.windows.Window;
import principal.graphics.DrawingSurface;
import principal.statemachine.GameStatus;
import principal.statemachine.gamestate.GameManager;
import principal.util.Random;

public class FourthSector extends Sector{

	private final int MAX_DOUBLE_DOOR = 3;
	private int doubleDoorCounter;
	
	
	public FourthSector(){
		windows =  new Window[15];
		initWindows();
		
		countBrokenWindows();
	}
	
	
	private void initWindows() {
		int posX = 283;
		int posY = -222;
		int i = 0;
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 5; x++) {
				if (obsCounter < MAX_OBSTACLES)
					setWithObstacles(posX, posY, i);
				else{
					setWithoutObstacles(posX, posY, i);
					}
				posX += 49;
				i++;
			}
			posX = 283;
			posY -= 74; 
		}
	}
	
	
	
	private void setWithObstacles(int posX, int posY, int i) {
		if (Random.boolValue(5) && doubleDoorCounter < MAX_DOUBLE_DOOR) {
			boolean hasObstacle = Random.boolValue(6);
			if (hasObstacle) 
				obsCounter++;
			windows[i] = new DoubleDoor(posX, posY);
			doubleDoorCounter++;
		}else{
			boolean hasObstacle = Random.boolValue(5);
			if (hasObstacle) 
				obsCounter++;
			windows[i] = new TwoPanels(posX, posY, hasObstacle);
		}
	}

	private void setWithoutObstacles(int posX, int posY, int i) {
		if (Random.boolValue(5) && doubleDoorCounter < MAX_DOUBLE_DOOR) {
			windows[i] = new DoubleDoor(posX, posY);
			doubleDoorCounter++;
		}else{
			windows[i] = new TwoPanels(posX, posY,false);
		}
	}
	
	
	
	
	
	private void countBrokenWindows(){
		for (int i = 0; i < windows.length; i++) {
			Window w = windows[i];
			if (w.isBroken()) {
				brokenWindows.add(w);
			}
		}
	}
	
	
	
	@Override
	public void tick(long beforeTime) {
		for (int i = 0; i < windows.length; i++) {
			Window w = windows[i];
			w.tick(null, beforeTime);			
			if (!w.isBroken()) {
				if(brokenWindows.contains(w)){
					Score.getScore().fixWindow();
				}
				brokenWindows.remove(w);
			}
		}
//		if(changeSector()){
//			
//			Building.getBuilding().initSectors();
//			Building.getBuilding().initActualSectors();
//			Building.getBuilding().stopGM();
//			HUD.getHud().reset();
//			DrawingSurface.resetSurface();
//			GameManager.getGameManager().resetLevel();
//			GameStatus.changeState(1);
//	}
	}

	
	@Override
	public void draw(Graphics2D g, long time) {
		for(int i = 0; i < windows.length; i++) {
			windows[i].draw(g, time);
		}
	}
	

	@Override
	public boolean hasBirds() {
		return true;
	}

	@Override
	public boolean hasNicelanders() {
		return true;
	}


	@Override
	public Rectangle getBotBounds() {
		return new Rectangle(POS_X + 18, POS_Y + 307, 278, 8);
	}


	@Override
	public Rectangle getTopBounds() {
		return new Rectangle(POS_X + 18, POS_Y + 40 ,278, 8);
	}
	
	
}
	