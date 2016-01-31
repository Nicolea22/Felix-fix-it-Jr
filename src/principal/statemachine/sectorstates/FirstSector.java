package principal.statemachine.sectorstates;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import principal.Constant;
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
		int posY = 478;
		int i = 0;
		for (int y = 0; y < ROW; y++) {
			for (int x = 0; x < COL; x++) {			
				
				
				if ((posX != 381 && posY != 478) || (posX != 381 && posY != 407) || posY == 330) {
					windows[i] = new TwoPanels(posX, posY);
				}
				
				
				if (posY == 478 && posX == 381) {
					windows[i] = new Door(369, 458);
				}
				
				
				if (posY == 404 && posX == 381) {
					windows[i] = new Semicircular(369, 403);
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
	public void tick() {
		for (int i = 0; i < windows.length; i++) {
			Window w = windows[i];
			w.tick(null);			
			if (!w.isBroken()) {
				brokenWindows.remove(w);
			}
		}
	}
	
	
	
	@Override
	public void draw(Graphics2D g) {
		for (int i = 0; i < windows.length; i++){
			windows[i].draw(g);
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
	public boolean hasObstacles() {
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
