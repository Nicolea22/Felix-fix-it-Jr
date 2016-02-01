package principal.entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import principal.Handler;
import principal.entities.creatures.Creature;
import principal.physics.Position;

public abstract class Entity {
	
	protected int animCounter = 0;
	
	protected int width;
	protected int height;

	protected Rectangle top;
	protected Rectangle bot;
	protected Rectangle left;
	protected Rectangle right;
	protected Rectangle all;
	
	private Position position;
	
	public Entity(float x, float y){
		position = new Position(x, y);
	}
	
	public abstract void draw(Graphics2D g);
	public abstract void tick(ArrayList<Creature> objects);
	
	// Getters and setters
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public float getX(){
		return position.getX();
	}
	
	public void setX(float x){
		position.setX(x);
	}
	
	public float getY(){
		return position.getY();
	}
	
	public void setY(float y){
		position.setY(y);
	}
	
	public abstract String getName();

	// Limites
	public Rectangle getBounds(){
		return all;
	}
		
	public Rectangle getTopBounds(){
		return top;
	}
	
	public Rectangle getLeftBounds() {
		return left;
	}
		
	public Rectangle getRightBounds() {
		return right;
	}
		
	public Rectangle getBotBounds() {
		return bot;
	}
	
}
