package principal.statemachine.sectorstates;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import principal.Constant;
import principal.Score;
import principal.entities.windows.*;

public class FirstSector extends Sector {

	public FirstSector(){
		super();
		windows = new Window[15];
		initWindows();
		countBrokenWindows();
	}
	
	
	private void initWindows() {
		// diferencia x = 49
		// diferencia y = -74
		int posX = 283;
		int posY = 488;
		int i = 0;
		for (int y = 0; y < ROW; y++) {
			for (int x = 0; x < COL; x++) {			
				if ((posX != 381 && posY != 488) || (posX != 381 && posY != 417) || posY == 340) {
					windows[i] = new TwoPanels(posX, posY, false);
				}
				
				if (posY == 488 && posX == 381) {
					windows[i] = new Door(369, 468);
				}
				
				if (posY == 414 && posX == 381) {
					windows[i] = new Semicircular(369, 413);
				}
				
				i++;
				posX += 49;
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
		for (int i = 0; i < windows.length; i++){
			windows[i].draw(g, time);
		}
	}

	
	@Override
	public boolean hasBirds() {
		return false;
	}


	@Override
	public boolean hasNicelanders() {
		return false;
	}


	@Override
	public Rectangle getBotBounds() {
		return new Rectangle(POS_X + 18, Constant.HEIGHT - 44, 278, 6);
	}

	@Override
	public Rectangle getTopBounds() {
		return new Rectangle(POS_X + 18, POS_Y + 778, 278, 6);
	}
}
