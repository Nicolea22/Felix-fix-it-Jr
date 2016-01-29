package principal.entities.creatures;

import principal.Handler;
import principal.entities.Entity;
import principal.entities.ID;
import principal.physics.Displacement;

public abstract class Creature extends Entity{

	private Displacement displacement;
	
	protected int directionX;
	protected int directionY;
	
	protected ID id;
	
	protected Handler handler;
	
	public Creature(float x, float y, Handler handler) {
		super(x,y);
		this.handler = handler;
		displacement = new Displacement();
		handler.add(this);
	}
	
	// Setters y getters
	public float getDx(){
		return displacement.getDx();
	}
		
	public float getDy(){
		return displacement.getDy();
	}

	public void setDx(float dx){
		displacement.setDx(dx);
	}
	
	public void setDy(float dy){
		displacement.setDy(dy);
	}
	
	public int getDirectionX() {
		return directionX;
	}

	public void setDirectionX(int directionX) {
		this.directionX = directionX;
	}

	public int getDirectionY() {
		return directionY;
	}

	public void setDirectionY(int directionY) {
		this.directionY = directionY;
	}
	
	public ID getID(){
		return id;
	}
	
	public abstract String getName();

}
