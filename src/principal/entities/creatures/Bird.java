package principal.entities.creatures;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import principal.Handler;
import principal.Images;
import principal.graphics.Animation;
import principal.statemachine.gamestate.GameManager;

public class Bird extends Creature{

	private Animation bird;
	
	public Bird(float x, float y, Handler handler){
		super(x,y,handler);
		bird = GameManager.animations.getBird();
	}
	
	
	@Override
	public String getName() {
		return "Bird";
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(bird.getActualFrame(), (int)getX(), (int)getY(), null);
	}

	@Override
	public void tick(ArrayList<Creature> objects) {
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle();
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
		return null;
	}

}
