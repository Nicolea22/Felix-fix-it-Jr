package principal.entities.creatures;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import principal.Constant;
import principal.Handler;
import principal.Level;
import principal.entities.Building;
import principal.entities.Entity;
import principal.entities.ID;
import principal.graphics.Animation;
import principal.statemachine.characterstates.State;
import principal.statemachine.characterstates.bird.BirdMoving;
import principal.statemachine.gamestate.GameManager;
import principal.util.Random;

public class Bird extends Creature{

	private State state;
	private boolean side;
	
	public Bird(float x, float y, boolean side){
		super(x,y);

		vel = Level.getLevel().getBirdVel();
		id = ID.Bird;

		this.side = side;
		side();
		
		state = BirdMoving.getMoving();
		
		Handler.add(this);
	}
	
	private void side(){
		
		
		if (side){
			setX(0 - 30);
			directionX = 1;
		}else{
			setX(Constant.WIDTH);
			directionX = -1;
		}
	}
	
	
	@Override
	public String getName() {
		return "Bird";
	}

	
	@Override
	public void draw(Graphics2D g, long elapsedTime) {
		state.update();

		g.drawImage(state.getImage(directionX), (int)getX(), (int)getY(), null);
//		g.draw(getBounds());

	}


	@Override
	public void tick(ArrayList<Entity> objects, long beforeTime) {
		
//		System.out.println("Bird: " + vel);
		setX(getX() + getDx());
		if (side) {
			setDx(vel);
			if (getX()> Constant.WIDTH + 20) side = !side;
			directionX = 1;
		}else{
			setDx(-vel);
			if (getX() < 0 - 20) {
				side = !side;
				setY(Random.value(Building.getBuilding().getBotBounds().y, Building.getBuilding().getTopBounds().y));
			}
			directionX = -1;
		}
		
	}

	
	public void setVelocity(float vel) {}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)getX(), (int)getY(), 30, 20);
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
