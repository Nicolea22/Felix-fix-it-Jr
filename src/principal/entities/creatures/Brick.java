package principal.entities.creatures;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import principal.Constant;
import principal.Handler;
import principal.entities.Entity;
import principal.entities.ID;
import principal.graphics.Animation;
import principal.statemachine.gamestate.GameManager;

public class Brick extends Creature {
	
	private Animation brick;
	private int animationTickCounter = 0;
	private int animUpdate;
	
	public Brick(float x, float y, Handler handler) {
		super(x,y, handler);
		animUpdate = 4000;
		brick = GameManager.animations.getBrick();
		id = ID.Brick;
	}

	@Override
	public String getName() {
		return "Brick";
	}

	@Override
	public void draw(Graphics2D g) {
		
		animationTickCounter++;
		if (animationTickCounter % animUpdate == 0){
			animationTickCounter = 0;
			brick.tick();
		}
		g.drawImage(brick.getActualFrame(), (int)getX(), (int)getY(), null);
		
//		g.draw(getBounds());
	}

	@Override
	public void tick(ArrayList<Creature> creat) {
	
		setY(getY() + 1.5f);
		if (getY() > 590) {
			handler.remove(this);
		}
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)getX(), (int)getY(), 18, 12);
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