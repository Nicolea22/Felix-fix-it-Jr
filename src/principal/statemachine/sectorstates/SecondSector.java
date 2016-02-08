package principal.statemachine.sectorstates;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import principal.Score;
import principal.entities.windows.DoubleDoor;
import principal.entities.windows.TwoPanels;
import principal.entities.windows.Window;
import principal.util.Random;

public class SecondSector extends Sector{
	
	private final int MAX_DOUBLE_DOOR = 3;
	private int doubleDoorCounter;
	
	public SecondSector() {
		super();
		windows =  new Window[15];
		
		initWindows();
		countBrokenWindows();
	}
	
	
	private void initWindows() {
		int posX = 283;
		int posY = 240;
		int i = 0;
		for (int y = 0; y < ROW; y++) {
			for (int x = 0; x < COL; x++) {
				if (Random.boolValue(5) && doubleDoorCounter < MAX_DOUBLE_DOOR) {
					windows[i] = new DoubleDoor(posX, posY);
					doubleDoorCounter++;
				}else
					windows[i] = new TwoPanels(posX, posY);
				posX += 49;
				i++;
			}
			posX = 283;
			posY -= 74;
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


	// Rectangle(261 + 18, 314 + 779, 278, 6);
	@Override
	public Rectangle getBotBounds(){
		return new Rectangle(POS_X + 18, POS_Y + 778, 278, 8);
	}

	@Override
	public Rectangle getTopBounds() {
		return new Rectangle(POS_X + 18, POS_Y + 540, 278, 8);
	}


}
