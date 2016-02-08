package principal.entities.windows;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import principal.entities.Entity;
import principal.entities.creatures.Creature;
import principal.graphics.Sprite;
import principal.util.Random;
import principal.util.ResourceLoader;

public class Door extends Window{

	private Sprite[] images;
	private int state;
	
	public Door(float x, float y) {
		super(x, y);
		
		loadImages();
		initWindows();
		
		width = images[0].getWidth() - 20;
		height = images[0].getHeight() - 41;
	}
	
	
	private void loadImages() {
		images = new Sprite[12];
		for (int i = 0; i < images.length; i++) {
			images[i] = new Sprite(ResourceLoader.getLoader().
					loadImage("images/window/semicircular/door/"+ i+".png"));
		}
	}
	
	
	private void initWindows() {
//		strokesRequired = Random.value(0, 16);
		strokesRequired = 1;
	}
	
	
	@Override
	public void draw(Graphics2D g, long time) {
		g.drawImage(images[state].getImage(), (int)getX(), (int)getY(), null);
//		g.draw(getBounds());
	}

	
	@Override
	public void tick(ArrayList<Entity> objects, long beforeTime) {	
		if (strokesRequired >= 12) state = 11;
		if (strokesRequired < 8 && strokesRequired >= 4) state = 6;
		if (strokesRequired < 4 && strokesRequired >= 1) state = 4;
		if (strokesRequired <= 0) state = 0;
	}
	

	@Override
	public Rectangle getTopBounds() {
		return new Rectangle(0,0,0,0);
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
		return new Rectangle((int)getX(), (int)getY() + 95, 60, 4);
	}

	
	@Override
	public String getName() {
		return "Door";
	}

	
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)getX() + 10, (int)getY() + 40, width, height);
	}



	
	
}
	
