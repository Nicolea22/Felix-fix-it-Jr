package principal.entities.creatures;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import principal.Constant;
import principal.Handler;
import principal.entities.ID;
import principal.graphics.Animation;
import principal.statemachine.gamestate.GameManager;

public class Bird extends Creature{

	private Animation animation;

	private long animDelay;
	
	private boolean side;
	private final float VEL = .7f;
	
	public Bird(float x, float y, Handler handler, boolean side){
		super(x,y,handler);
		this.side = side;
		animDelay = System.currentTimeMillis();
		side();
		
		animation = GameManager.animations.getBird();
		id = ID.Bird;
	}
	
	private void side(){
		if (side){
			setX(0 - 30);
		}else
			setX(Constant.WIDTH);
	}
	
	
	@Override
	public String getName() {
		return "Bird";
	}

	@Override
	public void draw(Graphics2D g) {
		
		g.drawImage(animation.getActualFrame(), (int)getX(), (int)getY(), null);

		if (animDelay - System.currentTimeMillis() > 100){
			animDelay = System.currentTimeMillis();
			animation.tick();
		}
			

	}

	@Override
	public void tick(ArrayList<Creature> objects) {
		setX(getX() + getDx());
		if (side){
			setDx(VEL);
		}else
			setDx(-VEL);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle();
	}

	@Override
	public Rectangle getTopBounds() {
		return new Rectangle();
	}

	@Override
	public Rectangle getLeftBounds() {
		return new Rectangle();
	}

	@Override
	public Rectangle getRightBounds() {
		return new Rectangle();
	}

	@Override
	public Rectangle getBotBounds() {
		return new Rectangle();
	}

}
