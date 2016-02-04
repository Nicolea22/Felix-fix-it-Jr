package principal.entities.creatures;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import principal.Handler;
import principal.entities.Building;
import principal.entities.ID;
import principal.statemachine.characterstates.State;
import principal.statemachine.characterstates.ralphstates.Climbing;
import principal.statemachine.characterstates.ralphstates.Demolishing;
import principal.statemachine.characterstates.ralphstates.Move;
import principal.util.Random;

public class Ralph extends Creature {
	
	private float CLIMBING = 3.0f;
	private float vel = 1.5f;
	private long freq;
	
	private boolean climb = false;
	private boolean demolishing = false;
	private long delay = 5000;
	
	private State state;
	private int floor;
	private Brick brick;
	
	private long time = System.currentTimeMillis();
	
	private boolean prevGM = false;
	
	public Ralph(float x, float y, Handler handler) {
		super(x, y, handler);
		freq = 5000;
		id = ID.Ralph;
		state = Move.getMove();
		setDx(vel);
		width = 93;
		height = 84;
		floor = 0;
		
	}
	

	@Override
	public void draw(Graphics2D g, long time) {
		
		state.update(time);
		g.drawImage(state.getImage(0),(int)getX(), (int)getY() + 10, null);
//		g.draw(getBounds());
		
	}


	@Override
	public void tick(ArrayList<Creature> creat, long elapsedTime) {
		if (elapsedTime - time > 1500  || Building.getBuilding().isChangingSector()){
			if (Building.getBuilding().getGM()) {
				climbing(floor);
				prevGM = true;
				if (getY() == floor - 1)
				moving(elapsedTime);
			}else {
				moving(elapsedTime);	
				if(prevGM){
					floor = floor - 238;
					prevGM = false;
				}
			}
		}
	}
	
	
	private void climbing(int piso){
		state = Climbing.getClimbing();
		setDy(-CLIMBING);
		if (getY() > piso ){
			setY(getY() + getDy());
		}		
	}
	
	private void moving(long elapsedTime){
		
		state = Move.getMove();
		
		setX(getX() + getDx());
		
		if (getBounds().intersects(Building.getBuilding().getLeftBounds())){
			setDx(vel);
		}else
			if (getBounds().intersects(Building.getBuilding().getRightBounds()))
				setDx(-vel);
		
		
		
		if (elapsedTime - time > 3000) {
			time = System.currentTimeMillis();
			state = Demolishing.getDemolishing();
			throwBrick();
		}
		
	}
		
	
	
	private void throwBrick() {
		handler.add(new Brick((int)getX(), (int)getY() + 70, handler));
		handler.add(new Brick((int)getX() + 32, (int)getY()+ 70, handler));
		handler.add(new Brick((int)getX() + 64, (int)getY() + 70, handler));
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
