package principal.entities.windows;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import principal.Game;
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
		
		images = Game.animations.getDoor();
		strokesRequired = Random.value(0, 16);
		initWindows();
		
		width = images[0].getWidth() - 20;
		height = images[0].getHeight() - 41;
	}
	
	
	private void initWindows() {
		if (strokesRequired > 12){
			state = 4;
		}else
			if (strokesRequired <= 12 && strokesRequired > 8){
				state = 3;
			}else
				if (strokesRequired <= 8 && strokesRequired > 4){
					state = 2;
				}else
					if (strokesRequired <= 4 && strokesRequired > 0){
						state = 1;
					}else
						if (strokesRequired == 0){
							state = 0;
						}
	}
	
	
	@Override
	public void draw(Graphics2D g, long time) {
		g.drawImage(images[state].getImage(), (int)getX(), (int)getY(), null);
//		g.draw(getBounds());
	}
	
//	state = 11;
//	state = 6;
//	state = 4;
	
	@Override
	public void tick(ArrayList<Entity> objects, long beforeTime) {	
		System.out.println(strokesRequired);
		initWindows();
		
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
	
