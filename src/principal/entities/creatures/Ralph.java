package principal.entities.creatures;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import principal.Handler;
import principal.entities.Building;
import principal.entities.ID;
import principal.statemachine.characterstates.State;
import principal.statemachine.characterstates.ralphstates.Move;
import principal.util.Random;

public class Ralph extends Creature {
	
	private float vel = 1.5f;
	private int freq;
	
	private State state;
	
	private Brick brick;
	
	public Ralph(float x, float y, Handler handler) {
		super(x, y, handler);
		freq = 10;
		id = ID.Ralph;
		state = Move.getMove();
		setDx(vel);
		width = 93;
		height = 84;
		
	}
	

	@Override
	public void draw(Graphics2D g) {
		
		state.update();
		g.drawImage(state.getImage(),(int)getX(), (int)getY() + 10, null);
//		g.draw(getBounds());
		
	}


	@Override
	public void tick(ArrayList<Creature> creat) {
		setX(getX() + getDx());
		
		if (getBounds().intersects(Building.getBuilding().getLeftBounds())){
			setDx(vel);
		}else
			if (getBounds().intersects(Building.getBuilding().getRightBounds()))
				setDx(-vel);
		
		
		if (Random.value(1, 100) % freq == 0) {
			throwBrick();
		}
		
		
	}
	
	
	private void throwBrick() {
		if (Random.value(1, 50) % 5 == 0){
			handler.add(new Brick((int)getX() + 32, (int)getY()+ 70, handler));
		}
	}

	@Override
	public String getName() {
		return "Ralph";
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)getX(), (int)getY(), width, height);
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
