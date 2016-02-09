package principal.entities.windows;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import principal.entities.Entity;
import principal.entities.windows.parts.Glass;
import principal.graphics.Sprite;
import principal.util.Random;
import principal.util.ResourceLoader;

public class TwoPanels extends Window{

	private Sprite window;
	
	private final int BOT_DISP_Y = 20;
	
	private Glass topGlass;
	private Glass botGlass;
		
	private int topGlassState;
	private int botGlassState;
	
	
	
	public TwoPanels(float x, float y){
		super(x,y);
		window = new Sprite(ResourceLoader.getLoader().loadImage("images/window/0.png"));
		
		strokesRequired = Random.value(0, 4);
//		strokesRequired = 1;
		
		width = 38;
		height = 60;
		
		topGlass = new Glass();
		botGlass = new Glass();
		
		topGlassState = 1;
		botGlassState = 1;
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
		
		g.setColor(Color.GREEN);
//		g.draw(getBounds());
//		g.draw(getBotBounds());
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
		return new Rectangle ((int)getX(),(int)getY(), 32, 6);
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
		return new Rectangle((int)getX() ,(int)getY() + 49 ,40 ,5 );
	}
	
	public String getName(){
		return "TwoPanels";
	}


	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)getX(), (int)getY(), width, height);
	}


}
