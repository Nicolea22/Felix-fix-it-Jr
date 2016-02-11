package principal.entities.windows;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import principal.Game;
import principal.entities.Entity;
import principal.entities.creatures.Creature;
import principal.graphics.Sprite;
import principal.util.Random;
import principal.util.ResourceLoader;

public class DoubleDoor extends Window{

	protected boolean hasFlowerPot;
	protected boolean hasRoof;
	
	private Sprite[] img;
	private int doors;
	

	public DoubleDoor(float x, float y) {
		super(x, y);
		
		img = Game.animations.getDoubleDoor();
		
		width = img[0].getImage().getWidth(null);
		height = img[0].getImage().getHeight(null);
		
		doors = Random.value(0, 3);

	}


	
	
	@Override
	public void draw(Graphics2D g, long time) {
		g.drawImage(img[doors].getImage() ,(int)getX() ,(int)getY(), null);
		g.setColor(Color.GREEN);
		

		
//		g.draw(getBounds());
//		g.draw(getTopBounds());
//		g.draw(getBotBounds());
//		g.draw(getLeftBounds());
//		g.draw(getRightBounds());
	}
	
	@Override
	public void tick(ArrayList<Entity> objects, long BeforeTime) {	
		
	}
	
	@Override
	public Rectangle getTopBounds() {
		return new Rectangle ((int)getX(),(int)getY() - 10, 36, 6);
	}

	@Override
	public Rectangle getLeftBounds() {
		if (doors == 0 || doors == 3){
			return new Rectangle(0,0,0,0);	
		}
		return new Rectangle((int)getX(),(int)getY() + 6 ,4, 44);
	}

	@Override
	public Rectangle getRightBounds() {
		if (doors == 0 || doors == 2){
			return new Rectangle(0,0,0,0);	
		}
		return new Rectangle((int)getX() + 32,(int)getY() + 6,4, 44);
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
