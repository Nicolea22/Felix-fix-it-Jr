package principal.entities.creatures;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import principal.Constant;
import principal.Handler;
import principal.entities.ID;
import principal.graphics.Animation;
import principal.statemachine.characterstates.State;
import principal.statemachine.characterstates.bird.BirdMoving;
import principal.statemachine.gamestate.GameManager;

public class Bird extends Creature{

	private State state;
	
	private boolean side;
	private final float VEL = .7f;
	
	public Bird(float x, float y, Handler handler, boolean side){
		super(x,y,handler);
		
		this.side = side;
		side();
		
		state = BirdMoving.getMoving();
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
	public void draw(Graphics2D g, long elapsedTime) {
		state.update(elapsedTime);

		g.drawImage(state.getImage(0), (int)getX(), (int)getY(), null);
		g.draw(getBounds());

	}


	@Override
	public void tick(ArrayList<Creature> objects, long beforeTime) {

		setX(getX() + getDx());
		if (side) {
			setDx(VEL);
			if (getX()> Constant.WIDTH + 20) side = !side;
		}else{
			setDx(-VEL);
			if (getX() < 0 - 20) side = !side;
		}
		
	}

	
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)getX(), (int)getY(), 30, 30);
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

	
}
