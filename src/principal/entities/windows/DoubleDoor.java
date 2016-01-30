package principal.entities.windows;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import principal.entities.creatures.Creature;
import principal.graphics.Sprite;
import principal.util.Random;
import principal.util.ResourceLoader;

public class DoubleDoor extends Window{

	private Sprite[] img;
	private int doors;
	
	public DoubleDoor(float x, float y, boolean openDoors) {
		super(x, y);
		img = new Sprite[4];
		loadImages();
		initWindows();
		
		width = img[0].getImage().getWidth(null);
		height = img[0].getImage().getHeight(null);
		
		doors = getIndex(openDoors);
	}
	
	
	private void loadImages(){
		for (int i = 0; i < 4; i++){
			img[i] =  new Sprite(ResourceLoader.getLoader().loadImage("images/window/doubledoor/"+i+".png"));
		}
	}

	
	private void initWindows() {}
	
	
	@Override
	public void draw(Graphics2D g) {
		g.drawImage(img[doors].getImage() ,(int)getX() ,(int)getY(), null);
		g.setColor(Color.GREEN);
		g.draw(getBounds());
	}
	
	@Override
	public void tick(ArrayList<Creature> objects) {	
		
	}

	
	public int getIndex(boolean openDoors) {
		if (openDoors){
			return Random.value(1, 3);
		}else
			return 0;
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

	@Override
	public String getName() {
		return "DoubleDoor";
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)getX(), (int)getY(), width, height);
	}
	
	
	
}
