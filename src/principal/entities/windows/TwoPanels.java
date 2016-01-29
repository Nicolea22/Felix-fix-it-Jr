package principal.entities.windows;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import principal.entities.creatures.Creature;
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
		initWindows();
		
		width = 38;
		height = 60;
		
		topGlass = new Glass();
		botGlass = new Glass();
	}

	
	private void initWindows() {
		strokesRequired = Random.value(0, 4);
		topGlassState = Random.value(1, 5);
		botGlassState = Random.value(1, 5);
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.drawImage(window.getImage(), (int)getX(), (int)getY(), null);
		
		g.drawImage(topGlass.getGlass(topGlassState).getImage(), 
				(int)getX() + topGlass.getDispX(topGlassState), 
				(int)getY() + topGlass.getDispY(topGlassState), null);
		
		g.drawImage(botGlass.getGlass(botGlassState).getImage(), 
				(int)getX() + botGlass.getDispX(botGlassState), 
				(int)getY() + botGlass.getDispY(botGlassState) + BOT_DISP_Y, null);
		
		g.setColor(Color.GREEN);
		g.draw(getBounds());
//		g.draw(getBotBounds());
	}

	
	@Override
	public void tick(ArrayList<Creature> objects) {	
		broken = strokesRequired > 0;
		tickingImages();
	}


	private void tickingImages() {
		if (strokesRequired >= 2 && strokesRequired < 4) 
			topGlassState = 0;
		else
			if (strokesRequired <= 2) {
				topGlassState = 0;
				if (!isBroken()) botGlassState = 0;
			} 
	}		
	

	
	@Override
	public Rectangle getTopBounds() {
		return null;
	}

	
	@Override
	public Rectangle getLeftBounds() {
		return null;
	}

	
	@Override
	public Rectangle getRightBounds() {
		return null;
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
