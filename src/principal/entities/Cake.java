package principal.entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import principal.Handler;
import principal.statemachine.characterstates.cake.CakeAnimation;
import principal.statemachine.gamestate.GameManager;

public class Cake extends Entity{

	private long cakeTime;
	
	public Cake(float x, float y) {
		super(x, y);
		id = ID.Cake;
		Handler.add(this);
		cakeTime = System.currentTimeMillis();
		state = CakeAnimation.getCake();
	}

	@Override
	public void draw(Graphics2D g, long time) {
		state.update();
		g.drawImage(state.getImage(0), (int)getX(), (int)getY(), null);
//		g.draw(getBounds());
	}

	@Override
	public void tick(ArrayList<Entity> objects, long beforeTime) {
		if (beforeTime - cakeTime > 5000){
			Handler.remove(this);
		}
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)getX(), (int)getY(), 20, 20);
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
		return new Rectangle(0,0,0,0);
	}

	@Override
	public String getName() {
		return "Cake";
	}

}
