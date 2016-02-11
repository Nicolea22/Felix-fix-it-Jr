package principal.entities.windows;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import principal.Game;
import principal.entities.Entity;
import principal.entities.windows.parts.Glass;
import principal.graphics.Sprite;
import principal.util.Random;

public class TwoPanels extends Window{

	private Sprite window;
	
	private final int BOT_DISP_Y = 20;
	
	private Glass topGlass;
	private Glass botGlass;
		
	private int topGlassState;
	private int botGlassState;
	
	private Sprite roof;
	private Sprite flowerPot;
	
	public TwoPanels(float x, float y, boolean hasObstacle){
		super(x,y);
		window = Game.animations.getTwoPanels();
		

		strokesRequired = Random.value(0, 4);
//		strokesRequired = 1;
		
		initObstacle(hasObstacle);
		
		width = 38;
		height = 60;
		
		topGlass = new Glass();
		botGlass = new Glass();
		
		topGlassState = 1;
		botGlassState = 1;
		
		roof = Game.animations.getRoof();
		flowerPot = Game.animations.getFlowerPot();
	}
	
	
	private void initObstacle(boolean hasObstacle){
		if (hasObstacle) {
			if (Random.boolValue(3)) {
				hasFlowerPot = true;
			}else
				hasRoof = true;
		}
	}
	

	
	@Override
	public void draw(Graphics2D g, long time) {
		
		g.drawImage(window.getImage(), (int)getX(), (int)getY(), null);

		g.drawImage(topGlass.getGlass(topGlassState).getImage(), 
			(int)getX() + topGlass.getDispX(topGlassState), 
			(int)getY() + topGlass.getDispY(topGlassState), null);

		
		g.drawImage(botGlass.getGlass(botGlassState).getImage(), 
				(int)getX() + botGlass.getDispX(botGlassState), 
				(int)getY() + botGlass.getDispY(botGlassState) + BOT_DISP_Y, null);
		
		if (hasFlowerPot){
			g.drawImage(flowerPot.getImage(), (int)getX() + 5, (int)getY() + 43, null);
		}
		
		if (hasRoof){
			g.drawImage(roof.getImage(), (int)getX() - 1, (int)getY() - 11, null);
		}
		
		g.setColor(Color.GREEN);
//		g.draw(getBounds());
//		g.draw(getBotBounds());
//		g.draw(getTopBounds());
	}

	
	@Override
	public void tick(ArrayList<Entity> objects, long beforeTime) {

		switch(strokesRequired) {
			case 0:
				topGlassState = 1;
				botGlassState = 1;
				break;
			case 1:
				topGlassState = 1;
				botGlassState = 5;
				break;
			case 2:
				topGlassState = 1;		
				botGlassState = 0;
				break;
			case 3:
				topGlassState = 4;
				botGlassState = 0;
				break;
			case 4:
				topGlassState = 0;
				botGlassState = 0;
				break;
			default:
				break;
		}
	}	
	

	
	@Override
	public Rectangle getTopBounds() {
		return new Rectangle ((int)getX(),(int)getY() - 10, 36, 6);
	}

	
	@Override
	public Rectangle getLeftBounds() {
		return new Rectangle(0,0,0,0);
	}

	
	@Override
	public Rectangle getRightBounds() {
		return new Rectangle(0,0,0,0);
	}

	
	@Override
	public Rectangle getBotBounds() {
		return new Rectangle((int)getX() ,(int)getY() + 52 ,40 , 5);
	}
	
	public String getName(){
		return "TwoPanels";
	}


	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)getX(), (int)getY(), width, height);
	}


}
