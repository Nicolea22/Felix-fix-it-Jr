package principal.statemachine.sectorstates;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import principal.entities.windows.DoubleDoor;
import principal.entities.windows.TwoPanels;
import principal.entities.windows.Window;
import principal.util.Random;

public class ThirdSector extends Sector{

	private final int MAX_DOUBLE_DOOR = 4;
	private int doubleDoorCounter;
	
	
	public ThirdSector(){
		windows =  new Window[15];
		initWindows();
	}
	
	
	private void initWindows() {
		int posX = 283;
		int posY = 6;
		int i = 0;
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 5; x++) {
				if (Random.pairValue() && doubleDoorCounter < MAX_DOUBLE_DOOR){
					windows[i] = new DoubleDoor(posX, posY, Random.pairValue());
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
	
	
	@Override
	public void tick() {
		for (int i = 0; i < windows.length; i++) {
			windows[i].tick(null);
			
		}
	}

	
	@Override
	public void draw(Graphics2D g) {
		for(int i = 0; i < windows.length; i++) {
			windows[i].draw(g);
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
	public boolean hasObstacles() {
		return true;
	}


	@Override
	public Rectangle getBotBounds() {
		return new Rectangle(POS_X + 18, POS_Y + 540, 278, 8);
	}


	@Override
	public Rectangle getTopBounds() {
		return new Rectangle();
	}

	

}
