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

public class Semicircular extends Window{
	
	private Sprite[] images;
	private int state;
	
	public Semicircular(float x, float y) {
		super(x, y);
		
		images = Game.animations.getSemicircular();
		
		strokesRequired = Random.value(0, 16);
		initWindow();
		
		
		width = images[0].getImage().getWidth(null);
		height = images[0].getImage().getHeight(null);
	}
	
	
	private void initWindow() {
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
	public void tick(ArrayList<Entity> objects, long beforeTime) {	
		initWindow();
	}
	
	
	@Override
	public void draw(Graphics2D g, long time) {
		g.drawImage(images[state].getImage(), (int)getX(), (int)getY(), null);
//		g.draw(getBotBounds());
//		g.draw(getBounds());
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
		return new Rectangle((int)getX()  , (int)getY() + 51, 70, 5);
	}

	public String getName() {
		return "Semicircular";
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)getX() + 5, (int)getY(), width - 11, height);
	}

	@Override
	public void getFixed(){
		if (isBroken()){
			strokesRequired--;
		}
	}
	
	
}
