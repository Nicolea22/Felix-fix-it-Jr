package principal.statemachine.sectorstates;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class ThirdSector extends Sector{

	public ThirdSector(){
		
	}
	
	
	@Override
	public void tick() {
		
	}

	
	@Override
	public void draw(Graphics2D g) {
		
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
		return new Rectangle();
	}

	

}
