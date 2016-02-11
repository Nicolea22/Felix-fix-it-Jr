package principal.entities.creatures;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import principal.Handler;
import principal.Level;
import principal.entities.Building;
import principal.entities.Entity;
import principal.entities.ID;
import principal.statemachine.characterstates.State;
import principal.statemachine.characterstates.ralphstates.Climbing;
import principal.statemachine.characterstates.ralphstates.Demolishing;
import principal.statemachine.characterstates.ralphstates.Move;
import principal.util.Random;

public class Ralph extends Creature {
	
	private float CLIMBING = 3.0f;
	
	private long DELAY_PER_BRICK = 5000;
	
	private int floor;
	
	private long time = System.currentTimeMillis();
	
	private long brickTime;
	
	private boolean prevGM;
	
	public Ralph(float x, float y) {
		super(x, y);
		id = ID.Ralph;
		state = Move.getMove();

		vel = Level.getLevel().getRalphVel();

		brickTime = Level.getLevel().getRalphTime();
		
		setDx(vel);
		prevGM = false;
		
		width = 93;
		height = 84;

		floor = 0;
		
		Handler.add(this);
	}
	

	@Override
	public void draw(Graphics2D g, long time) {
		
		state.update();
		g.drawImage(state.getImage(0),(int)getX(), (int)getY() + 10, null);
//		g.draw(getBounds());
		
	}


	@Override
	public void tick(ArrayList<Entity> ent, long elapsedTime) {

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
	
	
	private void climbing(int floor){
		state = Climbing.getClimbing();
		setDy(-CLIMBING);
		if (getY() > floor ){
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
		
		
		
		if (elapsedTime - time > brickTime) {
			
			time = System.currentTimeMillis();
			state = Demolishing.getDemolishing();
			throwBrick();
		}
		
	}
		
	
	
	private void throwBrick() {
		Handler.addBrick(getX()+25, getY() + 70);
		Handler.addBrick(getX()+50, getY() + 70);
//		int actualSector = Building.getBuilding().getIndexActualSector();
//		Brick brick = new Brick((int)getX() + 25, (int)getY()+ 70, actualSector);
//		Handler.add(brick);
//		Brick brick1 = new Brick((int)getX() + 50, (int)getY() + 70, actualSector);  
//		Handler.add(brick1);
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

	
	public void reset(float x, float y) {
		floor = 0;
		prevGM = false;
		setXY(x,y);
		vel = Level.getLevel().getRalphVel();
		brickTime = Level.getLevel().getRalphTime();
		
	}
	
	
	public void setBrickTime(long time){
		brickTime = time;
	}
	
	
}
